package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Coller implements Commande{

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.coller();
    }
}
