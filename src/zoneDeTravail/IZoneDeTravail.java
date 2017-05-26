package zoneDeTravail;

import memento.Memento;

public interface IZoneDeTravail {

    /*Methods*/
    public Memento saveStateToMemento();

    /*Getters*/
    public String getTexteSaisie();

    public String getSubstringTexteSaisie(int indiceDebut, int indiceFin);

    public String getPressePapier();

    public int getCurseur();

    public int getDebutSelection();

    public int getFinSelection();

    public int getLongeurTexte();

    /*Setters*/
    public void setTexteSaisie(String texteSaisie);

    public void setPressePapier(String pressePapier);

    public void setCurseur(int curseur);

    public void setDebutSelection(int debutSelection);

    public void setFinSelection(int finSelection);

    public void setStateFromMemento(Memento memento);


}
