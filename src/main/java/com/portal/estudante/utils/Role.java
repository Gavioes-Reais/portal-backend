package com.portal.estudante.utils;

public enum Role {

    STUDENT(1), TEACHER(2);
    private final int value;

    Role(int value){
        this.value = value;
    }

    public int getResponse() {
        return value;
    }


}
