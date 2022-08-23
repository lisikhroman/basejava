package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.ContactType;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.model.SectionType;

public class ResumeTestData {
    protected static Resume resume;

    public static void main(String[] args) {

        fillResume("uuid1", "name1");

        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle() + " " + resume.getContact(type));
        }
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + "\n" + resume.getSection(type));
            System.out.println();
        }
    }

    public static Resume fillResume(String uuid, String name) {

        resume = new Resume(uuid, name);

//        String numberResume = name.replace("name", "");
//
//        resume.setContact(ContactType.PHONE, "phone_" + numberResume);
//        resume.setContact(ContactType.SKYPE, "skype_" + numberResume);
//        resume.setContact(ContactType.EMAIL, "email_" + numberResume);
//        resume.setContact(ContactType.LINKEDIN_PROFILE, "linkedin_profile_" + numberResume);
//        resume.setContact(ContactType.GITHUB_PROFILE, "github_profile_" + numberResume);
//        resume.setContact(ContactType.STACKOVERFLOW_PROFILE, "stackoverflow_profile_" + numberResume);
//        resume.setContact(ContactType.HOMEPAGE, "homepage_" + numberResume);
//
//        resume.setSection(SectionType.OBJECTIVE, new SimpleLineSection("objective_" + numberResume));
//        resume.setSection(SectionType.PERSONAL, new SimpleLineSection("personal_" + numberResume));
//        resume.setSection(SectionType.ACHIEVEMENT, new BulletedListSection(List.of(
//                "•\tachievement_1_" + numberResume
//                , "•\tachievement_2_" + numberResume
//        )));
//        resume.setSection(SectionType.QUALIFICATIONS, new BulletedListSection(List.of(
//                "•\tqualification_1_" + numberResume
//                , "•\tqualification_2_" + numberResume
//        )));
//        resume.setSection(SectionType.EXPERIENCE, new ListExperience(new Experience(
//                "nameOrganisation_1_" + numberResume
//                , "websiteLink_1_" + numberResume
//                , new Experience.Period(LocalDate.of(2007, 3, 1), LocalDate.of(2008, 6, 1)
//                , "post_1_" + numberResume
//                , "postDuties_1_" + numberResume)
//        )));
//        resume.setSection(SectionType.EXPERIENCE, new ListExperience(new Experience(
//                "nameOrganisation_2_" + numberResume
//                , "websiteLink_2_" + numberResume
//                , new Experience.Period(LocalDate.of(2014, 10, 1)
//                , LocalDate.of(2016, 1, 1)
//                , "post_2_" + numberResume
//                , "postDuties_2_" + numberResume)
//        )));
//        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
//                "nameOrganisation_3_" + numberResume
//                , "websiteLink_3_" + numberResume
//                , new Experience.Period(LocalDate.of(2011, 3, 1)
//                , LocalDate.of(2011, 4, 1)
//                , "post_3_" + numberResume
//                , "")
//        )));
//        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
//                "nameOrganisation_4_" + numberResume
//                , "websiteLink_4_" + numberResume
//                , new Experience.Period(LocalDate.of(2013, 3, 1)
//                , LocalDate.of(2013, 5, 1)
//                , "post_4_" + numberResume
//                , "")
//        )));
//        resume.setSection(SectionType.EDUCATION, new ListExperience(new Experience(
//                "nameOrganisation_5_" + numberResume
//                , "websiteLink_5_" + numberResume
//                , new Experience.Period(LocalDate.of(1993, 9, 1)
//                , LocalDate.of(1997, 7, 1)
//                , "post_5_1_" + numberResume
//                , "")
//                , new Experience.Period(LocalDate.of(1987, 9, 1)
//                , LocalDate.of(1993, 7, 1)
//                , "post_5_2_" + numberResume
//                , "")
//        )));

        return resume;
    }
}
