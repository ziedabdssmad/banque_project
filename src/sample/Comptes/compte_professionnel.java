package sample.Comptes;

import sample.ConnectionBD.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class compte_professionnel extends compte {

private String nom_societe;
/*s
public compte_professionnel(long a, double b,long c) {
	super(a, b);
	nom_societe=c;
}
*/
public compte_professionnel(){super();}
public void ajouterToBase() throws SQLException, ClassNotFoundException {
	ConnectionClass connectionClass = new ConnectionClass();
	Connection connection = connectionClass.getConnection();
	Statement statement = connection.createStatement();
	String sql = "INSERT INTO compte_professionnel(Numero_compte,nom_societe,Somme_initiale) VALUES('" + this.Numero_compte() + "','" + this.getNom_societe() + "','" + this.getSomme_initiale() + "')";
	statement.executeUpdate(sql);
}


public String getNom_societe() {
	return nom_societe;
}



public void setNom_societe(String nom_societe) {
	this.nom_societe = nom_societe;
}


}
