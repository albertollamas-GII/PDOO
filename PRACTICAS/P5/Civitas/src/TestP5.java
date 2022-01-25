/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import civitas.CivitasJuego;
import controladorCivitas.controladorCivitas;
import GUI.VistaTextual;
import GUI.CivitasView;
import GUI.CapturaNombres;
import GUI.Dado;
import java.util.ArrayList;
/**
 *
 * @author albertollamasgonzalez
 */
public class TestP5 {
    public static void main(String args[]){
        CivitasView vista = new CivitasView();
        CapturaNombres vistaNombres = new CapturaNombres(vista, true);
        ArrayList<String> nombres = vistaNombres.getNombres();
        Dado.createInstance(vista);
        CivitasJuego juego = new CivitasJuego(nombres, false);
        controladorCivitas controlador = new controladorCivitas(juego, vista);
        vista.setCivitasJuego(juego);
        controlador.juega();
    }
}
