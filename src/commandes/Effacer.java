package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Effacer implements Commande{

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.effacer();
    }
}
