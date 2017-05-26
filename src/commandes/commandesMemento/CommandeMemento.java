package commandes.commandesMemento;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public interface CommandeMemento {
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker);
}
