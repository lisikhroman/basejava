package ru.javawebinar.basejava.model;

public enum ContactType {
    PHONE("Телефон"),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINKEDIN_PROFILE("Профиль LinkedIn"),
    GITHUB_PROFILE("Профиль GitHub"),
    STACKOVERFLOW_PROFILE("Профиль Stackoverflow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
