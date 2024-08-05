package Miembros;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
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
    String titulo, categoria, descripcion, fechaInicio, fechaFin, prioridad, estado, programador;
    public ActualizarTarea(String titulo, String categoria, String descripcion, String fechaInicio, String fechaFin, String prioridad, String estado, String programador) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.prioridad = prioridad;
        this.estado = estado;
        this.programador = programador;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    public String getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getProgramador() {
        return programador;
    }
    public void setProgramador(String programador) {
        this.programador = programador;
    }
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
                titulo=IngresarTitulo.getText();
                categoria=IngresarCategoria.getText();
                descripcion=IngresarDescripcion.getText();
                fechaInicio=IngresarFecha_Inicio.getText();
                fechaFin=IngresarFecha_Limite.getText();
                prioridad=IngresarPrioridad.getText();
                estado=IngresarEstado.getText();
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                    MongoCollection<Document> collection = database.getCollection("Tareas");
                    boolean tareaID=false;
                    int id= Integer.parseInt(IngresarID.getText());
                    //Document filtro=new Document("Tarea ID", id);
                    //Document existente=collection.find(filtro).first();
                    for (Document document : collection.find()) {
                        int id_tarea = document.getInteger("TareaID");
                        if (id_tarea == id) {
                            tareaID = true;
                            collection.updateOne(new Document("TareaID", id), Updates.combine(
                                    Updates.set("Titulo", titulo),
                                    Updates.set("Categoria", categoria),
                                    Updates.set("Descripcion", descripcion),
                                    Updates.set("FechaInicio", fechaInicio),
                                    Updates.set("FechaLimite", fechaFin),
                                    Updates.set("Prioridad", prioridad),
                                    Updates.set("Estado", estado)
                            ));
                            JOptionPane.showMessageDialog(null, "Actualización completada");
                            System.out.println("Registro actualizado correctamente");
                            //System.out.println("Documentos modificados: " + resultado.getModifiedCount());
                            break;
                        }
                    }
                    if (!tareaID) {
                        System.out.println("No se encontró ninguna tarea con el ID proporcionado");
                        JOptionPane.showMessageDialog(null, "No se encontró ninguna tarea con el ID proporcionado");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar la tarea");
                }
            }
        });
    }
}
