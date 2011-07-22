
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import vista.Vista;
import modelo.Modelo;
import controlador.Controlador;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import vista.Lateral;

public class Figuras {

    public static void main(String[] args) {
        try {
            final JFrame frame = new JFrame();
            Lateral lateral = new Lateral();
            frame.setLayout(null);
            frame.add(lateral.getOp());
            frame.add(lateral.getOb());
            frame.add(lateral.getAt());
            frame.setTitle("Graficador de Tostones 2011");
            frame.setVisible(true);
            frame.setSize(800, 600);
            frame.getContentPane().setPreferredSize(new Dimension(800,600));
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            Container guiobjects = frame.getContentPane();
            Modelo modelo = new Modelo();
            Vista vista = new Vista(new Dimension(600, 600), modelo);
            final Controlador controlador = new Controlador(modelo, vista,lateral);
            vista.controlador = controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
            JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
            ModelScroll.setBounds(200,0,600,600);
            guiobjects.add(ModelScroll);
            ModelScroll.repaint();
            frame.repaint();            
            //frame.pack();

        } catch (RuntimeException e) {
            exitApplication();
        }
    }

    public static void exitApplication() {
        System.out.println("Saliendo Adios...");
        System.exit(0);
    }
}

/*
 * if(event.getClickCount()==2){
JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.WARNING_MESSAGE);
}
 */
