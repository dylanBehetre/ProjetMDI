package commandes;

import zoneDeTravail.IZoneDeTravail;

public class Inserer implements Commande {

    private String texteAInserer;

    public Inserer(String texteAInserer) {
        this.texteAInserer = texteAInserer;
    }

    @Override
    public void execute(IZoneDeTravail zoneDeTravail) {
        zoneDeTravail.ajouterTexte(this.texteAInserer);
    }
}
