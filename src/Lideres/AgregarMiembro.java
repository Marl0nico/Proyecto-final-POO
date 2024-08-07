package Lideres;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
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
    private JLabel ImagenNuevo_Miembro;
    int cedula, nEquipo, telefono;
    String nombre, apellido, email, direccion, fechaNacimiento;
    public AgregarMiembro(int cedula, int nEquipo, int telefono, String nombre, String apellido, String email, String direccion, String fechaNacimiento) {
        this.cedula = cedula;
        this.nEquipo = nEquipo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }
    public int getCedula() {
        return cedula;
    }
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    public int getnEquipo() {
        return nEquipo;
    }
    public void setnEquipo(int nEquipo) {
        this.nEquipo = nEquipo;
    }
    public int getTelefono() {
        return telefono;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
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
                //AgregarMiembro agregarMiembros=new AgregarMiembro();
                cedula=Integer.parseInt(IngresoCedula.getText());
                nombre=IngresoNombre.getText();
                apellido=IngresoApellido.getText();
                email=IngresoEmail.getText();
                direccion=IngresoDireccion.getText();
                telefono=Integer.parseInt(IngresoTelefono.getText());
                nEquipo=Integer.parseInt(IngresoEquipo_Miembro.getText());
                fechaNacimiento=IngresoFecha_Nacimiento.getText();
                try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                    MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                    MongoCollection<Document> collection = database.getCollection("Miembros");
                    Document documento = new Document("IDMiembro", cedula)
                            .append("Nombre", nombre)
                            .append("Apellido", apellido)
                            .append("Email", email)
                            .append("Direccion", direccion)
                            .append("Telefono", telefono)
                            .append("MiembroEquipo", nEquipo)
                            .append("FechaNacimiento", fechaNacimiento);
                    collection.insertOne(documento);
                    System.out.println("Miembro agregado con éxito");
                    JOptionPane.showMessageDialog(null, "Miembro agregado con éxito");
                }
            }
        });
    }
}
