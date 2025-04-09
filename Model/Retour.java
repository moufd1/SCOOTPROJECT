
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Retour {
    private double kmRetour;  
    private Location location;  

    
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
    
}