/*

    NOMBRE DE LA CLASE: Main.java
    PROGRAMADOR: FGrancisoc Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        -

*/

public class Main{
    public static void main(String[] args) {
        Vista v = new Vista();
        int opcion;

        v.saludar();
        while(true){
            opcion = v.mostrarMenu();
            switch(opcion){
                case 1: // Parquear
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
                    System.exit(1);
                break;
                default:
                    v.opcionInvalida();
                break;
            }
        }
    }
}