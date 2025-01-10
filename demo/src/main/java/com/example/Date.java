package com.example;

import java.util.UUID;


public class Date {
    public static String generateID(){
        return UUID.randomUUID().toString();
    }
}
