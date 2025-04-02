
import java.util.*;

/**
 * 
 */
public class Location {

    private int idLocation;  
    private Date dateDebut;  
    private Date dateFin;  
    private Vector<Retour> listRetour;  
    private Vector<Scooter> listScooter;  
    private Client client;  

    public Location(int idLocation, Date dateDebut, Date dateFin, Client client) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.listRetour = new Vector<>();
        this.listScooter = new Vector<>();
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

    public List<Retour> getListRetour() {
        return listRetour;
    }

    public void setListRetour(Vector<Retour> listRetour) {
        this.listRetour = listRetour;
    }

    public Vector<Scooter> getListScooter() {
        return listScooter;
    }

    public void setListScooter(Vector<Scooter> listScooter) {
        this.listScooter = listScooter;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}