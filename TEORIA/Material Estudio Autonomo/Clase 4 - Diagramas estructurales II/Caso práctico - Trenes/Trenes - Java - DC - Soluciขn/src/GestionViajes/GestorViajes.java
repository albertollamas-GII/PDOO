
package GestionViajes;

import java.util.ArrayList;
import java.util.Date;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
public class GestorViajes {
    
    //Atributos básicos: no tiene
    
    //Atributos de referencia:
    private ArrayList<Estacion> estaciones = new ArrayList();
    private ArrayList<Tren> trenes = new ArrayList();
    private ArrayList<Pasajero> pasajeros = new ArrayList();
    
    //Cabecera de los métodos:
    
    public ArrayList<String> obtenerHorarios (String origen, String destino){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public int comprarBillete(Date fecha, String origen, String destino, int pasajero){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public float obtenerRecaudacion(){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void anularBillete(int numeroTren, Date fecha, int codigoPasajero){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void nuevaParada(int numeroTren, String nombreEstacion, Date horaLlegada, Date horaSalida){
    
        throw new UnsupportedOperationException("Not supported yet.");
    }
        
    private Tren buscarTren(int numero){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    private Pasajero buscarPasajero(int codigoPasajero){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    private Estacion buscarEstacion(String nombreEstacion){
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
