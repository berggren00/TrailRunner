package com.example;

import java.util.UUID;


public class GenerateID {
    public static String generateNewID(){
        return UUID.randomUUID().toString().substring(0,6);
    }
}
