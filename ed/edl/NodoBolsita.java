package ed.edl;
public class NodoBolsita<T> implements Comparable<NodoBolsita>{
    private T dato;
    private int cant;
    private NodoBolsita<T> ant, suc;
    public NodoBolsita(T d){
        dato = d;
        cant = 1;
        ant = suc = null;
    }
    @Override
    public boolean equals(Object o){
        boolean iguales = false;
        if(o instanceof NodoBolsita){
            if(dato.equals(((NodoBolsita)o).dato))
                iguales = true;
        }
        return iguales;
    }
    public void aumentarCant(){
        cant++;
    }
    public int compareTo(NodoBolsita o){
        int res;
        //res = ((Integer)cant).compareTo(o.cant);
        if(this.cant < o.cant){
            res = -1;
        }else if(this.cant == o.cant)
            res = 0;
        else
            res = 1;
        return res;
    }
    public int getCant(){
        return cant;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T d){
        dato = d;
    }
    public NodoBolsita<T> getAnt(){
        return ant;
    }
    public void setAnt(NodoBolsita<T> a){
        ant = a;
    }
    public NodoBolsita<T> getSuc(){
        return suc;
    }
    public void setSuc(NodoBolsita<T> s){
        suc = s;
    }
    @Override
    public String toString(){
        return "(" + dato.toString() + "," + cant + ")";
    }
}
