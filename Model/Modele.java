
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

   public void addScooter(Scooter scooter) {
        this.listScooters.add(scooter);
    }
    public void removeScooter(Scooter scooter) {
        this.listScooters.remove(scooter);
    }
    public void addPermis(Permis permis) {
        this.listPermis.add(permis);
    }
    public void removePermis(Permis permis) {
        this.listPermis.remove(permis);
    }

    public Vector<Permis> getListPermis() {
        return listPermis;
    }

}