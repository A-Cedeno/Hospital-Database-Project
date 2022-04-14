/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;
import java.util.*;
/**
 *
 * @author Georenz
 */
public class PatientCareUser extends User {
    public PatientCareUser(){
    }
    
    void updateDiagnosis(String s, Patient p) {
        p.setDiagnosis(s);
    }
     
     void updateRoomAllotment(String s, Patient p) {
         p.setRoomAllotment(s);
    }
    
    void updatePatientNotes(String s, Patient p) {
        p.setPatientNotes(s);
    }
    
}
