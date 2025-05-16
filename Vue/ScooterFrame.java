package Vue;
import Model.*;   
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ScooterFrame extends JFrame {
    private JTextField txtModele;
    private JTextField txtPuissance;
    private JTextField txtTarifJournalier;
    private JButton btnAjouterScooter;
    private JButton btnAfficherDisponibles;
    private JButton btnCalculerChiffreAffaires;
    private ParcScooters parc; // Assuming Parc is a class that manages scooters
    private JCheckBox cbA, cbA1, cbB, cbAM;

    public ScooterFrame(ParcScooters parc) {
        this.parc = parc;
        setTitle("Gérer les Scooters");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel lblModele = new JLabel("Modèle :");
        txtModele = new JTextField(15);
        JLabel lblPuissance = new JLabel("Puissance :");
        txtPuissance = new JTextField(5);
        JLabel lblTarif = new JLabel("Tarif journalier (€) :");
        txtTarifJournalier = new JTextField(7);

        cbA = new JCheckBox("A");
        cbA1 = new JCheckBox("A1");
        cbB = new JCheckBox("B");
        cbAM = new JCheckBox("AM");

        JPanel panelForm = new JPanel(new FlowLayout());
        panelForm.add(lblModele);
        panelForm.add(txtModele);
        panelForm.add(lblPuissance);
        panelForm.add(txtPuissance);
        panelForm.add(lblTarif);
        panelForm.add(txtTarifJournalier);
        panelForm.add(new JLabel("Permis autorisés :"));
        JPanel panelPermis = new JPanel(new FlowLayout());
        panelPermis.add(cbA);
        panelPermis.add(cbA1);
        panelPermis.add(cbB);
        panelPermis.add(cbAM);
        panelForm.add(panelPermis);

        btnAjouterScooter = new JButton("Ajouter Scooter");
        btnAfficherDisponibles = new JButton("Afficher Scooters Disponibles");
        btnCalculerChiffreAffaires = new JButton("Calculer Chiffre d'Affaires");

        add(panelForm);
        add(btnAjouterScooter);
        add(btnAfficherDisponibles);
        add(btnCalculerChiffreAffaires);

        btnAfficherDisponibles.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Scooters disponibles :\n");
            for (Scooter scooter : parc.getScootersDisponibles()) {
                Modele modele = scooter.getModele();
                sb.append("- Scooter ID : ").append(scooter.getIdScooter())
                  .append(", Modèle : ").append(modele.getNomModele())
                  .append(", Puissance : ").append(modele.getPuissance())
                  .append(", Tarif journalier : ").append(modele.getTarifJournalier()).append(" €\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnCalculerChiffreAffaires.addActionListener(e -> {
            String modeleNom = txtModele.getText();
            Scooter scooter = parc.getListScooter().stream()
                    .filter(s -> s.getModele().getNomModele().equals(modeleNom))
                    .findFirst()
                    .orElse(null);

            if (scooter != null) {
                double chiffreAffaires = scooter.calculerChiffreAffaires();
                JOptionPane.showMessageDialog(this, "Chiffre d'affaires pour le scooter " + modeleNom + " : " + chiffreAffaires + " €");
            } else {
                JOptionPane.showMessageDialog(this, "Scooter introuvable.");
            }
        });
    }

    public JTextField getTxtModele() {
        return txtModele;
    }

    public JButton getBtnAjouterScooter() {
        return btnAjouterScooter;
    }
    public JTextField getTxtPuissance() { return txtPuissance; }
    public JTextField getTxtTarifJournalier() { return txtTarifJournalier; }
    public JCheckBox getCbA() { return cbA; }
    public JCheckBox getCbA1() { return cbA1; }
    public JCheckBox getCbB() { return cbB; }
    public JCheckBox getCbAM() { return cbAM; }

}