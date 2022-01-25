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
public class JugadorEspeculador extends Jugador {
    
    static private int factorEspeculador = 2;
    
    protected JugadorEspeculador(Jugador jugador){
        super(jugador);
        actualizaPropiedadesPorConversion(this);
    }
    
    int getFactorEspeculador(){
        return factorEspeculador;
    }
    
    @Override
    protected int getCasasMax(){
        return Jugador.CasasMax * this.getFactorEspeculador();
    }
    
    @Override
    protected int getHotelesMax(){
        return Jugador.HotelesMax * this.getFactorEspeculador();
    }
    
    void actualizaPropiedadesPorConversion(JugadorEspeculador jugador){
        for (int i = 0; i < this.propiedades.size(); i++)
            this.propiedades.get(i).actualizaPropietarioPorConversion(jugador);
    }
    
    @Override
    public String toString(){
        String estado = "\nNombre del jugador especulador: " + this.getNombre() + ".\n";
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
        estado = estado.concat("\nFactor especulador: " + this.getFactorEspeculador() );
        estado = estado.concat("\nEste jugador puede construir el doble de casas y hoteles respecto a un jugador normal. Es decir: ");
        estado = estado.concat(this.getCasasMax() + " casas y " + this.getHotelesMax() + " hoteles.");
        return estado;
    }
}
