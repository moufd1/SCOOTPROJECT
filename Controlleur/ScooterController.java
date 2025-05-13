package Controlleur;
import javax.swing.*;
import Model.Modele;
import Model.ParcScooters;
import Model.Scooter;
import Vue.ScooterFrame;

public class ScooterController {
    private ScooterFrame view;
    private ParcScooters parc;

    public ScooterController(ScooterFrame view, ParcScooters parc) {
        this.view = view;
        this.parc = parc;
        initController();
    }

    private void initController() {
        view.getBtnAjouterScooter().addActionListener(e -> ajouterScooter());
    }

private void ajouterScooter() {
    String modeleNom = view.getTxtModele().getText();
    String puissanceStr = view.getTxtPuissance().getText();
    String tarifStr = view.getTxtTarifJournalier().getText();

    if (!modeleNom.isEmpty() && !puissanceStr.isEmpty() && !tarifStr.isEmpty()) {
        try {
            int puissance = Integer.parseInt(puissanceStr);
            double tarif = Double.parseDouble(tarifStr);

            Modele modele = new Modele(
                parc.getListScooter().size() + 1,
                modeleNom,
                puissance,
                tarif
            );
            Scooter scooter = new Scooter(parc.getListScooter().size() + 1, modele, parc);
            parc.addScooter(scooter);
            modele.addScooter(scooter);

            JOptionPane.showMessageDialog(view, "Scooter ajouté avec modèle : " + modeleNom);
            view.getTxtModele().setText("");
            view.getTxtPuissance().setText("");
            view.getTxtTarifJournalier().setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Veuillez entrer des valeurs numériques valides pour la puissance et le tarif.");
        }
    } else {
        JOptionPane.showMessageDialog(view, "Veuillez remplir tous les champs.");
    }
}
}   