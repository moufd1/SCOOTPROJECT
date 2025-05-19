package Vue;
import Model.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class ClientFrame extends JFrame {
    private JTextField txtNom, txtPrenom, txtNumPermis, txtDateExp, txtPaysEmission;
    private JCheckBox cbA, cbA1, cbA2, cbAM;
    private JButton btnAjouterClient;
    private JTable tableClients;
    private DefaultTableModel tableModel;
    private ParcScooters parc;

    public ClientFrame(ParcScooters parc) {
        this.parc = parc;
        setTitle("Gestion des Clients");
        setSize(900, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(15, 10));
        getContentPane().setBackground(new Color(245, 245, 245));

        JPanel panelForm = new JPanel(new GridBagLayout());
        panelForm.setBorder(new TitledBorder("Nouveau client"));
        panelForm.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        panelForm.add(new JLabel("Nom :"), gbc);
        gbc.gridx = 1;
        txtNom = new JTextField(14);
        panelForm.add(txtNom, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelForm.add(new JLabel("Prénom :"), gbc);
        gbc.gridx = 1;
        txtPrenom = new JTextField(14);
        panelForm.add(txtPrenom, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panelForm.add(new JLabel("Numéro de permis :"), gbc);
        gbc.gridx = 1;
        txtNumPermis = new JTextField(14);
        panelForm.add(txtNumPermis, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        panelForm.add(new JLabel("Date expiration (dd-MM-yyyy) :"), gbc);
        gbc.gridx = 1;
        txtDateExp = new JTextField(14);
        panelForm.add(txtDateExp, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        panelForm.add(new JLabel("Pays d'émission :"), gbc);
        gbc.gridx = 1;
        txtPaysEmission = new JTextField(14);
        panelForm.add(txtPaysEmission, gbc);


        gbc.gridx = 0; gbc.gridy = 5;
        panelForm.add(new JLabel("Types de permis :"), gbc);
        gbc.gridx = 1;
        JPanel panelPermis = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        cbA = new JCheckBox("A");
        cbA1 = new JCheckBox("A1");
        cbA2 = new JCheckBox("A2");
        cbAM = new JCheckBox("AM");
        panelPermis.add(cbA); panelPermis.add(cbA1); panelPermis.add(cbA2); panelPermis.add(cbAM);
        panelPermis.setBackground(Color.WHITE);
        panelForm.add(panelPermis, gbc);

        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        btnAjouterClient = new JButton("Ajouter Client");
        btnAjouterClient.setBackground(new Color(0, 120, 215));
        btnAjouterClient.setForeground(Color.WHITE);
        btnAjouterClient.setFocusPainted(false);
        btnAjouterClient.setToolTipText("Ajouter ce client à la liste");
        panelForm.add(btnAjouterClient, gbc);

        tableModel = new DefaultTableModel(new String[]{"Nom", "Prénom", "Permis", "Expiration", "Pays", "Types"}, 0);
        tableClients = new JTable(tableModel) {
            public Component prepareRenderer(javax.swing.table.TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? new Color(245, 250, 255) : Color.WHITE);
                else
                    c.setBackground(new Color(184, 207, 229));
                return c;
            }
        };
        tableClients.setRowHeight(22);
        tableClients.setSelectionBackground(new Color(184, 207, 229));
        tableClients.getTableHeader().setBackground(new Color(220, 220, 220));
        tableClients.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        JScrollPane scrollPane = new JScrollPane(tableClients);
        scrollPane.setBorder(new TitledBorder("Liste des clients"));

        add(panelForm, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);

        rafraichirTableauClients();
    }

    public void rafraichirTableauClients() {
        tableModel.setRowCount(0);
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        for (Client c : parc.getListClient()) {
            String types = "";
            if (c.getPermis() != null && c.getPermis().getListTypePermis() != null) {
                Vector<TypePermis> list = c.getPermis().getListTypePermis();
                for (TypePermis tp : list) types += tp.getType() + " ";
            }
            tableModel.addRow(new Object[]{
                c.getNom(), c.getPrenom(),
                (c.getPermis() != null ? c.getPermis().getNumPermis() : ""),
                (c.getPermis() != null ? sdf.format(c.getPermis().getDateExp()) : ""),
                (c.getPermis() != null ? c.getPermis().getPaysEmission() : ""),
                types.trim()
            });
        }
    }


    public JTextField getTxtNom() { return txtNom; }
    public JTextField getTxtPrenom() { return txtPrenom; }
    public JTextField getTxtNumPermis() { return txtNumPermis; }
    public JTextField getTxtDateExp() { return txtDateExp; }
    public JTextField getTxtPaysEmission() { return txtPaysEmission; }
    public JCheckBox getCbA() { return cbA; }
    public JCheckBox getCbA1() { return cbA1; }
    public JCheckBox getCbA2() { return cbA2; }
    public JCheckBox getCbAM() { return cbAM; }
    public JButton getBtnAjouterClient() { return btnAjouterClient; }
    public JTable getTableClients() { return tableClients; }
    public DefaultTableModel getTableModel() { return tableModel; }
}