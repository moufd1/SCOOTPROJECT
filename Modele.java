
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Modele {

    private int idModele;  
    private String nomModele;  
    private int puissance;  
    private List<Modele> listModele;  
    private List<Permis> listPermis;  

    // Constructeur
    public Modele(int idModele, String nomModele, int puissance) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.puissance = puissance;
        this.listModele = new ArrayList<>();
        this.listPermis = new ArrayList<>();
    }

    // Getters et Setters
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

    public List<Modele> getListModele() {
        return listModele;
    }

    public void setListModele(List<Modele> listModele) {
        this.listModele = listModele;
    }

    public List<Permis> getListPermis() {
        return listPermis;
    }

    public void setListPermis(List<Permis> listPermis) {
        this.listPermis = listPermis;
    }
}