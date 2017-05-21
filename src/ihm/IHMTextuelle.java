package ihm;

import commandes.*;
import zoneDeTravail.ZoneDeTravail;

import java.util.Scanner;

public class IHMTextuelle implements IHM {

    /*Attributes*/
    private boolean estLance;

    private ZoneDeTravail zoneDeTravail;

    private Scanner intScanner;
    private Scanner stringScanner;

    /*Constructor*/

    public IHMTextuelle() {
        this.estLance = false;

        this.zoneDeTravail = ZoneDeTravail.getInstance();

        this.intScanner = new Scanner(System.in);
        this.stringScanner = new Scanner(System.in);
    }

    /*Methods*/
    public void lancer() {
        this.estLance = true;
        Integer choixMenu;
        while (this.estLance) {
            this.afficherZoneDeTravail();
            this.afficherMenu();
            choixMenu = this.intScanner.nextInt();
            switch (choixMenu) {
                case 0:
                    this.arreter();
                    break;
                case 1:
                    this.inserer();
                    break;
                case 2:
                    this.selectionner();
                    break;
                case 3:
                    this.effacer();
                    break;
                case 4:
                    this.copier();
                    break;
                case 5:
                    this.couper();
                    break;
                case 6:
                    this.coller();
                    break;
                default:
                    break;
            }
        }
    }

    private void arreter() {
        this.estLance = false;
    }

    @Override
    public void inserer() {
        System.out.println("Que voulez-vous insérer ?");
        String textAInserer = this.stringScanner.nextLine();

        Commande inserer = new Inserer(textAInserer);
        inserer.execute(this.zoneDeTravail);
    }

    @Override
    public void selectionner() {
        boolean selectionEstCorrect = false;
        int debutSelection = 0;

        while (!selectionEstCorrect) {
            System.out.println("Quel est le numéro du caractère à partir duquel vous souhaitez commencer la selection ?");
            debutSelection = this.intScanner.nextInt();
            selectionEstCorrect = (0 <= debutSelection);
            if (!selectionEstCorrect) {
                System.out.println("Attention : Le numero doit être positif !");
            }
        }

        selectionEstCorrect = false;
        int finSelection = 0;
        while (!selectionEstCorrect) {
            System.out.println("Quel est le caractère à partir duquel vous souhaitez finir la selection ?");
            finSelection = this.intScanner.nextInt();
            selectionEstCorrect = (debutSelection < finSelection && finSelection <= this.zoneDeTravail.getLongeurTexte());
            if (!selectionEstCorrect) {
                System.out.println("Attention : Le numero doit être supérieur au début de la sélection et inférieur à la taille du texte !");
            }
        }

        Commande selectionner = new Selectionner(debutSelection, finSelection);
        selectionner.execute(this.zoneDeTravail);
    }

    @Override
    public void effacer() {
        Commande effacer = new Effacer();
        effacer.execute(zoneDeTravail);
    }

    @Override
    public void copier() {
        Commande copier = new Copier();
        copier.execute(zoneDeTravail);
    }

    @Override
    public void couper() {
        Commande couper = new Couper();
        couper.execute(zoneDeTravail);
    }

    @Override
    public void coller() {
        Commande coller = new Coller();
        coller.execute(zoneDeTravail);
    }

    public void changerEmplacementCurseur() {
        boolean saisieCorrecte = false;
        int nouvelEmplacementCurseur = 0;

        while (!saisieCorrecte) {
            System.out.println("A quelle indice souhaitez vous placer le curseur ?");
            nouvelEmplacementCurseur = intScanner.nextInt();
            saisieCorrecte = (0 <= nouvelEmplacementCurseur) && (nouvelEmplacementCurseur <= this.zoneDeTravail.getLongeurTexte());
            if (!saisieCorrecte) {
                System.out.println("Attention : l'indice du curseur doit être entre 0 et " + this.zoneDeTravail.getLongeurTexte() + " !");
            }
        }

        Commande changerEmplacementCurseur = new ChangerEmplacementCurseur(nouvelEmplacementCurseur);
        changerEmplacementCurseur.execute(zoneDeTravail);

    }

    private void afficherZoneDeTravail() {
        System.out.println("-----Espace de Travail-----");
        System.out.println(this.zoneDeTravail.getTexteSaisie());
        System.out.println("-----Informations sur l'espace de Travail-----");
        System.out.println("Position curseur : " + this.zoneDeTravail.getCurseur());
        System.out.println("Taille du texte : " + this.zoneDeTravail.getLongeurTexte());
        System.out.println("Presse papier : " + this.zoneDeTravail.getPressePapier());
        System.out.println("Position debut selection : " + this.zoneDeTravail.getDebutSelection());
        System.out.println("Position fin selection : " + this.zoneDeTravail.getFinSelection());
        System.out.println("-----Fin de l'espace de travail-----");
    }

    private void afficherMenu() {
        System.out.println("-----Menu-----");
        System.out.println("Taper le numero de la commande souhaitez : ");
        System.out.println("0-Arreter");
        System.out.println("1-Inserer");
        System.out.println("2-Selectionner");
        System.out.println("3-Effacer");
        System.out.println("4-Copier");
        System.out.println("5-Couper");
        System.out.println("6-Coller");
        System.out.println("7-Changer emplacement curseur");
        System.out.println("-----Fin Menu-----");
    }
}