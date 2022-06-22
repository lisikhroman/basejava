package ru.javawebinar.basejava.model;

public class SimpleLineSection extends AbstractSection {

    private final String textContent;

    public SimpleLineSection(String textContent) {
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public String toString() {
        return textContent;
    }
}
