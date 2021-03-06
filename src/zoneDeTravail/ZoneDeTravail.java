package zoneDeTravail;

import main.Erreur;
import memento.Memento;

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
    public Memento saveStateToMemento(){
        return new Memento(this);
    }

    public ZoneDeTravail clone(){
        ZoneDeTravail result = new ZoneDeTravail();
        result.pressePapier = this.getPressePapier();
        result.texteSaisie = this.getTexteSaisie();
        result.debutSelection = this.getDebutSelection();
        result.finSelection = this.getFinSelection();
        result.curseur = this.getCurseur();
        return result;
    }

    /*Getters*/
    public String getTexteSaisie() {
        return texteSaisie;
    }

    public String getSubstringTexteSaisie(int indiceDebut, int indiceFin) {
        return texteSaisie.substring(indiceDebut, indiceFin);
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
    public void setTexteSaisie(String texteSaisie) {
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

    public void setStateFromMemento(Memento memento){
        this.curseur = memento.getState().getCurseur();
        this.debutSelection = memento.getState().getDebutSelection();
        this.finSelection = memento.getState().getFinSelection();
        this.texteSaisie = memento.getState().getTexteSaisie();
        this.pressePapier = memento.getState().getPressePapier();
    }


}
