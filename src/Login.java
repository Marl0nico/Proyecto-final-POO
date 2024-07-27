import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.mongodb.client.model.Filters;
import org.bson.Document;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;
public class Login {
    //private JButton IniciarSesion;
    private JComboBox SeleccionUsuario;
    public JPanel PanelLogin;
    private JTextField IngresarUsuario;
    private JButton IngresoSistema;
    private JLabel Usuario;
    private JLabel Clave;
    private JLabel TituloLogin;
    private JLabel TipoUsuario;
    private JPasswordField IngresoClave;
    private JLabel ImagenLogin;
    private JLabel ErrorIngreso;
    public Login() {
        IngresoSistema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String seleccionUsuario = null;
                if (SeleccionUsuario.getSelectedItem() != null) {
                    seleccionUsuario = (String) SeleccionUsuario.getSelectedItem();
                    if ("Líder del equipo".equals(seleccionUsuario)) {
                        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
                            MongoDatabase database = mongoClient.getDatabase("BD_TaskFlow");
                            String usuario = IngresarUsuario.getText();
                            String clave = IngresoClave.getText();
                            MongoCollection<Document> collection = database.getCollection("Lideres");
                            Document query = new Document("Usuario", usuario);
                            FindIterable<Document> documentos = collection.find(query);
                            System.out.println("Conexión exitosa");
                            boolean ingreso = false;
                            // Iterar sobre los documentos encontrados
                            for (Document documento : documentos) {
                                String usuarioBD = documento.getString("Usuario");
                                String claveBD = String.valueOf(documento.get("Clave"));
                                // Verificar si el usuario y la contraseña coinciden
                                if (usuario.equals(usuarioBD) && (clave.equals(claveBD))) {
                                    JFrame frame2 = new JFrame("Menú Líder");
                                    frame2.setContentPane(new Lider().PanelLider);
                                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    frame2.setSize(800, 600);
                                    frame2.pack();
                                    frame2.setVisible(true);
                                    ((JFrame) SwingUtilities.getWindowAncestor(IngresoSistema)).dispose();
                                    ingreso = true;
                                    break;
                                } else{
                                    JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
                                }
                            }
                        }
                        catch (Exception e1) {
                            e1.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
                        }
                    } else if ("Miembro del equipo".equals(seleccionUsuario)) {
                        JFrame frame3 = new JFrame("Menú Miembros");
                        frame3.setContentPane(new Miembros().PanelMiembros);
                        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame3.setSize(800, 600);
                        frame3.pack();
                        frame3.setVisible(true);
                        ((JFrame) SwingUtilities.getWindowAncestor(IngresoSistema)).dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no válido.");
                    }
                }
            }
        });
    }
}
