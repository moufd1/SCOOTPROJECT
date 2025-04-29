package Model;

import java.util.*;

public class ParcScooters {
    private int idParc;
    private String nomParc;
    private Vector<Scooter> listScooter;
    private Vector<Client> listClient;
    private Vector<Location> listLocation;
    private static int nextId = 1; 

    public ParcScooters(int idParc, String nomParc) {
        this.idParc = idParc;
        this.nomParc = nomParc;
        this.listScooter = new Vector<>();
        this.listClient = new Vector<>();
        this.listLocation = new Vector<>();
    }

    
    public static int getNextId() {
        return nextId++;
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

    public void addScooter(Scooter scooter) {
        this.listScooter.add(scooter);
    }

    public Vector<Client> getListClient() {
        return listClient;
    }

    public void addClient(Client client) {
        this.listClient.add(client);
    }

    public void removeClient(Client client) {
        this.listClient.remove(client);
    }

    public Vector<Location> getListLocation() {
        return listLocation;
    }

    public void addLocation(Location location) {
        this.listLocation.add(location);
    }

    public void removeLocation(Location location) {
        this.listLocation.remove(location);
    }

    public void removeScooter(Scooter scooter) {
        this.listScooter.remove(scooter);
    }

    public void ajouterScooter(Scooter scooter) {
        if (scooter != null) {
            listScooter.add(scooter);
        }
    }

    public void retirerScooter(Scooter scooter) {
        listScooter.remove(scooter);
    }

    public List<Scooter> getScootersDisponibles() {
        List<Scooter> disponibles = new ArrayList<>();
        for (Scooter s : listScooter) {
            if (s.estDisponible()) {
                disponibles.add(s);
            }
        }
        return disponibles;
    }
}