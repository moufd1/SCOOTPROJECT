
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Location {

    private int idLocation;  
    private Date dateDebut;  
    private Date dateFin;  
    private List<Retour> listRetour;  
    private List<Scooter> listScooter;  
    private Client client;  

    // Constructeur
    public Location(int idLocation, Date dateDebut, Date dateFin, Client client) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.listRetour = new ArrayList<>();
        this.listScooter = new ArrayList<>();
    }

    // Getters et Setters
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

    public List<Retour> getListRetour() {
        return listRetour;
    }

    public void setListRetour(List<Retour> listRetour) {
        this.listRetour = listRetour;
    }

    public List<Scooter> getListScooter() {
        return listScooter;
    }

    public void setListScooter(List<Scooter> listScooter) {
        this.listScooter = listScooter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}