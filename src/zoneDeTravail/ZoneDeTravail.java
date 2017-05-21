package zoneDeTravail;

import main.Erreur;

public class ZoneDeTravail implements IZoneDeTravail {
    /*Attributes*/
    private String texteSaisie = "";
    private String pressePapier = "";
    private int curseur = 0;
    private int debutSelection = 0;
    private int finSelection = 0;

    private static ZoneDeTravail maZoneDeTravail;

    /*Constructor*/
    private ZoneDeTravail() {
        this.texteSaisie = "";
        this.pressePapier = "";
        this.curseur = 0;
        this.debutSelection = 0;
        this.finSelection = 0;
    }

    public static ZoneDeTravail getInstance() {
        if (ZoneDeTravail.maZoneDeTravail == null) {
            ZoneDeTravail.maZoneDeTravail = new ZoneDeTravail();
        }

        return ZoneDeTravail.maZoneDeTravail;
    }

    /*Methods*/
    @Override
    public void ajouterTexte(String texteAAjouter) {
        String texteAvantCurseur = this.texteSaisie.substring(0, this.debutSelection);
        String texteApresCurseur = this.texteSaisie.substring(this.finSelection, this.texteSaisie.length());
        this.setTexteSaisie(texteAvantCurseur + texteAAjouter + texteApresCurseur);
        this.setCurseur(this.debutSelection + texteAAjouter.length());
    }

    @Override
    public void effacer() {
        boolean selection = this.debutSelection != this.curseur;
        if (selection) {
            this.effacerSelection();
        } else if (this.curseur != 0) {
            this.effacerCaracterePrecedent();
        }
    }

    public void effacerSelection() {
        String texteAvantCurseur = this.texteSaisie.substring(0, this.debutSelection);
        String texteApresCurseur = this.texteSaisie.substring(this.finSelection, this.texteSaisie.length());
        this.setTexteSaisie(texteAvantCurseur + texteApresCurseur);
        this.setCurseur(this.debutSelection);
    }

    public void effacerCaracterePrecedent() {
        String texteAvantCurseur = this.texteSaisie.substring(0, this.curseur - 1);
        String texteApresCurseur = this.texteSaisie.substring(this.curseur, this.texteSaisie.length());
        this.setTexteSaisie(texteAvantCurseur + texteApresCurseur);
        this.setCurseur(this.curseur - 1);
    }

    public void copier() {
        this.pressePapier = this.texteSaisie.substring(this.debutSelection, this.finSelection);
    }

    @Override
    public void coller() {
        this.ajouterTexte(this.pressePapier);
    }

    @Override
    public void couper() {
        this.copier();
        this.effacerSelection();
    }

    /*Getters*/
    public String getTexteSaisie() {
        return texteSaisie;
    }

    public String getPressePapier() {
        return pressePapier;
    }

    public int getCurseur() {
        return curseur;
    }

    public int getDebutSelection() {
        return debutSelection;
    }

    public int getFinSelection() {
        return finSelection;
    }

    public int getLongeurTexte() {
        return this.texteSaisie.length();
    }

    /*Setters*/
    protected void setTexteSaisie(String texteSaisie) {
        this.texteSaisie = texteSaisie;
    }

    public void setPressePapier(String pressePapier) {
        this.pressePapier = pressePapier;
    }

    public void setCurseur(int curseur) {
        this.curseur = curseur;
        setDebutSelection(curseur);
        setFinSelection(curseur);
    }

    public void setDebutSelection(int debutSelection) {
        assert this.getLongeurTexte() > debutSelection
                && debutSelection > 0 : Erreur.message("l'indice de début de la sélection doit être positive et inférieur à la longueur du texte !");
        this.debutSelection = debutSelection;
    }

    public void setFinSelection(int finSelection) {
        assert finSelection > this.getDebutSelection()
                && finSelection < this.getTexteSaisie().length() : Erreur.message("l'indice de fin de la sélection doit supérieur à l'indice de début de la sélection !");
        this.finSelection = finSelection;
    }


}
