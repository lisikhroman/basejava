package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, int indexResume, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected void updateResume(Resume r, int indexResume, String uuid) {
        map.put(uuid, r);
    }

    @Override
    protected Resume getResume(int indexResume, String uuid) {
        return map.get(uuid);
    }

    @Override
    protected void deleteResume(int indexResume, String uuid) {
        map.remove(uuid);
    }

    @Override
    protected int findIndex(String uuid) {
        Resume resume = new Resume(uuid);
        List<Resume> list = new ArrayList<>(map.values());
        return list.indexOf(resume);
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
