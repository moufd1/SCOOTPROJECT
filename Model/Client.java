
import java.util.*;

/**
 * 
 */
public class Client {
        private int idClient;  
        private String nom;  
        private String prenom;  
        private Vector<Location> listLocation;  
        private Vector<Permis> listPermis;  

        public Client(int idClient, String nom, String prenom) {
            this.idClient = idClient;
            this.nom = nom;
            this.prenom = prenom;
            this.listLocation = new Vector<>();
            this.listPermis = new Vector<>();
        }

        public int getIdClient(){
            return idClient;
        }
    
        public void setIdClient(int idClient){
            this.idClient = idClient;
        }
    
        public String getNom(){
            return nom;
        }
    
        public void setNom(String nom){
            this.nom = nom;
        }
    
        public String getPrenom() {
            return prenom;
        }
    
        public void setPrenom(String prenom){
            this.prenom = prenom;
        }
    
        public Vector<Location> getListLocation(){
            return listLocation;
        }
    
        public void setListLocation(Vector<Location> listLocation){
            this.listLocation = listLocation;
        }
    
        public Vector<Permis> getListPermis(){
            return listPermis;
        }
    
        public void setListPermis(Vector<Permis> listPermis){
            this.listPermis = listPermis;
        }
    }
