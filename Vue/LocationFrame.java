package Vue;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import Model.*;

public class LocationFrame extends JFrame {
    private JTextField txtDateDebut, txtDateFin;
    private JComboBox<String> comboScooter, comboClient;
    private JButton btnCreerLocation, btnRetour;
    private JTable tableLocations;
    private DefaultTableModel tableModel;
    private ParcScooters parc;

    public LocationFrame(ParcScooters parc) {
        this.parc = parc;
        setTitle("Gérer les Locations");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 14));
        UIManager.put("ComboBox.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 13));
        UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 14));

        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 245, 245));


        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridBagLayout());
        panelForm.setBorder(new TitledBorder("Nouvelle location"));
        panelForm.setBackground(new Color(255, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Client :"), gbc);
        gbc.gridx = 1;
        comboClient = new JComboBox<>();
        comboClient.setPreferredSize(new Dimension(200, 25));
        panelForm.add(comboClient, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Date de Début (dd-MM-yyyy) :"), gbc);
        gbc.gridx = 1;
        txtDateDebut = new JTextField(12);
        panelForm.add(txtDateDebut, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelForm.add(new JLabel("Date de Fin (dd-MM-yyyy) :"), gbc);
        gbc.gridx = 1;
        txtDateFin = new JTextField(12);
        panelForm.add(txtDateFin, gbc);


        gbc.gridx = 0; gbc.gridy = 3;
        panelForm.add(new JLabel("Scooter :"), gbc);
        gbc.gridx = 1;
        comboScooter = new JComboBox<>();
        comboScooter.setPreferredSize(new Dimension(200, 25));
        panelForm.add(comboScooter, gbc);

        add(panelForm, BorderLayout.NORTH);

        tableModel = new DefaultTableModel(new String[]{"ID", "Client", "Scooter", "Début", "Fin", "Pénalité"}, 0);
        tableLocations = new JTable(tableModel) {

            public Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? new Color(245, 250, 255) : Color.WHITE);
                else
                    c.setBackground(new Color(184, 207, 229));
                return c;
            }
        };
        tableLocations.setRowHeight(24);
        tableLocations.setSelectionBackground(new Color(184, 207, 229));
        tableLocations.getTableHeader().setBackground(new Color(220, 220, 220));
        tableLocations.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(tableLocations);
        scrollPane.setBorder(new TitledBorder("Historique des locations"));
        add(scrollPane, BorderLayout.CENTER);

        rafraichirTableauLocations();


        btnCreerLocation = new JButton("Créer Location");
        btnCreerLocation.setToolTipText("Créer une nouvelle location");
        btnRetour = new JButton("Retour");
        btnRetour.setToolTipText("Clôturer la location sélectionnée");
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelButtons.setBackground(new Color(245, 245, 245));
        panelButtons.add(btnCreerLocation);
        panelButtons.add(btnRetour);
        add(panelButtons, BorderLayout.SOUTH);
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
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
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