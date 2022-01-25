package diapositiva24;

class Persona {
    private String nombre;
    public Persona (String n) { // Constructor con parámetros
        nombre=n ;
    }
    public String andar() { return("Ando como una persona"); }
    public String hablar() { return ("Hablo como una persona" ); }
}

class Profesor extends Persona {
    private String asignatura;
    public Profesor (String n , String a ) {
        super(n);   // Esta llamada es obligatoria ¿por qué?
                    // Además debe ser la primera línea
        asignatura = a ;
    }
    @Override
    public String hablar() { return ("Estimados alumnos: \n " + super.hablar()); }
    }

class Main {
    public static void main(String[] args) {
        System.out.println((new Profesor("Jaime" , "PDOO")).hablar());
    }
}
