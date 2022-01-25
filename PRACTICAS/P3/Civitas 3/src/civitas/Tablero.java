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
public class Tablero {
    private ArrayList<Casilla> casillas;
    private boolean porSalida;
    
    Tablero(){
        casillas = new ArrayList<>();
        casillas.add(new Casilla(TipoCasilla.DESCANSO,"Salida"));
        porSalida = false;
    }
    
    private boolean correcto(int numCasilla){
        boolean correcto = false;
        if (numCasilla < casillas.size() && numCasilla >= 0)
            correcto = true;
        return correcto;
    }
    
    public int numeroCalles(){
        int numeroCalles = 0;
        for (int i = 0; i < casillas.size(); i++){
            if (casillas.get(i).esCalle())
                numeroCalles++;
        }
        return numeroCalles;
    }
    
    public boolean computarPasoPorSalida(){
        return porSalida;   
    }
    
    public void añadeCasilla(Casilla casilla){
        casillas.add(casilla);
    }
    
    public Casilla getCasilla(int numCasilla){
        Casilla cas = new Casilla (null);
        if (correcto(numCasilla)){
            cas = casillas.get(numCasilla);
        }
        return cas;
    }
    
    public int nuevaPosicion(int actual, int tirada){
        int nuevaPosicion;
        nuevaPosicion = (actual + tirada) % casillas.size();
        if (nuevaPosicion != actual + tirada)
            porSalida = true;
        return nuevaPosicion;
    }
}
