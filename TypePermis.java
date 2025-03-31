
import java.io.*;
import java.util.*;

/**
 * 
 */
public class TypePermis {
    private String type;  
    private List<Permis> listPermis;  

    
    public TypePermis(String type) {
        this.type = type;
        this.listPermis = new ArrayList<>();
    }

    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Permis> getListPermis() {
        return listPermis;
    }

    public void setListPermis(List<Permis> listPermis) {
        this.listPermis = listPermis;
    }

}