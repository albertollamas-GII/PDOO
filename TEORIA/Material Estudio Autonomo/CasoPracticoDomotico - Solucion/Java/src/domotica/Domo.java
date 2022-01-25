package domotica;

import java.util.ArrayList;

public class Domo {
    private ArrayList<Habitacion> habitaciones; // relación de agregación

    public Domo() {
        this.habitaciones = new ArrayList<>();
    }

    // Constructor copia
    public Domo(Domo otro) {
        this.habitaciones = new ArrayList<>();
        Habitacion nueva = null;
        for(Habitacion hab: otro.habitaciones) {
            try {
                nueva = hab.clone();
            } catch (CloneNotSupportedException e) {
                System.err.println("CloneNotSupportedException");
            }
            this.habitaciones.add(nueva);
        }
    }
    
    public void incluirHabitación(Habitacion habitacion) {
        this.habitaciones.add(habitacion);
    }

    private Habitacion buscarHabitacion(int idHabitacion) {
        for(Habitacion hab: this.habitaciones) {
            if (hab.getIdHabitacion() == idHabitacion) return hab;
        }
        return null;
    }

    public void subirLuz(int idHabitacion) {
        Habitacion hab = buscarHabitacion(idHabitacion);
        if (hab != null) hab.subirLuz();
    }

    public void bajarLuz(int idHabitacion) {
        Habitacion hab = buscarHabitacion(idHabitacion);
        if (hab != null) hab.bajarLuz();
    }
    
}
