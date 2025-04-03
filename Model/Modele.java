
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Modele {

    private int idModele;  
    private String nomModele;  
    private int puissance;
    private Vector<Scooter> listScooters;
    private Vector<Permis> listPermis;  

    public Modele(int idModele, String nomModele, int puissance) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.puissance = puissance;
        this.listScooters = new Vector<>();
        this.listPermis = new Vector<>();
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public Vector<Scooter> getlistScooters() {
        return listScooters;
    }

    public void setlistScooters(Vector<Scooter> listScooters) {
        this.listScooters = listScooters;
    }

    public Vector<Permis> getListPermis() {
        return listPermis;
    }

    public void setListPermis(Vector<Permis> listPermis) {
        this.listPermis = listPermis;
    }
}