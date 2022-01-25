package b_comprobacionTipo_mal_hecho;

import java.util.Random;

class Persona {
    private String nombre ;

    public Persona(String n) {
        nombre=n ;
    }

    public void setNombre(String n) {
        nombre=n ;
    }
}

class Profesor extends Persona {
    public Profesor (String n) {
        super(n);
    }
}

public class a_mal_hecho {
    public static void main(String[] args) {
        Persona p;
        Random r = new Random();

        int dado = r.nextInt(6) +1;

        if (dado<=3) {
            p=new Persona ( "Pepe" ) ;
        } else {
            p=new Profesor ( "Pepe" ) ;
        }

        // Nada recomendable
        // Mal diseño
        // No lo hagáis
        // Lo digo en serio , no hagáis este tipo de diseños
        if (p instanceof Profesor) {
            p.setNombre("Prof . Pepe");
        } else {
            p.setNombre("Don /Dña Pepe");
        }
    }    
}
