package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int ItemNumber = findItemNumber(r.getUuid());
        if (ItemNumber != -1) {
            System.out.println("Такое резюме " + r.getUuid() + " уже есть!");
        } else if (storage.length == size) {
            System.out.println("В базе данных резюме закончилось место!!");
        } else {
            storage[size] = r;
            size++;
            System.out.println("Резюме " + r.getUuid() + " сохранено!");
        }
    }

    public Resume get(String uuid) {
        int ItemNumber = findItemNumber(uuid);
        if (ItemNumber != -1) {
            return storage[ItemNumber];
        }
        System.out.println("Резюме " + uuid + " отсутствует!");
        return null;
    }

    public void delete(String uuid) {
        int ItemNumber = findItemNumber(uuid);
        if (ItemNumber != -1) {
            storage[ItemNumber] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        } else {
            System.out.println("Резюме " + uuid + " отсутствует!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume r) {
        int ItemNumber = findItemNumber(r.getUuid());
        if (ItemNumber != -1) {
            storage[ItemNumber] = r;
            System.out.println("Резюме " + r.getUuid() + " обновлено!");
        } else {
            System.out.println("Резюме " + r.getUuid() + " отсутствует!");
        }
    }

    private int findItemNumber(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}
