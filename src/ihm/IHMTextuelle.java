package ihm;

import java.util.Scanner;

public class IHMTextuelle implements IHM {
    private String zoneDeTravail;
    private boolean estLance;

    private Scanner scanner;

    public IHMTextuelle(){
        this.zoneDeTravail = "";
        this.estLance = false;

        this.scanner = new Scanner(System.in);
    }

    public void lancer(){
        this.estLance = true;
        Integer choixMenu;
        while(this.estLance){
            this.afficherZoneDeTravail();
            this.afficherMenu();
            choixMenu = this.scanner.nextInt();
            switch (choixMenu) {
                case 0:
                    this.inserer();
                    break;
                case 1:
                    this.selectionner();
                    break;
                case 2:
                    this.effacer();
                    break;
                case 3:
                    this.copier();
                    break;
                case 4:
                    this.couper();
                    break;
                case 5:
                    this.coller();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void inserer() {

    }

    @Override
    public void selectionner() {

    }

    @Override
    public void effacer() {

    }

    @Override
    public void copier() {

    }

    @Override
    public void couper() {

    }

    @Override
    public void coller() {

    }


    private void afficherZoneDeTravail() {
        System.out.println("-----Espace de Travail-----");
        System.out.println(this.zoneDeTravail);
        System.out.println("-----Fin de l'espace de travail-----");
    }

    private void afficherMenu(){
        System.out.println("-----Menu-----");
        System.out.println("Taper le numero de la commande souhaitez : ");
        System.out.println("0-Inserer");
        System.out.println("1-Selectionner");
        System.out.println("2-Effacer");
        System.out.println("3-Copier");
        System.out.println("4-Couper");
        System.out.println("5-Coller");
        System.out.println("-----Fin Menu-----");
    }
}
