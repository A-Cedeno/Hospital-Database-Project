/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author stone
 */
public class DataBase
{   
    static String databaseName = "qacs";
    static String databaseUserName = "root";
    static String databasePassword = "root";
    static Connection con = null;
    static String error = "";
    static String patientTable = "CREATE TABLE Patient (PatientID INT NOT NULL, ";

    public static void main(String args[]) {

    }

    public static void createDatabase() 
    {
        Statement stmt;
        Connection con = null;
        try {
            String MySQLURL = "jdbc:mysql://localhost:3306/?useSSL=false";
            con = DriverManager.getConnection(MySQLURL, databaseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful!");
                stmt = con.createStatement();
                stmt.executeUpdate("CREATE DATABASE " + databaseName);
            }
        } catch (Exception e) {
            error = e.toString();
        }
    }

    public static void initalizeTables() 
    {
        Statement stmt;
        try 
        {
            if (con != null) 
            {
                System.out.println("Database connection is successful!");
                stmt = con.createStatement();
                stmt.executeUpdate("CREATE DATABASE " + databaseName);
            }
        } catch (Exception e) {
            error = e.toString();
        }
    }

            



}
