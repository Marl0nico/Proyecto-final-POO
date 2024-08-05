package Miembros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarTarea_Miembros {
    public JPanel PanelAgregar_Tarea;
    private JLabel TareasMiembros;
    private JTextField IngresoTitulo;
    private JTextField IngresoCategoria;
    private JTextField IngresoDescripcion;
    private JTextField IngresoFecha_Inicio;
    private JTextField IngresoFecha_Fin;
    private JTextField IngresoPrioridad;
    private JTextField IngresoEstado;
    private JLabel TituloTarea;
    private JLabel CategoriaTarea;
    private JLabel DescripcionTarea;
    private JLabel FechaInicio_Tarea;
    private JLabel FechaFin_Tarea;
    private JLabel PrioridadTarea;
    private JLabel EstadoTarea;
    private JButton CrearTarea;
    private JButton VolverPanel_Miembros;
    private JButton VaciarCampos;
    public JPanel PanelAgregar_Tareas;
    public AgregarTarea_Miembros() {
        VolverPanel_Miembros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame8 = new JFrame("Menú Miembros");
                frame8.setContentPane(new Miembros().PanelMiembros);
                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame8.setSize(800, 600);
                frame8.pack();
                frame8.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(VolverPanel_Miembros)).dispose();
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
