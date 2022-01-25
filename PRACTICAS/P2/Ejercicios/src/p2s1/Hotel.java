/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2s1;

import java.util.ArrayList;

/**
 *
 * @author albertollamasgonzalez
 */
public class Hotel {
    private static int NUM_HOTEL;
    private String nombre;
    private String ciudad;
    private int estrellas;
    private Director director;
    private ArrayList<Reserva> reservas;
    private ArrayList<Empleado> empleados;
    private ArrayList<Habitacion> habitaciones;
    
    
    
    Hotel(String unNombre, String unaCiudad, int estrellas){
        this.ciudad = unaCiudad;
        this.estrellas = estrellas;
        this.nombre = unNombre;
        NUM_HOTEL++;
        reservas = new ArrayList<>();
        empleados = new ArrayList<>();
        habitaciones = new ArrayList<>();
    }
    
    static public int getNUM_HOTELES(){
        return NUM_HOTEL;
    }
    
    public ArrayList<Empleado> getEmpleados(){
        return empleados;
    }
    
    public void setDirector(Director unDirector){
        director = new Director(unDirector);
    }
    
    public String getDirector(){
        return director.getNombre();
    }
    
    public void addReserva(Cliente cliente, String fechaEntrada, String fechaSalida){
        Reserva r = new Reserva(fechaEntrada, fechaSalida, cliente, this);
        reservas.add(r);
        cliente.addReserva(r);
    }
    
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
//    public boolean addEmpleado(Empleado empleado){
//        empleados.add(empleado);
//        return true;
//    }
    
    public boolean addEmpleado(String nombre){
        Empleado e = new Empleado(nombre);
        return empleados.add(e);
        
    }
    
    public void addHabitacion(int numero, int capacidad){
        Habitacion h = new Habitacion(numero, capacidad);
        habitaciones.add(h);
    }
    
    public int buscarHabitacionCapacidad(int capacidad){
        int numHab = -1;
        for (int i = 0; i < habitaciones.size(); i++){
            if (capacidad == habitaciones.get(i).getCapacidad()){
                numHab = habitaciones.get(i).getNumero();
            }
        }
        return numHab;
    }
}
