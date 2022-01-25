package domotica;

public class Main {

    public static void main(String[] args) {
        
        Dormitorio dormitorio = new Dormitorio(1, 2);
        Lavabo lavabo = new Lavabo(2);
        
        Domo domo = new Domo();
        domo.incluirHabitación(dormitorio);
        domo.incluirHabitación(lavabo);
        
        Domo copia = new Domo(domo);
        
    }    
}
