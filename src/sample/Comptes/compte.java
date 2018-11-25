package sample.Comptes;

import sample.ConnectionBD.ConnectionClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class compte {
	private long numero_compte;
	private double somme_initiale;

	/*public compte(long a, double b) {
		numero_compte = a;
		somme_initiale = b;
	}*/

	public compte() {

	}


	public void depot(double somme) {
		somme_initiale += somme;
	}

	public void retrait(double somme) {
		somme_initiale -= somme;
	}


	public double getSomme_initiale() {
		return somme_initiale;
	}

	public void setSomme_initiale(double somme_initiale) {
		this.somme_initiale = somme_initiale;
	}

	public long getNumero_compte() {
		return numero_compte;
	}

	public long Numero_compte() throws SQLException, ClassNotFoundException {
		String sql2="";
		ConnectionClass connectionClass = new ConnectionClass();
		Connection connection= connectionClass.getConnection();
		Statement statement = connection.createStatement();
		sql2="SELECT * FROM "+this.getClass().getSimpleName()+" WHERE Numero_compte=(SELECT MAX(Numero_compte) FROM "+this.getClass().getSimpleName()+")";
		ResultSet rs = statement.executeQuery(sql2);
		while (rs.next()){
			numero_compte=rs.getLong("Numero_compte");
		}
		return numero_compte+1 ;
	}


	public void setNumero_compte(long num_compte)  {
		this.numero_compte = num_compte;
	}

}