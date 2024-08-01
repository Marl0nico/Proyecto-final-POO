package Miembros;
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

            }
        });
        ActualizarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
