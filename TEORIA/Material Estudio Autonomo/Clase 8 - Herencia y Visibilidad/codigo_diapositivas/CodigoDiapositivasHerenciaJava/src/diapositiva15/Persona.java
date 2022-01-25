package diapositiva15;

class Persona {
    public String andar ( ) {
    return ( "Ando como una persona " ) ;
    }

    public String hablar ( ) {
        return ( " Hablo como una persona " ) ;
    }
}

class Profesor extends Persona {
    public String hablar ( ) {
        return ( " Hablo como un profesor " ) ;
    }
}

class Main {

    public static void main(String[] args) {
        Profesor profe = new Profesor ( ) ;
        profe.andar(); // Los profesores también andan
        profe.hablar();
    }
    
}
