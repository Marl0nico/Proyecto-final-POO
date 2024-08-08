package Lideres;

import com.mongodb.client.*;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarAvance_Equipo {
    private JButton RegresarPanel_Lider;
    private JTextField IngresarDato;
    private JButton BuscarDato;
    private JLabel VerEstado_Equipo;
    private JLabel ImagenEstado_Equipo;
    private JLabel DatoBuscar;
    private JLabel Nombre;
    private JLabel Tarea;
    private JLabel Estado;
    private JLabel MostrarTitulo;
    private JLabel MostrarTarea;
    private JLabel MostrarEstado;
    public JPanel PanelVer_Avance;
    private JLabel FechaLimite;
    private JLabel Prioridad;
    private JLabel MostrarFecha_Limite;
    private JLabel MostrarPrioridad;

    public VisualizarAvance_Equipo() {
        RegresarPanel_Lider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame8 = new JFrame("Menú Líder");
                frame8.setContentPane(new Lider().PanelLider);
                frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame8.setSize(800, 600);
                frame8.pack();
                frame8.setVisible(true);
                ((JFrame) SwingUtilities.getWindowAncestor(RegresarPanel_Lider)).dispose();
            }
        });
        BuscarDato.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                    //buscar en la BD si el miembro existe
                    MongoCollection<Document> collection1 = database.getCollection("Miembros");
                    //Document document1 = collection1.find().first(); // Aquí puedes usar un filtro si lo necesitas
                    //String dato1 = document1.getString("Nombre");
                    boolean miembro=false;
                    String dato=IngresarDato.getText();
                    for (Document document : collection1.find()) {
                        String nombreMiembro = document.getString("Nombre");
                        if (dato.equals(nombreMiembro)) {
                            miembro = true;
                            break;
                        }
                    }
                    if (miembro){
                        MongoCollection<Document> collection2 = database.getCollection("Tareas");
                        Document filtro1 = new Document("Programador", dato);
                        Document registro = collection2.find(filtro1).first();
                        if (registro != null) {
                            // Obtener los valores de los campos específicos
                            String titulo = registro.getString("Titulo");
                            String descripcion = registro.getString("Descripcion");
                            String estado = registro.getString("Estado");
                            String fechaLimite=registro.getString("FechaLimite");
                            String prioridad=registro.getString("Prioridad");
                            // Mostrar los valores en los campos correspondientes
                            Nombre.setText("Título:");
                            Tarea.setText("Tarea asignada:");
                            Estado.setText("Estado:");
                            FechaLimite.setText("Fecha Límite:");
                            Prioridad.setText("Prioridad:");
                            MostrarTitulo.setText(titulo);
                            MostrarTarea.setText(descripcion);
                            MostrarEstado.setText(estado);
                            MostrarFecha_Limite.setText(fechaLimite);
                            MostrarPrioridad.setText(prioridad);
                        } else {
                            // Manejar el caso donde no se encuentra ningún documento
                            System.out.println("No se encontró ninguna tarea con el nombre proporcionado.");
                            JOptionPane.showMessageDialog(null, "No existen tareas para el nombre ingresado");
                        }
                    } else {
                        System.out.println("No existe este miembro en la base de datos");
                        JOptionPane.showMessageDialog(null, "Esta persona no existe en la BD");
                    }
                }

            }
        });
    }
}
