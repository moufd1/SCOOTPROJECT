import java.util.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import Model.*;

public class main {
    public static void main(String[] args) {
        try {
            // Création des modèles
            Modele modele1 = new Modele(1, "Yamaha XMAX", 125);
            Modele modele2 = new Modele(2, "Honda PCX", 150);

            // Création des scooters
            Scooter scooter1 = new Scooter(1, modele1, null);
            Scooter scooter2 = new Scooter(2, modele2, null);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Création des clients
            Client client1 = new Client(1, "BELLAH", "Moufdi", new Permis(12321, dateFormat.parse("2027-04-09"), "Algerie"));
            Client client2 = new Client(2, "SAGUI", "Amayas", new Permis(453452, dateFormat.parse("2026-04-09"), "Algerie"));

            // Création du parc
            ParcScooters parc1 = new ParcScooters(1, "Parc Central");
            parc1.getListScooter().add(scooter1);
            parc1.getListScooter().add(scooter2);
            parc1.getListClient().add(client1);
            parc1.getListClient().add(client2);

            // Création des locations
            Location location1 = new Location(1, dateFormat.parse("2025-04-01"), dateFormat.parse("2025-04-05"), client1, scooter1, null);
            Location location2 = new Location(2, dateFormat.parse("2025-04-03"), dateFormat.parse("2025-04-07"), client2, scooter2, null);

            Retour retour1 = new Retour(120.5, location1);
            Retour retour2 = new Retour(85.3, location2);

            location1.setRetour(retour1);
            location2.setRetour(retour2);

            parc1.getListLocation().add(location1);
            parc1.getListLocation().add(location2);

            // Ajouter les locations aux clients
            client1.ajouterLocation(location1);
            client2.ajouterLocation(location2);

            // Affichage des informations
            System.out.println("=========== Informations sur le parc ==========");
            System.out.println("Nom du parc : " + parc1.getNomParc());
            System.out.println("Scooters disponibles :");
            for (Scooter scooter : parc1.getListScooter()) {
                System.out.println("- Scooter ID : " + scooter.getIdScooter() + ", Modèle : " + scooter.getModele().getNomModele());
            }

            System.out.println("\nClients enregistrés :");
            for (Client client : parc1.getListClient()) {
                System.out.println("- Client ID : " + client.getIdClient() + ", Nom : " + client.getNom() + ", Prénom : " + client.getPrenom());
            }

            System.out.println("\nLocations en cours :");
            for (Location location : parc1.getListLocation()) {
                System.out.println("- Location ID : " + location.getIdLocation() + ", Client : " + location.getClient().getNom() + ", Scooter : " + location.getScooter().getModele().getNomModele());
            }

            System.out.println("\nRetours :");
            for (Location location : parc1.getListLocation()) {
                Retour retour = location.getRetour();
                if (retour != null) {
                    System.out.println("- Retour pour la location ID : " + location.getIdLocation() + ", Kilométrage : " + retour.getKmRetour());
                } else {
                    System.out.println("- Aucun retour pour la location ID : " + location.getIdLocation());
                }
            }

            // Calcul et affichage du chiffre d'affaires du parc
            double chiffreAffaires = parc1.calculerChiffreAffaires();
            System.out.println("\nChiffre d'affaires du parc : " + chiffreAffaires + " €");

            // Calcul et affichage des dépenses totales des clients
            System.out.println("\nDépenses totales des clients :");
            for (Client client : parc1.getListClient()) {
                double depenseTotale = client.calculerDepenseTotale();
                System.out.println("- Client : " + client.getNom() + " " + client.getPrenom() + ", Dépense totale : " + depenseTotale + " €");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}