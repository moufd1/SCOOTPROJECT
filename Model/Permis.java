
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Permis {
    private int numPermis;  
    private Date dateExp;  
    private String paysEmission;  
    private Vector<TypePermis> listTypePermis;  

    
    public Permis(int numPermis, Date dateExp, String paysEmission) {
        this.numPermis = numPermis;
        this.dateExp = dateExp;
        this.paysEmission = paysEmission;
        this.listTypePermis = new Vector<>();
    }

    
    public int getNumPermis() {
        return numPermis;
    }

    public void setNumPermis(int numPermis) {
        this.numPermis = numPermis;
    }

    public Date getDateExp() {
        return dateExp;
    }

    public void setDateExp(Date dateExp) {
        this.dateExp = dateExp;
    }

    public String getPaysEmission() {
        return paysEmission;
    }

    public void setPaysEmission(String paysEmission) {
        this.paysEmission = paysEmission;
    }

    public Vector<TypePermis> getListTypePermis() {
        return listTypePermis;
    }

    public void addTypePermis(TypePermis typePermis) {
        this.listTypePermis.add(typePermis);
    }
    public void removeTypePermis(TypePermis typePermis) {
        this.listTypePermis.remove(typePermis);
    }


}