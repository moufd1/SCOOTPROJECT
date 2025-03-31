
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Scooter {

    private int idScooter;  
    private List<Scooter> listScooter;  
    private Modele modele;  
    private List<Location> listLocation;  

    
    public Scooter(int idScooter, Modele modele) {
        this.idScooter = idScooter;
        this.modele = modele;
        this.listScooter = new ArrayList<>();
        this.listLocation = new ArrayList<>();
    }

    
    public int getIdScooter() {
        return idScooter;
    }

    public void setIdScooter(int idScooter) {
        this.idScooter = idScooter;
    }

    public List<Scooter> getListScooter() {
        return listScooter;
    }

    public void setListScooter(List<Scooter> listScooter) {
        this.listScooter = listScooter;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public List<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(List<Location> listLocation) {
        this.listLocation = listLocation;
    }
}

