
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

    public Location(int idLocation, Date dateDebut, Date dateFin, Client client,  Scooter scooter) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.scooter = scooter;
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

}