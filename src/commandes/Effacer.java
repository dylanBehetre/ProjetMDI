package commandes;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Effacer implements Commande{

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        zoneDeTravail.effacer();
    }
}
