package ru.javawebinar.basejava.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Experience implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Link homePage;
    private final List<Period> periods;

    public Experience(String nameOrganization, String websiteLink, List<Period> periods) {
        this.homePage = new Link(nameOrganization, websiteLink);
        this.periods = periods;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public Link getHomePage() {
        return homePage;
    }

    @Override
    public String toString() {
        return homePage + " " + periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        return homePage.equals(that.homePage);
    }

    @Override
    public int hashCode() {
        return homePage.hashCode();
    }
}
