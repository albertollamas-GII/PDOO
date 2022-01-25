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
public class CasillaSorpresa extends Casilla{
    Sorpresa sorpresa;
    MazoSorpresas mazo;
    
    CasillaSorpresa(String nombre, Sorpresa sorpresa, MazoSorpresas mazo){
        super(nombre);
        this.sorpresa = sorpresa;
        this.mazo = mazo;
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos ){
        this.sorpresa = this.mazo.siguiente();
        informe (iactual, todos);
        this.sorpresa.aplicarAJugador(iactual, todos);
    }
}
