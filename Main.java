/*

    NOMBRE DE LA CLASE: Main.java
    PROGRAMADOR: Francisco Castillo 21562
    HISTORIAL DE MODIFICACIONES:
        - Se agrego una funcion para la lectura y/o creacion de archivos antes de la ejecicion leerArchivos()
        - Se elimino la propiedad rechazados, ahora sera manejada a traves de archivos
*/

public class Main{
    public static void main(String[] args) {
        Vista v = new Vista();
        //Vector parqueo = new Vector<EspacioParqueo>(5, 5);
        //Vector carros = new Vector<Carro>(5, 5);
        Archivos a = new Archivos();

        
        int opcion;
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
                    if(!a.retirarCarro(v.pedirPlaca() ) ){
                        v.noHayPlaca();
                    }
                break;
                case 3: //Ampliar
                    int ultimo = a.getUltimoParqueo();
                    for(int i = ultimo; i < ultimo + 5; i++){
                        a.ampliarParqueo(v.pedirDatosParqueo(i + 1));
                    }
                break;
                case 4: //Horarios de mayor utilizacion
                    v.mostrarHorarioMasUtilizado(a.getHorariosMasUtilizados());
                break;
                case 5: // Tiempo promedio de uso
                    v.mostrarPromedioUso(a.usoPromedio());
                break;
                case 6: // Numero de Parqueo mas utilizado
                break;
                case 7: // Rechazados
                    v.mostrarRechazados(a.leerRechazados());
                break;
                case 8: // Marca mas utilizada

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