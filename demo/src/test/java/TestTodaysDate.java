
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TodaysDate;



public class TestTodaysDate {
    private TodaysDate todaysDate;
    
    @BeforeEach
    public void setup(){
    todaysDate = new TodaysDate();
    } 

    @Test public void testTodaysDateWithoutArgument() {
        assertEquals(LocalDate.now(), todaysDate.getDate());
    }

    @Test
    public void testTodaysDateWithArgument() {
        LocalDate specificDate = LocalDate.of(2025, 1, 11);
        todaysDate = new TodaysDate(specificDate);
        assertEquals(specificDate, todaysDate.getDate());
    }

    @Test
    public void testToStringMethod() {
        LocalDate specificDate = LocalDate.of(2025, 1, 11);
        todaysDate = new TodaysDate(specificDate);
        assertEquals("2025-01-11", todaysDate.toString());
    }

    @Test
    public void testSetDate(){
        LocalDate newDate = LocalDate.of(2025, 1, 11);
        todaysDate.setDate(newDate);

        assertEquals(newDate, todaysDate.getDate());
    }

}
