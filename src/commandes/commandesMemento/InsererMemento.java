package commandes.commandesMemento;

import commandes.Commande;
import commandes.Inserer;
import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class InsererMemento implements CommandeMemento {

    /*Attributes*/
    private Commande inserer;

    /*Constructor*/
    public InsererMemento(String texteAInserer) {
        this.inserer = new Inserer(texteAInserer);
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        this.inserer.execute(zoneDeTravail);
    }
}
