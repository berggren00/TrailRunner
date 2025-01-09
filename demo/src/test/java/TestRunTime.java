import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.RunTime;

public class TestRunTime {
    
    @Test
    void ValidRunTime() {
        int hours = 1;
        int minutes = 32;
        int seconds = 46;

        RunTime runtime = new RunTime(hours, minutes, seconds);

        assertEquals(hours, runtime.getHours());
        assertEquals(minutes, runtime.getMinutes());
        assertEquals(seconds, runtime.getSeconds());
    }
}
