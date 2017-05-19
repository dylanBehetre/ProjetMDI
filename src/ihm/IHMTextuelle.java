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
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }
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
