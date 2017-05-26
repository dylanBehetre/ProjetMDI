package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Copier implements Commande{

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.setPressePapier(zoneDeTravail.getSubstringTexteSaisie(zoneDeTravail.getDebutSelection(), zoneDeTravail.getFinSelection()));
    }
}
