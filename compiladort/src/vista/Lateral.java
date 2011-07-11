/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Jean Carlos
 */
public class Lateral {

    private JPanel lateral, opciones, objetos, atributos;
    private JButton nuevo, abrir, guardar, salir, programa, interprete, compilador, maquina;
    private JLabel label1, label2, label3, valor1, valor2, valor3;
    private JTextField campo1, campo2, campo3;


    public Lateral() {
        lateral = new JPanel(null);
        lateral.setBounds(0, 0, 200,500);
        lateral.setBackground(Color.GRAY);
        lateral.setVisible(true);

        opciones = new JPanel(null);
        opciones.setBounds(0, 0, 200, 200);
        opciones.setBackground(Color.BLUE);
        opciones.setVisible(true);

        label1 = new JLabel("Menu Principal");
        label1.setBounds(25, 10, 100, 15);
        label1.setVisible(true);

        nuevo = new JButton("Nuevo", new ImageIcon("images/nuevo.gif"));
        nuevo.setBounds(25, 30, 150, 30);
        nuevo.setVisible(true);

        abrir = new JButton("Abrir", new ImageIcon("images/abrir.png"));
        abrir.setBounds(25, 70, 150, 30);
        abrir.setVisible(true);

        guardar = new JButton("Guardar", new ImageIcon("images/guardar.png"));
        guardar.setBounds(25, 110, 150, 30);
        guardar.setVisible(true);

        salir = new JButton("Salir", new ImageIcon("images/exit.gif"));
        salir.setBounds(25, 150, 150, 30);
        salir.setVisible(true);

        opciones.add(label1);
        opciones.add(nuevo);
        opciones.add(abrir);
        opciones.add(guardar);
        opciones.add(salir);

        objetos = new JPanel(null);
        objetos.setBounds(0, 200, 200, 200);
        objetos.setBackground(Color.RED);
        objetos.setVisible(true);

        label2 = new JLabel("Menu de Objetos");
        label2.setBounds(25, 10, 100, 15);
        label2.setVisible(true);

        programa = new JButton("Programa", new ImageIcon("images/programa32.png"));
        programa.setBounds(25, 30, 150, 30);
        programa.setVisible(true);

        compilador = new JButton("Compiladores", new ImageIcon("images/compilador32.png"));
        compilador.setBounds(25, 70, 150, 30);
        compilador.setVisible(true);

        interprete = new JButton("Interprete", new ImageIcon("images/interprete32.png"));
        interprete.setBounds(25, 110, 150, 30);
        interprete.setVisible(true);

        maquina = new JButton("Maquina", new ImageIcon("images/maquina32.png"));
        maquina.setBounds(25, 150, 150, 30);
        maquina.setVisible(true);

        objetos.add(label2);
        objetos.add(programa);
        objetos.add(compilador);
        objetos.add(interprete);
        objetos.add(maquina);

        atributos = new JPanel(null);
        atributos.setBounds(0, 400, 200, 200);
        atributos.setBackground(Color.YELLOW);
        atributos.setVisible(true);

        label3 = new JLabel("Opciones de Objetos");
        label3.setBounds(25, 10, 150, 15);
        label3.setVisible(true);

        valor1 = new JLabel("Valor1");
        valor1.setBounds(25, 35, 100, 15);
        valor1.setVisible(true);

        valor2 = new JLabel("Valor2");
        valor2.setBounds(25, 60, 100, 15);
        valor2.setVisible(true);

        valor3 = new JLabel("Valor3");
        valor3.setBounds(25, 85, 100, 15);
        valor3.setVisible(true);

        campo1 = new JTextField();
        campo1.setBounds(70, 35, 100, 20);
        campo1.setVisible(true);

        campo2 = new JTextField();
        campo2.setBounds(70, 60, 100, 20);
        campo2.setVisible(true);

        campo3 = new JTextField();
        campo3.setBounds(70, 85, 100, 20);
        campo3.setVisible(true);

        atributos.add(label3);
        atributos.add(valor1);
        atributos.add(valor2);
        atributos.add(valor3);
        atributos.add(campo1);
        atributos.add(campo2);
        atributos.add(campo3);

        lateral.add(opciones);
        lateral.add(objetos);
        lateral.add(atributos);        
    }

    public JPanel getLateral() {
        return lateral;
    }
}
