import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {
    private JTextField txtNom, txtPrenom;

    public ClientFrame() {
        setTitle("Gérer les Clients");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        
        JLabel lblNom = new JLabel("Nom :");
        txtNom = new JTextField(20);
        JLabel lblPrenom = new JLabel("Prénom :");
        txtPrenom = new JTextField(20);

        
        JButton btnAjouterClient = new JButton("Ajouter Client");

        
        add(lblNom);
        add(txtNom);
        add(lblPrenom);
        add(txtPrenom);
        add(btnAjouterClient);

        
    }
}
