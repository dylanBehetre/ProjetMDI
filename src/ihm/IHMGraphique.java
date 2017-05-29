package ihm;

import commandes.ChangerEmplacementCurseur;
import commandes.Commande;
import commandes.Copier;
import commandes.Selectionner;
import commandes.commandesMemento.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import memento.CareTaker;
import zoneDeTravail.ZoneDeTravail;
import javafx.embed.swing.JFXPanel;

public class IHMGraphique extends Application implements IHM {

    private ZoneDeTravail zdt ;
    private TextArea text;
    private Character car;
    private boolean bs;
    private CareTaker careTaker;
    final JFXPanel fxPanel = new JFXPanel();//Permet d'initaliser la fenetre
    public IHMGraphique() {
        zdt = ZoneDeTravail.getInstance();
        text = new TextArea();
        car = ' ';
        bs = false;
        careTaker = new CareTaker();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Editeur de texte");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 500, Color.WHITE);
        //-----------------------------------------------------------------------------------
        Label label1 = new Label("Texte:");
        text.setLayoutX(0);
        text.setLayoutY(30);
        text.setPrefSize(700,450);
        text.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                changerEmplacementCurseur();
                selectionner();
            }
        });
        text.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.BACK_SPACE){
                    System.out.println("EffacerIntelligemment");
                    effacer();
                    bs = true;
                }else{
                    bs = false;
                }
            }
        });
        text.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(!bs){
                    car = event.getCharacter().charAt(0);
                    inserer();
                }
            }
        });
        //----------------------------------------------------------------------------------
        Button redo = new Button();
        redo.setLayoutX(700);
        redo.setLayoutY(200);
        redo.setText("Redo");
        redo.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("redo");
                text.requestFocus();
                redo();
                text.setText(zdt.getTexteSaisie());
            }
        });
        //----------------------------------------------------------------------------------
        Button undo = new Button();
        undo.setLayoutX(700);
        undo.setLayoutY(240);
        undo.setText("Undo");
        undo.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("Undo");
                text.requestFocus();
                undo();
                text.setText(zdt.getTexteSaisie());
                System.out.println("taille "+careTaker.getSize());
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
                couper();
                text.setText(zdt.getTexteSaisie());
            }
        });
        //----------------------------------------------------------------------------------
        Button copie = new Button();
        copie.setLayoutX(700);
        copie.setLayoutY(360);
        copie.setText("Copier");
        copie.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                System.out.println("copier");
                text.requestFocus();
                copier();
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
                coller();
                text.setText(zdt.getTexteSaisie());
            }
        });
        //-----------------------------------------------------------------------------------
        root.getChildren().addAll(label1,text,redo,undo);
        root.getChildren().add(coupe);
        root.getChildren().add(colle);
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
        Application.launch();
    }

    @Override
    public void changerEmplacementCurseur() {
        Commande cursor = new ChangerEmplacementCurseur(text.getCaretPosition());
        cursor.execute(zdt);
    }

    @Override
    public void inserer() {
        CommandeMemento commande = new InsererMemento(car + "");
            commande.execute(zdt,careTaker);
            System.out.println(zdt.getTexteSaisie());
    }

    @Override
    public void selectionner() {
        if(text.getSelection().getStart() < text.getSelection().getEnd()){
            Commande selection = new Selectionner(text.getSelection().getStart(),text.getSelection().getEnd());
            selection.execute(zdt);
        }
    }

    @Override
    public void effacer() {
        CommandeMemento effacer = new EffacerMemento();
        effacer.execute(zdt,careTaker);
    }

    @Override
    public void copier() {
        Commande copier = new Copier();
        copier.execute(zdt);
    }

    @Override
    public void couper() {
        CommandeMemento couper = new CouperMemento();
        couper.execute(zdt,careTaker);
    }

    @Override
    public void coller() {
        CommandeMemento coller = new CollerMemento();
        coller.execute(zdt,careTaker);
    }

    public void undo(){
        CommandeMemento undoc = new Undo();
        undoc.execute(zdt,careTaker);
    }

    public void redo(){
        CommandeMemento redoc = new Redo();
        redoc.execute(zdt,careTaker);
    }
}
