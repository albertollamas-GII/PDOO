package unPaquete;

public class Padre {
    private int privado;
    protected int protegido;
    int paquete;
    public int publico;

    public void testInstanciaPadre(Padre o) {
        System.out.println(o.privado);
        System.out.println(o.protegido);
        System.out.println(o.paquete);
        System.out.println(o.publico) ;
    }

    public static void testClasePadre (Padre o) {
        System.out.println(o.privado);
        System.out.println(o.protegido);
        System.out.println(o.paquete);
        System.out.println(o.publico);
    }
}

