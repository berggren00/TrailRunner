
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TodaysDate;



public class TestTodaysDate {
    private TodaysDate todaysDate;
    
    @BeforeEach
    void setup(){
    todaysDate = new TodaysDate();
    } 

    @Test 
    void testTodaysDateWithoutArgument() {
        assertEquals(LocalDate.now(), todaysDate.getDate());
    }

    @Test
    void testTodaysDateWithArgument() {
        LocalDate specificDate = LocalDate.of(2025, 1, 11);
        todaysDate = new TodaysDate(specificDate);
        assertEquals(specificDate, todaysDate.getDate());
    }

    @Test
    void testToStringMethod() {
        LocalDate specificDate = LocalDate.of(2025, 1, 11);
        todaysDate = new TodaysDate(specificDate);
        assertEquals("2025-01-11", todaysDate.toString());
    }

    @Test
    void testSetDate(){
        LocalDate newDate = LocalDate.of(2025, 1, 11);
        todaysDate.setDate(newDate);

        assertEquals(newDate, todaysDate.getDate());
    }

}
