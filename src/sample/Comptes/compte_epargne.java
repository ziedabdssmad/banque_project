package sample.Comptes;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import sample.ConnectionBD.ConnectionClass;
import sample.RechercherCompte.RechercherCompteController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class compte_epargne extends compte {
private long cin;
private String nom;
private String prenom;
//private String date_de_naissance;
private String adresse;
private String date_de_naissance;
/*
public compte_epargne(long a, double b,long c,String d,String e,String f,String g) {
	super(a, b);
	cin=c;
	nom=d;
	prenom=e;
	date_de_naissance=f;
	adresse=g;
}
*/
	public compte_epargne() {
		super();
	}

	public void afficher() throws SQLException, ClassNotFoundException {
		System.out.println(this.getNom()+" "+this.getPrenom()+" "+this.getNumero_compte());
		//System.out.println(this.getClass());
		//System.out.println(this.getClass().getSimpleName());
	}

	public void ajouterToBase() throws SQLException, ClassNotFoundException {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		Statement statement = connection.createStatement();
		String sql="INSERT INTO compte_epargne(Numero_compte,nom,prenom,Adresse,Date_De_Naissance,Somme_initiale,cin) VALUES('"+this.Numero_compte()+"','"+this.getNom()+"','"+this.getPrenom()+"','"+this.getAdresse()+"','"+this.getDate_de_naissance()+"','"+this.getSomme_initiale()+"','"+this.getCin()+"')";
		statement.executeUpdate(sql);

	}

	public void getCompteEpargne()throws SQLException, ClassNotFoundException {
		RechercherCompteController rechercherCompteController=new RechercherCompteController();
		//long cinNumber=rechercherCompteController.getCin1();
		//this.setCin(cinNumber);
		//System.out.println(cinNumber);
		/*this.setCin(rs.getLong("cin"));
		this.setAdresse(rs.getString("Adresse"));
		this.setNom(rs.getString("nom"));
		this.setPrenom(rs.getString("prenom"));
		this.setDate_de_naissance(rs.getString("Date_De_Naissance"));
		this.setSomme_initiale(rs.getDouble("Somme_initiale"));*/
/*
		String sql2;
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		Statement statement = connection.createStatement();
		sql2="SELECT * FROM compte_epargne WHERE cin='"+cinNumber+"'";
		ResultSet rs = statement.executeQuery(sql2);
		while (rs.next()){
			this.setCin(rs.getLong("cin"));
			this.setAdresse(rs.getString("Adresse"));
			this.setNom(rs.getString("nom"));
			this.setPrenom(rs.getString("prenom"));
			this.setDate_de_naissance(rs.getString("Date_De_Naissance"));
			this.setSomme_initiale(rs.getDouble("Somme_initiale"));
			this.setNumero_compte(rs.getLong("Numero_compte"));
			//=rs.getLong("Numero_compte");
		}*/

	}

public long getCin() {
	return cin;
}

public void setCin(long cin) {
	this.cin = cin;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getDate_de_naissance() {
	return date_de_naissance;
}

public void setDate_de_naissance(String date_de_naissance) {
	this.date_de_naissance = date_de_naissance;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}


}
