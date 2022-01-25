/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import GUI.Dado;
import java.util.ArrayList;
/**
 *
 * @author albertollamasgonzalez
 */
public class TestP4 {
    public static void main (String args[]){
        
        Jugador j1 = new Jugador ("Pepe");
        
        CasillaCalle p1 = new CasillaCalle("Calle Teclado", 10, 12, 14);
        
        j1.puedeComprarCasilla();
        j1.comprar(p1);
        p1.actualizaPropietarioPorConversion(j1);
        
        System.out.println(j1.toString());
        System.out.println(p1.toString());
        
        SorpresaConvertirme convertir = new SorpresaConvertirme("Te has convertido en Jugador Especulador", 0);
        ArrayList<Jugador> todos = new ArrayList<>();
        todos.add(j1);
        convertir.aplicarAJugador(0, todos);
        
        System.out.println(p1.getPropietario().toString());
        
        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("l");
        nombres.add("w");
        nombres.add("r");
        nombres.add("t");
        CivitasJuego juego = new CivitasJuego(nombres, false);
        System.out.println(juego.getTablero().getCasilla(3).getNombre());
        
    }
}
