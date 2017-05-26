package commandes;

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
    public void execute(IZoneDeTravail zoneDeTravail) {
        String texteAvantCurseur = zoneDeTravail.getSubstringTexteSaisie(0, zoneDeTravail.getDebutSelection());
        String texteApresCurseur = zoneDeTravail.getSubstringTexteSaisie(zoneDeTravail.getFinSelection(), zoneDeTravail.getLongeurTexte());
        zoneDeTravail.setTexteSaisie(texteAvantCurseur + this.getTexteAInserer() + texteApresCurseur);

        zoneDeTravail.setCurseur(zoneDeTravail.getDebutSelection() + this.getLongeurTexteAInserer());
    }

    private int getLongeurTexteAInserer() {
        return texteAInserer.length();
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
