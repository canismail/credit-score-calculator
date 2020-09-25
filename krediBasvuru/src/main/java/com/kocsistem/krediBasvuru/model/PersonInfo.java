package com.kocsistem.krediBasvuru.model;

public class PersonInfo {

    private String id;
    private String name;
    private String phoneNumber;
    private int salary;
    private String score;
    private int limit;

    public void setScore(String score) {
        this.score = score;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public int getSalary() {
        return this.salary;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getScore() {
        return this.score;
    }

    public int getLimit() {
        return this.limit;
    }

}
