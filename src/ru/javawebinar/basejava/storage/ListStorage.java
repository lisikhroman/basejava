package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> list = new ArrayList<>();

    @Override
    protected void saveResume(Resume r, Object indexResume) {
        list.add(r);
    }

    @Override
    protected void updateResume(Resume r, Object indexResume) {
        list.set((Integer) indexResume, r);
    }

    @Override
    protected Resume getResume(Object indexResume) {
        return list.get((Integer) indexResume);
    }

    @Override
    protected void deleteResume(Object indexResume) {
        list.remove(((Integer) indexResume).intValue());
    }

    @Override
    protected Integer findSearchKey(String uuid) {
        return list.indexOf(new Resume(uuid, ""));
    }

    @Override
    protected boolean isExist(Object indexResume) {
        return (Integer) indexResume != -1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }
}
