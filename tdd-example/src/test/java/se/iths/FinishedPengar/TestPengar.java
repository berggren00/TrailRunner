package se.iths.FinishedPengar;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestPengar {
    @Test
    public void testMultiplication() {
        Pengar femma = Pengar.kronor(5);

        assertEquals(Pengar.kronor(10), femma.times(2));
        assertEquals(Pengar.kronor(15), femma.times(3));
    }

    @Test
    public void testEquality() {
        assertTrue(Pengar.kronor(5).equals(Pengar.kronor(5)));
        assertFalse(Pengar.kronor(5).equals(Pengar.kronor(6)));
        assertFalse(Pengar.kronor(5).equals(Pengar.euro(5)));
    }

    @Test
    public void testCurrency() {
        assertEquals("EUR", Pengar.euro(1).currency());
        assertEquals("SEK", Pengar.kronor(1).currency());
    }

    @Test
    public void testSimpleAddition() {
        Pengar sum = Pengar.kronor(5).plus(Pengar.kronor(5));

        assertEquals(Pengar.kronor(10), sum);
    }
}
