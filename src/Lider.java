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
                JFrame frame=new JFrame("Menú Login TaskFlow");
                frame.setContentPane((new Login()).PanelLogin);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
