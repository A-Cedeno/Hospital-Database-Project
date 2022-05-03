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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author alana
 */
public class Doctor extends javax.swing.JFrame {

    /**
     * Creates new form Doctor
     */
    public Doctor() throws SQLException {
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
                System.out.println("in here");
                ResultSet visitInfo = db.getVisit(localPatientID);
                if(visitInfo.getString("Admittance_Status").contains("Yes"))
                {
                    if(visitInfo.getString("Discharge_Status").contains("Yes"))
                    {
                        System.out.println(firstName + " " + lastName + " has already been discharged");
                    }
                    else
                    {
                        System.out.println("In here 2");
                        temp.addElement(firstName + " " + lastName);
                    }
                }
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
        SexuallyActive.setText(patientInfo.getString(15).replaceAll("\\s", ""));
        BloodType.setText(patientInfo.getString(16).replaceAll("\\s", ""));

        azure db = new azure();
        if (db.getVisit(localPatientID) != null)
        {
            ResultSet visitInfo = db.getVisit(localPatientID);
            Notes.setText(visitInfo.getString(4).replaceAll("\\s" + "\\s", ""));
            BloodPressure.setText(visitInfo.getString(6).replaceAll("\\s", ""));
            HeartRate.setText(visitInfo.getString(7).replaceAll("\\s", ""));
            Height.setText(visitInfo.getString(8).replaceAll("\\s", ""));
            Weight.setText(visitInfo.getString(9).replaceAll("\\s", ""));
            SelectedTest.setText(visitInfo.getString(12).replaceAll("\\s" + "\\s", ""));
            SelectedMedication.setText(visitInfo.getString(11).replaceAll("\\s" + "\\s", ""));
            Notes1.setText(visitInfo.getString(17).replaceAll("\\s" + "\\s", ""));
            //Admit.setSelectedItem(visitInfo.getString(13).replaceAll("\\s", ""));
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
        SexuallyActive.setText("Yes");
        BloodType.setText("A");
        Notes.setText("");
        BloodPressure.setText("");
        HeartRate.setText("");
        Height.setText("");
        Weight.setText("");
        //Admit.setSelectedItem("Yes");
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
        SSN = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        LastName = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        Gender = new javax.swing.JTextField();
        Ethnicity = new javax.swing.JTextField();
        Religion = new javax.swing.JTextField();
        Wallpaper3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        BloodPressure = new javax.swing.JTextField();
        BloodPressureLabel = new javax.swing.JLabel();
        HeartRateLabel = new javax.swing.JLabel();
        HeartRate = new javax.swing.JTextField();
        HeightLabel = new javax.swing.JLabel();
        WeightLabel = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        Weight = new javax.swing.JTextField();
        BloodTypeLabel = new javax.swing.JLabel();
        SexuallyActiveLabel = new javax.swing.JLabel();
        AllergiesLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Allergies = new javax.swing.JTextArea();
        SexuallyActive = new javax.swing.JTextField();
        BloodType = new javax.swing.JTextField();
        Wallpaper1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane = new javax.swing.JScrollPane();
        Medication = new javax.swing.JList<>();
        TestLabel = new javax.swing.JLabel();
        MedicationLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        SelectedMedication = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        Test = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        SelectedTest = new javax.swing.JTextArea();
        Wallpaper2 = new javax.swing.JLabel();
        DiagnosisLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Notes = new javax.swing.JTextArea();
        NotesLabel = new javax.swing.JLabel();
        PatientSelect = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        Submit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Diagnosis = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        Notes1 = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Discharge = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMinimumSize(new java.awt.Dimension(870, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setBackground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 280, -1, -1));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(503, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(360, 190));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 190));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SSNLabel.setText("SSN");
        jPanel1.add(SSNLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, 20));

        DOBLabel.setText("D.O.B");
        jPanel1.add(DOBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 10));

        LastNameLabel.setText("Last Name");
        jPanel1.add(LastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 20));

        ReligionLabel.setText("Religion");
        jPanel1.add(ReligionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 50, 30));

        EthnicityLabel.setText("Ethinicity");
        jPanel1.add(EthnicityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 50, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, -1));

        FirstNameLabel.setText("First Name");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));

        SSN.setEditable(false);
        jPanel1.add(SSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 90, -1));

        FirstName.setEditable(false);
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 90, -1));

        LastName.setEditable(false);
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 90, -1));

        DOB.setEditable(false);
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, -1));

        Gender.setEditable(false);
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, -1));

        Ethnicity.setEditable(false);
        Ethnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthnicityActionPerformed(evt);
            }
        });
        jPanel1.add(Ethnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 90, -1));

        Religion.setEditable(false);
        jPanel1.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 90, -1));

        Wallpaper3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray 2.jpg"))); // NOI18N
        Wallpaper3.setText("jLabel19");
        jPanel1.add(Wallpaper3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 300));

        jTabbedPane1.addTab("Personal Information", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BloodPressure.setEditable(false);
        jPanel2.add(BloodPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        BloodPressureLabel.setText("Blood Pressure");
        jPanel2.add(BloodPressureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        HeartRateLabel.setText("Heart rate");
        jPanel2.add(HeartRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        HeartRate.setEditable(false);
        jPanel2.add(HeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, -1));

        HeightLabel.setText("Height (ft)");
        jPanel2.add(HeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        WeightLabel.setText("Weight (kg)");
        jPanel2.add(WeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        Height.setEditable(false);
        Height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeightActionPerformed(evt);
            }
        });
        jPanel2.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 90, -1));

        Weight.setEditable(false);
        jPanel2.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 90, -1));

        BloodTypeLabel.setText("Blood Type");
        jPanel2.add(BloodTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        SexuallyActiveLabel.setText("Sexually Active?");
        jPanel2.add(SexuallyActiveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 20));

        AllergiesLabel.setText("Allergies");
        jPanel2.add(AllergiesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        Allergies.setEditable(false);
        Allergies.setColumns(20);
        Allergies.setLineWrap(true);
        Allergies.setRows(5);
        jScrollPane1.setViewportView(Allergies);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 270, 100));

        SexuallyActive.setEditable(false);
        jPanel2.add(SexuallyActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 90, -1));

        BloodType.setEditable(false);
        jPanel2.add(BloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 90, -1));

        Wallpaper1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray 2.jpg"))); // NOI18N
        Wallpaper1.setText("jLabel17");
        jPanel2.add(Wallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 300));

        jTabbedPane1.addTab("Vitals", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Medication.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Lantus", "Humalog", "Thiazide", "Lisinopril", "Alosetron", "Linaclotide", "Paxlovid", "Amoxicillin", "Montelukast", "Albuterol", "Atenolol" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Medication.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        Medication.setToolTipText("");
        jScrollPane.setViewportView(Medication);

        jPanel3.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 270, 80));

        TestLabel.setText("Select tests");
        jPanel3.add(TestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        MedicationLabel.setText("Prescribe medication");
        jPanel3.add(MedicationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        SelectedMedication.setColumns(20);
        SelectedMedication.setLineWrap(true);
        SelectedMedication.setRows(5);
        jScrollPane6.setViewportView(SelectedMedication);

        jPanel3.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 270, 20));

        Test.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Xray", "CT scan", "MRI", "CAT scan", "PET scan", "Blood test", "Urine test", "Stool test" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(Test);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 80));

        SelectedTest.setColumns(20);
        SelectedTest.setLineWrap(true);
        SelectedTest.setRows(5);
        jScrollPane5.setViewportView(SelectedTest);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 20));

        Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray 2.jpg"))); // NOI18N
        Wallpaper2.setText("jLabel18");
        jPanel3.add(Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 300));

        jTabbedPane1.addTab("Tests/Medication", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 320));

        DiagnosisLabel.setText("Diagnosis");
        getContentPane().add(DiagnosisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, -1, -1));

        Notes.setColumns(20);
        Notes.setLineWrap(true);
        Notes.setRows(5);
        Notes.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(Notes);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 290, 100));

        NotesLabel.setText("Notes");
        getContentPane().add(NotesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "John Doe", "Jane Doe" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PatientSelect.setViewportView(jList6);

        getContentPane().add(PatientSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 120, 90));

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
        getContentPane().add(Submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 70, 20));

        jLabel1.setText("Select Patient");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        Diagnosis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diabetes Type1", "Diabetes Type 2", "Hypertension", "IBS", "Covid19", "Pneumonia", "Ashtma", "Heart attack", "Stroke" }));
        Diagnosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DiagnosisActionPerformed(evt);
            }
        });
        getContentPane().add(Diagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        Notes1.setColumns(20);
        Notes1.setLineWrap(true);
        Notes1.setRows(5);
        Notes1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(Notes1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 290, 100));

        jLabel6.setText("Doctor's Notes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel7.setText("Discharge Patient?");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        Discharge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        Discharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DischargeActionPerformed(evt);
            }
        });
        getContentPane().add(Discharge, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 160, 100, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 6.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 170, 320));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 340, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 330, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeightActionPerformed

    private void SubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SubmitMouseClicked

    }//GEN-LAST:event_SubmitMouseClicked

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
         System.out.println("submit button pushed");
       azure db = new azure();
        db.connect(); 
          localBloodPressure = (String) BloodPressure.getText();
          localHeartRate = (String) HeartRate.getText();
            localTest = (String) Test.getSelectedValue();
            localMedication = (String) Medication.getSelectedValue();
            localDiagnosis = (String) Diagnosis.getSelectedItem();
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
            localDoctorNotes = (String) Notes1.getText();
            localDischargeStatus = (String) Discharge.getSelectedItem();
        //need to set a handler for admittance specifically as well
        //localAdmittance = (String) Admit.getSelectedItem();
        
        //if a patient already has an exisiting visit record that is not discharged, modify the record instead. Otherwise, create a new record for that patient
        //this will require that the information not directly controlled by nurse will need to be obtained from db and then saved back in there
        
        ArrayList<String> localPatientInfo = new ArrayList<String>();
        //localPatientInfo.add(localPatientID);
        //need to grab what's there and save it there again
        ResultSet visitInfo = db.getVisit(localPatientID);
        try
        {

            localPatientInfo.add(visitInfo.getString(3));
            //nurse specific notes
            localPatientInfo.add(visitInfo.getString(4));
            //discharge instructions, must be resaved
            localPatientInfo.add("");
            localPatientInfo.add(visitInfo.getString(6));
            localPatientInfo.add(visitInfo.getString(7));
            localPatientInfo.add(visitInfo.getString(8));
            localPatientInfo.add(visitInfo.getString(9));
            //local diagnosis, must be resaved
            localPatientInfo.add(localDiagnosis);
            //local prescriptions, must be resaved
            localPatientInfo.add(visitInfo.getString(11).replaceAll("\\s", "") + localMedication + ",");
            //local tests, must be resaved
            localPatientInfo.add(visitInfo.getString(12).replaceAll("\\s", "") + localTest + ",");
            localPatientInfo.add(visitInfo.getString(13));
            //addmitance date
            localPatientInfo.add(visitInfo.getString(14));
            //discharge date
            try
            {
                localPatientInfo.add(getDate());
            }
            catch(Exception e)
            {
            }
            //discharge Status 
            localPatientInfo.add(localDischargeStatus); //handled by doctor
            //localPatientInfo.add(localNotes);
            //doctor note, must be resaved
            localPatientInfo.add(localDoctorNotes); //handled by doctor, must add a text box for this or simply remove this column and put these notes in discharge instructions
            db.updateVisit(localPatientID, visitInfo.getInt("Visit_ID") ,localPatientInfo);
        }
        catch (Exception e)
        {
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

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void DiagnosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DiagnosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DiagnosisActionPerformed

    private void EthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthnicityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EthnicityActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void DischargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DischargeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DischargeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Doctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try
                {
                    new Doctor().setVisible(true);
                }
                catch (Exception e)
                {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Allergies;
    private javax.swing.JLabel AllergiesLabel;
    private javax.swing.JTextField BloodPressure;
    private javax.swing.JLabel BloodPressureLabel;
    private javax.swing.JTextField BloodType;
    private javax.swing.JLabel BloodTypeLabel;
    private javax.swing.JTextField DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JComboBox<String> Diagnosis;
    private javax.swing.JLabel DiagnosisLabel;
    private javax.swing.JComboBox<String> Discharge;
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
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JList<String> Medication;
    private javax.swing.JLabel MedicationLabel;
    private javax.swing.JTextArea Notes;
    private javax.swing.JTextArea Notes1;
    private javax.swing.JLabel NotesLabel;
    private javax.swing.JScrollPane PatientSelect;
    private javax.swing.JTextField Religion;
    private javax.swing.JLabel ReligionLabel;
    private javax.swing.JTextField SSN;
    private javax.swing.JLabel SSNLabel;
    private javax.swing.JTextArea SelectedMedication;
    private javax.swing.JTextArea SelectedTest;
    private javax.swing.JTextField SexuallyActive;
    private javax.swing.JLabel SexuallyActiveLabel;
    private javax.swing.JButton Submit;
    private javax.swing.JList<String> Test;
    private javax.swing.JLabel TestLabel;
    private javax.swing.JLabel Wallpaper1;
    private javax.swing.JLabel Wallpaper2;
    private javax.swing.JLabel Wallpaper3;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
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
    private String localDiagnosis;
    private String localTest;
    private String localMedication;
    private String localDoctorNotes;
    private String localDischargeStatus;
    private int localPatientID = -1;
}
