import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;

public class TestAddDistance {

    private AddDistance distance;
    
    @BeforeEach
    void setup(){
    distance = new AddDistance();
     }

    @Test
    void testAddDistance(){
        distance.addDistance(5.0);
        assertEquals(5.0, distance.getTotalDistance());
    }

    @Test
    void testInitialTotalDistanceisZero(){
        assertEquals(0, distance.getTotalDistance());
    }

    @Test
    void testAddNegativeDistance(){
        distance.addDistance(-2.0);
        assertEquals(-2, distance.getTotalDistance());
    }

}
