package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    protected void saveResume(Resume r, int indexResume) {
        int j = -indexResume - 1;
        System.arraycopy(storage, j, storage, j + 1, size - j);
        storage[j] = r;
    }

    protected void shiftArray(int indexResume) {
        int quantityElements = size - indexResume - 1;
        if (quantityElements > 0) {
            System.arraycopy(storage, indexResume + 1, storage, indexResume, quantityElements);
        }
    }

    protected int findIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
