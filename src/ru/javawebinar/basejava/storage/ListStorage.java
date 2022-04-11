package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> list = new ArrayList<>();

    @Override
    protected void saveResume(Resume r, int indexResume) {
        list.add(r);
    }

    @Override
    protected void updateResume(Resume r, int indexResume) {
        list.set(indexResume, r);
    }

    @Override
    protected Resume getResume(int indexResume) {
        return list.get(indexResume);
    }

    @Override
    protected void deleteResume(int indexResume) {
        list.remove(indexResume);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume resume = new Resume(uuid);
        return list.indexOf(resume);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }
}
