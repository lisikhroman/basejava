package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    public void save(Resume r) {
        String uuid = r.getUuid();
        saveResume(r, receiveNotExistedSearchKey(uuid));
    }

    protected abstract void saveResume(Resume r, Object searchKeyResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        updateResume(r, receiveExistedSearchKey(uuid));
    }

    protected abstract void updateResume(Resume r, Object searchKeyResume);

    public Resume get(String uuid) {
        return getResume(receiveExistedSearchKey(uuid));
    }

    protected abstract Resume getResume(Object searchKeyResume);

    public void delete(String uuid) {
        deleteResume(receiveExistedSearchKey(uuid));
    }

    protected abstract void deleteResume(Object searchKeyResume);

    protected abstract Object findSearchKey(String uuid);

    private Object receiveExistedSearchKey(String uuid) {
        Object searchKeyResume = findSearchKey(uuid);
        if (!isExist(searchKeyResume)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    private Object receiveNotExistedSearchKey(String uuid) {
        Object searchKeyResume = findSearchKey(uuid);
        if (isExist(searchKeyResume)) {
            throw new ExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    protected abstract boolean isExist(Object searchKeyResume);
}
