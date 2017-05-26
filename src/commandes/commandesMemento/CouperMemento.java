package commandes.commandesMemento;

import commandes.Commande;
import commandes.Couper;
import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class CouperMemento implements CommandeMemento {
    /*Attributes*/
    private Commande couper;

    /*Constructors*/
    public CouperMemento() {
        this.couper = new Couper();
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        this.couper.execute(zoneDeTravail);
    }
}
