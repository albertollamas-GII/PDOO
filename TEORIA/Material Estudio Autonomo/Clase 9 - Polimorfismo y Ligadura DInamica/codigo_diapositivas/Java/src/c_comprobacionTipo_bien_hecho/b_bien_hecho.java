package c_comprobacionTipo_bien_hecho;

import java.util.Random;

class Persona {
    private String nombre ;

    public Persona(String n) { nombre=n ; }
    
    protected void setNombre (String n ) { nombre=n ; }

    public void cambiarNombre(String n ) {
        setNombre ( "Don /Dña "+n ) ;
    }
}

class Profesor extends Persona {
    public Profesor (String n ) {
    super(n);
    }

    @Override
    public void cambiarNombre (String n) {
        setNombre ( " Prof . "+n ) ;
    }
}

public class b_bien_hecho {
    public static void main(String[] args) {
        Persona p;
        Random r=new Random();

        int dado=r.nextInt(6) +1;

        if (dado<=3) {
            p=new Persona ("Pepe");
        } else {
            p=new Profesor("Pepe");
        }

        // Tenemos el comportamiento correcto de forma automática
        p.cambiarNombre("Pepe");

        // También será válido si se añaden nuevos descendientes
        // de Persona/Profesor simplemente redefiniendo el método
    }
}
