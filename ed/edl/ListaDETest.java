package ed.edl;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaDETest{
    @Test
    public void vacia_ListaDEVacia_True(){
        ListaDE<Integer> l1 = new ListaDE();
        
        assertEquals(true, l1.vacia());
    }
    @Test
    public void vacia_ListaDEConUnElemento_False(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5);
        assertEquals(false, l1.vacia());
    }
    @Test
    public void longitud_ListaDEVacia_0(){
        ListaDE<Integer> l1 = new ListaDE();
        
        assertEquals(0, l1.longitud());
    }
    @Test
    public void longitud_ListaDE3Elementos_3(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        assertEquals(3, l1.longitud());
    }
    @Test
    public void acceder_ListaDEVacia_Null(){
        ListaDE<Integer> l1 = new ListaDE();
        assertEquals(null, l1.acceder(0));
    }
    @Test
    public void acceder_PosicionInvalida_Null(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        assertEquals(null, l1.acceder(10));
        assertEquals(null, l1.acceder(-1));
    }
    @Test
    public void acceder_PosicionValida_Elemento(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        assertEquals(new Integer(5), l1.acceder(0));
        assertEquals(new Integer(6), l1.acceder(1));
        assertEquals(new Integer(7), l1.acceder(2));
    }
    @Test
    public void insertarPos_PosicionInvalida_TamanioOriginal(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        l1.insertar(8, 10);
        l1.insertar(1, -1);
        assertEquals(3, l1.longitud());
    }
    @Test
    public void insertarPos_PosicionInicial_TamanioOriginalMas1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        l1.insertar(8, 0);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(0));
    }
    @Test
    public void insertarPos_PosicionFinal_TamanioOriginalMas1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        l1.insertar(8, 3);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(3));
    }
    @Test
    public void insertarPos_PosicionEnMedio_TamanioOriginalMas1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        assertEquals(3, l1.longitud());
        assertEquals(new Integer(6), l1.acceder(1));
        l1.insertar(8, 1);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(1));
    }
    @Test
    public void eliminar_PosicionInvalida_TamanioOriginal(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        assertEquals(null, l1.eliminar(10));
        assertEquals(null, l1.eliminar(-1));
        assertEquals(3, l1.longitud());
    }
    @Test
    public void eliminar_PosicionInicial_TamanioOriginalMenos1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1   -> 0
        l1.insertar(7); //pos = 2   -> 1
        //longitud = 3
        assertEquals(new Integer(5), l1.eliminar(0));
        assertEquals(new Integer(6), l1.acceder(0));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_ListaConUnElemento_ListaVacia(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0, null
        //longitud = 1
        assertEquals(new Integer(5), l1.eliminar(0));
        assertEquals(null, l1.acceder(0));
        assertEquals(0, l1.longitud());
        assertEquals(true, l1.vacia());
    }
    @Test
    public void eliminar_PosicionEnMedioDeLaLista_TamanioOriginalMenos1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0   -> 0
        l1.insertar(6); //pos = 1   
        l1.insertar(7); //pos = 2   -> 1
        //longitud = 3
        assertEquals(new Integer(6), l1.eliminar(1));
        assertEquals(new Integer(7), l1.acceder(1));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionFinal_TamanioOriginalMenos1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(5); //pos = 0   -> 0
        l1.insertar(6); //pos = 1   -> 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        assertEquals(new Integer(7), l1.eliminar(2));
        assertEquals(2, l1.longitud());
    }
    /*@Test
    public void compararDatos_ListasDeDistintoTamanio_False(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(1);
        l1.insertar(2);
        //l1 tiene 2 elementos
        ListaDE<Integer> l2 = new ListaDE();
        //l2 tiene 0 elementos
        assertEquals(false, l1.compararDatos(l2));
    }
    @Test
    public void compararDatos_ListasDeIgualTamanioMismosDatos_True(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(1); //pos = 0
        l1.insertar(2); //pos = 1
        //l1 tiene 2 elementos
        ListaDE<Integer> l2 = new ListaDE();
        l2.insertar(1); //pos = 0
        l2.insertar(2); //pos = 
        //l2 tiene 2 elementos
        assertEquals(true, l1.compararDatos(l2));
    }
    @Test
    public void compararDatos_ListasDeIgualTamanioDistintosDatos_False(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(1); //pos = 0
        l1.insertar(2); //pos = 1
        l1.insertar(3); //pos = 2
        //l1 tiene 2 elementos
        ListaDE<Integer> l2 = new ListaDE();
        l2.insertar(1); //pos = 0
        l2.insertar(3); //pos = 1
        l2.insertar(2); //pos = 2
        //l2 tiene 2 elementos
        assertEquals(false, l1.compararDatos(l2));
    }
    @Test
    public void compararDatos2_ListasDeIgualTamanioDistintosDatos_True(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(1); //pos = 0
        l1.insertar(2); //pos = 1
        l1.insertar(3); //pos = 2
        //l1 tiene 3 elementos
        ListaDE<Integer> l2 = new ListaDE();
        l2.insertar(1); //pos = 0
        l2.insertar(3); //pos = 1
        l2.insertar(2); //pos = 2
        //l2 tiene 3 elementos
        assertEquals(true, l1.compararDatos2(l2));
    }
    @Test
    public void clonar_ListaConUnElemento_LongitudEs1(){
        ListaDE<Integer> l1 = new ListaDE();
        l1.insertar(1); //pos = 0
        //l1 tiene un elemento
        ListaDE<Integer> l2 = (ListaDE<Integer>)l1.clonar();
        //l2 tiene un elemento
        
        //COPIAS EXACTAS
        assertEquals(1, l1.longitud());
        assertEquals(1, l2.longitud());
        
        assertEquals(new Integer(1), l1.acceder(0));
        assertEquals(new Integer(1), l2.acceder(0));
        
        //SON OBJETOS DISTINTOS
        assertEquals(new Integer(1), l1.eliminar(0));
        assertEquals(0, l1.longitud());
        
        assertEquals(1, l2.longitud());
        assertEquals(new Integer(1), l2.acceder(0));
    }*/
}












