package Model;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Scooter {

    private int idScooter;
    private Modele modele;  
    private ParcScooters parc;
    private Vector<Location> listLocation;  
    private boolean disponible = true; // Indique si le scooter est disponible
    private Location locationActuelle; // Location en cours

    
    public Scooter(int idScooter, Modele modele, ParcScooters parc) {
        this.parc = parc;
        this.idScooter = idScooter;
        this.modele = modele;
        this.listLocation = new Vector<>();
    }

    
    public int getIdScooter() {
        return idScooter;
    }

    public void setIdScooter(int idScooter) {
        this.idScooter = idScooter;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Vector<Location> getListLocation() {
        return listLocation;
    }
    public ParcScooters getParc() {
        return parc;
    }
    public void setParc(ParcScooters parc) {
        this.parc = parc;
    }
    public void addLocation(Location location) {
        this.listLocation.add(location);
    }
    public void removeLocation(Location location) {
        this.listLocation.remove(location);
    }


    public boolean estDisponible() {
        return disponible;
    }

    public void setDisponible(boolean dispo) {
        this.disponible = dispo;
    }
    public double calculerChiffreAffaires() {
        double total = 0.0;
        for (Location loc : listLocation) {
            total += loc.calculerMontant();
        }
        return total;
    }
    public Location getLocationActuelle() {
        return locationActuelle;
    }

    public void setLocationActuelle(Location locationActuelle) {
        this.locationActuelle = locationActuelle;
        this.disponible = (locationActuelle == null); // Met à jour la disponibilité
    }
    @Override
    public String toString() {
        return "Scooter { " +
                "idScoot=" + idScooter +
                ", modele=" + (modele != null ? modele.getNomModele() : "N/A") +
                " }";
    }
}