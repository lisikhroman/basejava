package ru.javawebinar.basejava;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.util.Collections;
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
        resume_1.setSections(SectionType.ACHIEVEMENT, new BulletedListSection("•\tОрганизация команды и успешная " +
                "реализация Java проектов для сторонних заказчиков: приложения автопарк на стеке Spring " +
                "Cloud/микросервисы, система мониторинга показателей спортсменов на Spring Boot, участие в " +
                "проекте МЭШ на Play-2, многомодульный Spring Boot + Vaadin проект для комплексных DIY смет",
                "•\tС 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\", \"Многомодульный" +
                        " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие " +
                        "(JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. Более 3500 выпускников.",
                "•\tРеализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                        "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "•\tНалаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, " +
                        "Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery." +
                        " Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java " +
                        "сервера.",
                "•\tРеализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC," +
                        " GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "•\tСоздание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base " +
                        "архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии " +
                        "через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и " +
                        "мониторинга системы по JMX (Jython/ Django).",
                "•\tРеализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, " +
                        "Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
                ,""
                ,""
                ,""
                ,""
                ,""
                ,""
                ,""
        ));
        resume_1.setSections(SectionType.QUALIFICATIONS, new BulletedListSection("•\tJEE AS: GlassFish (v2.1, v3), OC4J," +
                " JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "•\tVersion control: Subversion, Git, Mercury, ClearCase, Perforce",
                "•\tDB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, MySQL, SQLite, MS SQL," +
                        " HSQLDB",
                "•\tLanguages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy",
                "•\tXML/XSD/XSLT, SQL, C/C++, Unix shell scripts",
                "•\tJava Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, " +
                        "Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT)," +
                        " Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "•\tPython: Django.",
                "•\tJavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "•\tScala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "•\tТехнологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, " +
                        "MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, " +
                        "OAuth2, JWT.",
                "•\tИнструменты: Maven + plugin development, Gradle, настройка Ngnix",
                "•\tадминистрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport," +
                        " OpenCmis, Bonita, pgBouncer",
                "•\tОтличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных " +
                        "шаблонов, UML, функционального программирования",
                "•\tРодной русский, английский \"upper intermediate\""
        ));
        resume_1.setSections(SectionType.EXPERIENCE,
                new ListExperience(
                        Collections.singletonList(new Experience("Java Online Projects"
                                , "http://javaops.ru/"
                                , LocalDate.now()
                                , LocalDate.now()
                                , "Автор проекта "
                                , "Создание, организация и проведение Java онлайн проектов и стажировок."))));
    }

    public static void main(String[] args) {
        for (ContactType type : ContactType.values()) {
            System.out.println(type.getTitle() + " " + resume_1.getContacts(type));
        }
        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle() + "\n" + resume_1.getSections(type));
        }
    }
}
