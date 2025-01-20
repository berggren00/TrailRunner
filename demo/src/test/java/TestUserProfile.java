
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.UserInput;

class TestUserProfile {

    @Test
    void validInputsShouldCreateObject() {
        UserInput input = new UserInput(170, 25, 70.5);
        
        assertEquals(170, input.getHeightCm());
        assertEquals(25, input.getAgeYears());
        assertEquals(70.5, input.getWeightKg());
    }

    @Test
    void invalidHeightShouldThrowException() {
        assertThrows(IllegalArgumentException.class, 
            () -> new UserInput(0, 25, 70.5));
    }

    @Test
    void invalidAgeShouldThrowException() {
        assertThrows(IllegalArgumentException.class, 
            () -> new UserInput(170, -1, 70.5));
    }

    @Test
    void invalidWeightShouldThrowException() {
        assertThrows(IllegalArgumentException.class, 
            () -> new UserInput(170, 25, 0));
    }
}