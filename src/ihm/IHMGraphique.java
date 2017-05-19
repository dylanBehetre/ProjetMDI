package ihm;

import javafx.application.Application;
import javafx.stage.Stage;

public class IHMGraphique extends Application implements IHM {

    public IHMGraphique() {
    }

    public void start(Stage primaryStage) throws Exception {
        System.out.println( "Start method inside Thread : " +  Thread.currentThread().getName());
    }


    //Juste pour les tests
    public static void main(String[] args) {
        System.out.println( "Main method inside Thread : " +  Thread.currentThread().getName());
        launch(args);
    }

    public void lancer() {

    }

    public void inserer() {

    }

    public void selectionner() {

    }

    public void effacer() {

    }

    public void copier() {

    }

    public void couper() {

    }

    public void coller() {

    }
}
