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


public class Casilla {
    //Indica si es una calle, sorpresa o descanso
    private TipoCasilla tipo;
    private String nombre;
    private float precioCompra,precioEdificar,precioBaseAlquiler;
    private int numCasas, numHoteles;
    static private float FACTORIALALQUILERCALLE = 1.0f;
    static private float FACTORIALALQUILERCASA = 1.0f;
    static private float FACTORIALALQUILERHOTEL = 4.0f;
    MazoSorpresas mazo;
    Sorpresa sorpresa;
    Jugador propietario;
    
    
    public int cantidadCasasHoteles(){
        return this.getNumCasas() + this.getNumHoteles();
    }
    
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        init();
        this.tipo = unTipo.CALLE;
        this.nombre = unNombre;
        this.precioEdificar = unPrecioEdificar;
        this.precioCompra = unPrecioCompra;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
    }
    
    Casilla (TipoCasilla tipo, String nombre){
        init();
        this.tipo = tipo.DESCANSO;
        this.nombre = nombre;
        
    }
        
    Casilla(Casilla unaCasilla){
        init();
        if (unaCasilla != null){
            this.tipo = unaCasilla.tipo;
            this.nombre = unaCasilla.nombre;
            this.precioEdificar = unaCasilla.precioEdificar;
            this.precioCompra = unaCasilla.precioCompra;
            this.precioBaseAlquiler = unaCasilla.precioBaseAlquiler;
        }
    }
    
    Casilla (TipoCasilla tipo, String nombre, MazoSorpresas mazo){
        init();
        this.tipo = tipo.SORPRESA;
        this.nombre = nombre;
        this.mazo = mazo;
    }
    
    
    boolean comprar(Jugador jugador){
        this.propietario = jugador;
        return this.propietario.paga(precioCompra);
    }
    
    boolean construirCasa(Jugador jugador){
        jugador.paga(precioEdificar);
        numCasas++;
        return true;
    }
    
    boolean construirHotel(Jugador jugador){
        jugador.paga(precioEdificar);
        numHoteles++;
        return true;
    }

    
    boolean derruirCasas(int numero, Jugador jugador){
        boolean realizado = false;
        if (esEsteElPropietario(jugador) && this.getNumCasas() >= numero){
            this.numCasas = this.numCasas - numero;
            realizado = true;
        }
        return realizado;
    }
    
    public boolean esEsteElPropietario(Jugador jugador){
        boolean esEsteElPropietario = false;
        if (this.propietario != null){
            if (this.propietario == jugador)
                esEsteElPropietario = true;
        }
        return esEsteElPropietario;
    }

    public TipoCasilla getTipo(){
        return this.tipo;
    }
    
    public boolean esCalle (){
        return this.getTipo() == tipo.CALLE;
    }
    public String getNombre(){
        return nombre;
    }
    
    public TipoCasilla getCalle(){
        return tipo.CALLE;
    }

    
    public float getPrecioCompra(){
        return precioCompra;
    }
    
    public float getPrecioEdificar(){
        return precioEdificar;
    }
    
    public int getNumCasas(){
        return numCasas;
    }
    
    public int getNumHoteles(){
        return numHoteles;
    }
    
    public float getPrecioBaseAlquiler(){
        return precioBaseAlquiler;
    }
    
    public float getPrecioAlquilerCompleto(){
        float precioAlquilerCompleto = this.precioBaseAlquiler * (FACTORIALALQUILERCALLE + FACTORIALALQUILERCASA * this.numCasas + this.numHoteles * FACTORIALALQUILERHOTEL);
        return precioAlquilerCompleto;
    }
    
    public String toString(){
        String estado = "\nNombre de la casilla: " + nombre + ".\n";
        estado = estado.concat("Tipo de la casilla: " + tipo + ".\n");
        estado = estado.concat("Precio de Compra " + precioCompra + ".\n");
        estado = estado.concat("Precio para Edificar " + precioEdificar + ".\n");
        estado = estado.concat("Precio de Alquiler Base " + precioBaseAlquiler + ".\n");
        estado = estado.concat("Numero de casas: " + numCasas + ".\n");
        estado = estado.concat("Numero de hoteles: " + numHoteles + ".\n");
        if (propietario != null){
            estado = estado.concat("Propietario de la casilla: " + propietario.getNombre());
        }
        
        return estado;
    }
    
    void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre()
                + " ha caido en la casilla " + this.getNombre() );
    }
    
    private void init(){
        tipo = null;
        nombre = "";
        precioCompra = 0; precioEdificar = 0; precioBaseAlquiler = 0;
        numCasas= 0; numHoteles= 0;
        mazo = null;
        sorpresa = null;
        propietario = null;
             
    }
    
    
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        if (null != this.tipo)
            switch (this.tipo) {
            case CALLE:
                recibeJugador_calle(iactual, todos);
                break;
            case DESCANSO:
                informe(iactual,todos);
                break;
            case SORPRESA:
                recibeJugador_sorpresa(iactual, todos);
                break;
            default:
                break;
        }
    }
    
    private void recibeJugador_calle(int iactual, ArrayList<Jugador> todos ){
        informe(iactual, todos);
        if (!tienePropietario()){
            todos.get(iactual).puedeComprarCasilla();
        } else{
            tramitarAlquiler(todos.get(iactual));
        }
    }
    
    private void recibeJugador_sorpresa(int iactual, ArrayList<Jugador> todos ){
        this.sorpresa = this.mazo.siguiente();
        informe (iactual, todos);
        this.sorpresa.aplicarAJugador(iactual, todos);
    }

    
    public boolean tienePropietario(){
        return propietario != null;
    }
    
    public void tramitarAlquiler(Jugador jugador){
        if (tienePropietario() && !esEsteElPropietario(jugador)){
            jugador.pagaAlquiler(this.getPrecioAlquilerCompleto());
            this.propietario.recibe(this.getPrecioAlquilerCompleto());
        }
    }
    
    


     
}
