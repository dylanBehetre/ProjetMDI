package commandes;

import zoneDeTravail.IZoneDeTravail;
import memento.CareTaker;

public class Copier implements Commande{

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.copier();
    }
}
