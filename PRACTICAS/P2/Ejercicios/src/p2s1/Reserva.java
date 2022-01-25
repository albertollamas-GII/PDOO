/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2s1;
    

/**
 *
 * @author albertollamasgonzalez
 */
public class Reserva {
    private String fechaEntrada;
    private String fechaSalida;
    private Hotel hotel;
    private Cliente cliente;
    
    Reserva(String fechaEntrada, String fechaSalida, Cliente cliente, Hotel hotel){
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.cliente = cliente;
        this.hotel = hotel;
    }
    
    public String getFechaEntrada(){
        return fechaEntrada;
    }
    
    public Cliente getCliente(){
        return cliente;
    }
    
    
    
}
