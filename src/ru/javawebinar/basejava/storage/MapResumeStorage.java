package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveResume(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected void updateResume(Resume r, Resume resume) {
        map.put(r.getUuid(), r);
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }

    @Override
    protected void deleteResume(Resume resume) {
        map.remove((resume).getUuid());
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAll() {
        Map<String, Resume> sortedMap = new HashMap<>(map);
        return Arrays.asList(sortedMap.values().toArray(new Resume[map.size()]));
    }

    @Override
    public int size() {
        return map.size();
    }
}
