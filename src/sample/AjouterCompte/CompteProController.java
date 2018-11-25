package sample.AjouterCompte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Comptes.compte_professionnel;
//import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class CompteProController {

    @FXML TextField nom;
    @FXML TextField montantInitiale;

    @FXML
    public void AjouterCompte() throws SQLException, ClassNotFoundException {
        compte_professionnel Compte_pro = new compte_professionnel();
        Compte_pro.setNom_societe(nom.getText());
        //Compte_pro.setNumero_compte(200000000);
        //Compte_pro.setNumCompte();
        double number = new Double(montantInitiale.getText()).doubleValue();

        Compte_pro.setSomme_initiale(number);
        Compte_pro.ajouterToBase();

    }


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
