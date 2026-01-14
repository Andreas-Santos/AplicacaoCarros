package com.br.appCarros.AplicacaoCarros.model;

public class Spent {
    private double value;
    private String title;
    private String description;

    public Spent() {}

    public Spent(double value, String title, String description) {
        this.value = value;
        this.title = title;
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
