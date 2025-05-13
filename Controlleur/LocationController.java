package Controlleur;
import javax.swing.*;
import Model.Client;
import Model.Location;
import Model.ParcScooters;
import Model.Scooter;
import Vue.LocationFrame;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        view.getBtnCreerLocation().addActionListener(e -> creerLocation());
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

    private void creerLocation() {
        String nomClient = view.getTxtNomClient().getText();
        String prenomClient = view.getTxtPrenomClient().getText();
        String dateDebutStr = view.getTxtDateDebut().getText();
        String dateFinStr = view.getTxtDateFin().getText();
        String scooterSelectionne = (String) view.getComboScooter().getSelectedItem();

        if (!nomClient.isEmpty() && !prenomClient.isEmpty() && !dateDebutStr.isEmpty() && !dateFinStr.isEmpty() && scooterSelectionne != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateDebut = sdf.parse(dateDebutStr);
                Date dateFin = sdf.parse(dateFinStr);

                Client client = parc.getListClient().stream()
                        .filter(c -> c.getNom().equals(nomClient) && c.getPrenom().equals(prenomClient))
                        .findFirst()
                        .orElseGet(() -> {
                            Client newClient = new Client(parc.getListClient().size() + 1, nomClient, prenomClient, null);
                            parc.addClient(newClient);
                            return newClient;
                        });

                int scooterId = Integer.parseInt(scooterSelectionne.split("ID: ")[1].replace(")", ""));
                Scooter scooter = parc.getListScooter().stream()
                        .filter(s -> s.getIdScooter() == scooterId)
                        .findFirst()
                        .orElse(null);

                if (scooter != null && scooter.estDisponible()) {
                    scooter.setDisponible(false);
                    Location location = new Location(parc.getListLocation().size() + 1, dateDebut, dateFin, client, scooter, null);
                    parc.addLocation(location);
                    client.ajouterLocation(location);
                    scooter.addLocation(location);
                    JOptionPane.showMessageDialog(view, "Location créée pour " + nomClient + " avec scooter " + scooterSelectionne);
                    updateScooterCombo();
                    view.rafraichirTableauLocations(); // <-- AJOUTE CETTE LIGNE
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
    
}