import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.FitnessScore;
import com.example.KilometerTime;
import com.example.RunTime;

public class TestFitnessScore {

    private AddDistance distance;
    private RunTime runTime;
    private AverageSpeed averageSpeedCalc;
    
    @BeforeEach
    void setup(){
        distance = new AddDistance();
        runTime = new RunTime(1, 30, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);

    }


    @Test
    void testValidFitnessScore() {
        distance.addDistance(15);

        double currentScore = 50.0;
        int daysSinceLastRun = 3;

        double result = FitnessScore.calculateFitnessScore(currentScore, distance, averageSpeedCalc, runTime, daysSinceLastRun);

        double expectedKilometerTime = KilometerTime.calculateKilometerTime(runTime, distance);
        double expected = 50 + (15 + averageSpeedCalc.calculateAverageSpeed() / expectedKilometerTime) - 3 / 2.0;

        assertEquals(expected, result, 0.01);
    }

    @Test
    void testInvalidKilometerTime(){
        runTime = new RunTime(0, 0, 0);

        double currentScore = 40.0;
        int daysSinceLastRun = 5;
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(currentScore, distance, averageSpeedCalc, runTime, daysSinceLastRun);
        });
    }

    @Test
    void testAverageSpeedCalcNull(){
        distance.addDistance(10.0);
        averageSpeedCalc = null;
        runTime = new RunTime(1, 30, 0);
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(0, distance, averageSpeedCalc, runTime, 0);
        });
    }

    @Test
    void testRunTimeNull() {
        distance.addDistance(10.0);
        averageSpeedCalc.calculateAverageSpeed();
        runTime = null;
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(0, distance, averageSpeedCalc, runTime, 0);
        });
    }


    @Test
    void testAddDistanceNull(){
        distance = null;
        averageSpeedCalc.calculateAverageSpeed();
        runTime = new RunTime(1, 30, 0);
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(0, distance, averageSpeedCalc, runTime, 0);
        });

    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(0, null, null, null, 0);
        });
    }
}
