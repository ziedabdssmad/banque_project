package sample.RechercherCompte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Comptes.compte_epargne;
import sample.ConnectionBD.ConnectionClass;

import java.io.IOException;


import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RechercherCompteController {
     @FXML Label newNom;
    @FXML Label newPrenom;
    @FXML Label newCin;
    @FXML Label newAdresse;
    @FXML Label newNumCompte;
    @FXML Label newDate;
    @FXML Label newMontant;

    @FXML Label Nom;
    @FXML Label Prenom;
    @FXML Label Cin;
    @FXML Label Adresse;
    @FXML Label Date;
    @FXML Label Montant;
    @FXML Label TapezCin;

    public void setLabels(){
        Nom.setText("Nom");
        Prenom.setText("Prenom");
        Cin.setText("Cin");
        Adresse.setText("Adresse");
        Date.setText("Date");
        Montant.setText("Montant");
        TapezCin.setText("Compte Numero");
    }


    public void GoBack(ActionEvent event) throws IOException {
    Parent main = FXMLLoader.load(getClass().getResource("../sample.fxml"));
    Scene mainScene =new Scene(main,600,500);
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(mainScene);
    window.show();
    }

    @FXML MenuButton choix;
    @FXML TextField cin;
    @FXML Label labelCin;
    String nomTable;
    Parent scene;

    public void EpargneValidation(){
        choix.setText("Compte Epargne");
    }
    public void ProValidation(){
        choix.setText("Compte Professionel");
    }
    public void BloqueValidation(){
        choix.setText("Compte Bloque");
    }
    public void JointValidation(){
        choix.setText("Compte Joint");
    }

    public void getScene()throws IOException {
        if (choix.getText()=="Compte Epargne"){
            scene = FXMLLoader.load(getClass().getResource("AfficherCompteEpargne.fxml"));
        }
        if (choix.getText()=="Compte Professionnel"){
            Parent scene = FXMLLoader.load(getClass().getResource("../AfficherCompte/AfficherCompteProfessionnel.fxml"));
        }
        if (choix.getText()=="Compte Bloque"){
            Parent scene = FXMLLoader.load(getClass().getResource("../AfficherCompte/AfficherCompteBloque.fxml"));
        }
        if (choix.getText()=="Compte Joint"){
            Parent scene = FXMLLoader.load(getClass().getResource("../AfficherCompte/AfficherCompteJoint.fxml"));
        }
    }

    @FXML
    public void getInfoEpargne()throws SQLException, ClassNotFoundException{

    long number = new Long(cin.getText()).longValue();
    long cin1=number;

         compte_epargne Compte_Epargne = new compte_epargne();
         Compte_Epargne.setCin(cin1);
         System.out.println(Compte_Epargne);
         String sql2;
         ConnectionClass connectionClass = new ConnectionClass();
         Connection connection= connectionClass.getConnection();
         Statement statement = connection.createStatement();
         sql2="SELECT * FROM compte_epargne WHERE cin='"+cin1+"'";
         ResultSet rs = statement.executeQuery(sql2);
         while (rs.next()){
             Compte_Epargne.setCin(rs.getLong("cin"));
             Compte_Epargne.setAdresse(rs.getString("Adresse"));
             Compte_Epargne.setNom(rs.getString("nom"));
             Compte_Epargne.setPrenom(rs.getString("prenom"));
             Compte_Epargne.setDate_de_naissance(rs.getString("Date_De_Naissance"));
             Compte_Epargne.setSomme_initiale(rs.getDouble("Somme_initiale"));
             Compte_Epargne.setNumero_compte(rs.getLong("Numero_compte"));
         }
         Compte_Epargne.afficher();
         newNom.setText(Compte_Epargne.getNom());
         newPrenom.setText(Compte_Epargne.getPrenom());
         newCin.setText(Long.toString(Compte_Epargne.getCin()));
         newAdresse.setText(Compte_Epargne.getAdresse());
         newDate.setText(Compte_Epargne.getDate_de_naissance());
         newMontant.setText(Double.toString(Compte_Epargne.getSomme_initiale()));
         newNumCompte.setText(Long.toString(Compte_Epargne.getNumero_compte()));
    }


@FXML
        public void valider(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        getScene();
        getInfoEpargne();
        setLabels();
        choix.setVisible(false);
        cin.setVisible(false);
        labelCin.setVisible(false);
    }
}
