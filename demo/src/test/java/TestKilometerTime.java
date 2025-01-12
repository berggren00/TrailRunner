import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.KilometerTime;
import com.example.RunTime;

public class TestKilometerTime {
    private AddDistance distance;
    private RunTime runTime;
    
    @BeforeEach
    void setup(){
        distance = new AddDistance();
        runTime = new RunTime(1, 30, 0);
        new KilometerTime();
    }   

    @Test
    void testValidKilometerTime(){
        distance.addDistance(15);

        double result = KilometerTime.calculateKilometerTime(runTime, distance);
        assertEquals(6.0, result, 0.01);

    }

    @Test
    void testZeroDistance(){
        RunTime runTime = new RunTime(1, 0, 0);
        double result = KilometerTime.calculateKilometerTime(runTime, distance);
        assertEquals(-1, result);
    }

    @Test
    void testZeroTime(){
        RunTime runTime = new RunTime(0, 0, 0);
        distance.addDistance(10);

        double result = KilometerTime.calculateKilometerTime(runTime, distance);
        assertEquals(0, result);
    }

    @Test
    void testNegativeDistance() {
        RunTime runTime = new RunTime(1, 0, 0);
        distance.addDistance(-5);

        double result = KilometerTime.calculateKilometerTime(runTime, distance);
        assertEquals(-1, result);

    }

    @Test
    void testNegativeTime() {
    RunTime runTime = new RunTime(-1, 0, 0);

    double result = KilometerTime.calculateKilometerTime(runTime, distance);
    assertEquals(-1, result);
    }

}
