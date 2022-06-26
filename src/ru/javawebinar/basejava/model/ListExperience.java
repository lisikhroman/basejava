package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ListExperience extends AbstractSection {

    private final List<Experience> experience;

    public ListExperience(List<Experience> experience) {
        Objects.requireNonNull(experience, "experience must not be null");
        this.experience = experience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return experience.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListExperience that = (ListExperience) o;

        return experience.equals(that.experience);
    }

    @Override
    public int hashCode() {
        return experience.hashCode();
    }
}
