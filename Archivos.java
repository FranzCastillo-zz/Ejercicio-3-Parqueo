/*
    NOMBRE DE LA CLASE: Archivos.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se creo esta clase que resulto ser necesaria poder simplificar el manejo de archivos

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.Map;

public class Archivos {
    List<String> infoParqueos; //Parqueo;Tamanio;Techado;Aereo;Veces Usado|Placa, marca, modelo, horas estacionadas
    List<String> infoHorarios;

    public Archivos(){
        leerInfoParqueo();
        leerInfoHorarios();
    }
    private void crearArchivoParqueo(){
        try{
            File f = new File("infoParqueo.txt");
            if (f.createNewFile()) {
                FileWriter w = new FileWriter("infoParqueo.txt");
                w.write("1;Compacto;true;false;0|\n"+
                    "2;Estandar;true;false;0|\n"+
                    "3;Grande;true;false;0|\n"+
                    "4;Estandar;true;false;0|\n"+
                    "5;Grande;true;false;0|");
                w.close();
            }
        }catch(IOException ie){}
    }
    private void crearArchivoHorario(){
        try {
            File f = new File("infoHorarios.txt");
            if (f.createNewFile()) {
                FileWriter w = new FileWriter("infoHorarios.txt");
                w.write("Entrada;Salida;Horas estacionado");
                w.close();
            }
        }catch (IOException ie) {
            System.out.println("Ocurrio un error");
        }
    }
    private void cambiarLineaParqueo(int numLinea, String datos){
        try{
            Path path = Paths.get("infoParqueo.txt");
            List<String> lines = Files.readAllLines(path);
            lines.set(numLinea, datos);
            Files.write(path, lines);
        }catch (IOException ie) {
            crearArchivoParqueo();
        }
    }
    private void cambiarLineaHorario(int numLinea, String datos){
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            lines.set(numLinea, datos);
            Files.write(path, lines);
        }catch (IOException ie) {
            crearArchivoHorario();
        }
    }
    private void leerInfoParqueo(){
        try {
            Path path = Paths.get("infoParqueo.txt");
            infoParqueos = Files.readAllLines(path);
        }catch (IOException ie) {
            crearArchivoParqueo();
        }
    }
    private void leerInfoHorarios(){
        try {
            Path path = Paths.get("infoHorarios.txt");
            infoHorarios = Files.readAllLines(path);
        }catch (FileNotFoundException e) {
            
        }catch (IOException ie) {
            crearArchivoHorario();
        }
    }
    public int leerRechazados(){
        leerInfoHorarios();
        String linea = infoHorarios.get(0);
        String[] temp = linea.split(";");
        return Integer.parseInt(temp[temp.length - 1]);
    }
    private void incrementarRechazados(){
        leerInfoHorarios();
        String[] temp = infoHorarios.get(0).split(";");
        int antes = Integer.parseInt(temp[temp.length - 1]);
        int nuevo = antes + 1;
        String datos = temp[0] + ";" + temp[1] + ";" + temp[2] + ";" + nuevo;
        cambiarLineaHorario(0, datos);
    }
    private void escribirHoraEntrada(int hora){
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            lines.add(Integer.toString(hora) + ";");
            Files.write(path, lines);
        }catch (IOException ie) {
            crearArchivoHorario();
        }
    }
    private int calcularHorasEstacionadas(int i){
        int horas = 0;
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            String[] temp = lines.get(i).split(";");
            int inicio = Integer.parseInt(temp[0]);
            int fin = Integer.parseInt(temp[1]);
            horas = fin - inicio;
        }catch (IOException ie) {
            crearArchivoHorario();
        }
        return horas;
    }
    private void escribirHoraSalida(int hora){
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            int i = 0;
            for (String linea : lines) {
                String[] temp = linea.split(";");
                if(temp.length == 1){
                    String texto = temp[0] + ";" + Integer.toString(hora);
                    lines.set(i, texto);
                    Files.write(path, lines);
                    texto +=  ";" + calcularHorasEstacionadas(i);
                    lines.set(i, texto);
                    Files.write(path, lines);
                    return;
                }else{
                    i++;
                }
            }
        }catch (IOException ie) {
            crearArchivoHorario();
        }
    }
    public void parquearCarro(Carro c){
        leerInfoParqueo();
        int i = 0;
        boolean parqueado = false;
        for (String espacio : infoParqueos) {
            String[] temp = espacio.split("\\|");
            if(temp.length == 1){ //Si no tiene ningun carro parqueado
                String actual = temp[0];
                int largo = actual.length();
                String tempUsos = actual.substring(0, largo - 1) + (Integer.parseInt(actual.substring(largo - 1, largo)) + 1) + "|";
                String sTemp = tempUsos + c.getPlaca() + "," + c.getMarca() + ",";
                if(c.getModelo() != -1){
                    sTemp += + c.getModelo() + "," + c.getHoraEntrada();
                    cambiarLineaParqueo(i, sTemp);
                    escribirHoraEntrada(c.getHoraEntrada());
                    parqueado = true;
                    return;
                }
            }
            i++;
        }
        if(!parqueado){
            incrementarRechazados();
        }
    }
    public boolean retirarCarro(String placa){
        leerInfoParqueo();
        int i = 0;
        boolean retirado = false;
        for (String espacio : infoParqueos) {
            String[] temp = espacio.split("\\|");
            if(temp.length > 1){ //Si tiene ningun carro parqueado
                String[] datosCarro = temp[1].split(",");
                if(datosCarro[0].equals(placa)){
                    cambiarLineaParqueo(i, temp[0] + "|");
                    retirado = true;
                    escribirHoraSalida(LocalDateTime.now().getHour());
                }
            }
            i++;
        }
        return retirado;
    }
    private String palabraMasUsada(String[] datos){
        // BY: https://www.geeksforgeeks.org/frequent-word-array-strings/
        HashMap<String, Integer> hs = new HashMap<String, Integer>();
        for (int i = 0; i < datos.length; i++) {
            if (hs.containsKey(datos[i])) {
                hs.put(datos[i], hs.get(datos[i]) + 1);
            }
            else {
                hs.put(datos[i], 1);
            }
        }
        Set<Map.Entry<String, Integer> > set = hs.entrySet();
        String key = "";
        int value = 0;
        for (Map.Entry<String, Integer> me : set) {
            if (me.getValue() > value) {
                value = me.getValue();
                key = me.getKey();
            }
        }
        return key;
    }
    public String[] getHorariosMasUtilizados(){
        String[] resultado = new String[2];
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            List<String> tempEntrada = new ArrayList<String>();
            List<String> tempSalida = new ArrayList<String>();
            for (String linea : lines) {
                String[] temp = linea.split(";");
                if(!temp[0].equals("")){
                    tempEntrada.add(temp[0]);
                }
                if(temp.length > 1 && !temp[1].equals("")){
                    tempSalida.add(temp[1]);
                }
            }
            

            String[] arreglo = new String[tempEntrada.size()];
            tempEntrada.toArray(arreglo);
            resultado[0] = palabraMasUsada(arreglo);

            arreglo = new String[tempSalida.size()];
            tempSalida.toArray(arreglo);
            resultado[1] = palabraMasUsada(arreglo);

            return resultado;
        }catch (IOException ie) {
            System.out.println("Ocurrio un error");
            return resultado;
        }
    }
    public int getUltimoParqueo(){
        leerInfoParqueo();
        String linea = infoParqueos.get(infoParqueos.size() - 1);
        String[] temp = linea.split(";");
        return Integer.parseInt(temp[0]);
    }
    public void ampliarParqueo(String datos){
        leerInfoParqueo();
        try{
            Path path = Paths.get("infoParqueo.txt");
            List<String> lines = Files.readAllLines(path);
            lines.add(datos);
            Files.write(path, lines);
        }catch (IOException ie) {
            System.out.println("Ocurrio un error");
        }
    }
    public int usoPromedio(){
        int promedio = 0;
        int i = 0;
        try{
            Path path = Paths.get("infoHorarios.txt");
            List<String> lines = Files.readAllLines(path);
            for (String linea : lines) {
                String[] temp = linea.split(";");
                if(!temp[0].equals("Entrada")){
                    if(temp.length > 1) {
                        promedio += Integer.parseInt(temp[2]);
                        i++;
                    }
                }
            }
            promedio /= i;
        }catch(IOException ie){
            crearArchivoHorario();
        }
        return promedio;
    }
}
