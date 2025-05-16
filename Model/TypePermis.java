package Model;
import java.io.*;
import java.util.*;

/**
 * 
 */
public class TypePermis {
    private String type;  
    private Vector<Permis> listPermis;
    private Vector<Modele> listModele;

    
    public TypePermis(String type) {
        this.type = type;
        this.listPermis = new Vector<>();
        this.listModele = new Vector<>();
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Vector<Permis> getListPermis() {
        return listPermis;
    }
    public Vector<Modele> getListModele() {
        return listModele;
    }
    public void addListModele(Modele modele) {
        this.listModele.add(modele);
    }
    public void removeListModele(Modele modele) {
        this.listModele.remove(modele);
    }  
    public void addPermis(Permis permis) {
        this.listPermis.add(permis);
    }
    public void removePermis(Permis permis) {
        this.listPermis.remove(permis);
    }


}