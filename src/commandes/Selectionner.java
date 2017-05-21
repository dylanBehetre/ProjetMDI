package commandes;

import main.Erreur;
import zoneDeTravail.IZoneDeTravail;

public class Selectionner implements Commande{

    /*Attributes*/
    private int indiceDebut;
    private int indiceFin;

    /*Constructor*/
    public Selectionner(int indiceDebut, int indiceFin) {
        this.indiceDebut = indiceDebut;
        this.indiceFin = indiceFin;
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        assert indiceDebut > 0 : Erreur.message("l'indice de début de la sélection doit être positive !");
        assert indiceFin > indiceDebut
                && indiceFin < zoneDeTravail.getTexteSaisie().length() : Erreur.message("l'indice de fin de la sélection doit supérieur à l'indice de début de la sélection !");

        zoneDeTravail.setDebutSelection(indiceDebut);
        zoneDeTravail.setFinSelection(indiceFin);
    }

    /*Getters*/
    public int getIndiceDebut() {
        return indiceDebut;
    }

    public int getIndiceFin() {
        return indiceFin;
    }

    /*Setters*/
    public void setIndiceDebut(int indiceDebut) {
        this.indiceDebut = indiceDebut;
    }

    public void setIndiceFin(int indiceFin) {
        this.indiceFin = indiceFin;
    }
}
