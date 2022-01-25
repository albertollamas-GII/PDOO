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
public class Cliente {
    private String dni;
    private String nombre;
    private ArrayList<Reserva> reservas;
    
    
    Cliente(String dni, String nombre){
        this.dni = dni;
        this.nombre = nombre;
        reservas = new ArrayList<>();
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public ArrayList<Reserva> getReservas(){
        return reservas;
    }
    
    
}
