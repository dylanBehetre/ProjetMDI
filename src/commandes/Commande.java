package commandes;

import zoneDeTravail.IZoneDeTravail;

public interface Commande {
    public void execute(IZoneDeTravail zoneDeTravail);
}
