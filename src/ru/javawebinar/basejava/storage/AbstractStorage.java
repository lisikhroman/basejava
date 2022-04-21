package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume r) {
        String uuid = r.getUuid();
        saveResume(r, checkExistIndex(uuid), uuid);
    }

    protected abstract void saveResume(Resume r, int indexResume, String uuid);

    public void update(Resume r) {
        String uuid = r.getUuid();
        updateResume(r, checkNotExistIndex(uuid), uuid);
    }

    protected abstract void updateResume(Resume r, int indexResume, String uuid);

    public Resume get(String uuid) {
        return getResume(checkNotExistIndex(uuid), uuid);
    }

    protected abstract Resume getResume(int indexResume, String uuid);

    public void delete(String uuid) {
        deleteResume(checkNotExistIndex(uuid), uuid);
    }

    protected abstract void deleteResume(int indexResume, String uuid);

    protected abstract int findIndex(String uuid);

    private int checkNotExistIndex(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume < 0) {
            throw new NotExistStorageException(uuid);
        }
        return indexResume;
    }

    private int checkExistIndex(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            throw new ExistStorageException(uuid);
        }
        return indexResume;
    }
}
