/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

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
    
    Casilla(TipoCasilla unTipo, String unNombre, float unPrecioCompra, float unPrecioEdificar, float unPrecioAlquilerBase){
        this.tipo = unTipo;
        this.nombre = unNombre;
        this.precioEdificar = unPrecioEdificar;
        this.precioCompra = unPrecioCompra;
        this.precioBaseAlquiler = unPrecioAlquilerBase;
    }
    Casilla(Casilla unaCasilla){
        if (unaCasilla != null){
            this.tipo = unaCasilla.tipo;
            this.nombre = unaCasilla.nombre;
            this.precioEdificar = unaCasilla.precioEdificar;
            this.precioCompra = unaCasilla.precioCompra;
            this.precioBaseAlquiler = unaCasilla.precioBaseAlquiler;
        }
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
        String estado = "Nombre de la casilla: " + nombre + ".\n";
        estado = estado.concat("Tipo de la casilla: " + tipo + ".\n");
        estado = estado.concat("Precio de Compra " + precioCompra + ".\n");
        estado = estado.concat("Precio para Edificar " + precioEdificar + ".\n");
        estado = estado.concat("Precio de Alquiler Base " + precioBaseAlquiler + ".\n");
        estado = estado.concat("Numero de casas: " + numCasas + ".\n");
        estado = estado.concat("Numero de hoteles: " + numHoteles + ".\n");

        return estado;
    }
    
        
}
