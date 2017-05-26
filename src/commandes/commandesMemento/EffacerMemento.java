package commandes.commandesMemento;

import commandes.Commande;
import commandes.EffacerIntelligemment;
import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class EffacerMemento implements CommandeMemento {

    /*Attributes*/
    private Commande effacerIntelligement;

    /*Constructors*/
    public EffacerMemento() {
        this.effacerIntelligement = new EffacerIntelligemment();
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        this.effacerIntelligement.execute(zoneDeTravail);
    }
}
