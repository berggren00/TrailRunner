import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.KilometerTime;
import com.example.RunTime;

public class TestKilometerTime {

    @Test
    public void testValidKilometerTime(){
        RunTime runTime = new RunTime(1, 30, 0);
        AddDistance addDistance = new AddDistance();

        addDistance.addDistance(15);

        double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
        assertEquals(6.0, result, 0.01);

    }

    @Test
    public void testZeroDistance(){
        RunTime runTime = new RunTime(1, 0, 0);
        AddDistance addDistance = new AddDistance();

        double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
        assertEquals(-1, result);
    }

    @Test
    public void testZeroTime(){
        RunTime runTime = new RunTime(0, 0, 0);
        AddDistance addDistance = new AddDistance();
        addDistance.addDistance(10);

        double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
        assertEquals(0, result);
    }

    @Test
    public void testNegativeDistance() {
        RunTime runTime = new RunTime(1, 0, 0);
        AddDistance addDistance = new AddDistance();
        addDistance.addDistance(-5);

        double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
        assertEquals(-1, result);

    }

    @Test
    public void testNegativeTime() {
    RunTime runTime = new RunTime(-1, 0, 0);
    AddDistance addDistance = new AddDistance();

    double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
    assertEquals(-1, result);
    }

}
