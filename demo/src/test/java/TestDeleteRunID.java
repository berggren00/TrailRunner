import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.example.DeleteRunID;

public class TestDeleteRunID {
    @Test
    void shouldDeleteRunByID() {
        DeleteRunID deleteRunID = new DeleteRunID();
        String runId = deleteRunID.addRun(5.0);
        deleteRunID.deleteRun(runId);
    }

    @Test
    void shouldThrowExceptionWhenDeletingNonExistentRunID() {
        DeleteRunID deleteRunID = new DeleteRunID();
        assertThrows(IllegalArgumentException.class, () -> 
            deleteRunID.deleteRun("nonexistent-id")
        );
    }
}
