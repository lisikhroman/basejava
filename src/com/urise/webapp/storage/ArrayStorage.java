package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume != -1) {
            System.out.println("Такое резюме " + uuid + " уже есть!");
        } else if (size == storage.length) {
            System.out.println("В базе данных резюме закончилось место!!");
        } else {
            storage[size] = r;
            size++;
            System.out.println("Резюме " + uuid + " сохранено!");
        }
    }

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume != -1) {
            return storage[indexResume];
        }
        System.out.println("Резюме " + uuid + " отсутствует!");
        return null;
    }

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        if (indexResume != -1) {
            storage[indexResume] = storage[size - 1];
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
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (indexResume != -1) {
            storage[indexResume] = r;
            System.out.println("Резюме " + uuid + " обновлено!");
        } else {
            System.out.println("Резюме " + uuid + " отсутствует!");
        }
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].toString())) {
                return i;
            }
        }
        return -1;
    }
}
