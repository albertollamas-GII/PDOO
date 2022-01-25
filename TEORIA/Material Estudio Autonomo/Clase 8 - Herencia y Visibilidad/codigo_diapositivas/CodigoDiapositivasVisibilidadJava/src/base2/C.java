package base2;

import base.*;

public class C extends B {
    protected int protegidoC = 2;
    public void test() {
        A a = new A();
        //a.protegidoA = 666;
        B b = new B();
        //b.protegidoB = 666;
        C c = new C();
        c.protegidoA = 555;
        D d = new D();
        d.protegidoA = 555;
        D d2 = new D();
        d2.protegidoB = 555;
        //d2.protegidoD = 555;
        this.protegidoA = 777;
    }
}
