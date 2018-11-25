package sample.AfficherCompte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
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

public class AfficherCompteController implements Initializable {

    @FXML TableView<compte_epargne> tableview;
    @FXML TableColumn<compte_epargne,Long> Numero_compte ;
    @FXML TableColumn<compte_epargne,String> Nom ;
    @FXML TableColumn<compte_epargne,String> Prenom ;
    @FXML TableColumn<compte_epargne,String> Adresse ;
    @FXML TableColumn<compte_epargne,Double> Montant ;
    @FXML TableColumn<compte_epargne,Long> Cin ;
    @FXML TableColumn<compte_epargne,String> Date;

    public void GoBack(ActionEvent event) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("../crerCompte.fxml"));
        Scene mainScene =new Scene(main,760,500);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @FXML
    public void getInfoEpargne()throws SQLException, ClassNotFoundException{

        String sql2;
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection= connectionClass.getConnection();
        Statement statement = connection.createStatement();
        sql2="SELECT * FROM compte_epargne";
        ResultSet rs = statement.executeQuery(sql2);
        ObservableList<compte_epargne> comptes;
        comptes = FXCollections.observableArrayList();
        while (rs.next()){
            compte_epargne Compte_Epargne = new compte_epargne();
            Compte_Epargne.setCin(rs.getLong("cin"));
                Compte_Epargne.setAdresse(rs.getString("Adresse"));
                Compte_Epargne.setNom(rs.getString("nom"));
                Compte_Epargne.setPrenom(rs.getString("prenom"));
                Compte_Epargne.setDate_de_naissance(rs.getString("Date_De_Naissance"));
                Compte_Epargne.setSomme_initiale(rs.getDouble("Somme_initiale"));
                Compte_Epargne.setNumero_compte(rs.getLong("Numero_compte"));
                comptes.add(Compte_Epargne);
        }

for (int i=0;i<comptes.size();i++) {
    Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
    Prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
    Adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
    Montant.setCellValueFactory(new PropertyValueFactory<>("somme_initiale"));
    Date.setCellValueFactory(new PropertyValueFactory<>("date_de_naissance"));
    Cin.setCellValueFactory(new PropertyValueFactory<>("cin"));
    Numero_compte.setCellValueFactory(new PropertyValueFactory<>("numero_compte"));
    tableview.setItems(comptes);
        }
    }

    public void Valider() throws SQLException, ClassNotFoundException {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getInfoEpargne();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

