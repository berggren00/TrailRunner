
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.RunDetails;
import com.example.RunTime;

public class TestRunDetails {
    private AddDistance distance;
    private RunTime runTime;
    private AverageSpeed averageSpeedCalc;
    
    @BeforeEach
    void setup() {
        RunDetails.clearRunDetails();
        RunDetails.addRundetails("test", "Test details");
        distance = new AddDistance();
        runTime = new RunTime(0, 0, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
    }

    @Test
    void testAddRunDetails(){
        String id = "testrun1";
        String details = "Distance: 5km, Time: 25 min, Speed: 12 km/h";
        RunDetails.addRundetails(id, details);

        assertEquals(details, RunDetails.getRunDetails(id), "Run details should match the added details");
    }

    @Test
    void testGetRunDetailsExistingID() {
        String id = "test";
        String expectedDetails = "Test details";

        assertEquals(expectedDetails, RunDetails.getRunDetails(id), "Run details should be retrieved correctly for existing ID");
    }

    @Test
    void testGetRunDetailsNonExistingID(){
        String id = "nonExistingID";
        String expectedMessage = "No details found for ID: nonExistingID";

        assertEquals(expectedMessage, RunDetails.getRunDetails(id), "Should return message for non-existing ID");
    }

    @Test
    void getIntegrateRunDetails() {
        String id = "integrateRun1";

        distance.addDistance(10);
        runTime = new RunTime(0, 45, 0);
        
        RunDetails.interigateRunDetails(id, distance, runTime, averageSpeedCalc, null, null, null);

        String details = RunDetails.getRunDetails(id);        
        assertTrue(details.contains("Distance: 10.0 km"), "Details should contain correct distance");
        assertTrue(details.contains("Time: 0h 45m 0s"), "Details should contain correct time");
        assertTrue(details.contains("Average Speed"), "Details should include average speed information");

    }

}
