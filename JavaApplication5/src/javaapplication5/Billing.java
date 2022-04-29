/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication5;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alana
 */
public class Billing extends javax.swing.JFrame {

    /**
     * Creates new form Billing
     */
    public Billing() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        Gender = new javax.swing.JTextField();
        Zip = new javax.swing.JTextField();
        GenderLabel = new javax.swing.JLabel();
        FirstName = new javax.swing.JTextField();
        DOBLabel = new javax.swing.JLabel();
        MaritalStatusLabel = new javax.swing.JLabel();
        PregnantLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        DOB = new javax.swing.JTextField();
        PrimaryPhone = new javax.swing.JTextField();
        SecondaryPhoneLabel = new javax.swing.JLabel();
        PrimaryPhoneLabel = new javax.swing.JLabel();
        SecondaryPhone = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        AptLabel = new javax.swing.JLabel();
        Address = new javax.swing.JTextField();
        AddressLabel = new javax.swing.JLabel();
        Apt = new javax.swing.JTextField();
        CityLabel = new javax.swing.JLabel();
        City = new javax.swing.JTextField();
        StateLabel = new javax.swing.JLabel();
        State = new javax.swing.JTextField();
        ZipLabel = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        MaritalStatus = new javax.swing.JTextField();
        Pregnant = new javax.swing.JTextField();
        Wallpaper = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        AgeLabel = new javax.swing.JLabel();
        VaccinesLabel = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        Weight = new javax.swing.JTextField();
        Age = new javax.swing.JTextField();
        HeightLabel = new javax.swing.JLabel();
        WeightLabel = new javax.swing.JLabel();
        VisitsLabel = new javax.swing.JLabel();
        MedicationLabel = new javax.swing.JLabel();
        AllergiesLabel = new javax.swing.JLabel();
        Vaccines = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Visits = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Medication = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        Allergies = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        Wallpaper2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LastNameBill = new javax.swing.JTextField();
        BillNumLabel = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        FirstNameBillLabel = new javax.swing.JLabel();
        DateReleased = new javax.swing.JTextField();
        LastNameBillLabel = new javax.swing.JLabel();
        InsuranceLabel = new javax.swing.JLabel();
        DateReleasedLabel = new javax.swing.JLabel();
        FirstNameBill = new javax.swing.JTextField();
        Insurance = new javax.swing.JComboBox<>();
        ItemsLabel = new javax.swing.JLabel();
        DueDateLabel = new javax.swing.JLabel();
        Items = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        DateAdmitted = new javax.swing.JTextField();
        DateAdmittedLabel = new javax.swing.JLabel();
        TaxLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        Save = new javax.swing.JButton();
        GenerateBill = new javax.swing.JButton();
        BillNum = new javax.swing.JTextField();
        DueDate = new javax.swing.JTextField();
        Tax = new javax.swing.JTextField();
        Wallpaper3 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        PatientSelect = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMaximumSize(new java.awt.Dimension(580, 466));
        setMinimumSize(new java.awt.Dimension(580, 466));
        setPreferredSize(new java.awt.Dimension(580, 466));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(420, 450));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(420, 450));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(420, 450));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FirstNameLabel.setText("First Name");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        LastNameLabel.setText("Last Name");
        jPanel1.add(LastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        Gender.setEditable(false);
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 90, -1));

        Zip.setEditable(false);
        Zip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipActionPerformed(evt);
            }
        });
        jPanel1.add(Zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 110, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        FirstName.setEditable(false);
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, -1));

        DOBLabel.setText("D.O.B");
        jPanel1.add(DOBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        MaritalStatusLabel.setText("Marital Status");
        jPanel1.add(MaritalStatusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, -1, -1));

        PregnantLabel.setText("Pregnant");
        jPanel1.add(PregnantLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        EmailLabel.setText("Email");
        jPanel1.add(EmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 30, -1));

        DOB.setEditable(false);
        DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBActionPerformed(evt);
            }
        });
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 90, -1));

        PrimaryPhone.setEditable(false);
        PrimaryPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimaryPhoneActionPerformed(evt);
            }
        });
        jPanel1.add(PrimaryPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 110, -1));

        SecondaryPhoneLabel.setText("Secondary Phone Number");
        jPanel1.add(SecondaryPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 130, -1));

        PrimaryPhoneLabel.setText("Primary Phone Number");
        jPanel1.add(PrimaryPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, -1));

        SecondaryPhone.setEditable(false);
        jPanel1.add(SecondaryPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 110, -1));

        Email.setEditable(false);
        jPanel1.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 110, -1));

        AptLabel.setText("Apt/Suite/Unit/Building");
        jPanel1.add(AptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 130, -1));

        Address.setEditable(false);
        jPanel1.add(Address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 110, -1));

        AddressLabel.setText("Street Address");
        jPanel1.add(AddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 80, -1));

        Apt.setEditable(false);
        jPanel1.add(Apt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 110, -1));

        CityLabel.setText("City");
        jPanel1.add(CityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 30, 20));

        City.setEditable(false);
        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });
        jPanel1.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 110, -1));

        StateLabel.setText("State");
        jPanel1.add(StateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 30, -1));

        State.setEditable(false);
        State.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateActionPerformed(evt);
            }
        });
        jPanel1.add(State, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 110, -1));

        ZipLabel.setText("Zip Code");
        jPanel1.add(ZipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 50, -1));

        LastName.setEditable(false);
        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, -1));

        MaritalStatus.setEditable(false);
        MaritalStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaritalStatusActionPerformed(evt);
            }
        });
        jPanel1.add(MaritalStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, -1));

        Pregnant.setEditable(false);
        Pregnant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PregnantActionPerformed(evt);
            }
        });
        jPanel1.add(Pregnant, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 90, -1));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 6.jpg"))); // NOI18N
        Wallpaper.setText("jLabel2");
        jPanel1.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 420));

        jTabbedPane1.addTab("Patient Information", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AgeLabel.setText("Age");
        jPanel2.add(AgeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        VaccinesLabel.setText("Vaccines");
        jPanel2.add(VaccinesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        Height.setEditable(false);
        Height.setText("6.3");
        Height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeightActionPerformed(evt);
            }
        });
        jPanel2.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 90, -1));

        Weight.setEditable(false);
        Weight.setText("79");
        Weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeightActionPerformed(evt);
            }
        });
        jPanel2.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 90, -1));

        Age.setEditable(false);
        Age.setText("45");
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        jPanel2.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 90, -1));

        HeightLabel.setText("Height (ft)");
        jPanel2.add(HeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        WeightLabel.setText("Weight (kg)");
        jPanel2.add(WeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        VisitsLabel.setText("Visits");
        jPanel2.add(VisitsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        MedicationLabel.setText("Medication");
        jPanel2.add(MedicationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        AllergiesLabel.setText("Allergies");
        jPanel2.add(AllergiesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Covid", "Influenza" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Vaccines.setViewportView(jList1);

        jPanel2.add(Vaccines, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 130, 70));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "November 10 2021", "January 15 2022", "January 28 2022", "March 17 2022", "" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Visits.setViewportView(jList2);

        jPanel2.add(Visits, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 270, 60));

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Albuterol", "Losartan (100 mg)", "Prednisone (20 mg)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Medication.setViewportView(jList3);

        jPanel2.add(Medication, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 130, 70));

        jList4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Iodine", "Amoxicillin", "Ceftriaxone" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Allergies.setViewportView(jList4);

        jPanel2.add(Allergies, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 270, 60));

        Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 4.jpg"))); // NOI18N
        Wallpaper2.setText("jLabel16");
        jPanel2.add(Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 430));

        jTabbedPane1.addTab("Medical Records", jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(430, 420));
        jPanel3.setMinimumSize(new java.awt.Dimension(430, 420));
        jPanel3.setPreferredSize(new java.awt.Dimension(430, 420));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LastNameBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameBillActionPerformed(evt);
            }
        });
        jPanel3.add(LastNameBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 90, -1));

        BillNumLabel.setText("Bill Number");
        jPanel3.add(BillNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        Total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TotalActionPerformed(evt);
            }
        });
        jPanel3.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 90, -1));

        FirstNameBillLabel.setText("First Name");
        jPanel3.add(FirstNameBillLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        DateReleased.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateReleasedActionPerformed(evt);
            }
        });
        jPanel3.add(DateReleased, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 90, -1));

        LastNameBillLabel.setText("Last Name");
        jPanel3.add(LastNameBillLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        InsuranceLabel.setText("Insurance");
        jPanel3.add(InsuranceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        DateReleasedLabel.setText("Date Released");
        jPanel3.add(DateReleasedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 70, 20));

        FirstNameBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameBillActionPerformed(evt);
            }
        });
        jPanel3.add(FirstNameBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, -1));

        Insurance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CT Medicare", "CT Medicaid", "United Healthcare", "ConnectiCare", "Anthem" }));
        jPanel3.add(Insurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 100, -1));

        ItemsLabel.setText("Billable Items");
        jPanel3.add(ItemsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        DueDateLabel.setText("Due Date");
        jPanel3.add(DueDateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, -1));

        jList5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "CT Scan", "Xray", "Blood Test" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Items.setViewportView(jList5);

        jPanel3.add(Items, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 270, 50));

        DateAdmitted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateAdmittedActionPerformed(evt);
            }
        });
        jPanel3.add(DateAdmitted, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 90, -1));

        DateAdmittedLabel.setText("Date Admitted");
        jPanel3.add(DateAdmittedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 80, -1));

        TaxLabel.setText("Tax $");
        jPanel3.add(TaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 240, 30, -1));

        TotalLabel.setText("Total Amount $");
        jPanel3.add(TotalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel3.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        GenerateBill.setText("Generate Bill");
        GenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBillActionPerformed(evt);
            }
        });
        jPanel3.add(GenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, -1, -1));

        BillNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BillNumActionPerformed(evt);
            }
        });
        jPanel3.add(BillNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 90, -1));

        DueDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DueDateActionPerformed(evt);
            }
        });
        jPanel3.add(DueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 90, -1));

        Tax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TaxActionPerformed(evt);
            }
        });
        jPanel3.add(Tax, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 90, -1));

        Wallpaper3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 5.png"))); // NOI18N
        Wallpaper3.setText("jLabel24");
        jPanel3.add(Wallpaper3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 420));

        jTabbedPane1.addTab("View Bill", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 420, 450));

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "John Doe", "Jane Doe" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PatientSelect.setViewportView(jList6);

        getContentPane().add(PatientSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 120, 90));

        OK.setText("Ok");
        OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKMouseClicked(evt);
            }
        });
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKActionPerformed(evt);
            }
        });
        getContentPane().add(OK, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 60, 20));

        jLabel1.setText("Select Patient");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
    // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
    Gender.setEditable(false);   
    }//GEN-LAST:event_GenderActionPerformed

    private void ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityActionPerformed

    private void StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateActionPerformed

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeightActionPerformed

    private void WeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeightActionPerformed

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void LastNameBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameBillActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void DateReleasedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateReleasedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateReleasedActionPerformed

    private void FirstNameBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameBillActionPerformed

    private void DateAdmittedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateAdmittedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateAdmittedActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void MaritalStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaritalStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaritalStatusActionPerformed

    private void PregnantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PregnantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PregnantActionPerformed

    private void PrimaryPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimaryPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimaryPhoneActionPerformed

    private void BillNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillNumActionPerformed

    private void DueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DueDateActionPerformed

    private void TaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaxActionPerformed

    private void OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMouseClicked

    }//GEN-LAST:event_OKMouseClicked

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        this.dispose();
        Billing billing = new Billing();
        billing.setVisible(true);
    }//GEN-LAST:event_OKActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        // get all the values then push bill to DB
        int daysStayed;
                
        
        localFirstName = FirstName.getText();
        localLastName = LastName.getText();
        localDOB = DOB.getText();
        localMaritalStatus = MaritalStatus.getText();
        localGender = Gender.getText();
        localPregnant = Pregnant.getText();
        localPrimaryPhone = PrimaryPhone.getText();
        localSecondaryPhone = SecondaryPhone.getText();
        localEmail = Email.getText();
        localAddress = Address.getText(); 
        localApt = Apt.getText();
        localCity = City.getText();
        localState = State.getText();
        localZip = Zip.getText();
        localHeight = Height.getText();
        localAge = Age.getText();
        localWeight = Weight.getText();
        localVisits = jList2.getSelectedValue(); //jList2 gets current selected value
        localMedications = jList3.getSelectedValue(); //jList3 this is an array of values
        localVaccines = jList1.getSelectedValue(); //jList1
        localAllergies = jList4.getSelectedValue(); //jlist4
        localBillNum = BillNum.getText();
        localFirstNameBill = FirstNameBill.getText();
        localLastNameBill = LastNameBill.getText();
        
        //super ugly parsing for number of days stayed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM ddd");   
        
        
        
        try {
            localDateReleased = sdf.parse(DateReleased.getText());
            localDateAdmitted = sdf.parse(DateAdmitted.getText());
        } catch (ParseException ex) {
            Logger.getLogger(Billing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        long t = localDateAdmitted.getTime() - localDateReleased.getTime();
        daysStayed = (int) TimeUnit.DAYS.convert(t,TimeUnit.MILLISECONDS);
       
        
        localBillable = jList5.getSelectedValue(); //jList5
        localTax= Tax.getText();
        localDueDate = DueDate.getText();
        localTotal= Total.getText();
        Random randy = new Random();
        System.out.println("Save button pushed");
        azure db = new azure();
        db.connect();
        int charge = daysStayed * 1000;
        //actual submitting happens here
        db.setBill(randy.nextInt(), randy.nextInt(), charge);
        
        db.close();

    }//GEN-LAST:event_SaveActionPerformed

    private void GenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBillActionPerformed
        // TODO add your handling code here:
        System.out.println("submit button pushed");
        azure db = new azure();
        db.connect();
        db.close();
    }//GEN-LAST:event_GenerateBillActionPerformed
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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField Age;
    private javax.swing.JLabel AgeLabel;
    private javax.swing.JScrollPane Allergies;
    private javax.swing.JLabel AllergiesLabel;
    private javax.swing.JTextField Apt;
    private javax.swing.JLabel AptLabel;
    private javax.swing.JTextField BillNum;
    private javax.swing.JLabel BillNumLabel;
    private javax.swing.JTextField City;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JTextField DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JTextField DateAdmitted;
    private javax.swing.JLabel DateAdmittedLabel;
    private javax.swing.JTextField DateReleased;
    private javax.swing.JLabel DateReleasedLabel;
    private javax.swing.JTextField DueDate;
    private javax.swing.JLabel DueDateLabel;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JTextField FirstName;
    private javax.swing.JTextField FirstNameBill;
    private javax.swing.JLabel FirstNameBillLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField Gender;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JButton GenerateBill;
    private javax.swing.JTextField Height;
    private javax.swing.JLabel HeightLabel;
    private javax.swing.JComboBox<String> Insurance;
    private javax.swing.JLabel InsuranceLabel;
    private javax.swing.JScrollPane Items;
    private javax.swing.JLabel ItemsLabel;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField LastNameBill;
    private javax.swing.JLabel LastNameBillLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField MaritalStatus;
    private javax.swing.JLabel MaritalStatusLabel;
    private javax.swing.JScrollPane Medication;
    private javax.swing.JLabel MedicationLabel;
    private javax.swing.JButton OK;
    private javax.swing.JScrollPane PatientSelect;
    private javax.swing.JTextField Pregnant;
    private javax.swing.JLabel PregnantLabel;
    private javax.swing.JTextField PrimaryPhone;
    private javax.swing.JLabel PrimaryPhoneLabel;
    private javax.swing.JButton Save;
    private javax.swing.JTextField SecondaryPhone;
    private javax.swing.JLabel SecondaryPhoneLabel;
    private javax.swing.JTextField State;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JTextField Tax;
    private javax.swing.JLabel TaxLabel;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JScrollPane Vaccines;
    private javax.swing.JLabel VaccinesLabel;
    private javax.swing.JScrollPane Visits;
    private javax.swing.JLabel VisitsLabel;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JLabel Wallpaper2;
    private javax.swing.JLabel Wallpaper3;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JTextField Zip;
    private javax.swing.JLabel ZipLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

private String localFirstName;
private String localLastName;
private String localDOB;
private String localMaritalStatus;
private String localGender;
private String localPregnant;
private String localPrimaryPhone;
private String localSecondaryPhone;
private String localEmail;
private String localAddress; 
private String localApt;
private String localCity;
private String localState;
private String localZip;
private String localHeight;
private String localAge;
private String localWeight;
private String localVisits; //jList2
private String localMedications; //jList3
private String localVaccines; //jList1
private String localAllergies; //jlist4
private String localBillNum;
private String localFirstNameBill;
private String localLastNameBill;
private Date localDateAdmitted;
private Date localDateReleased;
private String localBillable; //jList5
private String localTax;
private String localDueDate;
private String localTotal;

}
