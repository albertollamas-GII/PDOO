/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;

/**
 *
 * @author albertollamasgonzalez
 */
public class main {
    public static void main(String args[]){
//        Casilla c = new Casilla("Pablo");
//        CasillaCalle cc = new CasillaCalle("Pablo", 4);
//        
////        c.recibeJugador();
//        cc.recibeJugador(); //1 .Puede utilizar el metodo de la clase padre porque es exactamente igual que el del hijo
//                            //2. Ahora ejecuta el metodo de su clase en vez de la clase padre
//                            //3. El de su clase
//         //4                  
//        //c.construirCasa(); da error
//        cc.construirCasa();
//        ArrayList<Casilla> tablero = new ArrayList<>();
//        tablero.add(c); tablero.add(cc);
//        
//       // tablero.get(0).construirCasa(); No se puede porque Casilla no tiene ni el atributo numCasas ni el metodo construirCasa
//       ((CasillaCalle) tablero.get(1)).construirCasa(); //Lo solucionamos haciendo un casting 
        Casilla cale = new CasillaCalle("luis", 0);
        cale.recibeJugador();
        CasillaCalle casilla1 = new CasillaCalle("Juan", 0);
        
        Casilla casilla2 = new Casilla("Pedro");
        
        casilla2 = casilla1;
        
        casilla1.recibeJugador(); 
        casilla2.recibeJugador(); //ejecutan ambos el del hijo porque ahora casilla2 apunta en memoria al lugar de CasillaCalle por lo que ejecutaran el metodo del hijo
        casilla1.construirCasa(); 
        ((CasillaCalle) casilla2).construirCasa(); //es necesario hacer un casting
    }                       
}
