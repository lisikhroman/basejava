package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage {

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void saveResume(Resume r, int indexResume) {
        if (size == storage.length) {
            throw new StorageException("В базе данных резюме закончилось место!!", r.getUuid());
        }
        saveResumeInArray(r, indexResume);
        size++;
    }

    protected abstract void saveResumeInArray(Resume r, int indexResume);

    @Override
    public void updateResume(Resume r, int indexResume) {
        storage[indexResume] = r;
        System.out.println("Резюме " + r.getUuid() + " обновлено!");
    }

    @Override
    protected Resume getResume(int indexResume) {
        return storage[indexResume];
    }

    @Override
    protected void deleteResume(int indexResume) {
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
