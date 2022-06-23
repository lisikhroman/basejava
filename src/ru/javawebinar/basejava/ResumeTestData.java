package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class ResumeTestData {

    public static final String resumeUuid = UUID.randomUUID().toString();
    public static final Resume resume_1 = new Resume(resumeUuid, "Григорий Кислин");

    static {
        resume_1.setContacts(ContactType.PHONE, "+7(921) 855-0482");
        resume_1.setContacts(ContactType.SKYPE, "skype:grigory.kislin");
        resume_1.setContacts(ContactType.EMAIL, "gkislin@yandex.ru");
        resume_1.setContacts(ContactType.LINKEDIN_PROFILE, "https://www.linkedin.com/in/gkislin");
        resume_1.setContacts(ContactType.GITHUB_PROFILE, "https://github.com/gkislin");
        resume_1.setContacts(ContactType.STACKOVERFLOW_PROFILE, "https://stackoverflow.com/users/548473");
        resume_1.setContacts(ContactType.HOMEPAGE, "http://gkislin.ru/");

        resume_1.setSections(SectionType.OBJECTIVE, new SimpleLineSection("Ведущий стажировок и корпоративного" +
                " обучения по Java Web и Enterprise технологиям"));
        resume_1.setSections(SectionType.PERSONAL, new SimpleLineSection("Аналитический склад ума, сильная " +
                "логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume_1.setSections(SectionType.ACHIEVEMENT, new BulletedListSection(List.of(
                "•\tОрганизация команды и успешная реализация Java проектов для сторонних заказчиков: приложения " +
                        "автопарк на стеке Spring Cloud/микросервисы, система мониторинга показателей спортсменов на " +
                        "Spring Boot, участие в проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для " +
                        "комплексных DIY смет;"
                , "•\tС 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный " +
                        "maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                        "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                        "Более 3500 выпускников."
        )));
        resume_1.setSections(SectionType.QUALIFICATIONS, new BulletedListSection(List.of(
                "•\tJEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2;"
                , "•\tVersion control: Subversion, Git, Mercury, ClearCase, Perforce"
        )));
        resume_1.setSections(SectionType.EXPERIENCE, new ListExperience(List.of(new Experience(
                "Enkata"
                , "http://enkata.com/"
                , LocalDate.of(2007, 3, 1)
                , LocalDate.of(2008, 6, 1)
                , "Разработчик ПО"
                , "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, " +
                "Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."))));
        resume_1.setSections(SectionType.EXPERIENCE, new ListExperience(List.of(new Experience(
                "Wrike"
                , "https://www.wrike.com/"
                , LocalDate.of(2014, 10, 1)
                , LocalDate.of(2016, 1, 1)
                , "Старший разработчик (backend)"
                , "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."))));
        resume_1.setSections(SectionType.EDUCATION, new ListExperience(List.of(new Experience(
                "Luxoft"
                , "https://ibs-training.ru/kurs/obektno-orientirovannyy_analiz_i_proektirovanie_na_uml.html"
                , LocalDate.of(2011, 3, 1)
                , LocalDate.of(2011, 4, 1)
                , "Курс 'Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.'"
                , ""))));
        resume_1.setSections(SectionType.EDUCATION, new ListExperience(List.of(new Experience(
                "Coursera"
                , "https://www.coursera.org/course/progfun"
                , LocalDate.of(2013, 3, 1)
                , LocalDate.of(2013, 5, 1)
                , "'Functional Programming Principles in Scala' by Martin Odersky"
                , ""))));
    }

    public static void main(String[] args) {
        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle() + " " + resume_1.getContacts(type));
        }
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + "\n" + resume_1.getSections(type));
            System.out.println();
        }
    }
}
