
import java.io.*;
import java.util.*;

/**
 * 
 */
public class TypePermis {
    private String type;  
    private Vector<Permis> listPermis;  

    
    public TypePermis(String type) {
        this.type = type;
        this.listPermis = new Vector<>();
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

    public void setListPermis(Vector<Permis> listPermis) {
        this.listPermis = listPermis;
    }

}