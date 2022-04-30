package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume r) {
        String uuid = r.getUuid();
        saveResume(r, checkExistSearchKey(uuid));
    }

    protected abstract void saveResume(Resume r, Object searchKeyResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        updateResume(r, checkNotExistSearchKey(uuid));
    }

    protected abstract void updateResume(Resume r, Object searchKeyResume);

    public Resume get(String uuid) {
        return getResume(checkNotExistSearchKey(uuid));
    }

    protected abstract Resume getResume(Object searchKeyResume);

    public void delete(String uuid) {
        deleteResume(checkNotExistSearchKey(uuid));
    }

    protected abstract void deleteResume(Object searchKeyResume);

    protected abstract Object findSearchKey(String uuid);

    private Object checkNotExistSearchKey(String uuid) {
        Object searchKeyResume = findSearchKey(uuid);
        if (!checkSearchKey(searchKeyResume)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    private Object checkExistSearchKey(String uuid) {
        Object searchKeyResume = findSearchKey(uuid);
        if (checkSearchKey(searchKeyResume)) {
            throw new ExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    protected abstract boolean checkSearchKey(Object searchKeyResume);
}
