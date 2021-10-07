public abstract class Auto implements Encendible, Interface1 {
    private String placa;
    public Auto(String placa){
        this.placa = placa;
    }
    
    public boolean encender(){
        return true;
    }
}
