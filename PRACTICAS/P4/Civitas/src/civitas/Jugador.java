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
public class Jugador implements Comparable<Jugador> {
    protected static int CasasMax = 4;
    protected static int CasasPorHotel = 4;
    protected int casillaActual;
    protected static int HotelesMax = 4;
    private String nombre;
    protected static float PasoPorSalida = 1000;
    private boolean puedeComprar;
    private float saldo;
    private static float SaldoInicial = 7500;
    protected ArrayList<CasillaCalle> propiedades;
    
  
    int CantidadCasasHoteles(){
        return CasasMax + HotelesMax;
    }
    
    public int compareTo(Jugador otro){
        int resultado = 0;
        
        if( this.getSaldo() > otro.getSaldo() )
            resultado = 1;
        else if ( this.getSaldo() < otro.getSaldo() )
            resultado = -1;
             
        return resultado;
    }
    
    
    boolean comprar(CasillaCalle titulo){
        boolean result = false;
        
        if (this.puedeComprar){
            float precio = titulo.getPrecioCompra();
            if (this.puedoGastar(precio)){
                result = titulo.comprar(this);
                this.propiedades.add(titulo);
                Diario.getInstance().ocurreEvento("\nEl jugador "+this.getNombre()+ " compra la propiedad "+titulo);
                this.puedeComprar = false;
            } else
                Diario.getInstance().ocurreEvento("\nEl jugador"+this.getNombre()+ " no tiene saldo para comprar la propiedad "+titulo);
        }
        
        return result;
        
    }
    
    boolean construirCasa(int ip){
        boolean result = false;
        boolean existe = this.existeLaPropiedad(ip);
        if (existe){
            CasillaCalle propiedad = this.propiedades.get(ip);
            boolean puedoEdificar = this.puedeEdificarCasa(propiedad);
            float precioEdificar = propiedad.getPrecioEdificar();
            if (this.puedoGastar(precioEdificar) && propiedad.getNumCasas() < this.getCasasMax())
                puedoEdificar = true;
            if (puedoEdificar){
                propiedad.construirCasa(this);
                Diario.getInstance().ocurreEvento("\nEl jugador "+nombre+" construye casa en la propiedad "+ ip);
            }
        }
        return result;
    }
    
    boolean construirHotel(int ip){
        boolean result = false;
        if (this.existeLaPropiedad(ip)){
            boolean puedoEdificarHotel = this.puedoEdificarHotel(this.propiedades.get(ip));
            puedoEdificarHotel = false;
            float precio = this.propiedades.get(ip).getPrecioEdificar();
            if (this.puedoGastar(precio)){
                if (this.propiedades.get(ip).getNumHoteles() < this.getHotelesMax()){
                    if (this.propiedades.get(ip).getNumCasas() >= this.getCasasPorHotel())
                        puedoEdificarHotel = true;
                }
            }
            
            if (puedoEdificarHotel){
                result = this.propiedades.get(ip).construirHotel(this);
                this.propiedades.get(ip).derruirCasas(this.getCasasPorHotel(), this);
                Diario.getInstance().ocurreEvento("\nEl jugador "+nombre+ " construye hotel en la propiedad "+ip);
            }
        }
        return result;
    }
    
    boolean enBancarrota(){
        return saldo < 0;
    }
    
    public boolean existeLaPropiedad(int ip){
        return this.propiedades.get(ip) != null && this.propiedades.size() > ip;
    }
    
    protected int getCasasMax(){
        return CasasMax;
    }
    
    int getCasasPorHotel(){
        return CasasPorHotel;
    }
     //Se ha cambiado a public para poder utilizarlo en otro paquete en la clase vistaTextual

    public int getCasillaActual(){ 
        return this.casillaActual;
    }
    
    //Se ha cambiado a public para poder utilizarlo en otro paquete en la clase vistaTextual
    public ArrayList<CasillaCalle> getPropiedades(){
        return propiedades;
    }
    protected int getHotelesMax(){
        return HotelesMax;
    }
    
    //Se ha cambiado a public para poder utilizarlo en otro paquete en la clase vistaTextual
    public String getNombre(){ 
        return nombre;
    }
    
    public float getPremioPasoSalida(){
        return PasoPorSalida;
    }
    
    boolean getPuedeComprar(){
        return this.puedeComprar;
    }
    
    protected float getSaldo(){
        return this.saldo;
    }
    
    Jugador(String nombre){
        this.nombre = nombre;
        this.casillaActual = 0;
        this.propiedades = new ArrayList<>();
        this.puedeComprar = false;
        this.saldo = SaldoInicial;
    }
    
    protected Jugador(Jugador otroJugador){
        this.casillaActual = otroJugador.getCasillaActual();
        this.propiedades = otroJugador.getPropiedades();
        this.nombre = otroJugador.getNombre();
        this.puedeComprar = otroJugador.getPuedeComprar();
        this.saldo = otroJugador.getSaldo();
    }
    
    boolean modificaSaldo(float cantidad){
        this.saldo += cantidad;
        Diario.getInstance().ocurreEvento("\nEl nuevo saldo de " + this.getNombre() + " es de " + this.getSaldo() + " euros.");
        return true;
    }
    
    boolean moverACasilla(int numCasilla){
        this.casillaActual = numCasilla;
        this.puedeComprar = false;
        Diario.getInstance().ocurreEvento("\nEl jugador " + this.getNombre() + " se ha movido a la casilla " + this.getCasillaActual() + ".");
        return true;
    }
    
    boolean paga(float cantidad){
        return this.modificaSaldo(cantidad*-1);
    }
    
    boolean pagaAlquiler(float cantidad){
        return this.paga(cantidad);
    }
    
    boolean pasaPorSalida(){
        this.saldo += PasoPorSalida;
        Diario.getInstance().ocurreEvento("\nEl jugador " + this.getNombre() + " ha pasado por la casilla de salida.");
        return true;
    }
    
    boolean puedeComprarCasilla(){
        this.puedeComprar = true;
        return this.puedeComprar;
    }
    
    private boolean puedeEdificarCasa(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedades.size() <= CasasMax;
    }
    
    private boolean puedoEdificarHotel(CasillaCalle propiedad){
        return puedoGastar(propiedad.getPrecioEdificar()) && propiedades.size() <= HotelesMax && propiedad.getNumCasas() == CasasPorHotel;
    }
    
    private boolean puedoGastar(float precio){
        return this.getSaldo() >= precio;
    }
    
    protected boolean recibe (float cantidad){
        return this.modificaSaldo(cantidad);
    }
    
    protected boolean tieneAlgoQueGestionar(){
        return this.propiedades.size() > 0;
    }
    
    @Override
    public String toString(){
        String estado = "\nNombre del jugador: " + this.getNombre() + ".\n";
        estado = estado.concat("Casilla actual: " + this.casillaActual + ".\n");
        estado = estado.concat("Numero de propiedades: " + this.propiedades.size() + ".\n");
        estado = estado.concat("Las propiedades son:\n");
        for (int i = 0; i < this.propiedades.size(); i++){
            estado = estado.concat(this.propiedades.get(i).getNombre() + " ");
        }
        if (this.getPuedeComprar()){
            estado = estado.concat("\nPuede comprar.");
        } else{
            estado = estado.concat("\nNo puede comprar.");

        }
        estado = estado.concat("\nSaldo: " + this.getSaldo() + " euros.");
        return estado;
    }
    
    JugadorEspeculador convertir(){
        JugadorEspeculador j = new JugadorEspeculador(this);
        return j;
    }

}
