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
    protected static final int STORAGE_LIMIT = 100000;
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
        } else if (size == storage.length) {
            throw new StorageException("В базе данных резюме закончилось место!!", uuid);
        } else {
            saveResume(r, indexResume);
            size++;
        }
    }

    protected abstract void saveResume(Resume r, int indexResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            storage[indexResume] = r;
            System.out.println("Резюме " + uuid + " обновлено!");
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            return storage[indexResume];
        }
        throw new NotExistStorageException(uuid);
    }

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume >= 0) {
            shiftArray(indexResume);
            storage[size - 1] = null;
            size--;
        } else {
            throw new NotExistStorageException(uuid);
        }
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
