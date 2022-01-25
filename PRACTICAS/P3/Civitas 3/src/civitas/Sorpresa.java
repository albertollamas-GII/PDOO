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
public class Sorpresa {
    private String texto;
    private int valor;
    TipoSorpresa tipo;
    
    Sorpresa (Sorpresa sorpresa){
        this.texto = sorpresa.getTexto();
        this.valor = sorpresa.getValor();
        this.tipo = sorpresa.getTipoSorpresa();
    }
    public String getTexto(){
        return this.texto;
    }
    
    public int getValor(){
        return this.valor;
    }
    
    public TipoSorpresa getTipoSorpresa(){
        return this.tipo;
    }
    void aplicarAJugador(int actual, ArrayList<Jugador> todos){
        if (this.tipo == TipoSorpresa.PAGARCOBRAR)
            aplicarAJugador_pagarCobrar(actual, todos);
        if (this.tipo == TipoSorpresa.PORCASAHOTEL)
            aplicarAJugador_porCasaHotel(actual, todos);
    }
    
    private void aplicarAJugador_pagarCobrar(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor);
    }
    
    private void aplicarAJugador_porCasaHotel(int actual, ArrayList<Jugador> todos){
        informe(actual, todos);
        todos.get(actual).modificaSaldo(valor * todos.get(actual).CantidadCasasHoteles());
    }
    
    private void informe(int actual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("\nSe esta aplicando la sorpresa " + this.getTipoSorpresa() + " a " + todos.get(actual).getNombre());
    }
    
    Sorpresa(TipoSorpresa tipo, String texto, int valor){
        this.tipo = tipo;
        this.texto = texto;
        this.valor = valor;
    }
    
    public String toString(){
        return texto;
    }
    
    
}
