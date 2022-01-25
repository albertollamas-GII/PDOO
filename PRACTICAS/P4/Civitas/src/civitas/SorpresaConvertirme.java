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
public class SorpresaConvertirme extends Sorpresa {
    private String texto;
    private int valor;
    
    SorpresaConvertirme(String texto, int valor){
        this.texto = texto;
        this.valor = valor;
    }
    
    @Override
    void aplicarAJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        todos.set(iactual, new JugadorEspeculador(todos.get(iactual)));
    }
    
    void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("\nSe esta aplicando la sorpresa Convertir en Jugador Especulador a " + todos.get(actual).getNombre());
    }
}
