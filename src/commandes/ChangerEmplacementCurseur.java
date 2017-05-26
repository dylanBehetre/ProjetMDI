package commandes;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class ChangerEmplacementCurseur implements Commande {

    /*Attributes*/
    private int nouvelEmplacementCurseur;

    /*Constructor*/
    public ChangerEmplacementCurseur(int nouvelEmplacementCurseur) {
        this.nouvelEmplacementCurseur = nouvelEmplacementCurseur;
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        zoneDeTravail.setCurseur(this.nouvelEmplacementCurseur);
    }
}
