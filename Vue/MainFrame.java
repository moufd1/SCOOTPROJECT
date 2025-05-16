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
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFichier = new JMenu("Fichier");
        JMenuItem itemOuvrir = new JMenuItem("Ouvrir");
        JMenuItem itemQuitter = new JMenuItem("Quitter");

        menuFichier.add(itemOuvrir);
        menuFichier.addSeparator();
        menuFichier.add(itemQuitter);
        menuBar.add(menuFichier);
        setJMenuBar(menuBar);

        itemOuvrir.addActionListener(e -> JOptionPane.showMessageDialog(null, "Fonction Ouvrir activée."));
        itemQuitter.addActionListener(e -> System.exit(0));

        JButton btnClient = new JButton("Gérer les Clients");
        JButton btnScooter = new JButton("Gérer les Scooters");
        JButton btnLocation = new JButton("Gérer les Locations");
        JButton btnChiffreAffaires = new JButton("Afficher Chiffre d'Affaires");
        JButton btnDepensesClients = new JButton("Afficher Dépenses des Clients");
        JButton btnScootersDisponibles = new JButton("Scooters Disponibles");

        add(btnClient);
        add(btnScooter);
        add(btnLocation);
        add(btnChiffreAffaires);
        add(btnDepensesClients);
        add(btnScootersDisponibles);

        btnClient.addActionListener(e -> {
            ClientFrame clientFrame = new ClientFrame(parc); // Passez l'objet parc
            new ClientController(clientFrame, parc);
            clientFrame.setVisible(true);
        });

        btnScooter.addActionListener(e -> {
            ScooterFrame scooterFrame = new ScooterFrame(parc); // Passez l'objet parc
            new ScooterController(scooterFrame, parc);
            scooterFrame.setVisible(true);
        });

        btnLocation.addActionListener(e -> {
            LocationFrame locationFrame = new LocationFrame(parc);
            LocationController controller = new LocationController(locationFrame, parc);
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}