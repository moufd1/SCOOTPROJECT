package Vue;

import Controlleur.ClientController;
import Controlleur.LocationController;
import Controlleur.ScooterController;
import Model.ParcScooters;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ParcScooters parc;

    public MainFrame() {
        parc = new ParcScooters(1, "Parc Principal"); // Initialize the model

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

        add(btnClient);
        add(btnScooter);
        add(btnLocation);

        btnClient.addActionListener(e -> {
            ClientFrame clientFrame = new ClientFrame();
            new ClientController(clientFrame, parc);
            clientFrame.setVisible(true);
        });

        btnScooter.addActionListener(e -> {
            ScooterFrame scooterFrame = new ScooterFrame();
            new ScooterController(scooterFrame, parc);
            scooterFrame.setVisible(true);
        });

        btnLocation.addActionListener(e -> {
            LocationFrame locationFrame = new LocationFrame();
            new LocationController(locationFrame, parc);
            locationFrame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame().setVisible(true));
    }
}