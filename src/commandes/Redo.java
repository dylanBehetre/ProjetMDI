package commandes;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Redo implements Commande{

    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        zoneDeTravail.setStateFromMemento(careTaker.next());
    }
}
