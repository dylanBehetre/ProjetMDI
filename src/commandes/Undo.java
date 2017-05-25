package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Undo implements Commande {

    /*Constructor*/
    public Undo(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {

    }
}
