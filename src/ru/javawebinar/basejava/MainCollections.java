package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.Resume;

import java.util.*;

public class MainCollections {
    private static final String UUID_1 = "uuid1";
    private static final Resume RESIME_1 = new Resume(UUID_1);
    private static final String UUID_2 = "uuid2";
    private static final Resume RESIME_2 = new Resume(UUID_2);
    private static final String UUID_3 = "uuid3";
    private static final Resume RESIME_3 = new Resume(UUID_3);
    private static final String UUID_4 = "uuid4";
    private static final Resume RESIME_4 = new Resume(UUID_4);


    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESIME_1);
        collection.add(RESIME_2);
        collection.add(RESIME_3);
        collection.add(RESIME_4);

        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            System.out.println(r);
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
        }

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESIME_1);
        map.put(UUID_2, RESIME_2);
        map.put(UUID_3, RESIME_3);
        map.put(UUID_4, RESIME_4);

        for (String uuid : map.keySet()) {
            System.out.println(map.get(uuid));
        }

        for (Map.Entry<String, Resume> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }

        List<Resume> resumes = Arrays.asList(RESIME_1, RESIME_2, RESIME_3, RESIME_4);
        resumes.remove(1);
        System.out.println(resumes);
    }
}
