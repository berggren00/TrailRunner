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
    void addingSingleRun() {
        distanceTracker.addRun(5.0);
        assertEquals(5.0, distanceTracker.getTotalDistance(), "Total distance should match single added run");
    }

    @Test
    void addingMultipleRuns() {
        distanceTracker.addRun(5.0);
        distanceTracker.addRun(3.0);
        
        assertEquals(8.0, distanceTracker.getTotalDistance(), "Total distance should match added run - 8");
    }

    @Test
    void addingFirstRun() {
        distanceTracker.addRun(2.0);
        
        assertEquals(1, distanceTracker.getTotalRuns(), "Total runs should match added run - 1");
    }

    @Test
    void addingRun_ShouldIncreaseTotalRuns() {
        distanceTracker.addRun(2.0);
        distanceTracker.addRun(22.0);
        
        assertEquals(2, distanceTracker.getTotalRuns(), "Total runs should match added run - 2");
    }

}
