/*
    NOMBRE DE LA CLASE: Carro.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se ha importado java.util.Calendar para el manejo de las horas
        - horaEntrada y horaSalida ahora son enteros para ser guardados en formato 24 h y solo la hora
        - calcularHorasEstacionadas() sera void
        - se implemento el setHoraSalida
*/

import java.time.LocalDateTime;
public class Carro {
    private int horasEstacionadas;
    private String placa;
    private String marca;
    private int modelo;
    private int horaEntrada;
    private int horaSalida;

    public Carro(String placa, String marca, int modelo){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = LocalDateTime.now().getHour();
        this.horaSalida = -1;
    }

    private void calcularHorasEstacionadas(){
        if(horaSalida != -1){
            horasEstacionadas = horaSalida - horaEntrada;
        }else{
            horasEstacionadas = LocalDateTime.now().getHour() - horaEntrada;
        }
    }
    
    /** 
     * @return String
     */
    public String getPlaca(){
        return placa;
    }
    public String getMarca(){
        return marca;
    }
    public int getModelo(){
        return modelo;
    }
    
    /** 
     * @return int
     */
    public int getHorasEstacionadas(){
        calcularHorasEstacionadas();
        return horasEstacionadas;
    }
    
    /** 
     * @return int
     */
    public int getHoraEntrada(){
        return horaEntrada;
    }
    
    /** 
     * @return int
     */
    public int getHoraSalida(){
        return horaSalida;
    }
    
    /** 
     * @return String[] [placa, marca, modelo, horasEstacionadas]
     */
    public String[] getDatos(){
        String[] temp = {placa, marca, Integer.toString(modelo), Integer.toString(horasEstacionadas)};
        return temp;
    }
}
