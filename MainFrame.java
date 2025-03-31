import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    
    public MainFrame() {
        
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

        
        itemOuvrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Fonction Ouvrir activée.");
            }
        });

        itemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);  
            }
        });

        
        JButton btnClient = new JButton("Gérer les Clients");
        JButton btnScooter = new JButton("Gérer les Scooters");
        JButton btnLocation = new JButton("Gérer les Locations");

       
        add(btnClient);
        add(btnScooter);
        add(btnLocation);

        
        btnClient.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ClientFrame().setVisible(true);
            }
        });

        
        btnScooter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ScooterFrame().setVisible(true);
            }
        });

        
        btnLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LocationFrame().setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
