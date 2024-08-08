package Lideres;

import LogIn.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Lider {
    private JButton AsignarTareas;
    private JButton AgregarMiembro;
    private JButton VerProgreso;
    public JPanel PanelLider;
    private JButton FinSesion;
    private JLabel Lider;
    private JLabel ImagenAdministrador;
    public Lider() {
        FinSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame4=new JFrame("Menú Login TaskFlow");
                frame4.setContentPane((new Login()).PanelLogin);
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setSize(800, 600);
                frame4.pack();
                frame4.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(FinSesion)).dispose();
            }
        });
        AsignarTareas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Menú agregar tareas");
                frame2.setContentPane(new AsignacionTareas_Lider().PanelAgregar_Tarea);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(800, 600);
                frame2.pack();
                frame2.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(AsignarTareas)).dispose();
            }
        });
        AgregarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Menú agregar miembro");
                frame2.setContentPane(new AgregarMiembro().PanelAgregar_Miembro);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(800, 600);
                frame2.pack();
                frame2.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(AgregarMiembro)).dispose();
            }
        });
        VerProgreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame("Menú ver avances del equipo");
                frame2.setContentPane(new VisualizarAvance_Equipo().PanelVer_Avance);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(800, 600);
                frame2.pack();
                frame2.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(VerProgreso)).dispose();
            }
        });
    }
}
