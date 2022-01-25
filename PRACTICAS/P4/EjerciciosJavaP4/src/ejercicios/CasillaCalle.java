/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

/**
 *
 * @author albertollamasgonzalez
 */
public class CasillaCalle extends Casilla {
    private int numCasas;
    
    public CasillaCalle(String nombre, int numCasas) {
        super(nombre);
        this.numCasas = numCasas;
    }
    //1
//    boolean recibeJugador(){
//        System.out.println("Se ha recibido un jugador.");
//        return true;
//    }
    //2
//    @Override
//    boolean recibeJugador(){
//        System.out.println("Soy una casilla Calle y he recibido un jugador.");
//        return true;
//    }
    //3-reutilizando codigo del padre
    @Override
    boolean recibeJugador(){
        boolean salidaPadre = super.recibeJugador();
        if (salidaPadre){
            System.out.print("y además soy una Casilla calle.\n");
            return true;
        } else
            return false;
    }
    
    void construirCasa(){
        this.numCasas++;
        System.out.println("Tiene " + this.numCasas + " casas.");
    }
    
}
