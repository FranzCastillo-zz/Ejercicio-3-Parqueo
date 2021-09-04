/*
    NOMBRE DE LA CLASE: Archivos.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se creo esta clase que resulto ser necesaria poder simplificar el manejo de archivos

*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.imageio.IIOException;

import java.io.IOException;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Archivos {
    List<String> infoParqueos; //Parqueo;Tamanio;Techado;Aereo;Veces Usado|Placa, marca, modelo, horas estacionadas
    List<String> infoHorarios;

    public Archivos(){
        leerInfoParqueo();
        leerInfoHorarios();
    }

    private void cambiarLineaParqueo(int numLinea, String datos){
        try{
            Path path = Paths.get("infoParqueo.txt");
            List<String> lines = Files.readAllLines(path);
            lines.set(numLinea, datos);
            Files.write(path, lines);
        }catch (IOException ie) {
            System.out.println("Ocurrio un error");
        }
    }
    private void leerInfoParqueo(){
        try {
            Path path = Paths.get("infoParqueo.txt");
            infoParqueos = Files.readAllLines(path);
        }catch (IOException ie) {
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
            }catch(IOException ie2){
            }
        }
    }
    private void leerInfoHorarios(){
        try {
            Path path = Paths.get("infoParqueo.txt");
            infoParqueos = Files.readAllLines(path);
        }catch (FileNotFoundException e) {
            try {
                File f = new File("infoParqueo.txt");
                if (f.createNewFile()) {
                    FileWriter w = new FileWriter("infoParqueo.txt");
                    w.write("Entrada;Salida;Horas estacionado");
                    w.close();
                }
            }catch (IOException ie) {
                System.out.println("Ocurrio un error");
            }
        }catch (IOException ie) {
            System.out.println("Ocurrio un error");
        }
    }
    public boolean parquearCarro(Carro c){
        leerInfoParqueo();
        int i = 0;
        for (String espacio : infoParqueos) {
            String[] temp = espacio.split("\\|");
            if(temp.length == 1){ //Si no tiene ningun carro parqueado
                int largo = temp[0].length();
                String actual = temp[0];
                String tempUsos = actual.substring(0, largo - 1) + (Integer.parseInt(actual.substring(largo - 1, largo)) + 1) + "|";
                String sTemp = tempUsos + c.getPlaca() + "," + c.getMarca() + ",";
                if(c.getModelo() != -1){
                    sTemp += + c.getModelo() + "," + c.getHorasEstacionadas();
                    cambiarLineaParqueo(i, sTemp);
                    return true;
                }
            }
            i++;
        }
        return false;
    }
}
