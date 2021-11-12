package ed.edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaSERTest{
    @Test
    public void vacia_ListaVacia_True(){
        ListaSER<Integer> l1 = new ListaSER();
        assertEquals(true, l1.vacia());
    }
    @Test
    public void vacia_ListaConUnElemento_False(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1);
        assertEquals(false, l1.vacia());
    }
    @Test
    public void longitud_ListaVacia_0(){
        ListaSER<Integer> l1 = new ListaSER();
        assertEquals(0, l1.longitud());
    }
    @Test
    public void longitud_ListaConDosElemento_2(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1);
        l1.insertar(2);
        assertEquals(2, l1.longitud());
    }
    @Test
    public void acceder_ListaConDosElementoAccediendoALaPos1_2(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(new Integer(2), l1.acceder(1));
    }
    @Test
    public void acceder_PosicionFueraDeRango_Null(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(null, l1.acceder(5));
    }
    @Test
    public void insertarPos_InsertarInicio_Elemento(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0  -> 1
        l1.insertar(3, 0);  //pos -> 0
        l1.insertar(2); //pos -> 2
        assertEquals(new Integer(3), l1.acceder(0));
        assertEquals(new Integer(1), l1.acceder(1));
    }
    @Test
    public void insertarPos_InsertarFinal_Elemento(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0, longitud -> 1
        l1.insertar(3, 1);  //pos -> 1, longitud -> 2
        assertEquals(new Integer(3), l1.acceder(1));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void insertarPos_InsertarEnMedioDeLaLista_Elemento(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1  -> 2
        l1.insertar(3); //pos -> 2  -> 3
        
        l1.insertar(0, 1);  //pos -> 1
        assertEquals(new Integer(0), l1.acceder(1));
        assertEquals(new Integer(1), l1.acceder(0));
        assertEquals(new Integer(2), l1.acceder(2));
        assertEquals(new Integer(3), l1.acceder(3));
    }
    @Test
    public void eliminar_EliminarPrimerElemento_Elemento(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(new Integer(1), l1.eliminar(0));
        assertEquals(1, l1.longitud());
    }
    @Test
    public void eliminar_EliminarElementoDeEnMedio_Elemento(){
        ListaSER<Integer> l1 = new ListaSER();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        l1.insertar(3); //pos -> 2
        assertEquals(new Integer(2), l1.eliminar(1));
        assertEquals(2, l1.longitud());
    }
}













