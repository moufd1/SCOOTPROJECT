package Vue;

import javax.swing.*;
import java.awt.*;

public class LocationFrame extends JFrame {
    private JTextField txtDateDebut, txtDateFin, txtNomClient, txtPrenomClient;
    private JComboBox<String> comboScooter;
    private JButton btnCreerLocation;

    public LocationFrame() {
        setTitle("Gérer les Locations");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel lblNomClient = new JLabel("Nom du Client :");
        txtNomClient = new JTextField(20);

        JLabel lblPrenomClient = new JLabel("Prénom du Client :");
        txtPrenomClient = new JTextField(20);

        JLabel lblDateDebut = new JLabel("Date de Début (AAAA-MM-JJ) :");
        txtDateDebut = new JTextField(10);

        JLabel lblDateFin = new JLabel("Date de Fin (AAAA-MM-JJ) :");
        txtDateFin = new JTextField(10);

        JLabel lblScooter = new JLabel("Scooter :");
        comboScooter = new JComboBox<>();

        btnCreerLocation = new JButton("Créer Location");

        add(lblNomClient);
        add(txtNomClient);
        add(lblPrenomClient);
        add(txtPrenomClient);
        add(lblDateDebut);
        add(txtDateDebut);
        add(lblDateFin);
        add(txtDateFin);
        add(lblScooter);
        add(comboScooter);
        add(btnCreerLocation);
    }


    public JTextField getTxtNomClient() {
        return txtNomClient;
    }

    public JTextField getTxtPrenomClient() {
        return txtPrenomClient;
    }

    public JTextField getTxtDateDebut() {
        return txtDateDebut;
    }

    public JTextField getTxtDateFin() {
        return txtDateFin;
    }

    public JComboBox<String> getComboScooter() {
        return comboScooter;
    }

    public JButton getBtnCreerLocation() {
        return btnCreerLocation;
    }
}