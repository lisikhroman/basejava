package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(Resume r, Resume searchKey) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void deleteResume(Resume searchKey) {
        map.remove((searchKey).getUuid());
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Resume searchKey) {
        return searchKey != null;
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
