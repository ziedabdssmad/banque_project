package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import sample.Comptes.compte;

import java.io.IOException;


public class Controller {

   @FXML
   public void crerCompte(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("crerCompte.fxml"));
         root.getStyleClass().add("sceneCss.css");

       Scene compteScene =new Scene(root,760,650);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(compteScene);
         window.show();
     }
    @FXML
    public void rechercherCompte(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("RechercherCompte/RechercherCompte.fxml"));
        Scene compteScene =new Scene(compte,760,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }
    public void test(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("test.fxml"));
        Scene compteScene =new Scene(compte,500,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }
    @FXML
    public void supprimerController(ActionEvent event) throws IOException {
       Parent compte = FXMLLoader.load(getClass().getResource("SupprimerCompte/SupprimerCompte.fxml"));
       Scene compteScene =new Scene(compte,760,500);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       window.setScene(compteScene);
       window.show();
    }
    @FXML
    public void AfficherController(ActionEvent event) throws IOException {
        Parent compte = FXMLLoader.load(getClass().getResource("AfficherCompte/AfficherCompte.fxml"));
        Scene compteScene =new Scene(compte,760,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(compteScene);
        window.show();
    }


}
