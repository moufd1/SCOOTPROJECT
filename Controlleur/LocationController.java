package Controlleur;
import javax.swing.*;
import Model.*;
import Vue.LocationFrame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class LocationController {
    private LocationFrame view;
    private ParcScooters parc;

    public LocationController(LocationFrame view, ParcScooters parc) {
        this.view = view;
        this.parc = parc;
        initController();
    }

    private void initController() {
        updateScooterCombo();
        updateClientCombo();
        view.getBtnCreerLocation().addActionListener(e -> creerLocation());
        view.getBtnRetour().addActionListener(e -> cloturerLocation());
    }
    
   private void updateScooterCombo() {
    System.out.println("---- Scooters dans le parc ----");
    for (Scooter s : parc.getListScooter()) {
        System.out.println(s.getIdScooter() + " " + s.getModele().getNomModele() + " dispo=" + s.estDisponible());
    }
    view.getComboScooter().removeAllItems();
    for (Scooter scooter : parc.getScootersDisponibles()) {
        view.getComboScooter().addItem(scooter.getModele().getNomModele() + " (ID: " + scooter.getIdScooter() + ")");
    }
}

private void updateClientCombo() {
    view.getComboClient().removeAllItems();
    for (Client client : parc.getListClient()) {
        StringBuilder permisTypes = new StringBuilder();
        if (client.getPermis() != null) {
            for (TypePermis tp : client.getPermis().getListTypePermis()) {
                permisTypes.append(tp.getType()).append(" ");
            }
        }
        view.getComboClient().addItem(
            client.getNom() + " " + client.getPrenom() +
            " | Permis: " + (client.getPermis() != null ? client.getPermis().getNumPermis() : "N/A") +
            " | Types: " + permisTypes.toString().trim()
        );
    }
}
    private boolean typePermisCouvre(String permisPossede, String permisRequis) {
        if (permisPossede.equals("A")) return true; // A couvre tout
        if (permisPossede.equals("A2")) return !permisRequis.equals("A");
        if (permisPossede.equals("A1")) return permisRequis.equals("A1") || permisRequis.equals("AM");
        if (permisPossede.equals("AM")) return permisRequis.equals("AM");
        return permisPossede.equals(permisRequis);
    }
    private boolean clientPeutLouer(Client client, Modele modele) {
        Permis permis = client.getPermis();
        if (permis == null) return false;
        for (TypePermis typeClient : permis.getListTypePermis()) {
            for (TypePermis typeAutorise : modele.getListPermis()) {
                if (typePermisCouvre(typeClient.getType(), typeAutorise.getType())) {
                    return true;
                }
            }
    }
    return false;
}

private Date stripTime(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    return cal.getTime();
}

   private void creerLocation() {
    String clientSelectionne = (String) view.getComboClient().getSelectedItem();
    if (clientSelectionne == null) {
        JOptionPane.showMessageDialog(view, "Veuillez sélectionner un client.");
        return;
    }
    String[] infos = clientSelectionne.split(" \\| ")[0].split(" ");
    String nomClient = infos[0];
    String prenomClient = infos[1];

    Client client = parc.getListClient().stream()
        .filter(c -> c.getNom().equals(nomClient) && c.getPrenom().equals(prenomClient))
        .findFirst()
        .orElse(null);

    String dateDebutStr = view.getTxtDateDebut().getText();
    String dateFinStr = view.getTxtDateFin().getText();
    String scooterSelectionne = (String) view.getComboScooter().getSelectedItem();

    if (!dateDebutStr.isEmpty() && !dateFinStr.isEmpty() && scooterSelectionne != null) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            sdf.setLenient(false);
            Date dateDebut = sdf.parse(dateDebutStr);
            Date dateFin = sdf.parse(dateFinStr);

            if (dateDebut.after(dateFin)) {
                JOptionPane.showMessageDialog(view, "La date de début doit être avant la date de fin.");
                return;
            }
            if (stripTime(dateDebut).before(stripTime(new Date()))) {
                JOptionPane.showMessageDialog(view, "La date de début ne peut pas être dans le passé.");
                return;
            }

            Date dateExpPermis = client.getPermis().getDateExp();
            if (dateExpPermis.before(dateFin)) {
                JOptionPane.showMessageDialog(view, "Le permis du client expire avant la fin de la location !");
                return;
            }
            if (dateExpPermis.before(dateDebut)) {
                JOptionPane.showMessageDialog(view, "Le permis du client n'est plus valide à la date de début de location !");
                return;
            }

            int scooterId = Integer.parseInt(scooterSelectionne.split("ID: ")[1].replace(")", ""));
            Scooter scooter = parc.getListScooter().stream()
                    .filter(s -> s.getIdScooter() == scooterId)
                    .findFirst()
                    .orElse(null);

            if (!clientPeutLouer(client, scooter.getModele())) {
                JOptionPane.showMessageDialog(view, "Permis insuffisant pour ce scooter !");
                return;
            }

            if (scooter != null && scooter.estDisponible()) {
                scooter.setDisponible(false);
                Location location = new Location(parc.getListLocation().size() + 1, dateDebut, dateFin, client, scooter, null);
                parc.addLocation(location);
                client.ajouterLocation(location);
                scooter.addLocation(location);
                JOptionPane.showMessageDialog(view, "Location créée pour " + nomClient + " avec scooter " + scooterSelectionne);
                updateScooterCombo();
                view.rafraichirTableauLocations();
            } else {
                JOptionPane.showMessageDialog(view, "Scooter non disponible.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Erreur : " + ex.getMessage());
        }
    } else {
        JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs.");
    }
}
private void cloturerLocation() {
    int selectedRow = view.getTableLocations().getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(view, "Veuillez sélectionner une location à clôturer.");
        return;
    }
    int idLocation = Integer.parseInt(view.getTableModel().getValueAt(selectedRow, 0).toString());
    Location location = parc.getListLocation().stream()
        .filter(l -> l.getIdLocation() == idLocation)
        .findFirst()
        .orElse(null);
    if (location == null) {
        JOptionPane.showMessageDialog(view, "Location introuvable.");
        return;
    }
    if (location.getRetour() != null) {
        JOptionPane.showMessageDialog(view, "Ce scooter a déjà été retourné pour cette location.");
        return;
    }
    String kmRetourStr = JOptionPane.showInputDialog(view, "Entrez le kilométrage de retour :");
    String dateRetourStr = JOptionPane.showInputDialog(view, "Entrez la date de retour (dd-MM-yyyy) :");
    try {
        double kmRetour = Double.parseDouble(kmRetourStr);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setLenient(false);
        Date dateRetour = sdf.parse(dateRetourStr);

        if (dateRetour.before(location.getDateDebut())) {
            JOptionPane.showMessageDialog(view, "La date de retour ne peut pas être avant la date de début de location.");
            return;
        }
        if (dateRetour.before(location.getDateFin())) {
            int confirm = JOptionPane.showConfirmDialog(view, "La date de retour est avant la date de fin prévue. Continuer ?", "Attention", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) return;
        }

        Retour retour = new Retour(kmRetour, location);
        retour.setDateRetour(dateRetour);
        location.cloturer(retour);
        double penalite = location.calculerPenalite();
        JOptionPane.showMessageDialog(view, "Pénalité à payer : " + penalite + " €");
        view.rafraichirTableauLocations();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(view, "Erreur de saisie : " + ex.getMessage());
    }
}
    
}