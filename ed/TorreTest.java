package ed;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TorreTest{
    @Test
    public void agregarValoresATorre(){
        Torre t = new Torre();
        
        t.agregar("A"); // A
        t.agregar("A"); // A A
        t.agregar("B"); // A B A
        t.agregar("A"); // A A B A
        
        assertEquals("A A B A", t.toString().trim());
    }
}
