package Vue;

import Controlleur.ClientController;
import Controlleur.LocationController;
import Controlleur.ScooterController;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ParcScooters parc;

    public MainFrame() {
        parc = new ParcScooters(1, "Parc Principal");
        setTitle("Gestion de Location de Scooters");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 16));
        UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 15));
        UIManager.put("ComboBox.font", new Font("Segoe UI", Font.PLAIN, 15));
        UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 15));

        setLayout(new BorderLayout());

        JPanel panelHeader = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelHeader.setBackground(new Color(0, 120, 215));
        JLabel lblTitre = new JLabel("Gestion de Location de Scooters");
        lblTitre.setForeground(Color.WHITE);
        lblTitre.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panelHeader.add(lblTitre);
        add(panelHeader, BorderLayout.NORTH);


        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        panelMenu.setBackground(new Color(245, 250, 255));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(30, 20, 30, 20));

        JButton btnClient = new JButton("Clients");
        btnClient.setToolTipText("Gérer les clients");
        stylizeButton(btnClient);

        JButton btnScooter = new JButton("Scooters");
        btnScooter.setToolTipText("Gérer les scooters");
        stylizeButton(btnScooter);

        JButton btnLocation = new JButton("Locations");
        btnLocation.setToolTipText("Gérer les locations");
        stylizeButton(btnLocation);

        panelMenu.add(btnClient);
        panelMenu.add(Box.createVerticalStrut(20));
        panelMenu.add(btnScooter);
        panelMenu.add(Box.createVerticalStrut(20));
        panelMenu.add(btnLocation);

        panelMenu.add(Box.createVerticalStrut(40));
        JSeparator sep = new JSeparator();
        sep.setMaximumSize(new Dimension(180, 2));
        panelMenu.add(sep);

        JButton btnChiffreAffaires = new JButton("Chiffre d'Affaires");
        btnChiffreAffaires.setToolTipText("Afficher le chiffre d'affaires du parc");
        stylizeButton(btnChiffreAffaires);

        JButton btnDepensesClients = new JButton("Dépenses Clients");
        btnDepensesClients.setToolTipText("Afficher les dépenses des clients");
        stylizeButton(btnDepensesClients);

        JButton btnScootersDisponibles = new JButton("Scooters Disponibles");
        btnScootersDisponibles.setToolTipText("Voir les scooters disponibles");
        stylizeButton(btnScootersDisponibles);

        panelMenu.add(Box.createVerticalStrut(20));
        panelMenu.add(btnChiffreAffaires);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(btnDepensesClients);
        panelMenu.add(Box.createVerticalStrut(10));
        panelMenu.add(btnScootersDisponibles);

        add(panelMenu, BorderLayout.WEST);

        JPanel panelCentre = new JPanel();
        panelCentre.setBackground(Color.WHITE);
        JLabel lblSlogan = new JLabel("Bienvenue dans votre espace de gestion !");
        lblSlogan.setFont(new Font("Segoe UI", Font.ITALIC, 20));
        lblSlogan.setForeground(new Color(0, 120, 215));
        panelCentre.setLayout(new BoxLayout(panelCentre, BoxLayout.Y_AXIS));
        lblSlogan.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCentre.add(Box.createVerticalGlue());
        panelCentre.add(Box.createVerticalStrut(20));
        panelCentre.add(lblSlogan);
        panelCentre.add(Box.createVerticalGlue());
        add(panelCentre, BorderLayout.CENTER);

        btnClient.addActionListener(e -> {
            ClientFrame clientFrame = new ClientFrame(parc);
            new ClientController(clientFrame, parc);
            clientFrame.setVisible(true);
        });

        btnScooter.addActionListener(e -> {
            ScooterFrame scooterFrame = new ScooterFrame(parc);
            new ScooterController(scooterFrame, parc);
            scooterFrame.setVisible(true);
        });

        btnLocation.addActionListener(e -> {
            LocationFrame locationFrame = new LocationFrame(parc);
            new LocationController(locationFrame, parc);
            locationFrame.setVisible(true);
        });

        btnChiffreAffaires.addActionListener(e -> {
            double chiffreAffaires = parc.calculerChiffreAffaires();
            JOptionPane.showMessageDialog(this, "Chiffre d'affaires du parc : " + chiffreAffaires + " €");
        });

        btnDepensesClients.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Dépenses totales des clients :\n");
            for (Client client : parc.getListClient()) {
                double depenseTotale = client.calculerDepenseTotale();
                sb.append("- Client : ").append(client.getNom()).append(" ").append(client.getPrenom())
                  .append(", Dépense totale : ").append(depenseTotale).append(" €\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnScootersDisponibles.addActionListener(e -> {
            StringBuilder sb = new StringBuilder("Scooters disponibles :\n");
            for (Scooter scooter : parc.getScootersDisponibles()) {
                sb.append("- Scooter ID : ").append(scooter.getIdScooter())
                  .append(", Modèle : ").append(scooter.getModele().getNomModele()).append("\n");
            }
            JOptionPane.showMessageDialog(this, sb.toString());
        });
    }

    private void stylizeButton(JButton btn) {
        btn.setFocusPainted(false);
        btn.setBackground(new Color(240, 245, 255));
        btn.setForeground(new Color(0, 70, 140));
        btn.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 120, 215), 1),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
        ));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setIconTextGap(10);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}