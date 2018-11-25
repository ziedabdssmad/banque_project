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
import sample.Comptes.compte_joint;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class CompteJointController {
    @FXML TextField nom;
    @FXML TextField prenom;
    @FXML TextField cin;
    @FXML TextField montantInitiale;
    @FXML DatePicker dateDeNaissance;
    @FXML TextField adresse;
    @FXML TextField nom2;
    @FXML TextField prenom2;
    @FXML TextField cin2;
    @FXML DatePicker dateDeNaissance2;
    @FXML TextField adresse2;

    public void AjouterCompte() throws SQLException, ClassNotFoundException {
        compte_joint Compte_joint = new compte_joint();
        Compte_joint.setNom1(nom.getText());
        Compte_joint.setNom2(nom2.getText());

        Compte_joint.setPrenom1(prenom.getText());
        Compte_joint.setPrenom2(prenom2.getText());

        String date = dateDeNaissance.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Compte_joint.setDate_de_naissance1(date);
        String date2 = dateDeNaissance2.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Compte_joint.setDate_de_naissance2(date2);


        long number = new Long(cin.getText()).longValue();
        Compte_joint.setCin1(number);
        long number2 = new Long(cin2.getText()).longValue();
        Compte_joint.setCin2(number2);

        Compte_joint.setAdresse1(adresse.getText());
        Compte_joint.setAdresse2(adresse2.getText());

        double number3 = new Double(montantInitiale.getText()).doubleValue();

        Compte_joint.setSomme_initiale(number3);
        Compte_joint.ajouterToBase();

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
    public void GoBack(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("../crerCompte.fxml"));
        Scene mainScene =new Scene(main,760,600);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }


}
