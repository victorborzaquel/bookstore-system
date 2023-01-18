package com.victor.bookstoresystem.utils;

public class Id {
    private static Integer currentId = 0;
    private Id(){}
    public static Integer generate() {
        return ++currentId;
    }
}
