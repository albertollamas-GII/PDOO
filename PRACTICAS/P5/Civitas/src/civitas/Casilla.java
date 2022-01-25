/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;


/**
 *
 * @author albertollamasgonzalez
 */


public class Casilla {
    protected String nombre;
    
    Casilla(String nombre){
        this.nombre = nombre;
    }
   
        
    Casilla(Casilla unaCasilla){
        this.nombre = "";
        if (unaCasilla != null){
            this.nombre = unaCasilla.getNombre();
        }
    }
   
    public String getNombre(){
        return nombre;
    }
    
 
    @Override
    public String toString(){
        String estado = "\nNombre de la casilla: " + nombre + ".\n";
        return estado;
    }
    
    void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre()
                + " ha caido en la casilla " + this.getNombre() );
    }
    
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
    }

     
}
