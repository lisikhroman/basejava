package ru.javawebinar.basejava.model;

import java.util.Objects;

public class Link {

    private final String nameOrganization;
    private final String websiteLink;

    public Link(String nameOrganization, String websiteLink) {
        Objects.requireNonNull(nameOrganization, "nameOrganization must not be null");
        Objects.requireNonNull(websiteLink, "websiteLink must not be null");
        this.nameOrganization = nameOrganization;
        this.websiteLink = websiteLink;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    @Override
    public String toString() {
        return nameOrganization + " " +
                websiteLink + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!nameOrganization.equals(link.nameOrganization)) return false;
        return websiteLink.equals(link.websiteLink);
    }

    @Override
    public int hashCode() {
        int result = nameOrganization.hashCode();
        result = 31 * result + websiteLink.hashCode();
        return result;
    }
}
