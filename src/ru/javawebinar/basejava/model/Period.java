package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Period implements Serializable {
    private final LocalDate beginPeriod;
    private final LocalDate endPeriod;
    private final String post;
    private final String postDuties;

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
        return beginPeriod.getMonthValue() + "/" + beginPeriod.getYear() + " - " +
                endPeriod.getMonthValue() + "/" + endPeriod.getYear() + '\n' +
                post + '\n' +
                postDuties + '\n';
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
