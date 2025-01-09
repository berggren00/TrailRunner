import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.example.AddDistance;

public class TestAddDistance {
    @Test
    public void testAddDistance(){
        AddDistance distance = new AddDistance();
        distance.addDistance(5.0);
        assertEquals(5.0, distance.getTotalDistance());
    }
}
