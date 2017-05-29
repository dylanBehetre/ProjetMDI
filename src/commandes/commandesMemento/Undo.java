package commandes.commandesMemento;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Undo implements CommandeMemento {

    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        if(careTaker.getPointeur() == careTaker.getSize()){
            careTaker.add(zoneDeTravail.saveStateToMemento());
        }
        zoneDeTravail.setStateFromMemento(careTaker.previous());
        careTaker.setUndo(true);
    }
}
