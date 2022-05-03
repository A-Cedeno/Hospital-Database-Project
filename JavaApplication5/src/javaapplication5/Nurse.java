/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alana
 */
public class Nurse extends javax.swing.JFrame {

    /**
     * Creates new form Nurse
     */
    public Nurse() throws SQLException, ParseException {
        initComponents();
        setList();
    }


    public void setList() throws SQLException
    {
        azure db = new azure();
        //DefaultListModel empty = new DefaultListModel();
        //jList6.setModel(empty);
        ViewPatient viewPatient = new ViewPatient();
        
        DefaultListModel tempList = viewPatient.setPatient(); 
        DefaultListModel temp = new DefaultListModel();
        db.connect();
        //If the nurse has already filled in the information of a patient and set a decision on whether they should be admitted or not, that patient no longer appears
        /*
        for(int i = 0; i < 2; i++)
        {
            //System.out.println("length of temp list: " + tempList.size());
            System.out.println("items in temp list: " + tempList);
            String[] names = (tempList.get(i)).toString().split("[^A-Za-z]+");
            String firstName = names[0];
            System.out.println(firstName);
            String lastName = names[1];
            System.out.println(lastName);

            
            ResultSet patientInfo = db.getPatientByName(firstName, lastName);
            localPatientID = patientInfo.getInt(1);
            
            if (db.getVisit(localPatientID) != null)
            {
                System.out.println("Removing: " + firstName);
                tempList.remove(i);
            }
        }
        */

        Object[] patientNames = tempList.toArray();
        int count = tempList.size();
        for(int i = 0; i < count; i++)
        {
            //System.out.println("length of temp list: " + tempList.size());
            System.out.println("items in temp list: " + tempList);
            String[] names = (patientNames[i]).toString().split("[^A-Za-z]+");
            String firstName = names[0];
            System.out.println(firstName);
            String lastName = names[1];
            System.out.println(lastName);

            
            ResultSet patientInfo = db.getPatientByName(firstName, lastName);
            localPatientID = patientInfo.getInt(1);
            
            if (db.getVisit(localPatientID) != null)
            {
                System.out.println("Removing: " + firstName);
            }
            else 
            {
                temp.addElement(firstName + " " + lastName);
            }
        }

        db.close();

        //jList6.setModel(tempList);
        if(temp.isEmpty())
        {
            temp.addElement("No current patients to service");
            jList6.setModel(temp);
        }
        else
        {
            jList6.setModel(temp);
        }

        ListSelectionListener ltd = new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent listSelection)
            {
                boolean adjust = listSelection.getValueIsAdjusting();
                if(!adjust)
                {
                    JList l = (JList) listSelection.getSource();
                    String selectedValue = l.getSelectedValue().toString();
                    System.out.println("List Selection: " + selectedValue);
                    try
                    {
                        //emptyFields();
                        setPatient(selectedValue);
                    }
                    catch (Exception e)
                    {
                    }
                }
            }
        };
        jList6.addListSelectionListener(ltd);
    }
    
    public void setPatient(String name) throws SQLException
    {
        String[] names = name.split("[^A-Za-z]+");
        String firstName = names[0];
        System.out.println(firstName);
        String lastName = names[1];
        System.out.println(lastName);

        azure db = new azure();
        db.connect();
        ResultSet patientInfo = db.getPatientByName(firstName, lastName);
        localPatientID = patientInfo.getInt(1);

        /*
        ResultSet visitInfo = db.getVisit(localPatientID);
        if(db.getVisit(localPatientID) == null || (visitInfo.getString("Admittance_Status")).equals("Yes"))
        {
            populateFields(patientInfo);
        }
        */
        try
        {
            System.out.println("In setPatient method of Nurse");
            populateFields(patientInfo);

        }
        catch (Exception e)
        {
        }
        db.close();
    }

    public void populateFields(ResultSet patientInfo) throws SQLException
    {
        FirstName.setText(patientInfo.getString(2).replaceAll("\\s", ""));
        
        LastName.setText(patientInfo.getString(3).replaceAll("\\s", ""));
        DOB.setText(patientInfo.getString(4));
        Gender.setText(patientInfo.getString(5).replaceAll("\\s", ""));

        Ethnicity.setText(patientInfo.getString(12).replaceAll("\\s", ""));
        

        Religion.setText(patientInfo.getString(13).replaceAll("\\s", ""));
        SSN.setText(patientInfo.getString(14).replaceAll("\\s", ""));
        SexuallyActive.setSelectedItem(patientInfo.getString(15).replaceAll("\\s", ""));
        BloodType.setSelectedItem(patientInfo.getString(16).replaceAll("\\s", ""));

        azure db = new azure();
        if (db.getVisit(localPatientID) != null)
        {
            ResultSet visitInfo = db.getVisit(localPatientID);
            Notes.setText(visitInfo.getString(4).replaceAll("\\s" + "\\s", ""));
            BloodPressure.setText(visitInfo.getString(6).replaceAll("\\s", ""));
            HeartRate.setText(visitInfo.getString(7).replaceAll("\\s", ""));
            Height.setText(visitInfo.getString(8).replaceAll("\\s", ""));
            Weight.setText(visitInfo.getString(9).replaceAll("\\s", ""));
            Admit.setSelectedItem(visitInfo.getString(13).replaceAll("\\s", ""));
        }
    }

    public void emptyFields()
    {
        jList6.removeAll();
        FirstName.setText("");
        LastName.setText("");
        DOB.setText("");
        Gender.setText("");
        Ethnicity.setText("");
        Religion.setText("");
        SSN.setText("");
        SexuallyActive.setSelectedItem("Yes");
        BloodType.setSelectedItem("A");
        Notes.setText("");
        BloodPressure.setText("");
        HeartRate.setText("");
        Height.setText("");
        Weight.setText("");
        Admit.setSelectedItem("Yes");
    }

    public String getDate() throws ParseException
    {
        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        SSNLabel = new javax.swing.JLabel();
        DOBLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        ReligionLabel = new javax.swing.JLabel();
        EthnicityLabel = new javax.swing.JLabel();
        GenderLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        SSN = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        Ethnicity = new javax.swing.JTextField();
        Religion = new javax.swing.JTextField();
        Wallpaper = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BloodPressure = new javax.swing.JTextField();
        BloodPressureLabel = new javax.swing.JLabel();
        HeartRateLabel = new javax.swing.JLabel();
        HeartRate = new javax.swing.JTextField();
        HeightLabel = new javax.swing.JLabel();
        WeightLabel = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        Weight = new javax.swing.JTextField();
        BloodType = new javax.swing.JComboBox<>();
        BloodTypeLabel = new javax.swing.JLabel();
        SexuallyActiveLabel = new javax.swing.JLabel();
        SexuallyActive = new javax.swing.JComboBox<>();
        AllergiesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Allergies = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        AdmitLabel = new javax.swing.JLabel();
        JScrollPane = new javax.swing.JScrollPane();
        Notes = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        Admit = new javax.swing.JComboBox<>();
        PatientSelect = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        Submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMinimumSize(new java.awt.Dimension(840, 360));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, -1, -1));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(503, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(360, 190));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 190));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SSNLabel.setText("SSN");
        jPanel1.add(SSNLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 30, 20));

        DOBLabel.setText("D.O.B");
        jPanel1.add(DOBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 10));

        LastNameLabel.setText("Last Name");
        jPanel1.add(LastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, 20));

        ReligionLabel.setText("Religion");
        jPanel1.add(ReligionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        EthnicityLabel.setText("Ethinicity");
        jPanel1.add(EthnicityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        FirstNameLabel.setText("First Name");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        LastName.setEditable(false);
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, -1));

        SSN.setEditable(false);
        jPanel1.add(SSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 100, -1));

        FirstName.setEditable(false);
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 100, -1));

        DOB.setEditable(false);
        DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBActionPerformed(evt);
            }
        });
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 100, -1));

        Gender.setEditable(false);
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, -1));

        Ethnicity.setEditable(false);
        Ethnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthnicityActionPerformed(evt);
            }
        });
        jPanel1.add(Ethnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, -1));

        Religion.setEditable(false);
        Religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReligionActionPerformed(evt);
            }
        });
        jPanel1.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 100, -1));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray 2.jpg"))); // NOI18N
        Wallpaper.setText("jLabel15");
        jPanel1.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 330));

        jTabbedPane1.addTab("Personal Information", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(BloodPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 90, -1));

        BloodPressureLabel.setText("Blood Pressure");
        jPanel2.add(BloodPressureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        HeartRateLabel.setText("Heart rate");
        jPanel2.add(HeartRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jPanel2.add(HeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 90, -1));

        HeightLabel.setText("Height (ft)");
        jPanel2.add(HeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        WeightLabel.setText("Weight (kg)");
        jPanel2.add(WeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        Height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeightActionPerformed(evt);
            }
        });
        jPanel2.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, -1));
        jPanel2.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 90, -1));

        BloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-" }));
        jPanel2.add(BloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        BloodTypeLabel.setText("Blood Type");
        jPanel2.add(BloodTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        SexuallyActiveLabel.setText("Sexually Active?");
        jPanel2.add(SexuallyActiveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        SexuallyActive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        SexuallyActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexuallyActiveActionPerformed(evt);
            }
        });
        jPanel2.add(SexuallyActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 90, 20));

        AllergiesLabel.setText("Allergies");
        jPanel2.add(AllergiesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        Allergies.setColumns(20);
        Allergies.setLineWrap(true);
        Allergies.setRows(5);
        jScrollPane1.setViewportView(Allergies);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 270, 140));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray 2.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 320));

        jTabbedPane1.addTab("Vitals", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 350));

        AdmitLabel.setText("Admit the patient?");
        getContentPane().add(AdmitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, -1, -1));

        Notes.setColumns(20);
        Notes.setLineWrap(true);
        Notes.setRows(5);
        JScrollPane.setViewportView(Notes);

        getContentPane().add(JScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 280, 100));

        jLabel12.setText("Notes");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        Admit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        Admit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdmitActionPerformed(evt);
            }
        });
        getContentPane().add(Admit, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, 100, -1));

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "John Doe", "Jane Doe" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PatientSelect.setViewportView(jList6);

        getContentPane().add(PatientSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 50, 120, 90));

        Submit.setBackground(new java.awt.Color(255, 255, 255));
        Submit.setText("Submit");
        Submit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SubmitMouseClicked(evt);
            }
        });
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });
        getContentPane().add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 70, 20));

        jLabel1.setText("Select Patient");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 6.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, -10, 170, 360));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 300, 300));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 300, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void SexuallyActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexuallyActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SexuallyActiveActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBActionPerformed

    private void SubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMouseClicked

    }//GEN-LAST:event_SubmitMouseClicked

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
           System.out.println("submit button pushed");
       azure db = new azure();
        db.connect(); 
          localBloodPressure = (String) BloodPressure.getText();
          localHeartRate = (String) HeartRate.getText();
          //localBloodType = (String) BloodType.getSelectedItem();
          //localFirstName = FirstName.getText();
          //localLastName = LastName.getText();
          //localSexuallyActive = (String) SexuallyActive.getSelectedItem();
          localHeight = (String) Height.getText();
          localWeight = (String) Weight.getText();
          //localGender = (String) Gender.getText();
          //localReligion = (String) Religion.getText();
          //localEthnicity = (String) Ethnicity.getText();
          //localDOB = DOB.getText();
          //localSSN = SSN.getText();
          //localAllergies = Allergies.getText();
          localNotes = (String) Notes.getText();
        localAdmittance = (String) Admit.getSelectedItem();
        
        //if a patient already has an exisiting visit record that is not discharged, modify the record instead. Otherwise, create a new record for that patient
        //this will require that the information not directly controlled by nurse will need to be obtained from db and then saved back in there
        if (db.getVisit(localPatientID) != null)
        {
            //add modify visit method here, which still requires implementation in azure.java
            //ResultSet visitInfo = db.getVisit(localPatientID);
            
        }
        else 
        {
            
            
            ArrayList<String> localPatientInfo = new ArrayList<String>();
            //localPatientInfo.add(localPatientID);
            //need to grab what's there and save it there again
            localPatientInfo.add("");
            //nurse specific notes
            localPatientInfo.add(localNotes);
            //discharge instructions, must be resaved
            localPatientInfo.add("");
            localPatientInfo.add(localBloodPressure);
            localPatientInfo.add(localHeartRate);
            localPatientInfo.add(localHeight);
            localPatientInfo.add(localWeight);
            //local diagnosis, must be resaved
            localPatientInfo.add("");
            //local prescriptions, must be resaved
            localPatientInfo.add("");
            //local tests, must be resaved
            localPatientInfo.add("");
            localPatientInfo.add(localAdmittance);
            //addmitance date
            try
            {
                localPatientInfo.add(getDate());
            }
            catch(Exception e)
            {
            }
            //discharge date
            localPatientInfo.add("");
            //discharge Status 
            localPatientInfo.add("");
            //localPatientInfo.add(localNotes);
            //doctor note, must be resaved
            localPatientInfo.add("");
            db.setVisit(localPatientID, localPatientInfo);
        }
            /*
            if(localPatientID == -1) System.out.println("Error! Must select a patient before submitting visit records!"); //add handling here in ui
            if (db.getVisit(localPatientID) != null)
            {
                //add modify visit method here, which still requires implementation in azure.java
                //ResultSet visitInfo = db.getVisit(localPatientID);
            }
            else
            {
                db.setVisit(localPatientID, localPatientInfo);
            }
            */
        //Random patientID = new Random();
    //    localPatientInfo.add (localFirstName, localLastName, localAddress, localDOB, localGender, localPrimaryPhysician, localHealthInsurance, localCovidVaccine, localSecondaryPhone, localAllergies, localMedicalCondition, localEthnicity,localReligion,localSSN, localSexuallyActive,localBloodType);
        //db.setPatient(patientID.nextInt(),localPatientInfo);
       
        try
        {    
            db.close();  
            emptyFields();
            setList(); 
        }
        catch (Exception e)
        {
        }
    
    
           
    }//GEN-LAST:event_SubmitActionPerformed

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeightActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GenderActionPerformed

    private void EthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthnicityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EthnicityActionPerformed

    private void ReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReligionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReligionActionPerformed

    private void AdmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdmitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdmitActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nurse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {                   
                    new Nurse().setVisible(true);
                    
                }
                catch (Exception E)
                {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Admit;
    private javax.swing.JLabel AdmitLabel;
    private javax.swing.JTextArea Allergies;
    private javax.swing.JLabel AllergiesLabel;
    private javax.swing.JTextField BloodPressure;
    private javax.swing.JLabel BloodPressureLabel;
    private javax.swing.JComboBox<String> BloodType;
    private javax.swing.JLabel BloodTypeLabel;
    private javax.swing.JTextField DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JTextField Ethnicity;
    private javax.swing.JLabel EthnicityLabel;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField Gender;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JTextField HeartRate;
    private javax.swing.JLabel HeartRateLabel;
    private javax.swing.JTextField Height;
    private javax.swing.JLabel HeightLabel;
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JTextArea Notes;
    private javax.swing.JScrollPane PatientSelect;
    private javax.swing.JTextField Religion;
    private javax.swing.JLabel ReligionLabel;
    private javax.swing.JTextField SSN;
    private javax.swing.JLabel SSNLabel;
    private javax.swing.JComboBox<String> SexuallyActive;
    private javax.swing.JLabel SexuallyActiveLabel;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
private String localSexuallyActive;
    private String localHeight;
    private String localWeight;
    private String localGender;
    private String localReligion;
    private String localFirstName;
    private String localLastName;
    private String localEthnicity;
    private String localDOB;
    private String localSSN;
    private String localAllergies;
    private String localBloodType;
    private String localBloodPressure;
    private String localHeartRate;
    private String localNotes;
    private int localPatientID = -1;
    private String localAdmittance;
}
