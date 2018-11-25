package sample.AjouterCompte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Comptes.compte_epargne;
//import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class CompteEpargneController {

    @FXML TextField nom;
    @FXML TextField prenom;
    @FXML TextField cin;
    @FXML Slider montantInitiale;
    @FXML DatePicker dateDeNaissance;
    @FXML TextField adresse;
@FXML
    public void AjouterCompte() throws SQLException, ClassNotFoundException {
      compte_epargne Compte_epargne = new compte_epargne();
        Compte_epargne.setNom(nom.getText());
        Compte_epargne.setPrenom(prenom.getText());
        String date = dateDeNaissance.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Compte_epargne.setDate_de_naissance(date);

        long number = new Long(cin.getText()).longValue();
        Compte_epargne.setCin(number);
        Compte_epargne.setAdresse(adresse.getText());
        Compte_epargne.setSomme_initiale(montantInitiale.getValue());
        Compte_epargne.afficher();
        Compte_epargne.ajouterToBase();

}

@FXML
    public void GoBack(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("../crerCompte.fxml"));
        Scene mainScene =new Scene(main,760,600);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @FXML
    private void valider(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        /*compte_epargne Compte_epargne = new compte_epargne();
        Compte_epargne.setNom(nom.getText());
        Compte_epargne.setPrenom(prenom.getText());*/
        //
        //System.out.print(nom.getText());
       Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CompteEpargneModel.fxml"));
        stage.setScene(new Scene(root,500,90));
        stage.setTitle("Inscription avec succés");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();
        AjouterCompte();

    }
}
