
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;
import com.example.AverageSpeed;
import com.example.FitnessScore;
import com.example.GenerateID;
import com.example.KilometerTime;
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
        RunDetails.addRunDetails("test", "Test details");
        distance = new AddDistance();
        runTime = new RunTime(0, 0, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
        todaysDate = new TodaysDate();
    }

    @Test
    void testAddRunDetails(){
        String id = GenerateID.generateNewID();
        String details = "Distance: 5km, Time: 25 min, Speed: 12 km/h";
        RunDetails.addRunDetails(id, details);

        assertEquals(details, RunDetails.getRunDetails(id), "Run details should match the added details");
    }


    @Test
    void testPrintRunDetails() {
        String id = GenerateID.generateNewID();
        String details = "Sample run details";

        RunDetails.addRunDetails(id, details);

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
        String id = GenerateID.generateNewID();

        distance.addDistance(10);
        runTime = new RunTime(1, 0, 0);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
        averageSpeedCalc.calculateAverageSpeed();
        todaysDate = new TodaysDate(LocalDate.of(2025, 1, 11));
        KilometerTime.calculateKilometerTime(runTime, distance);
        FitnessScore.calculateFitnessScore(0, distance, averageSpeedCalc, runTime, 0);


        RunDetails.interigateRunDetails(id, distance, runTime, averageSpeedCalc, null, null, todaysDate);
        
        
        String result = RunDetails.getRunDetails(id);
        assertTrue(result.contains("Date: 2025-01-11"));
        assertTrue(result.contains("Distance: 10.0 km"));
        assertTrue(result.contains("Time: 1h 0m 0s"));
        assertTrue(result.contains("Average Speed: 10.0 km/h"));
        assertTrue(result.contains("Kilometer Time: 6.0 m/km"));
        assertTrue(result.contains("Fitness Score: 11.66"));
    }

    @Test
    void testIntegrateRunDetailsWithCustomFitnessScore(){
        String id = GenerateID.generateNewID();

        distance.addDistance(53);
        runTime = new RunTime(1, 30, 50);
        averageSpeedCalc = new AverageSpeed(distance, runTime);
        averageSpeedCalc.calculateAverageSpeed();
        KilometerTime kilometerTime = new KilometerTime();
        todaysDate = new TodaysDate(LocalDate.of(2025, 01, 12));

        FitnessScore fitnessScore = new FitnessScore();

        RunDetails.interigateRunDetails(id, distance, runTime, averageSpeedCalc, kilometerTime, fitnessScore, todaysDate);

        String result = RunDetails.getRunDetails(id);
        System.out.println("Generated Result: \n");
        assertTrue(result.contains("Fitness Score: 73.42"));
    }

    @Test
    void testClearRunDetails() {
        RunDetails.addRunDetails("run1", "Details for run 1");
        RunDetails.clearRunDetails();
        assertEquals("No details found for ID: run1", RunDetails.getRunDetails("run1"));
    }

    @Test
    void testSetDate(){
        LocalDate newDate = LocalDate.of(2025, 01, 11);

        todaysDate.setDate(newDate);

        assertEquals(newDate, todaysDate.getDate());
    }


}
