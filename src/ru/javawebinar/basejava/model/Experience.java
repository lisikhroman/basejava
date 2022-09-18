package ru.javawebinar.basejava.model;

import ru.javawebinar.basejava.util.DateUtil;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ru.javawebinar.basejava.util.DateUtil.NOW;

public class Experience implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Experience EMPTY = new Experience("", "", Period.EMPTY);

    private final Link homePage;
    private final List<Period> periods;

    public Experience(String name, String url, Period... periods) {
        this(new Link(name, url), Arrays.asList(periods));
    }

    public Experience(Link homePage, List<Period> periods) {
        this.homePage = homePage;
        this.periods = periods;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public Link getHomePage() {
        return homePage;
    }

    @Override
    public String toString() {
        return homePage + " " + periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        return homePage.equals(that.homePage);
    }

    @Override
    public int hashCode() {
        return homePage.hashCode();
    }

    public static class Period implements Serializable {

        public static final Period EMPTY = new Period();
        private LocalDate beginPeriod;
        private LocalDate endPeriod;
        private String post;
        private String postDuties;

        public Period() {
        }

        public Period(int startYear, Month startMonth, String post, String postDuties) {
            this(DateUtil.of(startYear, startMonth), NOW, post, postDuties);
        }

        public Period(int startYear, Month startMonth, int endYear, Month endMonth, String post, String postDuties) {
            this(DateUtil.of(startYear, startMonth), DateUtil.of(endYear, endMonth), post, postDuties);
        }

        public Period(LocalDate beginPeriod, LocalDate endPeriod, String post, String postDuties) {
            Objects.requireNonNull(beginPeriod, "beginPeriod must not be null");
            Objects.requireNonNull(endPeriod, "endPeriod must not be null");
            Objects.requireNonNull(post, "post must not be null");
            this.beginPeriod = beginPeriod;
            this.endPeriod = endPeriod;
            this.post = post;
            this.postDuties = postDuties;
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
            return beginPeriod.getMonthValue() + "/" + beginPeriod.getYear() + " - " + endPeriod.getMonthValue() + "/" + endPeriod.getYear() + '\n' + post + '\n' + postDuties + '\n';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Period period = (Period) o;

            if (!beginPeriod.equals(period.beginPeriod)) return false;
            if (!endPeriod.equals(period.endPeriod)) return false;
            if (!post.equals(period.post)) return false;
            return Objects.equals(postDuties, period.postDuties);
        }

        @Override
        public int hashCode() {
            int result = beginPeriod.hashCode();
            result = 31 * result + endPeriod.hashCode();
            result = 31 * result + post.hashCode();
            result = 31 * result + (postDuties != null ? postDuties.hashCode() : 0);
            return result;
        }
    }
}
