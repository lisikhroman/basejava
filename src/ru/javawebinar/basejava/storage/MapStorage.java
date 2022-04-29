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
        return map.get(uuid.toString());
    }

    @Override
    protected void deleteResume(Object uuid) {
        map.remove(uuid.toString());
    }

    @Override
    protected Object findSearchKey(String uuid) {
        if (map.containsKey(uuid)) {
            return uuid;
        } else {
            return -1;
        }
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
