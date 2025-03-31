
import java.io.*;
import java.util.*;

/**
 * 
 */
public class ParcScooters {

    private int idParc; 
    private String nomParc;  
    private List<Scooter> listScooter;  
    private List<Client> listClient;  

    // Constructeur
    public ParcScooters(int idParc, String nomParc) {
        this.idParc = idParc;
        this.nomParc = nomParc;
        this.listScooter = new ArrayList<>();
        this.listClient = new ArrayList<>();
    }

    // Getters et Setters
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

    public void setListScooter(List<Scooter> listScooter) {
        this.listScooter = listScooter;
    }

    public List<Client> getListClient() {
        return listClient;
    }

    public void setListClient(List<Client> listClient) {
        this.listClient = listClient;
    }
}