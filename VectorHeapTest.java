import org.junit.Test;
import static org.junit.Assert.*;

public class VectorHeapTest {

    @Test
    public void testAddAndRemove() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan", "Fractura", "C"));
        heap.add(new Paciente("Maria", "Apendicitis", "A"));
        
        Paciente primero = heap.remove();
        assertEquals("A", primero.getCodigoEmergencia());
        assertEquals("Maria", primero.toString().split(",")[0].trim());
    }
}