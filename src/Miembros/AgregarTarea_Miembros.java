package Miembros;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
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
    private JTextField IngresoProgramador;
    private JLabel Programador;
    //private MongoCollection<Document> collection;
    private MongoCollection<Document> collection;
    private int TareasID=1;
    String titulo, categoria, descripcion, fechaInicio, fechaFin, prioridad, estado, programador;
    public AgregarTarea_Miembros(String titulo, String categoria, String descripcion, String fechaInicio, String fechaFin, String prioridad, String estado, String programador) {
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
    public AgregarTarea_Miembros(MongoCollection<Document> collection){
        this.collection=collection;
        Document maxTareaIDDoc = collection.find().sort(Sorts.descending("TareaID")).first();
        if (maxTareaIDDoc != null) {
            this.TareasID = maxTareaIDDoc.getInteger("TareaID") + 1;
        } else {
            this.TareasID = 1; // Iniciar en 1 si la colección está vacía
        }
        //this.TareasID=(int) collection.countDocuments()+1;
    }
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
                IngresoProgramador.setText("");
            }
        });
        CrearTarea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                titulo=IngresoTitulo.getText();
                categoria=IngresoCategoria.getText();
                descripcion=IngresoDescripcion.getText();
                fechaInicio=IngresoFecha_Inicio.getText();
                fechaFin=IngresoFecha_Fin.getText();
                prioridad=IngresoPrioridad.getText();
                estado=IngresoEstado.getText();
                programador=IngresoProgramador.getText();
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                    MongoCollection<Document> collection1 = database.getCollection("Miembros");
                    boolean programadorEncontrado=false;
                    String nombre=IngresoProgramador.getText();
                    for (org.bson.Document document1 : collection1.find()) {
                        String nombreMiembros = document1.getString("Nombre");
                        if (nombreMiembros.equals(nombre)) {
                            programadorEncontrado = true;
                            break;
                        }
                    }
                    if (programadorEncontrado){
                        MongoCollection<org.bson.Document> collection = database.getCollection("Tareas");
                        org.bson.Document documento = new org.bson.Document("TareaID", TareasID)
                                .append("Titulo", titulo)
                                .append("Categoria", categoria)
                                .append("Descripcion", descripcion)
                                .append("FechaInicio", fechaInicio)
                                .append("FechaLimite", fechaFin)
                                .append("Prioridad", prioridad)
                                .append("Estado", estado)
                                .append("Programador", programador);
                        collection.insertOne(documento);
                        TareasID++;
                        System.out.println("Tarea agregada con éxito");
                        JOptionPane.showMessageDialog(null, "Tarea asignada exitosamente");
                    } else{
                        JOptionPane.showMessageDialog(null, "El programador no existe en la BD");
                    }
                }
            }
        });
    }
}
