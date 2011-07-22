package controlador;

import java.awt.Point;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.ListIterator;
import vista.Vista;
import modelo.Programa;
import modelo.Traductor;
import modelo.Interprete;
import modelo.Maquina;
import modelo.Figura;
import modelo.Modelo;
import vista.Lateral;

public class Controlador {

    private Modelo modelo;
    private Vista vista;
    private Figura seleccionada;
    private Lateral lateral;

    public Controlador(Modelo modelo, Vista vista, Lateral lateral) {
        this.modelo = modelo;
        this.vista = vista;
        seleccionada = null;
        this.lateral = lateral;
    }

    public Figura obtenerFigura(Point posicion) {
        ListIterator<Figura> it = modelo.getListado().listIterator();
        while (it.hasNext()) {
            Figura tmp = it.next();
            if (tmp.dentroFigura(posicion)) {
                tmp.setSeleccionada(true);
                return tmp;
            }
        }
        return null;
    }

    public void cambiarPosicion(Figura f, Point p) {
        f.setPosicion(p);
    }

    public Vista getVista() {
        return vista;
    }

    public void quitarFigura(Figura f) {

        modelo.QuitarFigura(f);
    }

    public void anyadirFigura(Figura f) {
        modelo.anyadirFigura(f);
    }

    public Figura getFiguraEn(Point p) {
        return modelo.getFiguraEn(p);
    }

    public void eVmousePressed(MouseEvent ev) {
        if (SwingUtilities.isLeftMouseButton(ev)) { 			//Click boton izquierdo selecciona figura
            seleccionada = this.getFiguraEn(ev.getPoint());

        } else if (SwingUtilities.isRightMouseButton(ev)) {
            if (lateral.gettipo() == 1) {
                this.anyadirFigura(new Programa(ev.getPoint(), 57));
            }
            if (lateral.gettipo() == 2) {
                this.anyadirFigura(new Traductor(ev.getPoint(), 40));
            }
            if (lateral.gettipo() == 3) {
                this.anyadirFigura(new Interprete(ev.getPoint(), 40));
            }
            if (lateral.gettipo() == 4) {
                this.anyadirFigura(new Maquina(ev.getPoint(), 40));
            } else {
            }
            /*
            //click boton izquierdo a�ade figura tipo cuadrado
            if (this.getFiguraEn(ev.getPoint()) == null) {
            this.anyadirFigura(new Traductor(ev.getPoint(), 40));
            }
            if (this.getFiguraEn(ev.getPoint()).getSeleccionada() == true && this.getFiguraEn(ev.getPoint()).getTipo() == 1) {
            this.quitarFigura(this.getFiguraEn(ev.getPoint()));
            this.anyadirFigura(new Interprete(ev.getPoint(), 40));
            }
            if (this.getFiguraEn(ev.getPoint()).getSeleccionada() == true && this.getFiguraEn(ev.getPoint()).getTipo() == 3) {
            this.quitarFigura(this.getFiguraEn(ev.getPoint()));
            this.anyadirFigura(new Programa(ev.getPoint(), 57));
            }
            if (this.getFiguraEn(ev.getPoint()).getSeleccionada() == true && this.getFiguraEn(ev.getPoint()).getTipo() == 2) {
            this.quitarFigura(this.getFiguraEn(ev.getPoint()));
            this.anyadirFigura(new Maquina(ev.getPoint(), 40));
            }
            } else if (SwingUtilities.isMiddleMouseButton(ev)) {//click boton medio a�ade figura tipo circulo
            if (this.getFiguraEn(ev.getPoint()).getSeleccionada() == true) {
            this.quitarFigura(this.getFiguraEn(ev.getPoint()));
            }*/
            //	this.anyadirFigura(new Programa(ev.getPoint(),57));
        }
        vista.repaint();
    }

    public void eVmouseDragged(MouseEvent ev) {
        if (seleccionada != null) {
            //El movimiento puede ser mas fluido recalculando el pto
            this.cambiarPosicion(seleccionada, ev.getPoint());
            vista.repaint();
            Point p = new Point();
            List<Figura> it = modelo.getListado();
            for (Figura elemento : it) {
                p = elemento.darPunto(); //Punto en el que se hace union con la figura
                for (Figura elemento2 : it) {
                    if (elemento2.getTipo() == 4) // Si es una maquina es otro punto ya que es inferior al traductor
                    {
                        p = elemento.darPunto2();
                        if (elemento2.dentroFigura2(p)) {
                            this.quitarFigura(elemento2);
                            p.x = p.x - 20;
                            p.y = p.y;
                            this.anyadirFigura(new Maquina(p, 40));
                            System.out.println(elemento2.getTipo());
                        }
                    } else if (elemento2.dentroFigura2(p)) //comparacion con cada posible figura
                    {
                        if (elemento2.getTipo() == 2) {
                            this.quitarFigura(elemento2);
                            p.x = p.x + 40;
                            p.y = p.y + 20;
                            this.anyadirFigura(new Traductor(p, 40));
                            System.out.println(elemento2.getTipo());
                        }
                        if (elemento2.getTipo() == 3) {
                            this.quitarFigura(elemento2);
                            p.x = p.x;
                            p.y = p.y - 100;
                            this.anyadirFigura(new Interprete(p, 40));
                            System.out.println(elemento2.getTipo());
                        }
                        if (elemento2.getTipo() == 1) {
                            this.quitarFigura(elemento2);
                            p.x = p.x - 10;
                            p.y = p.y - 109;
                            this.anyadirFigura(new Programa(p, 57));
                            System.out.println(elemento2.getTipo());
                        }
                    }
                }
            }
        }
    }

    public void eVmouseReleased(MouseEvent ev) {
        vista.repaint();
        if (seleccionada != null) {
            seleccionada.setSeleccionada(false);
            seleccionada = null;
        }
    }
}
