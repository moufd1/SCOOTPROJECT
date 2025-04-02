
import java.io.*;
import java.util.*;

/**
 * 
 */
public class Client {
        private int idClient;  
        private String nom;  
        private String prenom;  
        private List<Location> listLocation;  
        private List<Permis> listPermis;  
    
        // Constructeur
        public Client(int idClient, String nom, String prenom) {
            this.idClient = idClient;
            this.nom = nom;
            this.prenom = prenom;
            this.listLocation = new ArrayList<>();
            this.listPermis = new ArrayList<>();
        }
    
        // Getters et Setters
        public int getIdClient() {
            return idClient;
        }
    
        public void setIdClient(int idClient) {
            this.idClient = idClient;
        }
    
        public String getNom() {
            return nom;
        }
    
        public void setNom(String nom) {
            this.nom = nom;
        }
    
        public String getPrenom() {
            return prenom;
        }
    
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
    
        public List<Location> getListLocation() {
            return listLocation;
        }
    
        public void setListLocation(List<Location> listLocation) {
            this.listLocation = listLocation;
        }
    
        public List<Permis> getListPermis() {
            return listPermis;
        }
    
        public void setListPermis(List<Permis> listPermis) {
            this.listPermis = listPermis;
        }
    }
