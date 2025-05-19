package Model;
import java.util.*;

/**
 * 
 */
public class Retour {
    private double kmRetour;  
    private Location location;  
    private Date dateRetour;

    
    public Retour(double kmRetour, Location location) {
        this.kmRetour = kmRetour;
        this.location = location;
    }

    
    public double getKmRetour() {
        return kmRetour;
    }

    public void setKmRetour(double kmRetour) {
        this.kmRetour = kmRetour;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Date getDateRetour() {
        return dateRetour;
    }
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }




    @Override
    public String toString() {
        return "Retour{" +
                "kmRetour=" + kmRetour +
                ", location=" + location +
                '}';
    }
    
}