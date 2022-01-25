package otroPaquete;

import unPaquete.Padre;

public class HijaOtroPaquete extends Padre {
    public void testInstanciaHijaOtroPaquete(Padre o) {
        // Acceso a elementos heredados
        //System.out.println(privado);
        //System.out.println(paquete);
        System.out.println(protegido);
    
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        //System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseHijaOtroPaquete(Padre o) {
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        //System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }
    
    public void testInstanciaHijaOtroPaquete(HijaOtroPaquete o) {
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseHijaOtroPaquete(HijaOtroPaquete o) {
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public void testInstanciaHijaOtroPaquete(NietaOtroPaquete o) {
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseHijaOtroPaquete(NietaOtroPaquete o) {
        // Acceso a elementos de otra instancia
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }
}
