import org.junit.jupter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TrailRunner {


    @Test
    public void testAddDistance {
        tracker.addDistance(5.0);
        assertEquals(5.0,tracker.getTotalDistance());

    }
}
