package main;

import ihm.IHM;
import ihm.IHMTextuelle;

public class Lanceur {
    public static void main (String args[]){
        IHM monIHM = new IHMTextuelle();
        monIHM.lancer();

    }
}
