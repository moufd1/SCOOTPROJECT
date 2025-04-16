import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LocationFrame extends JFrame {
    private JTextField txtDateDebut, txtDateFin, txtNomClient;
    private JComboBox<String> comboScooter;

    public LocationFrame() {
        setTitle("Gérer les Locations");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel lblNomClient = new JLabel("Nom du Client :");
        txtNomClient = new JTextField(20);

        JLabel lblPrenomClient = new JLabel("Prénom du Client :");
        JTextField txtPrenomClient = new JTextField(20);

        JLabel lblDateDebut = new JLabel("Date de Début (AAAA-MM-JJ) :");
        txtDateDebut = new JTextField(10);

        JLabel lblDateFin = new JLabel("Date de Fin (AAAA-MM-JJ) :");
        txtDateFin = new JTextField(10);

        JLabel lblScooter = new JLabel("Scooter :");
        comboScooter = new JComboBox<>(new String[]{"Scooter 1", "Scooter 2"}); 

        JButton btnCreerLocation = new JButton("Créer Location");

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

        btnCreerLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomClient = txtNomClient.getText();
                String prenomClient = txtPrenomClient.getText();
                String dateDebutStr = txtDateDebut.getText();
                String dateFinStr = txtDateFin.getText();
                String scooterSelectionne = (String) comboScooter.getSelectedItem();

                if (!nomClient.isEmpty() && !dateDebutStr.isEmpty() && !dateFinStr.isEmpty() && scooterSelectionne != null) {
                    try {
                        Date dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutStr);
                        Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinStr);

                        Client client = new Client(1, nomClient, prenomClient, null); 
                        Scooter scooter = new Scooter(1, new Modele(1, scooterSelectionne, 125), null); 

                        Location location = new Location(1, dateDebut, dateFin, client, scooter, null);

                        JOptionPane.showMessageDialog(null, "Location créée pour le client " + nomClient + " avec le scooter " + scooterSelectionne);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erreur : " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                }
            }
        });
    }
}
