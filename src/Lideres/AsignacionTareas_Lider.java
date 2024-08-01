package Lideres;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AsignacionTareas_Lider {
    private JTextField IngresoTitulo;
    private JTextField IngresoCategoria;
    private JTextField IngresoDescripcion;
    private JTextField IngresoFecha_Inicio;
    private JTextField IngresoFecha_Fin;
    private JTextField IngresoPrioridad;
    private JTextField IngresoEstado;
    private JLabel TareasLider;
    private JLabel TituloTarea;
    private JLabel CategoriaTarea;
    private JLabel DescripcionTarea;
    private JLabel FechaInicio_Tarea;
    private JLabel FechaFin_Tarea;
    private JLabel PrioridadTarea;
    private JLabel EstadoTarea;
    private JButton CrearTarea;
    private JButton VolverPanel_Lider;
    private JButton VaciarCampos;
    public JPanel PanelAgregar_Tarea;
    public AsignacionTareas_Lider() {
        VolverPanel_Lider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame5 = new JFrame("Menú Líder");
                frame5.setContentPane(new Lider().PanelLider);
                frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame5.setSize(800, 600);
                frame5.pack();
                frame5.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(VolverPanel_Lider)).dispose();
            }
        });
        VaciarCampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IngresoTitulo.setText("");
                IngresoCategoria.setText("");
                IngresoDescripcion.setText("");
                IngresoFecha_Inicio.setText("");
                IngresoFecha_Fin.setText("");
                IngresoPrioridad.setText("");
                IngresoEstado.setText("");
            }
        });
        CrearTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
