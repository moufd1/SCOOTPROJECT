package Controlleur;
import Model.*;
import Vue.*;
import Vue.ClientFrame;
import javax.swing.*;
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

        if (!nom.isEmpty() && !prenom.isEmpty()) {
            Permis permis = null; 
            Client client = new Client(parc.getListClient().size() + 1, nom, prenom, permis);
            parc.addClient(client);
            JOptionPane.showMessageDialog(view, "Client ajouté : " + nom + " " + prenom);
            view.getTxtNom().setText("");
            view.getTxtPrenom().setText("");
        } else {
            JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs.");
        }
    }
}