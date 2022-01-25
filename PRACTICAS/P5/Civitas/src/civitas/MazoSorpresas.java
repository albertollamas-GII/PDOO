/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author albertollamasgonzalez
 */
public class MazoSorpresas {
    private ArrayList<Sorpresa> sorpresas;
    private boolean barajada;
    private int usadas;
    private boolean debug;
    
    private void init(){
        barajada = false;
        usadas = 0;
        sorpresas = new ArrayList<>();
    }
    
    MazoSorpresas(boolean d){
        init();
        debug = d;
        if (debug)
            Diario.getInstance().ocurreEvento("Debug esta activado");
    }
    
    MazoSorpresas(){
        init();
        debug = false;
    }
    
    
    void alMazo(Sorpresa s){
        if (!barajada){
            sorpresas.add(s);
        }
    }
    
    Sorpresa siguiente(){
        if (!barajada || usadas == sorpresas.size()){
            if (!debug)
                Collections.shuffle(sorpresas);
            usadas = 0;
            barajada = true;
        }
        usadas++;
        Sorpresa ultimaSorpresa = sorpresas.get(0);
        sorpresas.remove(0);
        sorpresas.add(ultimaSorpresa);
        return ultimaSorpresa;
    }

    
}
