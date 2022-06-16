package ru.javawebinar.basejava.model;

import java.util.List;

public class BulletedListSection extends AbstractSection {

    private final List<String> listContent;

    public BulletedListSection(List<String> listContent) {
        this.listContent = listContent;
    }

    public List<String> getListContent() {
        return listContent;
    }

}
