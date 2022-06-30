package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected AbstractFileStorage(File directory) {
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
    protected void saveResume(Resume r, File searchKey) {
        try {
            searchKey.createNewFile();
            doWrite(r, searchKey);
        } catch (IOException e) {
            throw new StorageException("IO error", searchKey.getName(), e);
        }
    }

    protected abstract void doWrite(Resume r, File file);

    @Override
    protected void updateResume(Resume r, File searchKey) {
        doWrite(r, searchKey);
    }

    @Override
    protected Resume getResume(File searchKey) {
        return doRead(searchKey);
    }

    protected abstract Resume doRead(File file);

    @Override
    protected void deleteResume(File searchKey) {
        searchKey.delete();
    }

    @Override
    protected File findSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File searchKey) {
        return searchKey.exists();
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
}
