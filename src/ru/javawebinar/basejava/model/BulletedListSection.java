package ru.javawebinar.basejava.model;

import java.util.List;

public class BulletedListSection extends AbstractSection {

    private List<String> listContent;

    public BulletedListSection(List<String> listContent) {
        this.listContent = listContent;
    }

    public BulletedListSection(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13) {
        super();
    }

    public List<String> getListContent() {
        return listContent;
    }

    @Override
    public String toString() {
        return listContent.toString();
    }

}
