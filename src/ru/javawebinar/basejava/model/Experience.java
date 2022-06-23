package ru.javawebinar.basejava.model;

import java.time.LocalDate;

public class Experience {

    private final String nameOrganization;
    private final String websiteLink;
    private final LocalDate beginPeriod;
    private final LocalDate endPeriod;
    private final String post;
    private final String postDuties;

    public Experience(String nameOrganization, String websiteLink, LocalDate beginPeriod, LocalDate endPeriod, String post, String postDuties) {
        this.nameOrganization = nameOrganization;
        this.websiteLink = websiteLink;
        this.beginPeriod = beginPeriod;
        this.endPeriod = endPeriod;
        this.post = post;
        this.postDuties = postDuties;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public LocalDate getBeginPeriod() {
        return beginPeriod;
    }

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public String getPost() {
        return post;
    }

    public String getPostDuties() {
        return postDuties;
    }

    @Override
    public String toString() {
        return nameOrganization + " " +
                websiteLink + '\n' +
                beginPeriod.getMonthValue() + "/" + beginPeriod.getYear() + " - " +
                endPeriod.getMonthValue() + "/" + endPeriod.getYear() + '\n' +
                post + '\n' +
                postDuties + '\n';
    }
}
