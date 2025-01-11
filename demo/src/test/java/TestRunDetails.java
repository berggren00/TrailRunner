
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.RunDetails;
import com.example.RunTime;
import com.example.TodaysDate;

public class TestRunDetails {
    private AddDistance distance;
    private RunTime runTime;
    private AverageSpeed averageSpeedCalc;
    private TodaysDate todaysDate;

    @BeforeEach
    void setup() {
        RunDetails.clearRunDetails();
        RunDetails.addRundetails("test", "Test details");
        distance = new AddDistance();
        runTime = new RunTime(0, 0, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
        todaysDate = new TodaysDate();
    }

    @Test
    void testAddRunDetails(){
        String id = "testrun1";
        String details = "Distance: 5km, Time: 25 min, Speed: 12 km/h";
        RunDetails.addRundetails(id, details);

        assertEquals(details, RunDetails.getRunDetails(id), "Run details should match the added details");
    }

    @Test
    void testPrintRunDetails() {
        String id = "run1";
        String details = "Sample run details";

        RunDetails.addRundetails(id, details);

        RunDetails.printRunDetails(id);
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
    void testInterigateRunDetails() {
        String id = "run2";

        distance.addDistance(10);
        runTime = new RunTime(1,0, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
        averageSpeedCalc.calculateAverageSpeed();
        todaysDate = new TodaysDate(LocalDate.of(2025, 1, 11));

        RunDetails.interigateRunDetails(id, distance, runTime, averageSpeedCalc, null, null, todaysDate);

        String result = RunDetails.getRunDetails(id);
        assertTrue(result.contains("Date: 2025-01-11"));
        assertTrue(result.contains("Distance: 10.0 km"));
        assertTrue(result.contains("Time: 1h 0m 0s"));
        assertTrue(result.contains("Average Speed: 10.0 km/h"));

    }

}
