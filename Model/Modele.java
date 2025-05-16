package Model;
import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

/**
 * 
 */
public class Modele {
    private int idModele;  
    private String nomModele;  
    private int puissance;
    private double tarifJournalier;
    private Vector<Scooter> listScooters;
    private Vector<TypePermis> listPermisAutorisé;  

    public Modele(int idModele, String nomModele, int puissance,double tarifJournalier) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.puissance = puissance;
        this.tarifJournalier = tarifJournalier;
        this.listScooters = new Vector<>();
        this.listPermisAutorisé = new Vector<>();
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
    public double getTarifJournalier() {
    return tarifJournalier;
    }   
    public void setTarifJournalier(double tarifJournalier) {
    this.tarifJournalier = tarifJournalier;
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
    public void addPermis(TypePermis permis) {
        this.listPermisAutorisé.add(permis);
    }
    public void removePermis(TypePermis permis) {
        this.listPermisAutorisé.remove(permis);
    }

    public Vector<TypePermis> getListPermis() {
        return listPermisAutorisé;
    }

}