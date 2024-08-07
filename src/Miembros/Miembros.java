package Miembros;
import Lideres.Lider;
import LogIn.Login;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Miembros {
    public JPanel PanelMiembros;
    private JLabel Miembros;
    private JButton AsignarTarea;
    private JButton FinSesion;
    private JButton ActualizarTarea;
    private JLabel ImagenMiembros;

    public Miembros() {
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
        AsignarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame8 = new JFrame("Menú asignar tarea");
                frame8.setContentPane(new AgregarTarea_Miembros().PanelAgregar_Tareas);
                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame8.setSize(800, 600);
                frame8.pack();
                frame8.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(AsignarTarea)).dispose();
            }
        });
        ActualizarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame9 = new JFrame("Menú actualizar tarea");
                frame9.setContentPane(new ActualizarTarea().PanelVer_Tareas);
                frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame9.setSize(800, 600);
                frame9.pack();
                frame9.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(ActualizarTarea)).dispose();
            }
        });
    }
}
