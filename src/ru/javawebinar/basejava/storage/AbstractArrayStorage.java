package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            throw new ExistStorageException(uuid);
        }
        if (size == storage.length) {
            throw new StorageException("В базе данных резюме закончилось место!!", uuid);
        }
        saveResume(r, indexResume);
        size++;
    }

    protected abstract void saveResume(Resume r, int indexResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume < 0) {
            throw new NotExistStorageException(uuid);
        }
        storage[indexResume] = r;
        System.out.println("Резюме " + uuid + " обновлено!");
    }

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume < 0) {
            throw new NotExistStorageException(uuid);

        }
        return storage[indexResume];
    }

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume < 0) {
            throw new NotExistStorageException(uuid);
        }
        shiftArray(indexResume);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void shiftArray(int indexResume);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int findIndex(String uuid);
}
