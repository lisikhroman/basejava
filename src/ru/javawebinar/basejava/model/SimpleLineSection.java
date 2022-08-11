package ru.javawebinar.basejava.model;

import java.util.Objects;

public class SimpleLineSection extends AbstractSection {
    private static final long serialVersionUID = 1L;

    private final String textContent;

    public SimpleLineSection(String textContent) {
        Objects.requireNonNull(textContent, "textContent must not be null");
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleLineSection that = (SimpleLineSection) o;

        return textContent.equals(that.textContent);
    }

    @Override
    public int hashCode() {
        return textContent.hashCode();
    }
}
