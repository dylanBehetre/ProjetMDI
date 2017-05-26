package commandes.commandesMemento;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Redo implements CommandeMemento {

    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        zoneDeTravail.setStateFromMemento(careTaker.next());
    }
}
