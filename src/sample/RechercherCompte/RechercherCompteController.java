package sample.RechercherCompte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Comptes.compte_bloque;
import sample.Comptes.compte_epargne;
import sample.Comptes.compte_professionnel;
import sample.ConnectionBD.ConnectionClass;

import java.io.IOException;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RechercherCompteController {
     @FXML Label newNom;
    @FXML Label newPrenom;
    @FXML Label newCin;
    @FXML Label newAdresse;
    @FXML Label newNumCompte;
    @FXML Label newDate;
    @FXML Label newMontant;
    @FXML Label newDateDebloquage;
    @FXML Label newTauxInteret;

    @FXML Label Nom;
    @FXML Label Prenom;
    @FXML Label Cin;
    @FXML Label Adresse;
    @FXML Label Date;
    @FXML Label Montant;
    @FXML Label TapezCin;
    @FXML Label DateDébloquage;
    @FXML Label  TauxInteret;


    public void setLabelsEpargne(){
        Nom.setText("Nom");
        Prenom.setText("Prenom");
        Cin.setText("Cin");
        Adresse.setText("Adresse");
        Date.setText("Date De Naissance");
        Montant.setText("Montant");
        TapezCin.setText("Compte Numero");
    }
    public void setLabelsBloque(){
        Nom.setText("Nom");
        Prenom.setText("Prenom");
        Cin.setText("Cin");
        Adresse.setText("Adresse");
        Date.setText("Date De Naissance");
        Montant.setText("Montant");
        TapezCin.setText("Compte Numero");
        DateDébloquage.setText("Date De Débloquage");
        TauxInteret.setText("Taux d'interet");

    }
    public void setLabelsPro(){
        Nom.setText("Nom Societé");
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
        labelCin.setText("Nom de la societé");
    }
    public void BloqueValidation(){
        choix.setText("Compte Bloque");
        System.out.print("Choix bloque !");
    }
    public void JointValidation(){
        choix.setText("Compte Joint");
    }

    public String getValidation(){
        String x="";
        if (choix.getText()=="Compte Epargne") {x="Compte Epargne";}
        if (choix.getText()=="Compte Bloque") {x="Compte Bloque";}
        if (choix.getText()=="Compte Professionel") {x="Compte Professionel";}
        if (choix.getText()=="Compte Joint") {x="Compte Joint";}
        return x;
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
         newNom.setText(Compte_Epargne.getNom());
         newPrenom.setText(Compte_Epargne.getPrenom());
         newCin.setText(Long.toString(Compte_Epargne.getCin()));
         newAdresse.setText(Compte_Epargne.getAdresse());
         newDate.setText(Compte_Epargne.getDate_de_naissance());
         newMontant.setText(Double.toString(Compte_Epargne.getSomme_initiale()));
         newNumCompte.setText(Long.toString(Compte_Epargne.getNumero_compte()));
    }

    public void getInfoBloque()throws SQLException, ClassNotFoundException{

        long number = new Long(cin.getText()).longValue();
        long cin1=number;

        compte_bloque Compte_Bloque = new compte_bloque();
        Compte_Bloque.setCin(cin1);
        System.out.println(Compte_Bloque);
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="SELECT * FROM compte_bloque WHERE cin='"+cin1+"'";
        ResultSet rs = statement.executeQuery(sql2);
        while (rs.next()){
            Compte_Bloque.setCin(rs.getLong("cin"));
            Compte_Bloque.setAdresse(rs.getString("Adresse"));
            Compte_Bloque.setNom(rs.getString("nom"));
            Compte_Bloque.setPrenom(rs.getString("prenom"));
            Compte_Bloque.setDate_de_naissance(rs.getString("Date_De_Naissance"));
            Compte_Bloque.setSomme_initiale(rs.getDouble("Somme_initiale"));
            Compte_Bloque.setNumero_compte(rs.getLong("Numero_compte"));
            Compte_Bloque.setDate_de_debloquage(rs.getString("date_de_debloquage"));
            Compte_Bloque.setTaux_interets(rs.getFloat("taux_interets"));
        }
        newNom.setText(Compte_Bloque.getNom());
        newPrenom.setText(Compte_Bloque.getPrenom());
        newCin.setText(Long.toString(Compte_Bloque.getCin()));
        newAdresse.setText(Compte_Bloque.getAdresse());
        newDate.setText(Compte_Bloque.getDate_de_naissance());
        newMontant.setText(Double.toString(Compte_Bloque.getSomme_initiale()));
        newNumCompte.setText(Long.toString(Compte_Bloque.getNumero_compte()));
        newDateDebloquage.setText(Compte_Bloque.getDate_de_debloquage());
        newTauxInteret.setText(Float.toString(Compte_Bloque.getTaux_interets()));

    }

    public void getInfoPro()throws SQLException, ClassNotFoundException{

        String nom = cin.getText();
        System.out.print(nom);

        compte_professionnel Compte_Pro= new compte_professionnel();
        Compte_Pro.setNom_societe(nom);
        //System.out.println(Compte_Epargne);
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="SELECT * FROM compte_professionnel WHERE nom_societe='"+nom+"'";
        ResultSet rs = statement.executeQuery(sql2);
        while (rs.next()){
            Compte_Pro.setNom_societe(rs.getString("nom_societe"));
            Compte_Pro.setSomme_initiale(rs.getDouble("Somme_initiale"));
            Compte_Pro.setNumero_compte(rs.getLong("Numero_compte"));
        }
        newNom.setText(Compte_Pro.getNom_societe());
        newMontant.setText(Double.toString(Compte_Pro.getSomme_initiale()));
        newNumCompte.setText(Long.toString(Compte_Pro.getNumero_compte()));
    }
    /*

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
    }*/



    @FXML
        public void valider(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
       // getScene();
        //EpargneValidation();

        System.out.println(choix.getText());

        if (getValidation()=="Compte Epargne"){
            getInfoEpargne();
            setLabelsEpargne();
        }
        if (getValidation()=="Compte Bloque"){
            getInfoBloque();
            setLabelsBloque();
        }
        if (getValidation()=="Compte Professionel"){
            getInfoPro();
            setLabelsPro();
        }
        choix.setVisible(false);
        cin.setVisible(false);
        labelCin.setVisible(false);
    }
}
