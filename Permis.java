
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Permis {
    private int numPermis;  
    private Date dateExp;  
    private String paysEmission;  
    private List<TypePermis> listTypePermis;  

    
    public Permis(int numPermis, Date dateExp, String paysEmission) {
        this.numPermis = numPermis;
        this.dateExp = dateExp;
        this.paysEmission = paysEmission;
        this.listTypePermis = new ArrayList<>();
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

    public List<TypePermis> getListTypePermis() {
        return listTypePermis;
    }

    public void setListTypePermis(List<TypePermis> listTypePermis) {
        this.listTypePermis = listTypePermis;
    }

}