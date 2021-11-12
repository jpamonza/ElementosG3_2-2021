package ed.edl;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class SetTest{
    @Test
    public void test1(){
        Set<Integer> s = new Set();
        s.insertar(1);
        s.insertar(2);
        s.insertar(3);
        s.insertar(2);//este no se inserta
        s.insertar(3);
        System.out.println(s);
    }
    @Test
    public void test2(){
        Set<Integer> s = new Set();
        s.insertar(1);
        s.insertar(2);
        s.insertar(3);
        s.insertar(2);//este no se inserta
        s.insertar(3);
        System.out.println(s);
        s.eliminar(2);
        System.out.println(s);
    }
    @Test
    public void test3(){
        Set<Integer> s = new Set();
        s.insertar(1);
        s.insertar(2);
        s.insertar(3);
        s.insertar(2);//este no se inserta
        s.insertar(3);
        System.out.println("Set antes de la eliminacion:" + s);
        s.eliminar(5);
        System.out.println("Set despues de la eliminacio del 5:"+s);
    }
}
