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
public class Empleado {
    private String nombre;
    // private ArrayList<Hotel> hotel;
    
    Empleado(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
//    public boolean addTrabajo(Hotel h){
//       if (this.hotel.size() > 2){
//           return false;
//       } else{
//           this.hotel.add(h);
//           return true;
//       }
//       
//    }
}
