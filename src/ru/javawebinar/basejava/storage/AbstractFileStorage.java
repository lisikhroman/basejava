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
        } catch (IOException e) {
            throw new StorageException("Could not create file", file.getName(), e);
        }
        updateResume(r, file);
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
        if (!file.delete()) {
            throw new StorageException("File delete error", file.getName());
        }
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
        for (File file : getListFiles()) {
            listResumes.add(getResume(file));
        }
        return listResumes;
    }

    @Override
    public void clear() {
        File[] files = getListFiles();
        if (files != null) {
            for (File file : files) {
                deleteResume(file);
            }
        }
    }

    @Override
    public int size() {
        return getListFiles().length;
    }

    public SaveStrategy getSaveStrategy() {
        return saveStrategy;
    }

    private File[] getListFiles() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory find error", null);
        }
        return directory.listFiles();
    }
}
