package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

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

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume != -1) {
            return storage[indexResume];
        }
        System.out.println("Резюме " + uuid + " отсутствует!");
        return null;
    }

    protected abstract int findIndex(String uuid);
}
