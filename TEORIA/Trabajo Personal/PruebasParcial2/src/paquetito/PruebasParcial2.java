package paquetito;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import paquetito.Hijo1;
import paquetito.Hijo2;
import paquetito.Padre;

/**
 *
 * @author albertollamasgonzalez
 */
public class PruebasParcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Padre p = new Padre(3);
        p.aumentaHadi();
        Hijo1 h = new Hijo1(); 
        System.out.println("Hadi Padre:" + p.getHadi() + "\tHadi Hijo: " + h.getHadi() );
    }
    
}
