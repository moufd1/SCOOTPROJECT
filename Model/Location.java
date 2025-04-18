package Model;
import java.util.*;

/**
 * 
 */
public class Location {

    private int idLocation;  
    private Date dateDebut;  
    private Date dateFin;
    private Scooter scooter;
    private Client client;
    private Retour retour;

    public Location(int idLocation, Date dateDebut, Date dateFin, Client client,  Scooter scooter, Retour retour) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.scooter = scooter;
        this.retour = retour;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    public Scooter getScooter() {
        return scooter;
    }
    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public void setRetour(Retour retour) {
        this.retour = retour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Retour getRetour() {
        return retour;
    }
    public void setRetour(double kmRetour) {
        this.retour.setKmRetour(kmRetour);
    }
    
    @Override
    public String toString() {
        return "Location { " +
                "idLocation=" + idLocation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", client=" + (client != null ? client.getNom() : "N/A") +
                ", scooter=" + (scooter != null ? scooter.getIdScooter() : "N/A") +
                " }";
    }


}