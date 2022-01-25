
package GestionViajes;

import java.util.ArrayList;
import java.util.Date;

/*
 * Solución al diagrama "DC - Trenes.jpg"
 */
class Pasajero {

    //Atributos básicos:
    private int codigo;
    private String nombre;
    private String email;
    
    //Atributos de referencia:
    private ArrayList<Billete> billetes = new ArrayList();
            /** La clase asociación queda:
             * Tren -1-----1..*- Billete -1..*----1- Pasajero
            */
    
        //No hay más atributos de referencia pues no se puede navegar
        // de Pasajero a GestorViajes
    
    
    public void anularBillete(int numeroTren, Date fecha){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    private Billete buscarBillete(int numeroTren, Date fecha){
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
