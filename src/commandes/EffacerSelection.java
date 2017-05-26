package commandes;

import zoneDeTravail.IZoneDeTravail;

public class EffacerSelection implements Commande {

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        String texteAvantCurseur = zoneDeTravail.getSubstringTexteSaisie(0, zoneDeTravail.getDebutSelection());
        String texteApresCurseur = zoneDeTravail.getSubstringTexteSaisie(zoneDeTravail.getFinSelection(), zoneDeTravail.getLongeurTexte());
        zoneDeTravail.setTexteSaisie(texteAvantCurseur + texteApresCurseur);
        zoneDeTravail.setCurseur(zoneDeTravail.getDebutSelection());
    }
}
