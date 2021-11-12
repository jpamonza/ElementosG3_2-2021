package ed.edl;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaSETest{
    @Test
    public void vacia_ListaSEVacia_True(){
        ListaSE<Integer> l1 = new ListaSE();
        assertEquals(true, l1.vacia());
    }
    @Test
    public void vacia_ListaSENoVacia_False(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1);
        assertEquals(false, l1.vacia());
    }
    @Test
    public void longitud_ListaSEConDosElementos_2(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1);
        l1.insertar(2);
        assertEquals(2, l1.longitud());
    }
    @Test
    public void longitud_ListaSEVacia_0(){
        ListaSE<Integer> l1 = new ListaSE();
        assertEquals(0, l1.longitud());
    }
    @Test
    public void acceder_ListaVacia_Null(){
        ListaSE<Integer> l1 = new ListaSE();
        assertEquals(null, l1.acceder(0));
    }
    @Test
    public void acceder_PosicionInvalida_Null(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(null, l1.acceder(5));
    }
    @Test
    public void acceder_PosicionValida_Elemento(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(new Integer(2), l1.acceder(1));
    }
    @Test
    public void insertarPos_PosicionInvalida_SinCambios(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        l1.insertar(5, 7);
        assertEquals(2, l1.longitud());
    }
    @Test
    public void insertarPos_InsercionExitosa_5(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        l1.insertar(5, 0);
        assertEquals(3, l1.longitud());
        assertEquals(new Integer(5), l1.acceder(0));
    }
    @Test
    public void insertarPos_InsercionFinalLista_5(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        l1.insertar(5, 2); //pos -> 2
        assertEquals(3, l1.longitud());
        assertEquals(new Integer(5), l1.acceder(2));
    }
    @Test
    public void insertarPos_InsercionAlMedioDeLaLista_5(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        //         (5)  //pos -> 1
        l1.insertar(2); //pos -> 1  -> 2
        l1.insertar(3); //pos -> 2  -> 3
        l1.insertar(5, 1); //pos -> 2
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(5), l1.acceder(1));
    }
    @Test
    public void eliminar_ElimarPrimerElemento_Elemento(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(2, l1.longitud());
        assertEquals(new Integer(1), l1.eliminar(0));
        assertEquals(1, l1.longitud());
    }
    @Test
    public void eliminar_ElimarPosicionFueraDeRango_Null(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1
        assertEquals(2, l1.longitud());
        assertEquals(null, l1.eliminar(10));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_ElimarPosicionEnMedioDeLaLista_Elemento(){
        ListaSE<Integer> l1 = new ListaSE();
        l1.insertar(1); //pos -> 0
        l1.insertar(2); //pos -> 1  X
        l1.insertar(3); //pos -> 2  -> 1
        System.out.println(l1);
        assertEquals(3, l1.longitud());
        assertEquals(new Integer(2), l1.eliminar(1));
        assertEquals(2, l1.longitud());
        assertEquals(new Integer(3), l1.acceder(1));
    }
}












