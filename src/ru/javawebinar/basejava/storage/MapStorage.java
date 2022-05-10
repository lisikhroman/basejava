package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected void updateResume(Resume r, Object uuid) {
        map.put((String) uuid, r);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return map.get((String) uuid);
    }

    @Override
    protected void deleteResume(Object uuid) {
        map.remove((String) uuid);
    }

    @Override
    protected Object findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object uuid) {
        return map.containsKey(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        TreeMap<String, Resume> sortedMap = new TreeMap<>(map);
        return sortedMap.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
