package unPaquete;

public class HijaPaquete extends Padre {
    public void testInstanciaHijaPaquete(Padre o) {
        //System.out.println(privado);
        //System.out.println(o.privado);
        System.out.println(protegido);
        System.out.println(o.protegido);
        System.out.println(o.paquete);
        System.out.println(o.publico);
    }

    public static void testClaseHijaPaquete(Padre o) {
        //System.out.println(o.privado);
        System.out.println(o.protegido);
        System.out.println(o.paquete);
        System.out.println(o.publico);
    }
}
