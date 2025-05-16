package Vue;
import Model.*;
import javax.swing.*;
import java.awt.*;

public class ClientFrame extends JFrame {
    private JTextField txtNom, txtPrenom;
    private JTextField txtNumPermis;
    private JTextField txtDateExp; // format : dd-MM-yyyy
    private JTextField txtPaysEmission;
    private JButton btnAjouterClient;
    private JButton btnAfficherHistorique, btnCalculerDepenses;
    private ParcScooters parc; // Référence au parc
    private JCheckBox cbA, cbA1, cbB, cbAM; // selon les types de permis possibles

    public ClientFrame(ParcScooters parc) {
        this.parc = parc; // Initialisation du parc

        setTitle("Gérer les Clients");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel lblNom = new JLabel("Nom :");
        txtNom = new JTextField(20);
        JLabel lblPrenom = new JLabel("Prénom :");
        txtPrenom = new JTextField(20);
        JLabel lblNumPermis = new JLabel("Numéro de permis :");
        txtNumPermis = new JTextField(10);
        JLabel lblDateExp = new JLabel("Date expiration (dd-MM-yyyy) :");
        txtDateExp = new JTextField(10);
        JLabel lblPaysEmission = new JLabel("Pays d'émission :");
        txtPaysEmission = new JTextField(5);

        btnAjouterClient = new JButton("Ajouter Client");
        btnAfficherHistorique = new JButton("Afficher Historique");
        btnCalculerDepenses = new JButton("Calculer Dépenses");

        cbA = new JCheckBox("A");
        cbA1 = new JCheckBox("A1");
        cbB = new JCheckBox("B");
        cbAM = new JCheckBox("AM");

        add(lblNom);
        add(txtNom);
        add(lblPrenom);
        add(txtPrenom);
        add(lblNumPermis);
        add(txtNumPermis);
        add(lblDateExp);
        add(txtDateExp);
        add(lblPaysEmission);
        add(txtPaysEmission);
        add(btnAjouterClient);
        add(btnAfficherHistorique);
        add(btnCalculerDepenses);
        add(cbA);
        add(cbA1);
        add(cbB);
        add(cbAM);

        // Action pour afficher l'historique des locations
        btnAfficherHistorique.addActionListener(e -> {
            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            Client client = parc.getListClient().stream()
                    .filter(c -> c.getNom().equals(nom) && c.getPrenom().equals(prenom))
                    .findFirst()
                    .orElse(null);

            if (client != null) {
                StringBuilder sb = new StringBuilder("Historique des locations pour " + nom + " " + prenom + " :\n");
                for (Location loc : client.getListLocation()) {
                    sb.append(loc).append("\n");
                }
                JOptionPane.showMessageDialog(this, sb.toString());
            } else {
                JOptionPane.showMessageDialog(this, "Client introuvable.");
            }
        });

        // Action pour calculer les dépenses d'un client
        btnCalculerDepenses.addActionListener(e -> {
            String nom = txtNom.getText();
            String prenom = txtPrenom.getText();
            Client client = parc.getListClient().stream()
                    .filter(c -> c.getNom().equals(nom) && c.getPrenom().equals(prenom))
                    .findFirst()
                    .orElse(null);

            if (client != null) {
                double depenseTotale = client.calculerDepenseTotale();
                JOptionPane.showMessageDialog(this, "Dépense totale pour " + nom + " " + prenom + " : " + depenseTotale + " €");
            } else {
                JOptionPane.showMessageDialog(this, "Client introuvable.");
            }
        });
    }

    // Getters for controller access
    public JTextField getTxtNom() {
        return txtNom;
    }

    public JTextField getTxtPrenom() {
        return txtPrenom;
    }

    public JTextField getTxtNumPermis() {
        return txtNumPermis;
    }

    public JTextField getTxtDateExp() {
        return txtDateExp;
    }

    public JTextField getTxtPaysEmission() {
        return txtPaysEmission;
    }

    public JButton getBtnAjouterClient() {
        return btnAjouterClient;
    }

    public JButton getBtnAfficherHistorique() {
        return btnAfficherHistorique;
    }

    public JButton getBtnCalculerDepenses() {
        return btnCalculerDepenses;
    }

    public JCheckBox getCbA() {
        return cbA;
    }

    public JCheckBox getCbA1() {
        return cbA1;
    }

    public JCheckBox getCbB() {
        return cbB;
    }

    public JCheckBox getCbAM() {
        return cbAM;
    }
}