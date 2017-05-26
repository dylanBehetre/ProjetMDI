package commandes;

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
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.setCurseur(this.nouvelEmplacementCurseur);
    }
}
