package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(MapResumeStorage.class.getName());

    public void save(Resume r) {
        LOG.info("Save " + r);
        String uuid = r.getUuid();
        saveResume(r, receiveNotExistedSearchKey(uuid));
    }

    protected abstract void saveResume(Resume r, SK searchKeyResume);

    public void update(Resume r) {
        LOG.info("Update " + r);
        String uuid = r.getUuid();
        updateResume(r, receiveExistedSearchKey(uuid));
    }

    protected abstract void updateResume(Resume r, SK searchKeyResume);

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        return getResume(receiveExistedSearchKey(uuid));
    }

    protected abstract Resume getResume(SK searchKeyResume);

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        deleteResume(receiveExistedSearchKey(uuid));
    }

    protected abstract void deleteResume(SK searchKeyResume);

    protected abstract SK findSearchKey(String uuid);

    private SK receiveExistedSearchKey(String uuid) {
        SK searchKeyResume = findSearchKey(uuid);
        if (!isExist(searchKeyResume)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    private SK receiveNotExistedSearchKey(String uuid) {
        SK searchKeyResume = findSearchKey(uuid);
        if (isExist(searchKeyResume)) {
            throw new ExistStorageException(uuid);
        }
        return searchKeyResume;
    }

    protected abstract boolean isExist(SK searchKeyResume);

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> sortedListResume = getAll();
        Comparator<Resume> fullNameUuidComparator = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);
        sortedListResume.sort(fullNameUuidComparator);
        return sortedListResume;
    }

    protected abstract List<Resume> getAll();
}
