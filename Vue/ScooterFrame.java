package Vue;

import javax.swing.*;
import java.awt.*;

public class ScooterFrame extends JFrame {
    private JTextField txtModele;
    private JButton btnAjouterScooter;

    public ScooterFrame() {
        setTitle("Gérer les Scooters");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JLabel lblModele = new JLabel("Modèle :");
        txtModele = new JTextField(20);

        btnAjouterScooter = new JButton("Ajouter Scooter");

        add(lblModele);
        add(txtModele);
        add(btnAjouterScooter);
    }

    // Getters for controller access
    public JTextField getTxtModele() {
        return txtModele;
    }

    public JButton getBtnAjouterScooter() {
        return btnAjouterScooter;
    }
}