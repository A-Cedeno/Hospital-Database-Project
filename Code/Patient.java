/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication5;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Georenz
 */
public class Patient {
    public Patient(int id) {
    setPatientID(rs.getINT(0));
    setPatientNotes(rs.getText(0));
    setDischargeInstructions(rs.getText(1));
    setBloodPressure(rs.getNString(0));
    
    }
    
    int PatientID;
    public void setID(int i){
    PatientID = i;
    }
    public int getID(){
    return PatientID;
    }
    
    
    
    String Name;
    public void setName(String n){
        Name = n;
    }
    public String getName(){
    return Name;
    }
    
    String Address;
    public void setAddress(String a){
    Address = a;
    }
    public String getAddress(){
    return Address;
    }
    
    String Symptoms;
    public void setSymptoms(String s){
    Symptoms = s;
    }
    public String getSymptoms(){
    return Symptoms;
    }
    
    String PrimaryCareProvider;
    public void setPrimaryCareProvider(String p){
    PrimaryCareProvider = p;
    }
    public String getPrimaryCareProvider(){
    return PrimaryCareProvider;
    }
    
    String HealthInsurance;
    public void setHealthInsurance(String h){
        HealthInsurance = h;
    }
    public String getHealthInsurance(){
        return HealthInsurance;
    }
    
    Boolean CovidVaccinationStatus;
    public void setCovidVaccinationStatus(boolean b){
        CovidVaccinationStatus = b;
    }
    public boolean getCovidVaccinationStatus(){
    return CovidVaccinationStatus;}
    
    String CovidVaccineType;
    public void setCovidVaccineType(String v){
    CovidVaccineType =  v;
    }
    public String getCovidVaccineType(){
    return CovidVaccineType;
    }
    
    java.util.Date CovidVaccineDate;
    public void setCovidVaccineDate(java.util.Date d){
        CovidVaccineDate = d;
    }
    public java.util.Date getCovidVaccineDate(){
        return CovidVaccineDate;
    }
    
    String EmergencyContactInfo;
    public void setEmergencyContactInfo(String e){
        EmergencyContactInfo = e;
    }
    public String getEmergencyContactInfo(){
        return EmergencyContactInfo;
    }
    
    List <String> ExistingMedicalConditions;
    public void setExistingMedicalConditions(List <String> e){
        ExistingMedicalConditions = e;
    }
    public List <String> getExistingMedicalConditions(){
        return ExistingMedicalConditions;
    }
    
    List <String> Allergies;
    public void setAllergies(List <String> a){
        Allergies = a;
    }
    public List <String> getAllergies(){
        return Allergies;
    }
    
    List <String> Medications;
    public void setMedications (List<String> m){
        Medications = m;
    }
    public List <String> getMedications(){
        return Medications;
    }
    
    String Weight;
    public void setWeight(String w){
        Weight = w;
    }
    public String getWeight(){
        return Weight;
    }
    
    String Height;
        public void setHeight(String h){
        Height = h;
    }
    public String getHeight(){
        return Height;
    }
    
    String Religion;
        public void setReligion(String r){
        Religion = r;
    }
    public String getReligion(){
        return Religion;
    }
    
    String Ethnicity;
        public void setEthnicity(String e){
        Ethnicity = e ;
    }
    public String getEthnicity(){
        return Ethnicity;
    }
    
    
    String Gender;
        public void setGender(String g){
       Gender = g;
    }
    public String getGender(){
        return Gender;
    }
    
    String SSN;
        public void setSSN(String s){
        SSN = s;
    }
    public String getSSN(){
        return SSN;
    }
    
    Boolean SexuallyActive;
    
    String BloodType;
        public void setBloodType(String b){
        BloodType = b;
    }
    public String getBloodType(){
        return BloodType;
    }
    
    String BloodPressure;
    public void setBloodPressure(String bp){
    BloodPressure = bp;
    }
    public String getBloodPressure(){}
    
    
    
    java.util.Date AdmittanceDate;
    public void setAdmittanceDate (java.util.Date d){
    AdmittanceDate = d;}
    public java.util.Date getAdmittanceDate(){
    return AdmittanceDate;
            }
    
    java.util.Date DischargeDate;
    public void setDischargeDate (java.util.Date d){
    DischargeDate = d;}
    public java.util.Date getDischargeDate(){
    return DischargeDate;
    }
    
    Boolean AdmittanceStatus;
    public void setAdmittanceStatus(boolean b){
    AdmittanceStatus = b;
    }
    public Boolean getAdmittanceStatus(){
        return AdmittanceStatus;
    }
    
    String DischargeInstructions;
    public void setDischargeInstructions(String s){
        DischargeInstructions= s;
    }
    public String getDischargeInstructions(){
    return DischargeInstructions;
    }
    
    String Diagnosis;
        public void setDiagnosis(String d){
        Diagnosis = d;
    }
    public String getDiagnosis(){
        return Diagnosis;
    }
    
    String RoomAllotment;
        public void setRoomAllotment(String r){
       RoomAllotment = r;
    }
    public String getRoomAllotment(){
        return RoomAllotment;
    }
    
    
    String PatientNotes;
        public void setPatientNotes(String p){
        PatientNotes = p;
    }
    public String getPatientNotes(){
        return PatientNotes;
    }
    
    String PatientNotesD;
        public void setPatientNotesD(String p){
        PatientNotesD = p;
    }
    public String getPatientNotesD(){
        return PatientNotesD;
    }
    
}
