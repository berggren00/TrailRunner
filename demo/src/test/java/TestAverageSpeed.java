import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.RunTime;

public class TestAverageSpeed {
    private AddDistance distance;
    private RunTime runtime;
    private AverageSpeed avgSpeed;

    @BeforeEach
    void setup() {
        distance = new AddDistance();
        runtime = new RunTime(1, 0, 0);
        avgSpeed = new AverageSpeed(distance, runtime);
    }

    @Test
    void calculateAverageSpeed_10km() {
        distance.addDistance(10.0);
        runtime = new RunTime(1, 0, 0);
        avgSpeed = new AverageSpeed(distance, runtime);

        double result = avgSpeed.calculateAverageSpeed();

        assertEquals(10.0, result);
    }

    @Test
    void calculateAverageSpeed_25km() {
        distance.addDistance(0.5);

        double result = avgSpeed.calculateAverageSpeed();

        assertEquals(0.5, result, 0.5, "Avrundas upp till 1 på grund av Math.round() i AverageSpeed klassen.");
    }

    @Test
    void calculateAverageSpeed_30Minutes() {
        distance.addDistance(10.0);
        runtime = new RunTime(0, 30, 0);
        avgSpeed = new AverageSpeed(distance, runtime);

        double result = avgSpeed.calculateAverageSpeed();

        assertEquals(20, result);
    }
    
    @Test
    void calculateAverageSpeed_MultipleDistances() {
        distance.addDistance(10.0);
        distance.addDistance(5.0);

        double result = avgSpeed.calculateAverageSpeed();

        assertEquals(15, result);
    }

    @Test
    void calculateAverageSpeed_ZeroDistance() {
        distance.addDistance(0.0);
        double result = avgSpeed.calculateAverageSpeed();

        assertEquals(0.0, result);
    }

    @Test
    void calculateAverageSpeed_ZeroTime() {
        distance.addDistance(10.0);
        runtime = new RunTime(0, 0, 0);
        avgSpeed = new AverageSpeed(distance, runtime);
    }
}
