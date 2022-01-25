package otroPaquete;

public class NietaOtroPaquete extends HijaOtroPaquete {
    // Ahora probamos con un parámetro de la superclase

    public void testInstanciaNietaOtroPaquete(HijaOtroPaquete o) {
        //System.out.println(o.privado);
        //System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseNietaOtroPaquete(HijaOtroPaquete o ) {
        //System.out.println(o.privado);
        //System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public void testInstanciaNietaOtroPaquete(NietaOtroPaquete o) {
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseNietaOtroPaquete(NietaOtroPaquete o ) {
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        //System.out.println(o.paquete);
        System.out.println(o.publico);
    }
}
