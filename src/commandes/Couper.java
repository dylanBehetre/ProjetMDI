package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Couper implements Commande {

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.couper();
    }
}
