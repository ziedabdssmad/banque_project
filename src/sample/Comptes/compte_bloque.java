package sample.Comptes;

import sample.ConnectionBD.ConnectionClass;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class compte_bloque extends compte {
	private long cin;
	private String nom;
	private String prenom;
	private String date_de_naissance;
	private String adresse;
    private String date_de_debloquage;
    private float taux_interets;
   /* public compte_bloque(long a, double b,long c,String d,String e,String f,String g,String h) {
    	super(a, b);
    	cin=c;
    	nom=d;
    	prenom=e;
    	date_de_naissance=f;
    	adresse=g;
    	date_de_debloquage=h;
        taux_interets=(float) 0.02;
	
    }*/
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

	public void setTaux_interets(float taux_interets) {
		this.taux_interets = taux_interets;
	}

	public float getTaux_interets() {
		return taux_interets;

	}

	public String getAdresse() {
		return adresse;

	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getDate_de_debloquage() {
		return date_de_debloquage;
	}
	public void setDate_de_debloquage(String date_de_debloquage) {
		this.date_de_debloquage = date_de_debloquage;
	}

	public void ajouterToBase() throws SQLException, ClassNotFoundException {
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		Statement statement = connection.createStatement();
		String sql="INSERT INTO compte_bloque(Numero_compte,nom,prenom,Adresse,Date_De_Naissance,Somme_initiale,cin,taux_interets,date_de_debloquage) VALUES('"+this.Numero_compte()+"','"+this.getNom()+"','"+this.getPrenom()+"','"+this.getAdresse()+"','"+this.getDate_de_naissance()+"','"+this.getSomme_initiale()+"','"+this.getCin()+"','"+this.getTaux_interets()+"','"+this.getDate_de_debloquage()+"')";
		statement.executeUpdate(sql);

	}




}
