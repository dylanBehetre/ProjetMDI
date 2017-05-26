package commandes;

import zoneDeTravail.IZoneDeTravail;

public class EffacerCaracterePrecedent implements Commande {

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        if (zoneDeTravail.getCurseur() != 0) {
            String texteAvantCurseur = zoneDeTravail.getSubstringTexteSaisie(0, zoneDeTravail.getCurseur() - 1);
            String texteApresCurseur = zoneDeTravail.getSubstringTexteSaisie(zoneDeTravail.getCurseur(), zoneDeTravail.getLongeurTexte());
            zoneDeTravail.setTexteSaisie(texteAvantCurseur + texteApresCurseur);
            zoneDeTravail.setCurseur(zoneDeTravail.getCurseur() - 1);
        }
    }
}
