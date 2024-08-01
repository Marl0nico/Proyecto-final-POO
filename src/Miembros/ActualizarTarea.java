package Miembros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActualizarTarea {
    private JTextField IngresarID;
    private JTextField IngresarTitulo;
    private JTextField IngresarCategoria;
    private JTextField IngresarDescripcion;
    private JTextField IngresarFecha_Inicio;
    private JTextField IngresarFecha_Limite;
    private JTextField IngresarPrioridad;
    private JTextField IngresarEstado;
    private JButton VaciarCampos;
    private JButton VolverPanel_Miembro;
    private JButton ActualizarTarea;
    public JPanel PanelVer_Tareas;
    private JLabel VerTareas;
    private JLabel IDTarea;
    private JLabel TítuloTarea;
    private JLabel CategoríaTarea;
    private JLabel DescripciónTarea;
    private JLabel FechaInicio_Tarea;
    private JLabel FechaFin_Tarea;
    private JLabel PrioridadTarea;
    private JLabel EstadoTarea;
    private JLabel ImagenActualizar_Tareas;

    public ActualizarTarea() {
        VolverPanel_Miembro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame6 = new JFrame("Menú Miembros");
                frame6.setContentPane(new Miembros().PanelMiembros);
                frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame6.setSize(800, 600);
                frame6.pack();
                frame6.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(VolverPanel_Miembro)).dispose();
            }
        });
        VaciarCampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresarID.setText("");
                IngresarTitulo.setText("");
                IngresarCategoria.setText("");
                IngresarDescripcion.setText("");
                IngresarFecha_Inicio.setText("");
                IngresarFecha_Limite.setText("");
                IngresarPrioridad.setText("");
                IngresarEstado.setText("");
            }
        });
        ActualizarTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
