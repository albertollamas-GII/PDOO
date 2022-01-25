/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2s1;

/**
 *
 * @author albertollamasgonzalez
 */
public class Habitacion {
    private int numero;
    private int capacidad;
    
    Habitacion(int numero, int capacidad){
        this.numero = numero;
        this.capacidad = capacidad;
    }
    
    public int getCapacidad(){
        return capacidad;
    }
    
    public int getNumero(){
        return numero;
    }
}
