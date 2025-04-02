import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScooterFrame extends JFrame {
    private JTextField txtModele;

    public ScooterFrame() {
        setTitle("Gérer les Scooters");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        
        JLabel lblModele = new JLabel("Modèle :");
        txtModele = new JTextField(20);

        
        JButton btnAjouterScooter = new JButton("Ajouter Scooter");

        
        add(lblModele);
        add(txtModele);
        add(btnAjouterScooter);

        
        btnAjouterScooter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String modele = txtModele.getText();
                if (!modele.isEmpty()) {
                    Modele m = new Modele(1, modele, 50);  // Créer un modèle de scooter avec ID auto-généré
                    Scooter scooter = new Scooter(1, m);  // Créer un scooter avec ID auto-généré
                    JOptionPane.showMessageDialog(null, "Scooter ajouté avec modèle : " + modele);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                }
            }
        });
    }
}
