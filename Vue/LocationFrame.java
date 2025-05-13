package Vue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import Model.*;

public class LocationFrame extends JFrame {
    private JTextField txtDateDebut, txtDateFin, txtNomClient, txtPrenomClient;
    private JComboBox<String> comboScooter;
    private JButton btnCreerLocation;
    private JTable tableLocations;
    private DefaultTableModel tableModel;
    private ParcScooters parc; // Référence au parc

    public LocationFrame(ParcScooters parc) {
        this.parc = parc; // Initialisation du parc

        setTitle("Gérer les Locations");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Haut : Formulaire pour ajouter une location
        JPanel panelForm = new JPanel(new GridLayout(5, 2));
        JLabel lblNomClient = new JLabel("Nom du Client :");
        txtNomClient = new JTextField(20);
        JLabel lblPrenomClient = new JLabel("Prénom du Client :");
        txtPrenomClient = new JTextField(20);
        JLabel lblDateDebut = new JLabel("Date de Début (dd-MM-yyyy) :");
        txtDateDebut = new JTextField(10);
        JLabel lblDateFin = new JLabel("Date de Fin (dd-MM-yyyy) :");
        txtDateFin = new JTextField(10);
        JLabel lblScooter = new JLabel("Scooter :");
        comboScooter = new JComboBox<>();

        panelForm.add(lblNomClient);
        panelForm.add(txtNomClient);
        panelForm.add(lblPrenomClient);
        panelForm.add(txtPrenomClient);
        panelForm.add(lblDateDebut);
        panelForm.add(txtDateDebut);
        panelForm.add(lblDateFin);
        panelForm.add(txtDateFin);
        panelForm.add(lblScooter);
        panelForm.add(comboScooter);

        add(panelForm, BorderLayout.NORTH);

        // Centre : Tableau pour afficher les locations
        tableModel = new DefaultTableModel(new String[]{"ID", "Client", "Scooter", "Début", "Fin"}, 0);
        tableLocations = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableLocations);
        add(scrollPane, BorderLayout.CENTER);

        // Bas : Bouton pour créer une location
        btnCreerLocation = new JButton("Créer Location");
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnCreerLocation);
        add(panelButtons, BorderLayout.SOUTH);

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

public void rafraichirTableauLocations() {
    tableModel.setRowCount(0); // Vide le tableau
    for (Location loc : parc.getListLocation()) {
        tableModel.addRow(new Object[]{
            loc.getIdLocation(),
            loc.getClient().getNom() + " " + loc.getClient().getPrenom(),
            loc.getScooter().getModele().getNomModele(),
            new SimpleDateFormat("dd-MM-yyyy").format(loc.getDateDebut()),
            new SimpleDateFormat("dd-MM-yyyy").format(loc.getDateFin())
        });
    }
}
}