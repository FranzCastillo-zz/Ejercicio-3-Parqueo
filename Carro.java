/*
    NOMBRE DE LA CLASE: Carro.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se ha importado java.util.Calendar para el manejo de las horas
        - horaEntrada y horaSalida ahora son enteros para ser guardados en formato 24 h y solo la hora
        - No fue necesario getHorasEstacionadas(), getHoraSalida(), getDatos()
*/

import java.time.LocalDateTime;
public class Carro {
    private String placa;
    private String marca;
    private int modelo;
    private int horaEntrada;

    public Carro(String placa, String marca, int modelo){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.horaEntrada = LocalDateTime.now().getHour();
    }    
    /** 
     * @return String la placa del vehiculo
     */
    public String getPlaca(){
        return placa;
    }
    
    /** 
     * @return String marca del vehiculo
     */
    public String getMarca(){
        return marca;
    }
    
    /** 
     * @return int anio modelo del vehiculo
     */
    public int getModelo(){
        return modelo;
    }
    /** 
     * @return int hora de entrada del vehiculo
     */
    public int getHoraEntrada(){
        return horaEntrada;
    }
}
