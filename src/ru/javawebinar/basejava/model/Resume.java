package ru.javawebinar.basejava.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private final String uuid;

    private final String fullName;

    private final Map<ContactType, String> contacts = new HashMap<>();

    private final Map<SectionType, AbstractSection> sections = new HashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    public int hashCode() {
        return uuid.hashCode();
    }

    public String toString() {
        return uuid;
    }

    public void setContacts(ContactType type, String value) {
        contacts.put(type, value);
    }

    public String getContacts(ContactType type) {
        return contacts.get(type);
    }

    public AbstractSection getSections(SectionType type) {
        return sections.get(type);
    }

    public void setSections(SectionType type, AbstractSection section) {
        sections.put(type, section);
    }
}
