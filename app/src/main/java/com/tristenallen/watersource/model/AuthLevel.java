package com.tristenallen.watersource.model;

/**
 * Created by tristen on 2/21/17.
 */
public enum AuthLevel {
    USER("User"), WORKER("Worker"), MANAGER("Manager"), ADMINISTRATOR("Admin");

    private String shortName;

    AuthLevel(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return shortName;
    }
}
