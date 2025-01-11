
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

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
}
