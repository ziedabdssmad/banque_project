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
import sample.Comptes.compte_bloque;
import sample.Comptes.compte_epargne;
//import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class CompteBloqueController {

    @FXML TextField nom;
    @FXML TextField prenom;
    @FXML TextField cin;
    @FXML TextField montantInitiale;
    @FXML DatePicker dateDeNaissance;
    @FXML TextField adresse;
    @FXML  DatePicker dateDeDebloquage;
    @FXML TextField taux_interet;
    @FXML
    public void AjouterCompte() throws SQLException, ClassNotFoundException {
        compte_bloque Compte_bloque = new compte_bloque();
        Compte_bloque.setNom(nom.getText());
        Compte_bloque.setPrenom(prenom.getText());
        String date = dateDeNaissance.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Compte_bloque.setDate_de_naissance(date);

        long number = new Long(cin.getText()).longValue();
        Compte_bloque.setCin(number);
        Compte_bloque.setAdresse(adresse.getText());
        double  mont = new Double(montantInitiale.getText()).doubleValue();

        Compte_bloque.setSomme_initiale(mont);
        float num = new Float(taux_interet.getText()).floatValue();
        String date1 = dateDeDebloquage.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Compte_bloque.setDate_de_debloquage(date1);

        Compte_bloque.setTaux_interets(num);

        Compte_bloque.ajouterToBase();

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
