package ru.javawebinar.basejava.storage;

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
        if (Integer.signum(indexResume) == 1) {
            System.out.println("Такое резюме " + uuid + " уже есть!");
        } else if (size == storage.length) {
            System.out.println("В базе данных резюме закончилось место!!");
        } else {
            saveResume(r, indexResume);
            size++;
            System.out.println("Резюме " + uuid + " сохранено!");
        }
    }

    protected abstract void saveResume(Resume r, int indexResume);

    public void update(Resume r) {
        String uuid = r.getUuid();
        int indexResume = findIndex(uuid);
        if (Integer.signum(indexResume) == 1) {
            storage[indexResume] = r;
            System.out.println("Резюме " + uuid + " обновлено!");
        } else {
            System.out.println("Резюме " + uuid + " отсутствует!");
        }
    }

    public Resume get(String uuid) {
        int indexResume = findIndex(uuid);
        if (Integer.signum(indexResume) == 1) {
            return storage[indexResume];
        }
        System.out.println("Резюме " + uuid + " отсутствует!");
        return null;
    }

    public void delete(String uuid) {
        int indexResume = findIndex(uuid);
        if (Integer.signum(indexResume) == -1) {
            shiftArray(indexResume);
            size--;
        } else {
            System.out.println("Резюме " + uuid + " отсутствует!");
        }
    }

    protected abstract void shiftArray(int indexResume);

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected abstract int findIndex(String uuid);
}
