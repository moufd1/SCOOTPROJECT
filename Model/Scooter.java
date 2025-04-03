
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Scooter {

    private int idScooter;
    private Modele modele;  
    private Vector<Location> listLocation;  

    
    public Scooter(int idScooter, Modele modele) {
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

    public void setListLocation(Vector<Location> listLocation) {
        this.listLocation = listLocation;
    }
}

