package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {
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

    @Override
    public void saveResume(Resume r, Object indexResume) {
        if (size == storage.length) {
            throw new StorageException("В базе данных резюме закончилось место!!", r.getUuid());
        }
        saveResumeInArray(r, (Integer) indexResume);
        size++;
    }

    protected abstract void saveResumeInArray(Resume r, int indexResume);

    @Override
    public void updateResume(Resume r, Object indexResume) {
        storage[(Integer) indexResume] = r;
        System.out.println("Резюме " + r.getUuid() + " обновлено!");
    }

    @Override
    protected Resume getResume(Object indexResume) {
        return storage[(Integer) indexResume];
    }

    @Override
    protected void deleteResume(Object indexResume) {
        shiftArray((Integer) indexResume);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void shiftArray(int indexResume);

    @Override
    protected boolean checkSearchKey(Object indexResume) {
        return (Integer) indexResume >= 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract Integer findSearchKey(String uuid);
}
