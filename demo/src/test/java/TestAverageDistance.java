import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.AverageDistance;

public class TestAverageDistance {
    @Test
    void testCalculateAverageDistance() { // Skapar uträkning av "Average Distance" i km.
        
        AverageDistance calculator = new AverageDistance();
        
        calculator.addRun(3.0);  // 3 km
        calculator.addRun(5.0);  // 5 km
        calculator.addRun(4.0);  // 4 km

        
        double averageDistance = calculator.calculateAverageDistance();   // Räknar ut Average Distance

       
        assertEquals(4.0, averageDistance, 0.01); // Verifierar att uträkningen stämmer. 
        // Borde resultera i 3 + 5 + 4 / 3 = 4. (Resultat =4.0)
    }

    @Test
    void testCalculateAverageDistanceNoRuns() {
        AverageDistance calculator = new AverageDistance();
        assertEquals(0.0, calculator.calculateAverageDistance(), 0.01);
    }
}