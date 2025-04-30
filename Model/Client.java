package Model;
import java.util.*;

/**
 * 
 */
public class Client {
        private int idClient;  
        private String nom;  
        private String prenom;
        private Permis permis;  
        private Vector<Location> listLocation;  
        private Vector<ParcScooters> listParc;

        public Client(int idClient, String nom, String prenom,Permis permis) {
            this.idClient = idClient;
            this.nom = nom;
            this.prenom = prenom;
            this.permis = permis;
            this.listLocation = new Vector<>();
            this.listParc = new Vector<>();
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
    
        public Vector<ParcScooters> getListParc(){
            return listParc;
        }
    
        public void setListParc(Vector<ParcScooters> listParc){
            this.listParc = listParc;
        }
        public Permis getPermis() {
            return permis;
        }
        public void setPermis(Permis permis) {
            this.permis = permis;
        }
        @Override
        public String toString() {
            return "Client { " +
                    "idClient=" + idClient +
                    ", nom='" + nom + '\'' +
                    ", prenom='" + prenom + '\'' +
                    " }";
        }
        //recheck apres mashi sur nkhliha
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Client)) return false;
            Client client = (Client) o;
            return idClient == client.idClient &&
                    Objects.equals(nom, client.nom) &&
                    Objects.equals(prenom, client.prenom);
        }

        public void ajouterLocation(Location location) {
            if (location != null) {
                listLocation.add(location);
            }
        }
        public boolean supprimerLocation(Location location) {
            return listLocation.remove(location);
        }

        public int getNombreLocations() {
            return listLocation.size();
        }

        public double calculerDepenseTotale() {
            double total = 0.0;
            for (Location loc : listLocation) {
                // calculerMontant() doit renvoyer le montant de la location
                total += loc.calculerMontant();
            }
            return total;
        }

        public void afficherHistoriqueLocations() {
            System.out.println("Historique des locations pour " + nom + " " + prenom + " :");
            for (Location loc : listLocation) {
                System.out.println(loc);  // Appelle toString() de Location
            }
        }   
    }
