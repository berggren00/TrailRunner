import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.KilometerTime;
import com.example.RunTime;

public class TestKilometerTime {

    @Test
    public void testKillometerTime() {
    RunTime runTime = new RunTime(1, 30, 0);
    AddDistance addDistance = new AddDistance();

    addDistance.addDistance(15.0);

    double result = KilometerTime.calculateKilometerTime(runTime, addDistance);
    
    assertEquals(6.0, result, 0.01);
    }
}