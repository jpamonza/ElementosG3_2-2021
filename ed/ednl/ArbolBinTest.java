package ed.ednl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ArbolBinTest{
    @Test
    public void test1(){
        ArbolBin<Integer> a1, a2;
        a1 = new ArbolBin();
        a2 = new ArbolBin();
        
        a1.insertarAmplitud(1);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(3);
        
        a2.insertarAmplitud(5);
        a2.insertarAmplitud(2);
        a2.insertarAmplitud(3);
        
        assertEquals(true, a1.samefringe(a2));
    }
    @Test
    public void test2(){
        ArbolBin<Integer> a1, a2;
        a1 = new ArbolBin();
        a2 = new ArbolBin();
        
        a1.insertarAmplitud(1);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(3);
        
        a2.insertarAmplitud(5);
        a2.insertarAmplitud(2);
        
        assertEquals(false, a1.samefringe(a2));
    }
    @Test
    public void test3(){
        ArbolBin<Integer> a1;
        a1 = new ArbolBin();
        
        a1.insertarAmplitud(1);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(3);
        
        assertEquals(false, a1.simetrico());
    }
    @Test
    public void test4(){
        ArbolBin<Integer> a1;
        a1 = new ArbolBin();
        
        a1.insertarAmplitud(1);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(2);
        
        assertEquals(true, a1.simetrico());
    }
    @Test
    public void test5(){
        ArbolBin<Integer> a1;
        a1 = new ArbolBin();
        
        a1.insertarAmplitud(1);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(2);
        a1.insertarAmplitud(3);
        a1.insertarAmplitud(4);
        a1.insertarAmplitud(4);
        a1.insertarAmplitud(3);
        
        assertEquals(true, a1.simetrico());
    }
    @Test
    public void testNivelesAmplitud(){
        ArbolBin<Integer> a = new ArbolBin();
        a.insertarAmplitud(5);
        a.insertarAmplitud(4);
        a.insertarAmplitud(90);
        a.insertarAmplitud(35);
        a.insertarAmplitud(21);
        a.insertarAmplitud(-1);
        a.insertarAmplitud(2);
        a.insertarAmplitud(9);
        a.insertarAmplitud(-2);
        a.insertarAmplitud(6);
        a.insertarAmplitud(1);
        a.insertarAmplitud(-3);
        a.insertarAmplitud(15);
        
        a.amplitudNiveles();
    }
    @Test
    public void testPodar(){
        ArbolBin<Integer> a = new ArbolBin();
        a.insertarAmplitud(5);
        a.insertarAmplitud(4);
        a.insertarAmplitud(90);
        a.insertarAmplitud(35);
        a.insertarAmplitud(21);
        a.insertarAmplitud(-1);
        a.insertarAmplitud(2);
        a.insertarAmplitud(9);
        a.insertarAmplitud(-2);
        a.insertarAmplitud(6);
        a.insertarAmplitud(1);
        a.insertarAmplitud(-3);
        a.insertarAmplitud(15);
        
        a.amplitudNiveles();
        a.podar(2);
        a.amplitudNiveles();
    }
    
    @Test
    public void testFrontera(){
        ArbolBin<Integer> a = new ArbolBin();
        a.insertarAmplitud(5);
        a.insertarAmplitud(4);
        a.insertarAmplitud(90);
        a.insertarAmplitud(35);
        a.insertarAmplitud(21);
        a.insertarAmplitud(-1);
        a.insertarAmplitud(2);
        a.insertarAmplitud(9);
        a.insertarAmplitud(-2);
        a.insertarAmplitud(6);
        a.insertarAmplitud(1);
        a.insertarAmplitud(-3);
        a.insertarAmplitud(15);
        
        System.out.println(a.frontera());
    }
}




















