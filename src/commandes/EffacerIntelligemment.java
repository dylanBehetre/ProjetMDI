package commandes;

import zoneDeTravail.IZoneDeTravail;

public class EffacerIntelligemment implements Commande {

    /*Methods*/
    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        Commande effacer;

        boolean selection = (zoneDeTravail.getDebutSelection() != zoneDeTravail.getCurseur());
        if (selection) {
            effacer = new EffacerSelection();
        } else {
            effacer = new EffacerCaracterePrecedent();
        }

        effacer.execute(zoneDeTravail);
    }
}
