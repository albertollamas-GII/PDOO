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
public class CasillaCalle extends Casilla{     
    private float precioCompra,precioEdificar,precioBaseAlquiler;
    private int numCasas, numHoteles;
    static private float FACTORIALALQUILERCALLE = 1.0f;
    static private float FACTORIALALQUILERCASA = 1.0f;
    static private float FACTORIALALQUILERHOTEL = 4.0f;
    Jugador propietario;
    
    CasillaCalle(String nombre, float precioCompra, float precioEdificar, float precioBaseAlquiler){
        super(nombre);
        this.precioBaseAlquiler = precioBaseAlquiler;
        this.precioCompra = precioCompra;
        this.precioEdificar = precioEdificar;
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
    Jugador getPropietario(){
        return this.propietario;
    }
    public boolean esEsteElPropietario(Jugador jugador){
        boolean esEsteElPropietario = false;
        if (this.propietario != null){
            if (this.propietario == jugador)
                esEsteElPropietario = true;
        }
        return esEsteElPropietario;
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
    
    public int cantidadCasasHoteles(){
        return this.getNumCasas() + this.getNumHoteles();
    }
    
    @Override
    public String toString(){
        String estado = "\nNombre de la casilla: " + nombre + ".\n";
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
    
    @Override
    void informe(int iactual, ArrayList<Jugador> todos){
        Diario.getInstance().ocurreEvento("El jugador " + todos.get(iactual).getNombre()
                + " ha caido en la casilla " + this.getNombre() );
    }
    
    @Override
    void recibeJugador(int iactual, ArrayList<Jugador> todos){
        informe(iactual, todos);
        if (!tienePropietario()){
            todos.get(iactual).puedeComprarCasilla();
        } else{
            tramitarAlquiler(todos.get(iactual));
        }   
      
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
    
    void actualizaPropietarioPorConversion(Jugador jugador){
        this.propietario = jugador;
    }
}
