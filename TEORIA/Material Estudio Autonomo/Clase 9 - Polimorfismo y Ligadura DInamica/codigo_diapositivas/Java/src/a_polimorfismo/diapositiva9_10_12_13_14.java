package a_polimorfismo;

import java.util.ArrayList;

class Persona {
    public String andar() {
        return ( "Ando como una persona");
    }

    public String hablar() {
        return ( "Hablo como una persona") ;
    }
}

class Profesor extends Persona {
    @Override
    public String hablar() {
        return ( " Hablo como un profesor " ) ;
    }

    public String impartirClase() {
        // Este método no lo tiene Persona ni ninguna de sus superclases
        return("Impartiendo clase") ;
    }
}

class Alumno extends Persona {
    // Clase " hermana " de Profesor
    // Alumno y Profesor son descendientes directos de Persona
}

class Diapositiva9_10_12_13_14 {

    public static void main(String[] args) {
        Persona p=new Persona();
        Persona p2=new Profesor(); // Puede también referenciar a un Profesor

        p.hablar(); // "Hablo como una persona "
        p2.hablar(); // " Hablo como un profesor "    
        
        // DIAPOSITIVA 10
        // Error de compilación . Las personas no tienen ese método
        //p.impartirClase();

        // Error de compilación . Object no es subclase de Persona
        //p=new Object();

        // DIAPOSITIVA 12
        Persona p3 = new Profesor(); // El objeto es un Profesor
                                    // y siempre lo será , a pesar de los casts

        // Error de compilación . Las personas no tienen ese método
        //p3.impartirClase();

        // Error de compilación . En general una Persona no es un Profesor
        //Profesor prof=p3;

        ((Profesor) p3).impartirClase();
        Profesor profe = (Profesor) p3;

         profe.hablar(); // "Hablo como un profesor"

        // Upcast innecesario y sin efectos
        ((Persona) profe).hablar(); // "Hablo como un profesor"

        // Upcast implícito y sin efectos
        Persona p4 = profe;
        p4.hablar(); // " Hablo como un profesor "

        //DIAPOSITIVA 13
        // Errores en tiempo de ejecución
        // java.lang.ClassCastException : Persona cannot be cast to Profesor

        Persona p5 = new Persona();
        Profesor profe2 = (Profesor) p5 ; // Error

        //profe2 = ((Profesor) new Persona()) ; // Error

        //((Profesor) p5).impartirClase(); // Error

        ((Profesor) ((Object) new Profesor())).impartirClase(); // OK

        
        //DIAPOSITIVA 14
        // Error de compilación . Tipos incompatibles
        //Alumno a1 = new Profesor();

        // Error de compilación . Tipos incompatibles
        //Alumno a2 = (Alumno) new Profesor();

        // Error en tiempo de ejecución
        // java.lang.ClassCastException : Profesor cannot be cast to Alumno
        //Alumno a3 =((Alumno) ((Object) new Profesor ()));
    }
}
