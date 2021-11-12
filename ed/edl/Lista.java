package ed.edl;
public interface Lista<T>{
    public boolean vacia();
    public void insertar(T dato);//al final por defecto
    public void insertar(T dato, int pos);//siempre y cuando, sea una posicion valida
    public T eliminar(int pos);
    public T acceder(int pos);
    public int longitud();
}