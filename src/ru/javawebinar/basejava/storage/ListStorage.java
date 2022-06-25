package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {

    private final List<Resume> list = new ArrayList<>();

    @Override
    protected void saveResume(Resume r, Integer indexResume) {
        list.add(r);
    }

    @Override
    protected void updateResume(Resume r, Integer indexResume) {
        list.set(indexResume, r);
    }

    @Override
    protected Resume getResume(Integer indexResume) {
        return list.get(indexResume);
    }

    @Override
    protected void deleteResume(Integer indexResume) {
        list.remove((indexResume).intValue());
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
    protected boolean isExist(Integer indexResume) {
        return indexResume != -1;
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
