package paquetito;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author albertollamasgonzalez
 */
public class Padre {
    private int hadi;
    Padre(){}
    Padre(int had){ hadi = had;}
    
    void aumentaHadi(){
        hadi = this.getHadi() + 1; 
    }
    
    int getHadi(){
        return this.hadi;
    }
    
}
