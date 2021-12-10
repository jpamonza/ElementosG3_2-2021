package ed;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class DiscursoTest{
    @Test
    public void test1(){
        String[] parrafos = {
            "estimados competidores esta es una prueba que les permitira llegar mas alla de lo que esperan exito en sus emprendimientos adelante con tezon constancia esfuerzo y sacrificio",
            "el tezon y esfuerzo que ustedes le ponen a la competencia es un examen a la hora de la clasificacion la constancia es camino a la superacion y ahora que se acerca el final de la competencia es hora de demostrar su valor constancia y superacion"
        };
        
        String[] diccionario = {
            "cerca", "hora", "ahora", "concurso", "examen",
            "competencia", "clasificacion", "superacion",
            "constancia", "corriente", "tezon", "excluido",
            "cantidad", "valor"
        };
        
        String[] stop = {
            "y", "o", "de", "la", "el", "las", "los", "es",
            "un", "una", "esa", "con", "por", "que", "se",
            "su", "sus", "lo", "a", "en", "le", "les"
        };
        
        Discurso d = new Discurso();
        
        assertTrue(
            Arrays.equals(
                new boolean[]{false, true},
                d.analizar(parrafos, diccionario, stop)
            )
        );
    }
}
