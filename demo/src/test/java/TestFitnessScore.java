import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.FitnessScore;
import com.example.KilometerTime;
import com.example.RunTime;

public class TestFitnessScore {
    @Test
    public void testValidFitnessScore() {
        AddDistance distance = new AddDistance();
        distance.addDistance(15);

        RunTime runTime = new RunTime(1, 30, 0);
        
        AverageSpeed averageSpeedCalc = new AverageSpeed(distance, runTime);

        double currentScore = 50.0;
        int daysSinceLastRun = 3;

        double result = FitnessScore.calculateFitnessScore(currentScore, distance, averageSpeedCalc, runTime, daysSinceLastRun);

        double expectedKilometerTime = KilometerTime.calculateKilometerTime(runTime, distance);
        double expected = 50 + (15 + averageSpeedCalc.calculateAverageSpeed() / expectedKilometerTime) - 3 / 2.0;

        assertEquals(expected, result, 0.01);
    }

    @Test
    public void testInvalidKilometerTime(){
        AddDistance addDistance = new AddDistance();
        RunTime runTime = new RunTime(0, 0, 0);
        AverageSpeed averageSpeedCalc = new AverageSpeed(addDistance, runTime);

        double currentScore = 40.0;
        int daysSinceLastRun = 5;

        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(currentScore, addDistance, averageSpeedCalc, runTime, daysSinceLastRun);
        });
    }

    @Test
    public void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> {
            FitnessScore.calculateFitnessScore(30, null, null, null, 2);
        });
    }
}
