
package domotica;

public class LimpiezaEspecializada <T extends Habitacion>{
    void limpiar(T habitacion){
        System.out.println("Estoy limpiando "+habitacion.getIdHabitacion());
    }
}

