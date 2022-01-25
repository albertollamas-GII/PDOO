package domotica;

public class Lavabo extends Habitacion {
    public Lavabo(int idHabitacion) {
        super(idHabitacion); // inicialización de los atributos heredados
    }

    @Override
    public void mostrar() {
        System.out.println("Es un lavabo");
    }

    @Override
    public int getIluminacion() {
        if (this.bombillaEncendida) return 1;
        else return 0;
    }
}
