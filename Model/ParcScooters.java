
import java.io.*;
import java.util.*;

/**
 * 
 */
public class ParcScooters {

    private int idParc; 
    private String nomParc;  
    private Vector<Scooter> listScooter;  
    private Vector<Client> listClient;
    private Vector<Location> listLocation;

    public ParcScooters(int idParc, String nomParc) {
        this.idParc = idParc;
        this.nomParc = nomParc;
        this.listScooter = new Vector<>();
        this.listClient = new Vector<>();
        this.listLocation= new Vector<>();
    }

    public int getIdParc() {
        return idParc;
    }

    public void setIdParc(int idParc) {
        this.idParc = idParc;
    }

    public String getNomParc() {
        return nomParc;
    }

    public void setNomParc(String nomParc) {
        this.nomParc = nomParc;
    }

    public List<Scooter> getListScooter() {
        return listScooter;
    }

    public void setListScooter(Vector<Scooter> listScooter) {
        this.listScooter = listScooter;
    }

    public Vector<Client> getListClient() {
        return listClient;
    }

    public void setListClient(Vector<Client> listClient) {
        this.listClient = listClient;
    }

    public Vector<Location> getListLocation() {
        return listLocation;
    }

    public void setListLocation(Vector<Location> listLocation) {
        this.listLocation = listLocation;
    }
}