package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class TestData {
    public static final String UUID_1 = UUID.randomUUID().toString();

    public static final Resume resume;

    static {
        resume = new Resume(UUID_1, "Name1");

        resume.setContact(ContactType.PHONE, "phone");
        resume.setContact(ContactType.SKYPE, "skype");
        resume.setContact(ContactType.EMAIL, "email");
        resume.setContact(ContactType.LINKEDIN_PROFILE, "linkedin_profile");
        resume.setContact(ContactType.GITHUB_PROFILE, "github_profile");
        resume.setContact(ContactType.STACKOVERFLOW_PROFILE, "stackoverflow_profile");
        resume.setContact(ContactType.HOMEPAGE, "homepage_");

        resume.setSection(SectionType.OBJECTIVE, new SimpleLineSection("objective_"));
        resume.setSection(SectionType.PERSONAL, new SimpleLineSection("personal_"));
        resume.setSection(SectionType.ACHIEVEMENT, new BulletedListSection(List.of(
                "•\tachievement_1_"
                , "•\tachievement_2_"
        )));
        resume.setSection(SectionType.QUALIFICATIONS, new BulletedListSection(List.of(
                "•\tqualification_1_"
                , "•\tqualification_2_"
        )));
        resume.setSection(SectionType.EXPERIENCE, new ListExperience(new Experience(
                "nameOrganisation_1_"
                , "websiteLink_1_"
                , new Experience.Period(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1)
                , "post_1_"
                , "postDuties_1_")
        )));
        resume.setSection(SectionType.EXPERIENCE, new ListExperience(new Experience(
                "nameOrganisation_2_"
                , "websiteLink_2_"
                , new Experience.Period(LocalDate.of(2014, 10, 1)
                , LocalDate.of(2016, 1, 1)
                , "post_2_"
                , "postDuties_2_")
        )));
        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
                "nameOrganisation_3_"
                , "websiteLink_3_"
                , new Experience.Period(LocalDate.of(2011, 3, 1)
                , LocalDate.of(2011, 4, 1)
                , "post_3_"
                , "")
        )));
        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
                "nameOrganisation_4_"
                , "websiteLink_4_"
                , new Experience.Period(LocalDate.of(2013, 3, 1)
                , LocalDate.of(2013, 5, 1)
                , "post_4_"
                , "")
        )));
        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
                "nameOrganisation_5_"
                , "websiteLink_5_"
                , new Experience.Period(LocalDate.of(1993, 9, 1)
                , LocalDate.of(1997, 7, 1)
                , "post_5_1_"
                , "")
                , new Experience.Period(LocalDate.of(1987, 9, 1)
                , LocalDate.of(1993, 7, 1)
                , "post_5_2"
                , "")
        )));
    }
}