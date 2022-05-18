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
    protected void saveResumeInArray(Resume r, int indexResume) {
        int freeIndex = -indexResume - 1;
        System.arraycopy(storage, freeIndex, storage, freeIndex + 1, size - freeIndex);
        storage[freeIndex] = r;
    }

    protected void shiftArray(int indexResume) {
        int quantityResume = size - indexResume - 1;
        if (quantityResume > 0) {
            System.arraycopy(storage, indexResume + 1, storage, indexResume, quantityResume);
        }
    }

    protected Integer findSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }
}
