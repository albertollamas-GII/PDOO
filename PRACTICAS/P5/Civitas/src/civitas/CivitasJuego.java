/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

import GUI.Dado;

/**
 *
 * @author albertollamasgonzalez
 */
public class CivitasJuego {
    private int indiceJugadorActual;
    private ArrayList<Jugador> jugadores;
    EstadoJuego estado;
    GestorEstados gestor;
    MazoSorpresas mazo;
    Tablero tablero;
    
    
    private void avanzaJugador(){
        Jugador jugadorActual = new Jugador(this.jugadores.get(indiceJugadorActual));
        int posicionActual = jugadorActual.getCasillaActual();
        int tirada = Dado.getInstance().tirar();
        int posicionNueva = this.tablero.nuevaPosicion(posicionActual, tirada);
        Casilla casilla = new Casilla(tablero.getCasilla(posicionNueva));
        this.contabilizarPasosPorSalida();
        this.jugadores.get(indiceJugadorActual).moverACasilla(posicionNueva);
        this.tablero.getCasilla(posicionNueva).recibeJugador(this.indiceJugadorActual, jugadores); 
        
    }
    
    public CivitasJuego(ArrayList<String> nombres, boolean debug){
        jugadores = new ArrayList<>();
        for (int i = 0; i < nombres.size(); i++)
            jugadores.add(new Jugador(nombres.get(i)));
        gestor = new GestorEstados();
        this.estado = gestor.estadoInicial();
        
        Dado.getInstance().setDebug(debug);
        this.indiceJugadorActual = Dado.getInstance().quienEmpieza(jugadores.size()-1);
        
        this.mazo = new MazoSorpresas(debug);
        
        tablero = new Tablero();
        this.inicializaMazoSorpresa();
        this.inicializaTablero(this.mazo);
        
        
    }
    
    public boolean comprar(){
        boolean res = false;
        Jugador jugadorActual = new Jugador(this.jugadores.get(indiceJugadorActual));
        int numCasillaActual = jugadorActual.getCasillaActual();
        res = this.jugadores.get(indiceJugadorActual).comprar((CasillaCalle)tablero.getCasilla(numCasillaActual));
        return res;
    }
    
    public boolean construirCasa(int ip){
        return this.jugadores.get(this.indiceJugadorActual).construirCasa(ip);
    }
    
    public boolean construirHotel(int ip){
         return this.jugadores.get(this.indiceJugadorActual).construirHotel(ip);

    }
    
    private void contabilizarPasosPorSalida(){
        if (this.tablero.computarPasoPorSalida())
            this.getJugadores().get(this.getIndiceJugadorActual()).pasaPorSalida();
    }
    
    public boolean finalDelJuego(){
        int numJugadores = this.jugadores.size();
        boolean alguienBancarrota = false;
        
        for(int i = 0; i < numJugadores && !alguienBancarrota ; i++)
            alguienBancarrota = this.jugadores.get(i).enBancarrota();
            
        return alguienBancarrota;
    }
    
    public int getIndiceJugadorActual(){
        return this.indiceJugadorActual;
    }
    
    public Jugador getJugadorActual(){
        return this.jugadores.get(this.indiceJugadorActual);
    }
    
    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
    
    public Tablero getTablero(){
        return this.tablero;
    }
    
    private void inicializaMazoSorpresa(){
        
        //Construimos una sorpresa de cada tipo al mazo
        this.mazo.alMazo(new SorpresaPagarCobrar("A pagar 150!", -150));
        this.mazo.alMazo(new SorpresaPorCasaHotel("A pagar 30 por cada casa u hotel!", 30));
        this.mazo.alMazo(new SorpresaPagarCobrar("A cobrar 150!", 150));
        this.mazo.alMazo(new SorpresaConvertirme("Te has convertido en Jugador Especulador!", 0));


    }
    
    private void inicializaTablero(MazoSorpresas mazo){
        //Calle 0,1        
        this.tablero.añadeCasilla(new CasillaCalle( "Calle Las Monjas", 500, 1000, 10000));
        this.tablero.añadeCasilla(new CasillaCalle( "Calle Cádiz ", 500, 1000, 750));
        
        //Sorpresa 1
        this.tablero.añadeCasilla(new CasillaSorpresa("SORPRESA ALEATORIA", mazo.siguiente(),mazo));
        
        //calles 3,4,5
        this.tablero.añadeCasilla(new CasillaCalle("Calle Granada", 750, 1250, 1000));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Sevilla ", 750, 1250, 1000));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Huelva", 800, 1100, 900));

        //Descanso 1
        this.tablero.añadeCasilla(new Casilla("PARKING"));
        
        //Sorpresa 2
        this.tablero.añadeCasilla(new CasillaSorpresa("SORPRESA ALEATORIA", mazo.siguiente(), mazo));

        //calles 6,7,8
        this.tablero.añadeCasilla(new CasillaCalle("Calle Almeria", 900, 1300, 1100));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Córdoba ", 900, 1300, 1100));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Málaga", 1000, 1400, 1200));
        
        //Sorpresa 3      
        this.tablero.añadeCasilla(new CasillaSorpresa( "SORPRESA ALEATORIA", mazo.siguiente(), mazo));
        
        //calles 9,10,11  
        this.tablero.añadeCasilla(new CasillaCalle("Calle Toledo", 1000, 1500, 1300));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Caceres ", 1100, 1800, 1500));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Badajoz", 1300, 1900, 1700));
    
        //Sorpresa 4
        this.tablero.añadeCasilla(new CasillaSorpresa("SORPRESA ALEATORIA", mazo.siguiente(), mazo));
        
        //calles 12,13,14
        this.tablero.añadeCasilla(new CasillaCalle("Calle Madrid", 2000, 2300, 2250));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Barcelona ", 2100, 2300, 2250));
        this.tablero.añadeCasilla(new CasillaCalle("Calle Bilbao", 2000, 2300, 2250));
    
    }
    
    private void pasarTurno(){
        this.indiceJugadorActual = (this.getIndiceJugadorActual() + 1) % this.jugadores.size();
    }
    
    //Lo he puesto public para poder utilizarlo en vistaTextual
    public ArrayList<Jugador> ranking(){ 
        ArrayList<Jugador> ranking = new ArrayList<Jugador>(this.jugadores);
        
        for (int i = 0; i < ranking.size(); i++){
            float max = ranking.get(i).getSaldo();
            Jugador jugadorMaxSaldo = ranking.get(i);
            int tempId = i;
            for (int j = i+1; j < ranking.size(); j++){
                if (ranking.get(j).getSaldo() > max){
                    max = ranking.get(j).getSaldo();
                    jugadorMaxSaldo = ranking.get(j);
                    tempId = j;
                }
            }
            Jugador temp = ranking.get(i);
            ranking.set(i, jugadorMaxSaldo);
            ranking.set(tempId, temp);
            
        }
        
        return ranking;
    }
    
    
    
    public OperacionJuego siguientePaso(){
        Jugador jugadorActual = new Jugador(this.getJugadorActual());
        OperacionJuego operacion = this.gestor.siguienteOperacion(jugadorActual, estado);
        
        if(operacion == OperacionJuego.PASAR_TURNO){
            this.pasarTurno();
            this.siguientePasoCompletado(operacion);
        } else if (operacion == OperacionJuego.AVANZAR){
            this.avanzaJugador();
            this.siguientePasoCompletado(operacion);
        }
        
        return operacion;
    }
    
    public void siguientePasoCompletado(OperacionJuego operacion){
        this.estado = this.gestor.siguienteEstado(jugadores.get(indiceJugadorActual), estado, operacion);
    }
}
