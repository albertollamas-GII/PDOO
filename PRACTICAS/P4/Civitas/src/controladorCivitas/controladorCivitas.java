/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladorCivitas;

import vistaTextualCivitas.VistaTextual;
import civitas.CivitasJuego;
import civitas.OperacionJuego;
import civitas.OperacionInmobiliaria;
import civitas.GestionInmobiliaria;
import civitas.Jugador;


import java.util.ArrayList;
/**
 *
 * @author albertollamasgonzalez
 */
public class controladorCivitas {
    private CivitasJuego modelo;
    private VistaTextual vista;
    
    public controladorCivitas(CivitasJuego modelo, VistaTextual vista){
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void juega(){
        while (!modelo.finalDelJuego()){
            vista.actualiza();
            vista.pausa();
            OperacionJuego siguiente = modelo.siguientePaso();
            vista.mostrarSiguienteOperacion(siguiente);
            if (siguiente != OperacionJuego.PASAR_TURNO){
                vista.mostrarEventos();
            }
            
            boolean fin = modelo.finalDelJuego();
            if (!fin){
                if (siguiente == OperacionJuego.COMPRAR){
                    Respuesta respuesta = vista.comprar();
                    if (respuesta == Respuesta.SI){
                        modelo.comprar();
                    }
                    modelo.siguientePasoCompletado(siguiente);
                } else if (siguiente == OperacionJuego.GESTIONAR){
                    OperacionInmobiliaria opUsuario = vista.elegirOperacion();
                    if (opUsuario != OperacionInmobiliaria.TERMINAR){
                        int propiedad = vista.elegirPropiedad();
                        GestionInmobiliaria gestion = new GestionInmobiliaria(opUsuario, propiedad);
                        if (opUsuario == OperacionInmobiliaria.CONSTRUIR_CASA)
                            modelo.construirCasa(propiedad);
                        if (opUsuario == OperacionInmobiliaria.CONSTRUIR_HOTEL)
                            modelo.construirHotel(propiedad);
                    } else
                        modelo.siguientePasoCompletado(siguiente);
                }
            }
            
        }
        vista.actualiza();
    }
}
