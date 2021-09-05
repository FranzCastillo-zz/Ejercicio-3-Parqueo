/*

    NOMBRE DE LA CLASE: Vista.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        -Se incluyo un metodo de Saludo y despedida
        -Se incluye opcionInvalida()
        -Se incluyo un MostrarRechazados()
        -Se incluyo un noHayPlaca()
*/
import java.util.Scanner;
public class Vista {
    private Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    public void saludar(){
        System.out.println("Hola! Bienvenido al parqueo.");
    }
    public void despedir(){
        System.out.println("Adios!");
    }
    public void opcionInvalida(){
        System.out.println("Ha ingresado una opcion invalida, vuelva a intentarlo.");
    }
    public int mostrarMenu(){
        try{
            System.out.println("");
            System.out.println("Que desea hacer ahora? (Ingrese el numero de opcion que desea)");
            System.out.println("1. Parquear un carro");
            System.out.println("2. Retirar un carro del parqueo");
            System.out.println("3. Ampliar parqueo");
            System.out.println("4. Mostrar horarios de mayor utilizacion");
            System.out.println("5. Mostrar el tiempo promedio en parqueo");
            System.out.println("6. Mostrar el parqueo mas utilizado");
            System.out.println("7. Mostrar cantidad de vehiculos rechazados");
            System.out.println("8. Mostrar la marca de carros mas utilizada");
            System.out.println("9. Caracteristicas del parqueo mas utilizado");
            System.out.println("10. Salir");
            int temp = scan.nextInt();
            scan.nextLine();
            return temp;
        }
        catch(Exception e){
            scan.next();
			return -1;
        }
    }
    public String pedirPlaca(){
        System.out.println("Ingrese la placa del vehiculo que va a ingresar: ");
        return scan.nextLine();
    }
    public String pedirMarca(){
        System.out.println("Ingrese la marca del vehiculo: ");
        return scan.nextLine();
    }
    public int pedirModelo(){
        try{
            System.out.println("Ingrese el modelo del vehiculo: (Ej. 2012)");
            int temp = scan.nextInt();
            return temp;
        }catch(Exception e){
            return -1;
        }
    }
    public void mostrarRechazados(int rechazados){
        System.out.println("Se ha rechazado un total de: " + rechazados + " vehiculos");
    }
    public void noHayPlaca(){
        System.out.println("No existe un carro parqueado con esta placa.");
    }
    public void mostrarHorarioMasUtilizado(String[] datos){
        System.out.println("La hora de entrada mas popular es: " + datos[0]);
        System.out.println("La hora de salida mas popular es: " + datos[1]);
    }
    public String pedirDatosParqueo(int numParqueo){
        String temp = "";
        temp += Integer.toString(numParqueo) + ";";
        System.out.println("Ingrese el tamanio del nuevo parqueo ["+ numParqueo +"]: (Compacto, Estandar, Grande)");
        temp += scan.nextLine() + ";";
        System.out.println("Ingrese si es techado: (true / false)");
        temp += scan.nextLine() + ";";
        System.out.println("Ingrese si es aereo: (true / false)");
        temp += scan.nextLine() + ";";
        temp += "0" + "|";
        return temp;
    }
    public void mostrarPromedioUso(int dato){
        System.out.println("El parqueo se utiliza, en promedio, " + dato + " horas");
    }
}
