package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    protected void saveResume(Resume r, int indexResume) {
        storage[size] = r;
    }

    protected void shiftArray(int indexResume) {
        storage[indexResume] = storage[size - 1];
        storage[size - 1] = null;
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}
