/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package civitas;

import java.util.ArrayList;

/**
 *
 * @author albertollamasgonzalez
 */
//Clase utilizada en las practicas 1 y 2 para probar los métodos
public class Civitas {
    static final int NUMJUGADORES = 4;
//    public static void main(String[] args){
//        
//        /* 
//        1.Llama 100 veces al método quienEmpieza() de Dado considerando que hay 4 jugadores, y 
//        calcula cuantas veces se obtiene cada uno de los valores posibles. 
//        Comprueba si se cumplen a nivel práctico las probabilidades de cada valor.
//        */
//        int veces1= 0, veces2=0, veces3=0, veces4=0;
//        int num = 0;
//        for (int i = 0; i < 99; i++){
//            num = Dado.getInstance().quienEmpieza(NUMJUGADORES);
//            switch (num){
//                case 1:
//                    veces1++;
//                    break;
//                case 2:
//                    veces2++;
//                    break;
//                case 3:
//                    veces3++;
//                    break;
//                case 4:
//                    veces4++;
//                    break;
//            }           
//        }
//        
//        if (veces1 == veces2){
//            if (veces1 == veces3){
//                if (veces1 == veces4){
//                    System.out.println("Hay un 25% de probabilidad de que empiece cada jugador");
//                }
//            }
//        }else{
//            
//            System.out.println ("Ejercicio 1:\n No se cumple a nivel práctico las probabilidades de cada jugador\n");
//        }
//        
//        /*
//        2. Asegúrate de que funciona el modo debug del dado activando y 
//        desactivando ese modo, y realizando varias tiradas en cada modo.
//        */
//        
//        System.out.println("Ejercicio2: \nDebug true");
//
//        Dado.getInstance().setDebug(true);
//        int tirada = 0;
//        
//        for (int i = 0; i < 5; i++){
//            tirada = Dado.getInstance().tirar();
//            System.out.println("Tirada " + i + ": " + tirada);
//        }
//        
//        System.out.println("Debug false");
//        Dado.getInstance().setDebug(false);
//        
//        for (int i = 0; i < 5; i++){
//            tirada = Dado.getInstance().tirar();
//            System.out.println("Tirada " + i + ": " + tirada);
//        }
//        
//        /*
//        3.Prueba al menos una vez el método getUltimoResultado() de Dado.
//        */
//        System.out.println("\nEjercicio 3: ");
//        System.out.println("El ultimo resultado es " + Dado.getInstance().getUltimoResultado());
//        
//        /*
//        4.Muestra al menos un valor de cada tipo enumerado.
//        */
//        System.out.println("\nEjercicio 4: ");
//        System.out.println(TipoCasilla.CALLE);
//        System.out.println(TipoSorpresa.PAGARCOBRAR);
//        System.out.println(EstadoJuego.INICIO_TURNO);
//        
//        /*
//        5. Crea un objeto Tablero y haz las siguientes pruebas: añade algunas calles al tablero, 
//        obtén dichas casillas y muestra su estado por consola usando el método toString de la clase Casilla.
//        */
//        
//        Casilla casilla1 = new Casilla(TipoCasilla.CALLE, "Victoria", 12000, 3000, 700);
//        Casilla casilla2 = new Casilla(TipoCasilla.CALLE, "Surprise", 10000, 1000, 500);
//        Casilla casilla3 = new Casilla(TipoCasilla.CALLE, "Mesa", 3000, 100, 200);
//
//        Tablero tablero = new Tablero();
//        tablero.añadeCasilla(casilla1);
//        tablero.añadeCasilla(casilla2);
//        tablero.añadeCasilla(casilla3);
//        
//        String salidaCasilla1 = casilla1.toString();
//        
//        System.out.println("\nEjercicio 5: \n" + salidaCasilla1);
//        
//        /*
//        6. Crea algunos bucles sobre la totalidad de las calles para calcular y 
//        mostrar cuál es la calle más cara (en cuanto a su precio de compra), la más barata y el precio medio de las calles.
//        */
//        System.out.println("\nEjercicio 6: ");
//
//        Casilla masCara = new Casilla(TipoCasilla.CALLE, "auxiliar 1", 0, 0,0);
//        Casilla masBarata = new Casilla(TipoCasilla.CALLE, "auxiliar 2", 99999999, 99999999,99999999);
//        for (int i = 1; i < tablero.numeroCalles() + 1; i++){
//            Casilla aux = new Casilla(tablero.getCasilla(i));
//            if (aux.getPrecioCompra() > masCara.getPrecioCompra())
//                masCara = new Casilla(aux);
//            if (aux.getPrecioCompra() < masBarata.getPrecioCompra())
//                masBarata = new Casilla(aux);
//        }
//        
//        
//        System.out.println ("La calle mas cara es la calle " + masCara.getNombre());
//        System.out.println ("La calle mas barata es la calle " + masBarata.getNombre());
//
//        
//        float totalSumaCalles = 0;
//        
//        for (int i = 1; i < tablero.numeroCalles() + 1; i++){
//            Casilla aux = new Casilla(tablero.getCasilla(i));
//            if (aux.esCalle())
//                totalSumaCalles += aux.getPrecioCompra();
//        }
//        
//        //(12000+10000+3000) / 3
//        float precioMedio = totalSumaCalles / tablero.numeroCalles();
//
//        System.out.println("Precio Medio de las calles: " + precioMedio);
//        
//        
//        /*
//        7. Usa la clase Diario, aprovecha y prueba todos los métodos de Diario.
//        */
//        //Hay eventos pendientes porque se activa y desactiva modo debug y se tiran los dados
//        System.out.println("\nEjercicio 7: Mostrando los eventos de Diario:\n");
//        if (Diario.getInstance().eventosPendientes()){
//            Diario.getInstance().ocurreEvento("Pasa por casilla de salida");
//            Diario.getInstance().ocurreEvento("Compra un hotel");
//        }
//        while (Diario.getInstance().eventosPendientes()){
//            System.out.println(Diario.getInstance().leerEvento());
//        }
//
//        
//        /*
//        8.Finalmente, realiza distintas tiradas con el dado y 
//        asegúrate de que se calcula correctamente la posición de destino en el tablero.
//        */
//        System.out.println("\nEjercicio 8: Tiramos el dado una vez desde la casilla 1: \n");
//        tirada = Dado.getInstance().tirar();
//        System.out.println("El resultado de la tirada es " + tirada);
//        int nuevaPosicion = tablero.nuevaPosicion(1, tirada);
//        System.out.println("Se tiran los dados y vamos desde la casilla 1 hasta la casilla: " + nuevaPosicion);
//    }
    
    //Main para probar practica 2
    //Se han probado los metodos de cada clase en un main rapido en cada comprobando los metodos con mayor complejidad
    //En este main se ha creado un nuevo juego para comprobar la clase CIvitasJuego, la cual parece ser la principal al inicializar mazo y tablero.
//    public static void main(String[] args){
//        ArrayList<String> nombres = new ArrayList<>();
//        nombres.add("Pablo");
//        nombres.add("Pedro");
//        nombres.add("Juan");
//        nombres.add("Luis");
//        CivitasJuego nuevoJuego = new CivitasJuego(nombres, true);
//        
//        System.out.println("Empieza " + nombres.get(nuevoJuego.getIndiceJugadorActual()));
//    }
}
