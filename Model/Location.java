package Model;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 
 */
public class Location {

    private int idLocation;  
    private Date dateDebut;  
    private Date dateFin;
    private Scooter scooter;
    private Client client;
    private Retour retour;

    public Location(int idLocation, Date dateDebut, Date dateFin, Client client,  Scooter scooter, Retour retour) {
        this.idLocation = idLocation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
        this.scooter = scooter;
        this.retour = retour;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }


    public Scooter getScooter() {
        return scooter;
    }
    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public void setRetour(Retour retour) {
        this.retour = retour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public Retour getRetour() {
        return retour;
    }
    public void setRetour(double kmRetour) {
        this.retour.setKmRetour(kmRetour);
    }
    public double calculerMontant() {
        long diffMillis = dateFin.getTime() - dateDebut.getTime();
        long nbJours = Math.max(1, TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS));
        double tarif = scooter.getModele().getTarifJournalier();
        return nbJours * tarif;
    }

    public void cloturer(Retour retour) {
        this.retour = retour;
        if (scooter != null) {
            scooter.setDisponible(true);
        }
    }
    public double calculerPenalite() {
        if (retour == null) return 0.0;
        double penalite = 0.0;
        // Pénalité pour retard (ex: 10€/jour de retard)
        if (retour.getDateRetour() != null && retour.getDateRetour().after(dateFin)) {
            long retard = TimeUnit.DAYS.convert(retour.getDateRetour().getTime() - dateFin.getTime(), TimeUnit.MILLISECONDS);
            penalite += retard * 10.0;
        }
        // Calcul du nombre de jours de location
        long diffMillis = dateFin.getTime() - dateDebut.getTime();
        long nbJours = Math.max(1, TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS));
        double kmInclus = 100.0 * nbJours; // 100 km par jour
        // Pénalité pour dépassement de km (ex: 0.5€/km au-delà du km inclus)
        if (retour.getKmRetour() > kmInclus) {
            penalite += (retour.getKmRetour() - kmInclus) * 0.5;
        }
        return penalite;
    }
    
    @Override
    public String toString() {
        return "Location { " +
                "idLocation=" + idLocation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", client=" + (client != null ? client.getNom() : "N/A") +
                ", scooter=" + (scooter != null ? scooter.getIdScooter() : "N/A") +
                " }";
    }


}