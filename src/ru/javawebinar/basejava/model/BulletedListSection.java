package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BulletedListSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    public static final BulletedListSection EMPTY = new BulletedListSection("");

    private List<String> listContent;

    public BulletedListSection() {
    }

    public BulletedListSection(String... listContent) {
        this(Arrays.asList(listContent));
    }

    public BulletedListSection(List<String> listContent) {
        Objects.requireNonNull(listContent, "listContent must not be null");
        this.listContent = listContent;
    }

    public List<String> getListContent() {
        return listContent;
    }

    @Override
    public String toString() {
        return listContent.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BulletedListSection that = (BulletedListSection) o;

        return listContent.equals(that.listContent);
    }

    @Override
    public int hashCode() {
        return listContent.hashCode();
    }
}
