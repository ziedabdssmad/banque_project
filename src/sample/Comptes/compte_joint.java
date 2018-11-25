package sample.Comptes;

import sample.ConnectionBD.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class compte_joint extends compte {
/*	public compte_joint(long a, double b,long c,String d,String e,String f,String g,long c1,String d1,String e1,String f1,String g1) {
		super(a, b);
		cin1=c;
		nom1=d;
		prenom1=e;
		date_de_naissance1=f;
		adresse1=g;
		cin2=c1;
		nom2=d1;
		prenom2=e1;
		date_de_naissance2=f1;
		adresse2=g1;
	
	}*/
	private long cin1;
	private String nom1;
	private String prenom1;
	private String date_de_naissance1;
	private String adresse1;
	private long cin2;
	private String nom2;
	private String prenom2;
	private String date_de_naissance2;
	private String adresse2;
	public long getCin1() {
		return cin1;
	}
	public void setCin1(long cin1) {
		this.cin1 = cin1;
	}
	public String getNom1() {
		return nom1;
	}
	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}
	public String getPrenom1() {
		return prenom1;
	}
	public void setPrenom1(String prenom1) {
		this.prenom1 = prenom1;
	}
	public String getDate_de_naissance1() {
		return date_de_naissance1;
	}
	public void setDate_de_naissance1(String date_de_naissance1) {
		this.date_de_naissance1 = date_de_naissance1;
	}
	public String getAdresse1() {
		return adresse1;
	}
	public void setAdresse1(String adresse1) {
		this.adresse1 = adresse1;
	}
	public long getCin2() {
		return cin2;
	}
	public void setCin2(long cin2) {
		this.cin2 = cin2;
	}
	public String getNom2() {
		return nom2;
	}
	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}
	public String getPrenom2() {
		return prenom2;
	}
	public void setPrenom2(String prenom2) {
		this.prenom2 = prenom2;
	}
	public String getDate_de_naissance2() {
		return date_de_naissance2;
	}
	public void setDate_de_naissance2(String date_de_naissance2) {
		this.date_de_naissance2 = date_de_naissance2;
	}
	public String getAdresse2() {
		return adresse2;
	}
	public void setAdresse2(String adresse2) {
		this.adresse2 = adresse2;
	}

	public void ajouterToBase() throws SQLException, ClassNotFoundException {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		Statement statement = connection.createStatement();
		String sql="INSERT INTO compte_joint(Numero_compte,nom,prenom,Adresse,Date_De_Naissance,Somme_initiale,cin,nom2,prenom2,Adresse2,Date_De_Naissance2,cin2) VALUES('"+this.Numero_compte()+"','"+this.getNom1()+"','"+this.getPrenom1()+"','"+this.getAdresse1()+"','"+this.getDate_de_naissance1()+"','"+this.getSomme_initiale()+"','"+this.getCin1()+"','"+this.getNom2()+"','"+this.getPrenom2()+"','"+this.getAdresse2()+"','"+this.getDate_de_naissance2()+"','"+this.getCin2()+"')";
		statement.executeUpdate(sql);

	}



}
