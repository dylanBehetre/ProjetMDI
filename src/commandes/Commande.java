package commandes;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public interface Commande {
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker);
}
