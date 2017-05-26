package commandes.commandesMemento;

import commandes.Coller;
import commandes.Commande;
import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class CollerMemento implements CommandeMemento {
    /*Attributes*/
    private Commande coller;

    /*Constructors*/
    public CollerMemento() {
        this.coller = new Coller();
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        this.coller.execute(zoneDeTravail);
    }
}
