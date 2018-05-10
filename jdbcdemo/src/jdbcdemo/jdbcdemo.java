package jdbcdemo;

import java.sql.*;
import java.util.Scanner;

public class jdbcdemo {

	private static Scanner eingabe;

	public static void main(String[] args) {
		
		eingabe = new Scanner(System.in);
		System.out.println("Geben Sie das Passwort für die Datenbank an:");
		String passwort = eingabe.nextLine();
		
		
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blabla?useSSL=true", "root", passwort);
			
			Statement myStmt = myConn.createStatement();
			
			String sql = "insert into benutzer" + "(vorname, nachname, email)" + "values('Marven', 'Molitor', 'marv@kack.com')";
			myStmt.executeUpdate(sql);
			
			ResultSet myRs = myStmt.executeQuery("select * from benutzer");
			
			while(myRs.next()) {
				
				System.out.println(myRs.getString("vorname") + "," + myRs.getString("nachname"));
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		
		}

	}

}
