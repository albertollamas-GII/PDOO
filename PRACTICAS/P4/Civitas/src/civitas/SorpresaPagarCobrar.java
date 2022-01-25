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
public class SorpresaPagarCobrar extends Sorpresa {
    private String texto;
    private int valor;
    
    SorpresaPagarCobrar(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("\nSe esta aplicando la sorpresa PagarCobrar a " + todos.get(actual).getNombre());
    }
    
}
