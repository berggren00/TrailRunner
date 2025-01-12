import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.TotalDistanceInKM;

public class TestTotalDistanceInKM {
    private TotalDistanceInKM distanceTracker;

    @BeforeEach
    void setUp() {
        distanceTracker = new TotalDistanceInKM();
    }

    @Test
    void newRun_ZeroDistance() {
        double totalDistance = distanceTracker.getTotalDistance();
        
        assertEquals(0, totalDistance, "New tracker should have 0 distance");
    }

    @Test
    void newRun_ZeroRuns() {
        int totalRuns = distanceTracker.getTotalRuns();
        
        assertEquals(0, totalRuns, "New tracker should have 0 runs");
    }

    @Test
    void addingRun_ShouldIncreaseDistance() {
        distanceTracker.addRun(5.0);
        double firstTotal = distanceTracker.getTotalDistance();

        distanceTracker.addRun(3.0);
        double secondTotal = distanceTracker.getTotalDistance();

        assertEquals(5.0, firstTotal, "Total distance should match added run - 5");
        assertEquals(8.0, secondTotal, "Total distance should match added run - 8");
    }

    @Test
    void addingRun_ShouldIncreaseTotalRuns() {
        distanceTracker.addRun(2.0);
        int firstCount = distanceTracker.getTotalRuns();

        distanceTracker.addRun(22.0);
        int secondCount = distanceTracker.getTotalRuns();

        assertEquals(1, firstCount, "Total runs should match added run - 1");
        assertEquals(2, secondCount, "Total runs should match added run - 2");
    }

}
