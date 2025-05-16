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
    private JComboBox<String> comboClient;
    private JButton btnRetour;

    public LocationFrame(ParcScooters parc) {
        this.parc = parc; // Initialisation du parc

        setTitle("Gérer les Locations");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Haut : Formulaire pour ajouter une location
        JPanel panelForm = new JPanel(new GridLayout(6, 2));
        JLabel lblDateDebut = new JLabel("Date de Début (dd-MM-yyyy) :");
        txtDateDebut = new JTextField(10);
        JLabel lblDateFin = new JLabel("Date de Fin (dd-MM-yyyy) :");
        txtDateFin = new JTextField(10);
        JLabel lblScooter = new JLabel("Scooter :");
        comboScooter = new JComboBox<>();
        JLabel lblClient = new JLabel("Client :");
        comboClient = new JComboBox<>();
        
        
        panelForm.add(lblClient);
        panelForm.add(comboClient);
        panelForm.add(lblDateDebut);
        panelForm.add(txtDateDebut);
        panelForm.add(lblDateFin);
        panelForm.add(txtDateFin);
        panelForm.add(lblScooter);
        panelForm.add(comboScooter);

        

        add(panelForm, BorderLayout.NORTH);

        // Centre : Tableau pour afficher les locations
        tableModel = new DefaultTableModel(new String[]{"ID", "Client", "Scooter", "Début", "Fin", "Pénalité"}, 0);
        tableLocations = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableLocations);
        add(scrollPane, BorderLayout.CENTER);

        // Bas : Boutons pour créer/clôturer une location
        btnCreerLocation = new JButton("Créer Location");
        btnRetour = new JButton("Retour");
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnCreerLocation);
        panelButtons.add(btnRetour); // Ajoute ici, à côté de Créer Location
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

    public JComboBox<String> getComboClient() {
        return comboClient;
    }

    public JButton getBtnRetour() {
        return btnRetour;
    }

    public JTable getTableLocations() {
        return tableLocations;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

public void rafraichirTableauLocations() {
    tableModel.setRowCount(0);
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    for (Location loc : parc.getListLocation()) {
        String penaliteStr = (loc.getRetour() != null) ? String.valueOf(loc.calculerPenalite()) : "";
        tableModel.addRow(new Object[]{
            loc.getIdLocation(),
            loc.getClient().getNom() + " " + loc.getClient().getPrenom(),
            loc.getScooter().getModele().getNomModele(),
            sdf.format(loc.getDateDebut()),
            sdf.format(loc.getDateFin()),
            penaliteStr
        });
    }
}
}