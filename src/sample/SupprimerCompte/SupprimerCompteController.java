package sample.SupprimerCompte;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Comptes.compte_epargne;
import sample.ConnectionBD.ConnectionClass;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SupprimerCompteController {
    @FXML
    public void GoBack(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("../sample.fxml"));
        Scene mainScene =new Scene(main,760,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }
    @FXML
    MenuButton choix;
    @FXML
    TextField cin;
    @FXML
    Label labelCin;



    public void EpargneValidation(){
        choix.setText("Compte Epargne");
    }
    public void ProValidation(){
        choix.setText("Compte Professionel");
        labelCin.setText("Nom de la societé");

    }
    public void BloqueValidation(){
        choix.setText("Compte Bloque");
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

    public void supprimerEpargne()throws SQLException, ClassNotFoundException{
        long number = new Long(cin.getText()).longValue();
        long cin1=number;
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="DELETE FROM compte_epargne WHERE cin='"+cin1+"'";
        statement.executeUpdate(sql2);
    }
    public void supprimerBloque()throws SQLException, ClassNotFoundException{
        long number = new Long(cin.getText()).longValue();
        long cin1=number;
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="DELETE FROM compte_bloque WHERE cin='"+cin1+"'";
        statement.executeUpdate(sql2);
    }
    public void supprimerPro()throws SQLException, ClassNotFoundException{
        String nom = cin.getText();
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="DELETE FROM compte_professionnel WHERE nom_societe='"+nom+"'";
        statement.executeUpdate(sql2);
    }
    /*
    public void supprimerJoint()throws SQLException, ClassNotFoundException{
        long number = new Long(cin.getText()).longValue();
        long cin1=number;
        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="DELETE FROM compte_joint WHERE cin='"+cin1+"'";
        statement.executeUpdate(sql2);
    }*/


    @FXML
    private void Valider(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        if (getValidation()=="Compte Epargne"){
            supprimerEpargne();
        }
        if (getValidation()=="Compte Bloque"){
            supprimerBloque();
        }
        if (getValidation()=="Compte Professionel"){
            supprimerPro();
        }

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("supprimerCompteModel.fxml"));
        stage.setScene(new Scene(root,500,90));
        stage.setTitle("Suppression avec succés");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(((Node)event.getSource()).getScene().getWindow() );
        stage.show();

    }

}
