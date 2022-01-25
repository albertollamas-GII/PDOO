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
abstract class Sorpresa {
    
    protected String texto;
    protected int valor;
    
    Sorpresa(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    public String getTexto(){
        return this.texto;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    abstract void aplicarAJugador(int actual, ArrayList<Jugador> todos);
    
}
