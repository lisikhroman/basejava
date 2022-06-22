package ru.javawebinar.basejava.model;

import java.util.List;

public class ListExperience extends AbstractSection {

    private final List<Experience> experience;

    public ListExperience(List<Experience> experience) {
        this.experience = experience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return experience.toString();
    }
}
