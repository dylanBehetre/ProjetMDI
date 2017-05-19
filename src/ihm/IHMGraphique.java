package ihm;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class IHMGraphique extends Application implements IHM {

    public IHMGraphique() {
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Editeur de texte");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500, Color.WHITE);
        //-----------------------------------------------------------------------------------
        Label label1 = new Label("Name:");
        TextField textField = new TextField ();
        textField.setLayoutX(0);
        textField.setLayoutY(300);
        textField.setPrefSize(300,10);
        //----------------------------------------------------------------------------------
        Button copie = new Button();
        copie.setLayoutX(700);
        copie.setLayoutY(400);
        copie.setText("Copier");
        copie.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("copier");
                System.out.println(textField.getCharacters());
            }
        });
        //-----------------------------------------------------------------------------------
        Button insert = new Button();
        insert.setLayoutX(700);
        insert.setLayoutY(360);
        insert.setText("Inserer");
        insert.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("insertion");
            }
        });
        //-----------------------------------------------------------------------------------
        Button colle = new Button();
        colle.setLayoutX(700);
        colle.setLayoutY(320);
        colle.setText("Coller");
        colle.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Coller");
            }
        });
        //-----------------------------------------------------------------------------------
        root.getChildren().addAll(label1,textField);
        root.getChildren().add(colle);
        root.getChildren().add(insert);
        root.getChildren().add(copie);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    //Juste pour les tests
    public static void main(String[] args) {
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
