public class EspacioParqueo {
    private String tamanio;
    private int largo;
    private int ancho;
    private int altura;
    private boolean techado;
    private boolean aereo;
    private String parqueadoActual;
    private int vecesUsado;

    public EspacioParqueo(){

    }
    public String getTamanio(){
        return tamanio;
    }
    public boolean isTechado(){
        return techado;
    }
    public boolean isAereo(){
        return aereo;
    }
    public String getParqueadoActual(){
        return "";
    }
    public int getVecesUsado(){
        return -1;
    }
}
