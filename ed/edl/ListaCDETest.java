package ed.edl;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ListaCDETest{
    @Test
    public void vacia_ListaVacia_True(){
        ListaCDE<Integer> l1 = new ListaCDE();
        assertEquals(true, l1.vacia());
    }
    @Test
    public void vacia_ListaConUnElemento_False(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(15);
        assertEquals(false, l1.vacia());
    }
    @Test
    public void longitud_ListaCDEVacia_0(){
        ListaCDE<Integer> l1 = new ListaCDE();
        
        assertEquals(0, l1.longitud());
    }
    @Test
    public void longitud_ListaCDE3Elementos_3(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        assertEquals(3, l1.longitud());
    }
    @Test
    public void acceder_ListaCDEVacia_Null(){
        ListaCDE<Integer> l1 = new ListaCDE();
        assertEquals(null, l1.acceder(0));
    }
    @Test
    public void acceder_PosicionNegativa_Elemento(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5);     //0,    -3
        l1.insertar(6);     //1,    -2
        l1.insertar(7);     //2,    -1
        assertEquals(new Integer(7), l1.acceder(-1));
    }
    @Test
    public void acceder_PosicionPositiva_Elemento(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        assertEquals(new Integer(5), l1.acceder(0));
        assertEquals(new Integer(6), l1.acceder(1));
        assertEquals(new Integer(7), l1.acceder(2));
    }
    @Test
    public void insertarPos_PosicionNegativa_TamanioOriginal(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5);//0,-4
        l1.insertar(6);//1,-3
        //(4)            2,-2
        l1.insertar(7);//3,-1
        l1.insertar(4, -1);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(4), l1.acceder(-2));
    }
    @Test
    public void insertarPos_PosicionInicial_TamanioOriginalMas1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        l1.insertar(8, 0);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(0));
    }
    @Test
    public void insertarPos_PosicionInicial2_TamanioOriginalMas1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0,3
        l1.insertar(6); //pos = 1,4
        l1.insertar(7); //pos = 2,5
        //longitud = 3
        l1.insertar(8, 3);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(0));
    }
    @Test
    public void insertarPos_PosicionEnMedio_TamanioOriginalMas1(){
        ListaCDE<Integer> l1 = new ListaCDE();
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
    public void insertarPos_PosicionEnMedio2_TamanioOriginalMas1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0   ,   3
        l1.insertar(6); //pos = 1   ,   4
        l1.insertar(7); //pos = 2   ,   5
        //longitud = 3
        assertEquals(3, l1.longitud());
        assertEquals(new Integer(6), l1.acceder(1));
        l1.insertar(8, 4);
        assertEquals(4, l1.longitud());
        assertEquals(new Integer(8), l1.acceder(1));
    }
    @Test
    public void eliminar_ListaConUnElemento_ListaVacia(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0, null
        //longitud = 1
        assertEquals(new Integer(5), l1.eliminar(0));
        assertEquals(null, l1.acceder(0));
        assertEquals(0, l1.longitud());
        assertEquals(true, l1.vacia());
    }
    @Test
    public void eliminar_PosicionNegativa_TamanioOriginal(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5);
        l1.insertar(6);
        l1.insertar(7);
        assertEquals(new Integer(7), l1.eliminar(-1));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionInicial_TamanioOriginalMenos1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0
        l1.insertar(6); //pos = 1   -> 0
        l1.insertar(7); //pos = 2   -> 1
        //longitud = 3
        assertEquals(new Integer(5), l1.eliminar(0));
        assertEquals(new Integer(6), l1.acceder(0));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionInicial2_TamanioOriginalMenos1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0,3
        l1.insertar(6); //pos = 1,4   -> 0
        l1.insertar(7); //pos = 2,5   -> 1
        //longitud = 3
        assertEquals(new Integer(5), l1.eliminar(3));
        assertEquals(new Integer(6), l1.acceder(0));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionEnMedioDeLaLista_TamanioOriginalMenos1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0   -> 0
        l1.insertar(6); //pos = 1   
        l1.insertar(7); //pos = 2   -> 1
        //longitud = 3
        assertEquals(new Integer(6), l1.eliminar(1));
        assertEquals(new Integer(7), l1.acceder(1));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionEnMedioDeLaLista2_TamanioOriginalMenos1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0,3   -> 0,2,4
        l1.insertar(6); //pos = 1,4   
        l1.insertar(7); //pos = 2,5   -> 1,3
        //longitud = 3
        assertEquals(new Integer(6), l1.eliminar(4));
        assertEquals(new Integer(5), l1.acceder(4));
        assertEquals(2, l1.longitud());
    }
    @Test
    public void eliminar_PosicionFinal_TamanioOriginalMenos1(){
        ListaCDE<Integer> l1 = new ListaCDE();
        l1.insertar(5); //pos = 0   -> 0
        l1.insertar(6); //pos = 1   -> 1
        l1.insertar(7); //pos = 2
        //longitud = 3
        assertEquals(new Integer(7), l1.eliminar(2));
        assertEquals(2, l1.longitud());
    }
}
