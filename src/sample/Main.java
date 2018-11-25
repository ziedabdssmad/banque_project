package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.getStyleClass().add("sceneCss.css");
        // scene.getStylesheets().add("path/stylesheet.css");

        primaryStage.setTitle("Banque");
        primaryStage.setScene(new Scene(root, 750, 605));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
