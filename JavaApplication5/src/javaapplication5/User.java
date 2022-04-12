/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;

/**
 *
 * @author Georenz
 */
public class User {
    
    public User (){
    }
    
    
    String Name;
    public void setName(String n){
    Name =n;}
    public String getName(){
        return Name;
    }
    
    String Password;
    public void setPassword(String p){
    Password = p;
            }
    public String getPassword(){
        return Password;
    }
    
    String UserID;
    public void setUserID(String u)
    {
        UserID = u;
    }
    public String getUserID()
    {
        return UserID;
    }
    
    public User(String n, String u) {
        this.setName(n);
        this.setUserID(u);
        //constructor?
    }
    
    void login(){
        //method for logging in here
    }
    
    
}
