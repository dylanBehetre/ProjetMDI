package main;

import ihm.IHM;
import ihm.IHMGraphique;
import ihm.IHMTextuelle;
import memento.CareTaker;

public class Lanceur {
    public static void main (String args[]){
        IHM monIHM = new IHMGraphique();
        monIHM.lancer();

    }
}
