package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tp10.ecole.Ecole;
import tp10.ecole.Onglets;
import java.io.IOException;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Onglets onglets = new Onglets();

        VBox vBox = new VBox(onglets.onglets());
        Scene scene = new Scene(vBox, 1280, 960);

        primaryStage.setScene(scene);
        primaryStage.setTitle("ISEN Java TP_10");


        primaryStage.show();
    }

    public static void main(String[] args) throws IOException {
        Ecole monEcole = new Ecole();
        monEcole.createJsonFile();
        launch(args);
    }


}
