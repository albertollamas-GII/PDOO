package domotica;

public abstract class Habitacion implements Cloneable {
    private int idHabitacion;
    protected boolean bombillaEncendida; // true = encendida, false = apagada
    
    @Override
    public Habitacion clone() throws CloneNotSupportedException {
        Habitacion nueva = (Habitacion) super.clone();
        nueva.idHabitacion = this.idHabitacion;
        nueva.bombillaEncendida = this.bombillaEncendida;
        return nueva;
    }

    public Habitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
        this.bombillaEncendida = false;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void subirLuz() {
        this.bombillaEncendida = true;
    }

    public void bajarLuz() {
        this.bombillaEncendida = false;
    }

    public void mostrar() {
        System.out.println("Es una habitación");
    }

    public abstract int getIluminacion();
}
