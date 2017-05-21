package ihm;

import commandes.Commande;
import commandes.Effacer;
import commandes.Inserer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import zoneDeTravail.ZoneDeTravail;

public class IHMGraphique extends Application implements IHM {

    private ZoneDeTravail zdt ;
    private TextArea text;

    public IHMGraphique() {
        zdt = ZoneDeTravail.getInstance();
        text = new TextArea();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Editeur de texte");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500, Color.WHITE);
        //-----------------------------------------------------------------------------------
        Label label1 = new Label("Texte:");
        text.setLayoutX(0);
        text.setLayoutY(30);
        text.setPrefSize(300,100);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changerEmplacementCurseur();
            }
        });
        text.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                inserer();
            }
        });
        //----------------------------------------------------------------------------------
        Button coupe = new Button();
        coupe.setLayoutX(700);
        coupe.setLayoutY(280);
        coupe.setText("Couper");
        coupe.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("coupe");
                text.requestFocus();
                System.out.println(text.getSelectedText());
            }
        });
        //----------------------------------------------------------------------------------
        Button copie = new Button();
        copie.setLayoutX(700);
        copie.setLayoutY(400);
        copie.setText("Copier");
        copie.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("copier");
                text.requestFocus();
                System.out.println(text.getSelectedText());
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
                inserer();
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
        root.getChildren().addAll(label1,text);
        root.getChildren().add(coupe);
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

    @Override
    public void lancer() {

    }

    @Override
    public void changerEmplacementCurseur() {
        zdt.setCurseur(text.getCaretPosition());
    }

    @Override
    public void inserer() {
        if(text.getLength() > 0){
            Character current = text.getText().charAt(text.getCaretPosition()-1);
            Inserer commande = new Inserer(current+"");
            commande.execute(zdt);
            System.out.println(zdt.getTexteSaisie());
        }

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
}
