package Lideres;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarMiembro {
    private JTextField IngresoCedula;
    private JTextField IngresoNombre;
    private JTextField IngresoApellido;
    private JTextField IngresoEmail;
    private JTextField IngresoDireccion;
    private JTextField IngresoTelefono;
    private JTextField IngresoEquipo_Miembro;
    private JTextField IngresoFecha_Nacimiento;
    private JLabel AgregarMiembro;
    private JLabel IDMiembro;
    private JLabel NombreMiembro;
    private JLabel ApellidoMiembro;
    private JLabel EmailMiembro;
    private JLabel DireccionMiembro;
    private JLabel TelefonoMiembro;
    private JLabel EquipoMiembro;
    private JLabel FechaNacimiento_Miembro;
    private JButton IngresarMiembro;
    private JButton VaciarCampos;
    private JButton VolverPanel_Lider2;
    public JPanel PanelAgregar_Miembro;
    public AgregarMiembro() {
        VolverPanel_Lider2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame6 = new JFrame("Menú Líder");
                frame6.setContentPane(new Lider().PanelLider);
                frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame6.setSize(800, 600);
                frame6.pack();
                frame6.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(VolverPanel_Lider2)).dispose();
            }
        });
        VaciarCampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresoCedula.setText("");
                IngresoNombre.setText("");
                IngresoApellido.setText("");
                IngresoEmail.setText("");
                IngresoDireccion.setText("");
                IngresoTelefono.setText("");
                IngresoEquipo_Miembro.setText("");
                IngresoFecha_Nacimiento.setText("");
            }
        });
        IngresarMiembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
