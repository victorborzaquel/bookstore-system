package com.victor.bookstoresystem.utils;

import com.victor.bookstoresystem.enums.IdType;

import java.util.EnumMap;
import java.util.Map;

public class Id {
    private static final Map<IdType, Integer> currentId = new EnumMap<>(IdType.class);
    private Id(){}
    public static Integer generate(IdType type){
        currentId.put(type, currentId.getOrDefault(type, 0) + 1);
        return currentId.get(type);
    }
}
