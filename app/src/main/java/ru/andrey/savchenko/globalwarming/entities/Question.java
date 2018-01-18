package ru.andrey.savchenko.globalwarming.entities;

/**
 * Created by savchenko on 18.01.18.
 */

public class Question {
    private int id;
    private String good;
    private String bad;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", good='" + good + '\'' +
                ", bad='" + bad + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }

    public String getBad() {
        return bad;
    }

    public void setBad(String bad) {
        this.bad = bad;
    }

    public Question(int id, String good, String bad) {
        this.id = id;
        this.good = good;
        this.bad = bad;
    }
}
