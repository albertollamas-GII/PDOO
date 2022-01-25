package domotica;

public class Dormitorio extends Habitacion implements Cloneable {
    private boolean persianaSubida;
    private int camas;
    
    @Override
    public Dormitorio clone() throws CloneNotSupportedException {
        Dormitorio nuevo = (Dormitorio) super.clone();
        nuevo.camas = this.camas;
        nuevo.persianaSubida = this.persianaSubida;
        return nuevo;
    }    

    public Dormitorio(int idHabitacion, int camas) {
        super(idHabitacion); // inicialización de los atributos heredados
        this.persianaSubida = false; // inicialización del atributo propio
        this.camas = camas;
    }

    @Override
    public void subirLuz() {
        if (!this.persianaSubida) this.persianaSubida = true;
        else super.subirLuz(); // para encender la bombilla se llama al método del padre
    }

    @Override
    public void bajarLuz() {
        if (this.bombillaEncendida) // se puede acceder a atributo del padre por ser protected 
            super.bajarLuz(); // para bajar la luz se llama al método del padre
        else this.persianaSubida = false;
    }

    public int getCamas() {
        return camas;
    }

    @Override
    public void mostrar() {
        System.out.println("Es un dormitorio");
    }

    @Override
    public int getIluminacion() {
        int suma = 0;
        if (this.bombillaEncendida) suma += 1;
        if (this.persianaSubida) suma += 1;
        return suma;
    }
}
