package Vue;
import Model.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ScooterFrame extends JFrame {
    private JTextField txtModele, txtPuissance, txtTarifJournalier;
    private JCheckBox cbA, cbA1, cbB, cbAM;
    private JButton btnAjouterScooter;
    private JTable tableScooters;
    private DefaultTableModel tableModel;
    private ParcScooters parc;

    public ScooterFrame(ParcScooters parc) {
        this.parc = parc;
        setTitle("Gestion des Scooters");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 10));
        getContentPane().setBackground(new Color(245, 245, 245));

        // ---- Panel Formulaire (gauche) ----
        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(new TitledBorder("Nouveau scooter"));
        panelForm.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Ligne 1 : Modèle
        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Modèle :"), gbc);
        gbc.gridx = 1;
        txtModele = new JTextField(14);
        panelForm.add(txtModele, gbc);

        // Ligne 2 : Puissance
        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Puissance (cc) :"), gbc);
        gbc.gridx = 1;
        txtPuissance = new JTextField(14);
        panelForm.add(txtPuissance, gbc);

        // Ligne 3 : Tarif journalier
        gbc.gridx = 0; gbc.gridy = 2;
        panelForm.add(new JLabel("Tarif journalier (€) :"), gbc);
        gbc.gridx = 1;
        txtTarifJournalier = new JTextField(14);
        panelForm.add(txtTarifJournalier, gbc);

        // Ligne 4 : Permis autorisés
        gbc.gridx = 0; gbc.gridy = 3;
        panelForm.add(new JLabel("Permis autorisés :"), gbc);
        gbc.gridx = 1;
        JPanel panelPermis = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cbA = new JCheckBox("A");
        cbA1 = new JCheckBox("A1");
        cbB = new JCheckBox("B");
        cbAM = new JCheckBox("AM");
        panelPermis.add(cbA); panelPermis.add(cbA1); panelPermis.add(cbB); panelPermis.add(cbAM);
        panelPermis.setBackground(Color.WHITE);
        panelForm.add(panelPermis, gbc);

        // Ligne 5 : Bouton
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnAjouterScooter = new JButton("Ajouter Scooter");
        btnAjouterScooter.setBackground(new Color(0, 120, 215));
        btnAjouterScooter.setForeground(Color.WHITE);
        btnAjouterScooter.setFocusPainted(false);
        btnAjouterScooter.setToolTipText("Ajouter ce scooter au parc");
        panelForm.add(btnAjouterScooter, gbc);

        // ---- Panel Liste Scooters (droite) ----
        tableModel = new DefaultTableModel(new String[]{"ID", "Modèle", "Puissance", "Tarif", "Permis autorisés", "Disponible"}, 0);
        tableScooters = new JTable(tableModel) {
            public Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? new Color(245, 250, 255) : Color.WHITE);
                else
                    c.setBackground(new Color(184, 207, 229));
                return c;
            }
        };
        tableScooters.setRowHeight(22);
        tableScooters.setSelectionBackground(new Color(184, 207, 229));
        tableScooters.getTableHeader().setBackground(new Color(220, 220, 220));
        tableScooters.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(tableScooters);
        scrollPane.setBorder(new TitledBorder("Liste des scooters"));

        // ---- Ajout panels à la fenêtre ----
        add(panelForm, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
        rafraichirTableauScooters();
    }

    // Getters pour le contrôleur
    public JTextField getTxtModele() { return txtModele; }
    public JTextField getTxtPuissance() { return txtPuissance; }
    public JTextField getTxtTarifJournalier() { return txtTarifJournalier; }
    public JCheckBox getCbA() { return cbA; }
    public JCheckBox getCbA1() { return cbA1; }
    public JCheckBox getCbB() { return cbB; }
    public JCheckBox getCbAM() { return cbAM; }
    public JButton getBtnAjouterScooter() { return btnAjouterScooter; }
    public JTable getTableScooters() { return tableScooters; }
    public DefaultTableModel getTableModel() { return tableModel; }

    public void rafraichirTableauScooters() {
        tableModel.setRowCount(0);
        for (Scooter s : parc.getListScooter()) {
            Modele m = s.getModele();
            StringBuilder permis = new StringBuilder();
            if (m != null && m.getListPermis() != null) {
                for (TypePermis tp : m.getListPermis()) {
                    permis.append(tp.getType()).append(" ");
                }
            }
            tableModel.addRow(new Object[]{
                s.getIdScooter(),
                (m != null ? m.getNomModele() : ""),
                (m != null ? m.getPuissance() : ""),
                (m != null ? m.getTarifJournalier() : ""),
                permis.toString().trim(),
                s.estDisponible() ? "Oui" : "Non"
            });
        }
    }
}