/*

    NOMBRE DE LA CLASE: Main.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se agrego una funcion para la lectura y/o creacion de archivos antes de la ejecicion leerArchivos()

*/
import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Vista v = new Vista();
        Vector parqueo = new Vector<EspacioParqueo>(5, 5);
        Vector carros = new Vector<Carro>(5, 5);
        Archivos a = new Archivos();

        
        int opcion;
        int rechazados;
        v.saludar();
        while(true){
            opcion = v.mostrarMenu();
            switch(opcion){
                case 1: // Parquear
                    String placa = v.pedirPlaca();
                    String marca = v.pedirMarca();
                    int modelo = v.pedirModelo();
                    Carro c = new Carro(placa, marca, modelo);
                    a.parquearCarro(c);
                break;
                case 2: //Retirar
                break;
                case 3: //Ampliar
                break;
                case 4: //Horarios de mayor utilizacio
                break;
                case 5: // Tiempo promedio de uso
                break;
                case 6: // Numero de Parqueo mas utilizado
                break;
                case 8: // Rechazados
                break;
                case 9: // Mostrar caracteristicas de parqueo mas utilizado
                break;
                case 10: // Salir
                    v.despedir();
                    System.exit(1);
                break;
                default:
                    v.opcionInvalida();
                break;
            }
        }
    }
}