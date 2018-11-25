package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class crerCompteController {


    @FXML
    public void CompteEpargne(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("AjouterCompte/CompteEpargne.fxml"));
        //compte.getStyleClass().add("sceneCss.css");

        Scene compteScene =new Scene(compte,760,650);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }
    @FXML
    public void ComptePro(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("AjouterCompte/ComptePro.fxml"));
        Scene compteScene =new Scene(compte,760,650);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }
    @FXML
    public void CompteBloque(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("AjouterCompte/CompteBloque.fxml"));
        Scene compteScene =new Scene(compte,760,650);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }
    @FXML
    public void CompteJoint(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("AjouterCompte/CompteJoint.fxml"));
        Scene compteScene =new Scene(compte,800,650);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }

    @FXML
    public void GoBack(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene mainScene =new Scene(main,700,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
}
