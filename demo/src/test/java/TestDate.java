import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Date;

public class TestDate {
    private Date date;

    @BeforeEach
    void setup(){
        date = new Date();
    }
    


    @Test
    void testGeneratedIDIsNotNull(){
        String id = date.generateID();
        assertNotNull(id, "Generated ID should not be null");
    }

   @Test
   void testGenerateIDIsUnique(){
    HashSet<String> generatedIDs = new HashSet<>();
    String id = date.generateID();
    for (int i = 0; i < 1000; i++) {
        assertFalse(generatedIDs.contains(id), "Generated ID should be unique");
    }
   }

   @Test
   void testNotDuplicateIDsinLargeSet() {
    int numIDs = 100000;
    HashSet<String> generatedIDs = new HashSet<>();
    for (int i = 0; i < numIDs; i++) {
        String id = date.generateID();
        assertTrue(generatedIDs.add(id), "Duplicate ID detected" + id);
    }
   }
    
}  
