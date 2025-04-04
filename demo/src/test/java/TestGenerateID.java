import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.GenerateID;

public class TestGenerateID {
    
    @BeforeEach
    void setup(){
        new GenerateID();
    }
    


    @Test
    void testGeneratedIDIsNotNull(){
        String id = GenerateID.generateNewID();
        assertNotNull(id, "Generated ID should not be null");
    }

   @Test
   void testGenerateIDIsUnique(){
    HashSet<String> generatedIDs = new HashSet<>();
    String id = GenerateID.generateNewID();
    for (int i = 0; i < 100; i++) {
        assertFalse(generatedIDs.contains(id), "Generated ID should be unique");
    }
   }

   @Test
   void testNotDuplicateIDsinLargeSet() {
    int numIDs = 1000;
    HashSet<String> generatedIDs = new HashSet<>();
    for (int i = 0; i < numIDs; i++) {
        String id = GenerateID.generateNewID();
        assertTrue(generatedIDs.add(id), "Duplicate ID detected" + id);
    }
   }
    
}  
