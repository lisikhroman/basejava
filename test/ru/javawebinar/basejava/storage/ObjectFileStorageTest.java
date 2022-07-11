package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.io.InputStream;
import java.io.OutputStream;

public class ObjectFileStorageTest extends AbstractStorageTest {

    public ObjectFileStorageTest() {
        super(new AbstractFileStorage(STORAGE_DIR, new ObjectStreamStorage()) {
            @Override
            protected void doWrite(Resume r, OutputStream os) {

            }

            @Override
            protected Resume doRead(InputStream is) {
                return null;
            }
        });
    }
}
