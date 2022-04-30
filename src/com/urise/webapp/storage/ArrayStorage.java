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
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                result = true;
                System.out.println("Такое резюме уже есть!");
            }
            if (i == size) {
                System.out.println("В базе данных резюме закончилось место!!");
            }
        }
        if (!result) {
            storage[size] = r;
            size++;
            System.out.println("Резюме сохранено!");
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
            }
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
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (r.getUuid().equals(storage[i].getUuid())) {
                storage[i] = r;
                result = true;
                System.out.println("Резюме обновлено!");
            }
        }
        if (!result) {
            System.out.println("Резюме отсутствует!");
        }
    }
}
