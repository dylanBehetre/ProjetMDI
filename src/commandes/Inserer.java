package commandes;

import memento.CareTaker;
import zoneDeTravail.IZoneDeTravail;

public class Inserer implements Commande {

    /*Attributes*/
    private String texteAInserer;

    /*Constructor*/
    public Inserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail, CareTaker careTaker) {
        careTaker.add(zoneDeTravail.saveStateToMemento());
        zoneDeTravail.ajouterTexte(this.texteAInserer);
    }
    /*Getters*/
    public String getTexteAInserer() {
        return texteAInserer;
    }

    /*Setters*/
    public void setTexteAInserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }


}
