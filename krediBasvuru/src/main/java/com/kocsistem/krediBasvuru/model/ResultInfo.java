package com.kocsistem.krediBasvuru.model;

public class ResultInfo {

    private String error;
    private String creditScore;
    private int creditLimit;

    public void setError(String error) {
        this.error = error;
    }

    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public int getCreditLimit() {
        return this.creditLimit;
    }

    public String getCreditScore() {
        return this.creditScore;
    }

    public String getError() {
        return this.error;
    }

}