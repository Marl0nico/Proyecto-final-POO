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
                /*try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    Document nombre=null;
                    nombre=new Document("Nombre", IngresarDato.getText());
                    FindIterable<Document> documentos = collection.find();
                    for (Document documento : documentos) {
                        Document registro=collection.find(nombre).first();
                        if (registro!=null){
                            String titulo= documento.getString("Titulo");
                            String descripcion = documento.getString("Descripcion");
                            String estado= documento.getString("Estado");
                            MostrarTitulo.setText(titulo);
                            MostrarTarea.setText(descripcion);
                            MostrarEstado.setText(estado);
                        }
                        //System.out.println(documento.toJson());
                    }
                }*/
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
                    //MongoCollection<Document> collection = database.getCollection("Tareas");
                    // Crear el filtro para buscar por el nombre ingresado
                    //Document filtro = new Document("Programador", IngresarDato.getText());
                    // Encontrar el primer documento que coincide con el filtro
                    //Document registro = collection.find(filtro).first();
                    if (miembro){
                        MongoCollection<Document> collection2 = database.getCollection("Tareas");
                        Document filtro1 = new Document("Programador", dato);
                        Document registro = collection2.find(filtro1).first();
                        if (registro != null) {
                            // Obtener los valores de los campos específicos
                            String titulo = registro.getString("Titulo");
                            String descripcion = registro.getString("Descripcion");
                            String estado = registro.getString("Estado");
                            // Mostrar los valores en los campos correspondientes
                            Nombre.setText("Título:");
                            Tarea.setText("Tarea asignada:");
                            Estado.setText("Estado:");
                            MostrarTitulo.setText(titulo);
                            MostrarTarea.setText(descripcion);
                            MostrarEstado.setText(estado);
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
