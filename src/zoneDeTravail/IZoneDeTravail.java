package zoneDeTravail;

public interface IZoneDeTravail {

    /*Methods*/
    public void ajouterTexte(String texteAAjouter);

    public void copier();

    public void coller();

    public void couper();

    public void effacer();

    /*Getters*/
    public String getTexteSaisie();

    public String getPressePapier();

    public int getCurseur();

    public int getDebutSelection();

    public int getFinSelection();

    /*Setters*/
    public void setCurseur(int curseur);

    public void setDebutSelection(int debutSelection);

    public void setFinSelection(int finSelection);

}
