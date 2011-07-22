package modelo;

import java.awt.Graphics;
import java.awt.Point;

public class t extends Figura {

    String entrada = ""; // codigo que resive
    String salida = "";  // codigo que genera
    String implementacion = ""; //codigo del compilador

    @Override
    public boolean dentroFigura(Point p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void dibujar(Graphics g) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean dentroFigura2(Point p) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point darPunto() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Point darPunto2() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
