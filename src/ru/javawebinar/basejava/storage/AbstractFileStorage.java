package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;
    private final SaveStrategy saveStrategy;

    protected AbstractFileStorage(File directory, SaveStrategy saveStrategy) {
        this.saveStrategy = saveStrategy;
        Objects.requireNonNull(directory, "directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected void saveResume(Resume r, File file) {
        try {
            file.createNewFile();
            saveStrategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    protected abstract void doWrite(Resume r, OutputStream os) throws IOException;

    @Override
    protected void updateResume(Resume r, File file) {
        try {
            saveStrategy.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File write error", r.getUuid(), e);
        }
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return saveStrategy.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected void deleteResume(File file) {
        file.delete();
    }

    @Override
    protected File findSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> listResumes = new ArrayList<>();
        for (File file : Objects.requireNonNull(directory.listFiles(), "directory.listFiles() must not be null")) {
            listResumes.add(getResume(file));
        }
        return listResumes;
    }

    @Override
    public void clear() {
        directory.deleteOnExit();
    }

    @Override
    public int size() {
        return Objects.requireNonNull(directory.list(), "directory.list() must not be null").length;
    }

    public SaveStrategy getSaveStrategy() {
        return saveStrategy;
    }
}
