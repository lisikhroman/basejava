package ru.javawebinar.basejava.exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Такое резюме " + uuid + " уже есть!", uuid);
    }
}