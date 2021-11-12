package ed.edl;
public class Bolsita<T>{
    private NodoBolsita<T> inicio; 
    public static void main(String[] args){
        Bolsita<Integer> b = new Bolsita();
        b.insertar(1);
        b.insertar(2);
        b.insertar(4);
        b.insertar(2);
        b.insertar(3);
        b.insertar(4);
        b.insertar(2);
        b.insertar(2);
        b.insertar(3);
        System.out.println(b.toString());
    }
    public Bolsita(){
        inicio = null;
    }
    public boolean vacia(){
        return inicio == null;
    }
    public void insertar(T dato){
        if(vacia()){
            inicio = new NodoBolsita(dato);
        }else{
            NodoBolsita<T> act = buscar(dato);
            if(act == null){
                act = inicio;
                while(act.getSuc() != null)
                    act = act.getSuc();
                NodoBolsita<T> nuevo = new NodoBolsita(dato);
                act.setSuc(nuevo);
                nuevo.setAnt(act);
            }else{
                act.aumentarCant();
                if(act != inicio){
                    if(act.getAnt() != null)
                        act.getAnt().setSuc(act.getSuc());
                    if(act.getSuc() != null)
                        act.getSuc().setAnt(act.getAnt());
                    act.setAnt(null);
                    act.setSuc(null);
                    insertar(act);
                }
            }
        }
    }
    private void insertar(NodoBolsita<T> n){
        NodoBolsita<T> act = inicio;
        while(act != null && act.compareTo(n) >= 0){
            act = act.getSuc();
        }
        if(act == inicio){
            inicio.setAnt(n);
            n.setSuc(inicio);
            inicio = n;
        }else{
            NodoBolsita<T> ant = act.getAnt();
            ant.setSuc(n);
            n.setAnt(ant);
            act.setAnt(n);
            n.setSuc(act);
        }
    }
    private NodoBolsita<T> buscar(T dato){
        NodoBolsita act = inicio;
        while(act != null && act.getDato() != dato){
            act = act.getSuc();
        }
        return act;
    }
    @Override
    public String toString(){
        String res = "{";
        NodoBolsita<T> aux = inicio;
        boolean mostrarComa = false;
        while(aux != null){
            if(mostrarComa)
                res += ", ";
            else
                mostrarComa = true;
            res += aux.toString();
            aux = aux.getSuc();
        }
        res += "}";
        return res;
    }
}
