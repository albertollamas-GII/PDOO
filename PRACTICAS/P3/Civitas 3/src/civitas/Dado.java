/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.Random;
/**
 *
 * @author albertollamasgonzalez
 */
public class Dado {
    private Random random;
    private int ultimoResultado;
    private boolean debug;
    static final private Dado instance = new Dado();
    
    private Dado(){
        ultimoResultado = 0;
        debug = false;
        random = new Random();
    }
    
    static public Dado getInstance(){
        return instance;
    }
    
    public int tirar(){
        int numero = 1;
        if (!debug){
            numero = random.nextInt(6)+1;
            ultimoResultado = numero;
        }
        
        Diario.getInstance().ocurreEvento("Se tiran los dados y el resultado es: " + numero + ".");
        
        return numero;
    }
    
    public int quienEmpieza(int n){
        int quienEmpieza = random.nextInt(n) + 1;
        return quienEmpieza;
    }
    
    public void setDebug(boolean d){
        debug = d;
        Diario.getInstance().ocurreEvento("Se ha cambiado el modo debug a: " + d);
    }
    
    int getUltimoResultado(){
        return ultimoResultado;
    }
}
