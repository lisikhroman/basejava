package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, String searchKey) {
        map.put(searchKey, r);
    }

    @Override
    protected void updateResume(Resume r, String searchKey) {
        map.put(searchKey, r);
    }

    @Override
    protected Resume getResume(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void deleteResume(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected String findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
