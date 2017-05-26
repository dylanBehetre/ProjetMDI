package commandes.commandesMemento;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Undo implements CommandeMemento {

    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        zoneDeTravail.setStateFromMemento(careTaker.previous());
        careTaker.setUndo(true);
    }
}
