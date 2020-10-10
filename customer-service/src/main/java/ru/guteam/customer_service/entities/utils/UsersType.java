package ru.guteam.customer_service.entities.utils;

public enum UsersType {
    CUSTOMER("C"), RESTAURANT("R");

    private String code;

    private UsersType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
