package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage<String> {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected void updateResume(Resume r, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected Resume getResume(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void deleteResume(String uuid) {
        map.remove(uuid);
    }

    @Override
    protected String findSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return map.containsKey(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAll() {
        TreeMap<String, Resume> sortedMap = new TreeMap<>(map);
        return Arrays.asList(sortedMap.values().toArray(new Resume[map.size()]));
    }

    @Override
    public int size() {
        return map.size();
    }
}
