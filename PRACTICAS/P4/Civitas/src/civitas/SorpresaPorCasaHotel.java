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
public class SorpresaPorCasaHotel extends Sorpresa{
    private String texto;
    private int valor;
    
    public String getTexto(){
        return this.texto;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    
    SorpresaPorCasaHotel(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    public String toString(){
        return texto;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor * todos.get(actual).CantidadCasasHoteles());
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("\nSe esta aplicando la sorpresa PorCasaHotel a " + todos.get(actual).getNombre());
    }
}
