package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void save(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            throw new ExistStorageException(uuid);
        }
        saveResume(r, indexResume);
    }

    protected abstract void saveResume(Resume r, int indexResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        checkNotExistIndex(indexResume, uuid);
        updateResume(r, indexResume);
    }

    protected abstract void updateResume(Resume r, int indexResume);

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        checkNotExistIndex(indexResume, uuid);
        return getResume(indexResume);
    }

    protected abstract Resume getResume(int indexResume);

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        checkNotExistIndex(indexResume, uuid);
        deleteResume(indexResume);
    }

    protected abstract void deleteResume(int indexResume);

    protected abstract int findIndex(String uuid);

    private void checkNotExistIndex(int indexResume, String uuid) {
        if (indexResume < 0) {
            throw new NotExistStorageException(uuid);
        }
    }
}
