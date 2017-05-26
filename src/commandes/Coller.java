package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Coller implements Commande {

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        Commande inserer = new Inserer(zoneDeTravail.getPressePapier());
        inserer.execute(zoneDeTravail);
    }
}
