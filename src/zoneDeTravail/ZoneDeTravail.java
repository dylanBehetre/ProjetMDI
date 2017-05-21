package zoneDeTravail;

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
        String texteAvantCurseur = this.texteSaisie.substring(0, this.curseur);
        String texteApresCurseur = this.texteSaisie.substring(this.curseur, this.texteSaisie.length());
        ;
        texteSaisie = texteAvantCurseur + texteAAjouter + texteApresCurseur;
        this.deplacerCusreur(texteAAjouter.length());
    }

    public void deplacerCusreur(int deplacement) {
        curseur += deplacement;
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

    /*Setters*/
    public void setTexteSaisie(String texteSaisie) {
        this.texteSaisie = texteSaisie;
    }

    public void setPressePapier(String pressePapier) {
        this.pressePapier = pressePapier;
    }

    public void setCurseur(int curseur) {
        this.curseur = curseur;
    }

    public void setDebutSelection(int debutSelection) {
        this.debutSelection = debutSelection;
    }

    public void setFinSelection(int finSelection) {
        this.finSelection = finSelection;
    }
}
