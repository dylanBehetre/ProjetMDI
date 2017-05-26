package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Couper implements Commande {

    /*Attributes*/
    private Commande copier;
    private Commande effacerSelection;

    /*Constructors*/
    public Couper() {
        this.copier = new Copier();
        this.effacerSelection = new EffacerSelection();
    }

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        copier.execute(zoneDeTravail);
        effacerSelection.execute(zoneDeTravail);
    }
}
