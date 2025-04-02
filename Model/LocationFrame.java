import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class LocationFrame extends JFrame {
    private JTextField txtDateDebut, txtDateFin;

    public LocationFrame() {
        setTitle("Gérer les Locations");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        
        JLabel lblDateDebut = new JLabel("Date de Début (AAAA-MM-JJ) :");
        txtDateDebut = new JTextField(10);
        JLabel lblDateFin = new JLabel("Date de Fin (AAAA-MM-JJ) :");
        txtDateFin = new JTextField(10);

        
        JButton btnCreerLocation = new JButton("Créer Location");

        
        add(lblDateDebut);
        add(txtDateDebut);
        add(lblDateFin);
        add(txtDateFin);
        add(btnCreerLocation);

        
        btnCreerLocation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dateDebutStr = txtDateDebut.getText();
                String dateFinStr = txtDateFin.getText();
                if (!dateDebutStr.isEmpty() && !dateFinStr.isEmpty()) {
                    try {
                        Date dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutStr);
                        Date dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFinStr);
                        
                        Location location = new Location(1, dateDebut, dateFin, new Client(1, "John", "Doe"));
                        JOptionPane.showMessageDialog(null, "Location créée du " + dateDebut + " au " + dateFin);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de format de date.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.");
                }
            }
        });
    }
}
