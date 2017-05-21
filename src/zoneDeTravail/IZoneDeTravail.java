package zoneDeTravail;

public interface IZoneDeTravail {

    /*Methods*/
    public void ajouterTexte(String texteAAjouter);

    public void effacer();

    /*Getters*/
    public String getTexteSaisie();

    public String getPressePapier();

    public int getCurseur();

    public int getDebutSelection();

    public int getFinSelection();

    /*Setters*/
    public void setDebutSelection(int debutSelection);

    public void setFinSelection(int finSelection);

}
