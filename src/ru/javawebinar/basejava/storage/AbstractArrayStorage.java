package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
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
    public void saveResume(Resume r, Integer indexResume) {
        if (size == storage.length) {
            throw new StorageException("В базе данных резюме закончилось место!!", r.getUuid());
        }
        saveResumeInArray(r, indexResume);
        size++;
    }

    protected abstract void saveResumeInArray(Resume r, int indexResume);

    @Override
    public void updateResume(Resume r, Integer indexResume) {
        storage[indexResume] = r;
        System.out.println("Резюме " + r.getUuid() + " обновлено!");
    }

    @Override
    protected Resume getResume(Integer indexResume) {
        return storage[indexResume];
    }

    @Override
    protected void deleteResume(Integer indexResume) {
        shiftArray(indexResume);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void shiftArray(int indexResume);

    @Override
    protected boolean isExist(Integer indexResume) {
        return indexResume >= 0;
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    protected abstract Integer findSearchKey(String uuid);
}
