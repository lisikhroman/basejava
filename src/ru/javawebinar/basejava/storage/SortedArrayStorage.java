package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

//    static class ResumeComparator implements Comparator<Resume>{
//        @Override
//        public int compare(Resume o1, Resume o2) {
//            return o1.getUuid().compareTo(o2.getUuid());
//        }
//    }

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void saveToArray(Resume r, int index) {
        int freeIndex = -index - 1;
        System.arraycopy(storage, freeIndex, storage, freeIndex + 1, size - freeIndex);
        storage[freeIndex] = r;
    }

    protected void deleteFromArray(int index) {
        int quantityResume = size - index - 1;
        if (quantityResume > 0) {
            System.arraycopy(storage, index + 1, storage, index, quantityResume);
        }
    }

    protected Integer findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
