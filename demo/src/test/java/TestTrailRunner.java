package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestTrailRunner {


    @Test
    public void testAddDistance {
        tracker.addDistance(5.0);
        assertEquals(5.0,tracker.getTotalDistance());

    }
}
