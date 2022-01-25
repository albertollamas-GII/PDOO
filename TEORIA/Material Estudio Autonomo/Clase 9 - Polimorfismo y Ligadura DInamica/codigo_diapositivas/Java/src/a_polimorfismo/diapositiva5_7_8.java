package a_polimorfismo;

import java.util.ArrayList;

class FiguraGeometrica { 
    float area() {return 0.0f;}
}

class Circulo extends FiguraGeometrica { 
    private float radio;

    public Circulo(float radio) {
        this.radio = radio;
    }

    @Override
    float area() {
        return (float)Math.PI * radio * radio;
    }
}

class Rectangulo extends FiguraGeometrica { 
    private float lado1,lado2;

    public Rectangulo(float lado1, float lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    float area() {
        return lado1 * lado2 ;
    }
}

class Diapositiva5_7_8 {

    public static void main(String[] args) {
        float radio = 5, lado1=3, lado2=4;
        
        ArrayList<FiguraGeometrica> coleccionDeFiguras = new ArrayList<>();
        coleccionDeFiguras.add (new Circulo(radio)) ;
        coleccionDeFiguras.add (new Rectangulo(lado1, lado2)) ;

        float suma = 0.0f;
        for (FiguraGeometrica unaFigura : coleccionDeFiguras ) {
            suma += unaFigura . area ( ) ;
        }
    }
}
