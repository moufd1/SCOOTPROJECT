package Controlleur;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Modele;
import Model.ParcScooters;
import Model.Scooter;
import Model.TypePermis;
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
            if (view.getCbA().isSelected())   modele.addPermis(new TypePermis("A"));
            if (view.getCbA1().isSelected())  modele.addPermis(new TypePermis("A1"));
            if (view.getCbB().isSelected())   modele.addPermis(new TypePermis("B"));
            if (view.getCbAM().isSelected())  modele.addPermis(new TypePermis("AM"));
            
            Scooter scooter = new Scooter(parc.getListScooter().size() + 1, modele, parc);
            parc.addScooter(scooter);
            modele.addScooter(scooter);

            rafraichirTableauScooters(); // <-- AJOUTE CETTE LIGNE ICI

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

private void rafraichirTableauScooters() {
    DefaultTableModel model = view.getTableModel();
    model.setRowCount(0);
    for (Scooter s : parc.getListScooter()) {
        Modele m = s.getModele();
        StringBuilder permis = new StringBuilder();
        if (m != null && m.getListPermis() != null) {
            for (TypePermis tp : m.getListPermis()) {
                permis.append(tp.getType()).append(" ");
            }
        }
        model.addRow(new Object[]{
            s.getIdScooter(),
            (m != null ? m.getNomModele() : ""),
            (m != null ? m.getPuissance() : ""),
            (m != null ? m.getTarifJournalier() : ""),
            permis.toString().trim(),
            s.estDisponible() ? "Oui" : "Non"
        });
    }
}
}