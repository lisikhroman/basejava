package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {

    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(Resume r, Object resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(Object resume) {
        return (Resume) resume;
    }

    @Override
    protected void deleteResume(Object resume) {
        map.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
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
