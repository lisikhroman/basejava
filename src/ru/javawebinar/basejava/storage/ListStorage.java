package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> list = new ArrayList<>();

    @Override
    protected void saveResume(Resume r, Integer searchKey) {
        list.add(r);
    }

    @Override
    protected void updateResume(Resume r, Integer searchKey) {
        list.set(searchKey, r);
    }

    @Override
    protected Resume getResume(Integer searchKey) {
        return list.get(searchKey);
    }

    @Override
    protected void deleteResume(Integer searchKey) {
        list.remove((searchKey).intValue());
    }

    @Override
    protected Integer findSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != -1;
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(list);
    }

    @Override
    public int size() {
        return list.size();
    }
}
