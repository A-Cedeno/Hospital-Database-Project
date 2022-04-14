/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbconnect;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author stone
 */
public class azure 
{
    static String error = "";
    static Connection con = null;


    public static void main(String args[]) throws SQLException
    {   
        
        connect();
        ResultSet list = getPatientList();
        System.out.println(list.getString(2));
        close();

        connect();
        String access = authorize(1083, "pass");
        System.out.println(access);
        close();
        //String access = authorize(1083, "pass");
        connect();
        
        close();

    } 


    public static void connect()
    {
        //buffer.connect();
        try 
        {
            String server = "jdbc:sqlserver://hospital-mangement.database.windows.net:1433;database=Hospital-Mangement;user=dmathieu;password=h$XBKQD5;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            con = DriverManager.getConnection(server);
            if (con != null) {
                System.out.println("Database connection is successful!");
            }

        } catch (Exception e) {
            error = e.toString();
            System.out.println(error);
        }
    }

    public static void close()
    {
        try
        {
            con.close();
        } 
        catch (Exception e) 
        {
            error = e.toString();
        }
        //buffer.disconnect();
    }
        

    public static ResultSet getPatientList()
    {    
        try
        {
            PreparedStatement stmt = con.prepareStatement("Select * FROM Patient");
            ResultSet list = stmt.executeQuery();

            list.next();
            return list;

        } catch (Exception e) {
            error = e.toString();
        }

        return null;
    }

    public static ResultSet getPatientByID(int ID)
    {    
        //connect();

        try
        {
            PreparedStatement stmt = con.prepareStatement("Select * FROM Patient WHERE Patient_ID = ?");
            stmt.setInt(1, ID);
            ResultSet patient = stmt.executeQuery();

            patient.next();
            return patient;

        } catch (Exception e) {
            error = e.toString();
        }

        //close();
        return null;
    }

    public static ResultSet getPatientByName(String firstName, String lastName)
    {    
        //connect();

        try
        {
            PreparedStatement stmt = con.prepareStatement("Select * FROM Patient WHERE First_Name = ? AND Last_Name = ?");
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            ResultSet patient = stmt.executeQuery();

            patient.next();
            return patient;

        } catch (Exception e) {
            error = e.toString();
        }

        //close();
        return null;
    }

    public static ResultSet getVisit(int patientID)
    {    

        try
        {
            PreparedStatement stmt = con.prepareStatement("Select * FROM Visit WHERE Patient_ID = ?");
            stmt.setInt(1, patientID);
            ResultSet visit = stmt.executeQuery();

            visit.next();
            return visit;

        } catch (Exception e) {
            error = e.toString();
        }

        return null;
    }

    public static void setBill(int visitID, int billID, int charge)
    {
        try
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Bill VALUES(?, ?, ?)");
            
            stmt.setInt(1, visitID);
            stmt.setInt(2, billID);
            stmt.setInt(3, charge);
            stmt.executeUpdate();

        } catch (Exception e) {
            error = e.toString();
        }
    }

    //for this method to work, the backend must be packaging the arraylist containing the patient information in the exact same order
    public static void updatePatient(int patientID, ArrayList<String> patientInfo)
    {    
    
        //connect();

        try
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE Patient SET First_Name = ? AND Last_Name = ? AND Address = ? AND Date_of_Birth = ? AND Gender = ? AND Primary_Physician = ? AND Health_Insurance AND Covid_Vaccine AND Emergency_Contact AND Allergies = ? AND Medical_Condition = ? AND Ethnicity = ? AND Religion = ? AND Social_Security = ? AND Sexual_Activity = ? AND Blood_Type = ?");
            
            for(int i = 0; i < patientInfo.size(); i++)
            {
                stmt.setString((i + 1), patientInfo.get(i));
            }
            stmt.executeUpdate();

        } catch (Exception e) {
            error = e.toString();
        }

        //close();
    }
    public static String authorize(int ID, String pass) throws SQLException
    {
        //connect();
        ResultSet user = null;
        String access;
        try
        {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Employee WHERE ID = ? AND Password = ?");
            
            stmt.setInt(1, ID);
            stmt.setString(2, pass);
            user = stmt.executeQuery();
            user.next();
            access = user.getString("Access_Level");
            

        } catch (Exception e) {
            error = e.toString();
            return error;
        }

        //close();

        return access;  
    }
    
    public static void setPatient(int patientID, ArrayList<String> patientInfo)
    {
        try
        {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO Patient VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            for(int i = 0; i < patientInfo.size(); i++)
            {
                stmt.setString((i + 1), patientInfo.get(i));
            }
            stmt.executeUpdate();

        } catch (Exception e) {
            error = e.toString();
        }
        
    }
}
