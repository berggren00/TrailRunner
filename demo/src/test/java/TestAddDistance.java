package com.example;

import org.junit.jupiter.api.Test;

public class TestAddDistance {

    @Test
    public void testAddDistance
        AddDistance distance = new AddDistance();
        distance.addDistance(5.0)
        assertEquals(5.0, distance.getTotalDistance());
}