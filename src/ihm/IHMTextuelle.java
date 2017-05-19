package ihm;

public class IHMTextuelle implements IHM {
    private String zoneDeTravail;
    private boolean estLance;

    public IHMTextuelle(){
        this.zoneDeTravail = "";
        this.estLance = false;

    }

    public void lancer(){
        this.estLance = true;
        while(this.estLance){
            System.out.println("-----Espace de Travail-----");
            System.out.println(this.zoneDeTravail);
            System.out.println("-----Fin de l'espace de travail-----");

        }
    }

    private void afficherMenu(){
        System.out.println("-----Menu-----");
        System.out.println("Taper la commande souhaitez : ");
        System.out.println("0-Selectionner");
        System.out.println("-----Fin Menu-----");


    }
}
