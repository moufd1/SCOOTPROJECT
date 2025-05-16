package Controlleur;
import Model.*;
import Vue.*;
import Vue.ClientFrame;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientController {
    private ClientFrame view;
    private ParcScooters parc; 

    public ClientController(ClientFrame view, ParcScooters parc) {
        this.view = view;
        this.parc = parc;
        initController();
    }

    private void initController() {
        view.getBtnAjouterClient().addActionListener(e -> ajouterClient());
    }

    private void ajouterClient() {
        String nom = view.getTxtNom().getText();
        String prenom = view.getTxtPrenom().getText();
        String numPermisStr = view.getTxtNumPermis().getText();
        String dateExpStr = view.getTxtDateExp().getText();
        String paysEmission = view.getTxtPaysEmission().getText();

        if (!nom.isEmpty() && !prenom.isEmpty() && !numPermisStr.isEmpty() && !dateExpStr.isEmpty() && !paysEmission.isEmpty()) {
            try {
                int numPermis = Integer.parseInt(numPermisStr);
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                Date dateExp = sdf.parse(dateExpStr);

                Permis permis = new Permis(numPermis, dateExp, paysEmission);
                if (view.getCbA().isSelected())   permis.addTypePermis(new TypePermis("A"));
                if (view.getCbA1().isSelected())  permis.addTypePermis(new TypePermis("A1"));
                if (view.getCbB().isSelected())   permis.addTypePermis(new TypePermis("B"));
                if (view.getCbAM().isSelected())  permis.addTypePermis(new TypePermis("AM"));

                Client client = new Client(parc.getListClient().size() + 1, nom, prenom, permis);
                parc.addClient(client);
                JOptionPane.showMessageDialog(view, "Client ajouté : " + nom + " " + prenom);
                view.getTxtNom().setText("");
                view.getTxtPrenom().setText("");
                view.getTxtNumPermis().setText("");
                view.getTxtDateExp().setText("");
                view.getTxtPaysEmission().setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(view, "Erreur dans la saisie du permis : " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs.");
        }
    }
}