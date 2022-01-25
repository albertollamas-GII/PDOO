/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import civitas.CivitasJuego;
import controladorCivitas.controladorCivitas;
import vistaTextualCivitas.VistaTextual;

import java.util.ArrayList;
/**
 *
 * @author albertollamasgonzalez
 */
public class JuegoTexto {
    public static void main(String[] args){
        ArrayList<String> jugadores = new ArrayList<>();
        jugadores.add("Pablo");
        jugadores.add("Alvaro");
        jugadores.add("Luis");
        jugadores.add("Juan");
        
        CivitasJuego juego = new CivitasJuego(jugadores, true);
        VistaTextual vista = new VistaTextual (juego);
        controladorCivitas controlador = new controladorCivitas(juego,vista);
        controlador.juega();
    }
}
