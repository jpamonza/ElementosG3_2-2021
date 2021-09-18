public class Hospital extends Edificio {
    @Override
    public boolean ingresar(Personal posibleMedico){
        boolean res;
        
        if(posibleMedico instanceof Medico){
            res = true;
        }else{
            res = false;
        }
        
        return res;
    }
}
