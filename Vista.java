/*

    NOMBRE DE LA CLASE: Vista.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        -Se incluyo un metodo de Saludo y despedida
        -Se incluye opcionInvalida()

*/
import java.util.InputMismatchException;
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
}
