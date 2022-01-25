package GUI;

import civitas.Casilla;
import civitas.CivitasJuego;
import civitas.Diario;
import civitas.OperacionJuego;
import controladorCivitas.Respuesta;
import civitas.OperacionInmobiliaria;
import civitas.Jugador;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import civitas.Tablero;



public class VistaTextual implements Vista {
  
    
  private static String separador = "=====================";
  
  private Scanner in;
  
  CivitasJuego juegoModel;
  
  public VistaTextual (CivitasJuego juegoModel) {
    in = new Scanner (System.in);
    this.juegoModel=juegoModel;
  }
  
  
           
 public  void pausa() {
    System.out.print ("\nPulsa una tecla\n");
    in.nextLine();
  }

  int leeEntero (int max, String msg1, String msg2) {
    Boolean ok;
    String cadena;
    int numero = -1;
    do {
      System.out.print (msg1);
      cadena = in.nextLine();
      try {  
        numero = Integer.parseInt(cadena);
        ok = true;
      } catch (NumberFormatException e) { // No se ha introducido un entero
        System.out.println (msg2);
        ok = false;  
      }
      if (ok && (numero < 0 || numero >= max)) {
        System.out.println (msg2);
        ok = false;
      }
    } while (!ok);

    return numero;
  }

  int menu (String titulo, ArrayList<String> lista) {
    String tab = "  ";
    int opcion;
    System.out.println (titulo);
    for (int i = 0; i < lista.size(); i++) {
      System.out.println (tab+i+"-"+lista.get(i));
    }

    opcion = leeEntero(lista.size(),
                          "\n"+tab+"Elige una opción: ",
                          tab+"Valor erróneo");
    return opcion;
  }

    public void actualiza() {
      System.out.println("\nEs el turno de: " + this.juegoModel.getJugadorActual().getNombre());
      if (this.juegoModel.getJugadorActual() != null && !this.juegoModel.finalDelJuego()){
          if (!this.juegoModel.getJugadorActual().getPropiedades().isEmpty()){
            System.out.println("\nEl jugador " + this.juegoModel.getIndiceJugadorActual() +
                    " tiene las siguientes propiedades:\n");
            for (int i = 0; i < this.juegoModel.getJugadorActual().getPropiedades().size(); i++){
                System.out.println(this.juegoModel.getJugadorActual().getPropiedades().get(i).getNombre() + " \n");
            }
          } else {
              System.out.println("\nNo tiene propiedades.");
          }
          System.out.println("La casilla actual en la que se encuentra es: " + this.juegoModel.getTablero().getCasilla(this.juegoModel.getJugadorActual().getCasillaActual()).getNombre());
      } else{
          System.out.println("\nLista de Jugadores ordenada por el saldo:\n El ganador es: ");
          for (int i = 0; i < this.juegoModel.getJugadores().size(); i++){
              System.out.println("Jugador " + i + ": " + this.juegoModel.ranking().get(i).getNombre() + "\n");
          }
      }
    }

    public Respuesta comprar() {
        String casillaActual = this.juegoModel.getTablero().getCasilla(this.juegoModel.getJugadorActual().getCasillaActual()).toString();
    
        int opcion = menu ("Has llegado a la casilla\n" + casillaActual + "\n¿Quieres comprarla?",
                        new ArrayList<> (Arrays.asList("SI","NO") ) );
    
        return (Respuesta.values()[opcion]);   
    }

    public OperacionInmobiliaria elegirOperacion() {
        int opcion = menu("\n¿Qué gestión inombiliaria desea hacer?", new ArrayList<> (Arrays.asList("CONSTRUIR_CASA", "CONSTRUIR_HOTEL", "TERMINAR")));
        return OperacionInmobiliaria.values()[opcion];
    }

    
    public int elegirPropiedad() {
        String propiedades[] = new String[this.juegoModel.getJugadorActual().getPropiedades().size()];
        for (int i = 0; i < propiedades.length; i++){
            propiedades[i] = this.juegoModel.getJugadorActual().getPropiedades().get(i).getNombre();
        }
        int opcion = menu("¿Sobre qué propiedad desea realizar la gestión?", new ArrayList<> (Arrays.asList(propiedades)));
        while (!this.juegoModel.getJugadorActual().existeLaPropiedad(opcion))
                    opcion = menu("¿Sobre qué propiedad desea realizar la gestión?", new ArrayList<> (Arrays.asList(propiedades)));

        return opcion;
    }
    
   
    public void mostrarSiguienteOperacion(OperacionJuego operacion) {
        System.out.println("\nLa siguiente operacion que va a realizar el juego es: " + operacion.toString());
    }

    public void mostrarEventos() {
        while (Diario.getInstance().eventosPendientes())
            System.out.println(Diario.getInstance().leerEvento());
    }

}
