/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package javaapplication5;

/**
 *
 * @author alana
 */
public class Patient extends javax.swing.JFrame {

    /** Creates new form Patient */
    public Patient() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
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
        Religion = new javax.swing.JComboBox<>();
        ReligionLabel = new javax.swing.JLabel();
        Ethnicity = new javax.swing.JComboBox<>();
        EthinicityLabel = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        GenderLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        LastName = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        SSN = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        Wallpaper = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SecondaryPhone = new javax.swing.JTextField();
        StreetName = new javax.swing.JTextField();
        PrimaryPhoneLabel = new javax.swing.JLabel();
        SecondaryPhoneLabel = new javax.swing.JLabel();
        StreetNameLabel = new javax.swing.JLabel();
        Apt = new javax.swing.JTextField();
        AptLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        CityLabel = new javax.swing.JLabel();
        StateLabel = new javax.swing.JLabel();
        ZipLabel = new javax.swing.JLabel();
        City = new javax.swing.JTextField();
        Zip = new javax.swing.JTextField();
        PrimaryPhone = new javax.swing.JTextField();
        State = new javax.swing.JTextField();
        Wallpaper2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        HealthInsuranceLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        BloodTypeLabel = new javax.swing.JLabel();
        BloodType = new javax.swing.JComboBox<>();
        SexuallyActiveLabel = new javax.swing.JLabel();
        SexuallyActive = new javax.swing.JComboBox<>();
        HeightLabel = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        WeightLabel = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        Wallpaper3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setLocation(new java.awt.Point(500, 360));
        setMaximumSize(new java.awt.Dimension(500, 360));
        setMinimumSize(new java.awt.Dimension(500, 360));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, -1));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(503, 300));

        jPanel1.setMaximumSize(new java.awt.Dimension(360, 190));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 190));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SSNLabel.setText("SSN");
        jPanel1.add(SSNLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, -1, -1));

        DOBLabel.setText("D.O.B");
        jPanel1.add(DOBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, -1, 10));

        LastNameLabel.setText("Last Name");
        jPanel1.add(LastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 20));

        Religion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Christianity", "Judaism", "Atheism", "Buddhism", "Hinduism", "Other" }));
        Religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReligionActionPerformed(evt);
            }
        });
        jPanel1.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 100, -1));

        ReligionLabel.setText("Religion");
        jPanel1.add(ReligionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        Ethnicity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White", "Hispanic", "Asian", "American Indian", "African American", "Native Hawaiian", "Latino", "Other" }));
        Ethnicity.setToolTipText("");
        Ethnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthnicityActionPerformed(evt);
            }
        });
        jPanel1.add(Ethnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 100, -1));

        EthinicityLabel.setText("Ethinicity");
        jPanel1.add(EthinicityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Nonbinary", "Other" }));
        Gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenderActionPerformed(evt);
            }
        });
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 100, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        FirstNameLabel.setText("First Name");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        LastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameActionPerformed(evt);
            }
        });
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, -1));

        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 100, -1));

        SSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSNActionPerformed(evt);
            }
        });
        jPanel1.add(SSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 100, -1));

        DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBActionPerformed(evt);
            }
        });
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 100, -1));

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 6.jpg"))); // NOI18N
        Wallpaper.setText("jLabel31");
        jPanel1.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 330));

        jTabbedPane1.addTab("Personal Information", jPanel1);

        jPanel2.setMaximumSize(new java.awt.Dimension(360, 290));
        jPanel2.setMinimumSize(new java.awt.Dimension(360, 290));
        jPanel2.setPreferredSize(new java.awt.Dimension(360, 290));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SecondaryPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SecondaryPhoneActionPerformed(evt);
            }
        });
        jPanel2.add(SecondaryPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 110, -1));

        StreetName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StreetNameActionPerformed(evt);
            }
        });
        jPanel2.add(StreetName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 110, -1));

        PrimaryPhoneLabel.setText("Primary Phone Number");
        jPanel2.add(PrimaryPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 130, -1));

        SecondaryPhoneLabel.setText("Emergency Phone Number");
        jPanel2.add(SecondaryPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, -1));

        StreetNameLabel.setText("Street Name");
        jPanel2.add(StreetNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        Apt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AptActionPerformed(evt);
            }
        });
        jPanel2.add(Apt, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 110, -1));

        AptLabel.setText("Apt/Suite/Unit/Building");
        jPanel2.add(AptLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        EmailLabel.setText("Email");
        jPanel2.add(EmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        jPanel2.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 110, -1));

        CityLabel.setText("City");
        jPanel2.add(CityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        StateLabel.setText("State");
        jPanel2.add(StateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        ZipLabel.setText("Zip Code");
        jPanel2.add(ZipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        City.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CityActionPerformed(evt);
            }
        });
        jPanel2.add(City, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 110, -1));

        Zip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipActionPerformed(evt);
            }
        });
        jPanel2.add(Zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 110, -1));

        PrimaryPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimaryPhoneActionPerformed(evt);
            }
        });
        jPanel2.add(PrimaryPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 110, -1));

        State.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StateActionPerformed(evt);
            }
        });
        jPanel2.add(State, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 110, -1));

        Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 4.jpg"))); // NOI18N
        Wallpaper2.setText("jLabel30");
        jPanel2.add(Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 340));

        jTabbedPane1.addTab("Contact Information", jPanel2);

        jPanel3.setMaximumSize(new java.awt.Dimension(360, 290));
        jPanel3.setMinimumSize(new java.awt.Dimension(360, 290));
        jPanel3.setPreferredSize(new java.awt.Dimension(360, 290));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        HealthInsuranceLabel.setText("Health Insurance");
        jPanel3.add(HealthInsuranceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MedicareCT", "Medicaid Ct", "United Healthcare", "" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, -1));

        jLabel2.setText("Primary Physician");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jLabel3.setText("Covid Vaccine");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel4.setText("Allergies");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 90, 20));

        jLabel5.setText("Medical Conditions");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 20));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 90, 20));

        BloodTypeLabel.setText("Blood Type");
        jPanel3.add(BloodTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, 20));

        BloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-" }));
        BloodType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BloodTypeActionPerformed(evt);
            }
        });
        jPanel3.add(BloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, -1));

        SexuallyActiveLabel.setText("Sexually Active?");
        jPanel3.add(SexuallyActiveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 90, 20));

        SexuallyActive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        SexuallyActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SexuallyActiveActionPerformed(evt);
            }
        });
        jPanel3.add(SexuallyActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 100, 20));

        HeightLabel.setText("Height (ft)");
        jPanel3.add(HeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 20));

        Height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeightActionPerformed(evt);
            }
        });
        jPanel3.add(Height, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 100, -1));

        WeightLabel.setText("Weight (kg)");
        jPanel3.add(WeightLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, 20));

        Weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeightActionPerformed(evt);
            }
        });
        jPanel3.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 100, -1));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 90, -1));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 90, -1));

        Wallpaper3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 5.png"))); // NOI18N
        Wallpaper3.setText("jLabel29");
        jPanel3.add(Wallpaper3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 340));

        jTabbedPane1.addTab("Medical Information", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 360));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        jLabel6.setText("Submit info to Database");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void SexuallyActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SexuallyActiveActionPerformed
        // TODO add your handling code here:
        localSexuallyActive = (String) SexuallyActive.getSelectedItem();
       // System.out.println(SexuallyActive.getSelectedItem());
    }//GEN-LAST:event_SexuallyActiveActionPerformed

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
        localHeight = Height.getText();
    }//GEN-LAST:event_HeightActionPerformed

    private void WeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeightActionPerformed
        // TODO add your handling code here:
        localWeight = Weight.getText();
    }//GEN-LAST:event_WeightActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        // TODO add your handling code here:
        localGender = (String) Gender.getSelectedItem();
    }//GEN-LAST:event_GenderActionPerformed

    private void ReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReligionActionPerformed
        // TODO add your handling code here:
        localReligion = (String) Religion.getSelectedItem();
    }//GEN-LAST:event_ReligionActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
        localFirstName = FirstName.getText();
    }//GEN-LAST:event_FirstNameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //wasnt able to figure out which button this is maybe submit button?
       // dbconnect.connect();
        
       // patient tempPatient = dbconnect.getPatientByName(localFirstName,localLastName);
        
        //somehow get the patient ID out of the field 0
        int tempPatientID = 0;
        String localAddress = localStreetName + localApt + localCity + localState;
        String[] localPatientInfo = {localFirstName, localLastName, localAddress, localDOB, localGender, localPrimaryPhysician, localHealthInsurance, localCovidVaccine, localSecondaryPhone, localAllergies, localMedicalCondition, localEthnicity,localReligion,localSSN, localSexuallyActive,localBloodType  };
        //dbconnect.setPatient(tempPatientID, localPatientInfo);
        
      //  dbconnect.close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void EthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthnicityActionPerformed
        // TODO add your handling code here:
        localEthnicity = (String) Ethnicity.getSelectedItem();
    }//GEN-LAST:event_EthnicityActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
        localLastName = LastName.getText();
    }//GEN-LAST:event_LastNameActionPerformed

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
        localDOB = DOB.getText();
    }//GEN-LAST:event_DOBActionPerformed

    private void SSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSNActionPerformed
        // TODO add your handling code here:
        localSSN = SSN.getText();
    }//GEN-LAST:event_SSNActionPerformed

    private void PrimaryPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimaryPhoneActionPerformed
        // TODO add your handling code here:
        localPrimaryPhone = PrimaryPhone.getText();
    }//GEN-LAST:event_PrimaryPhoneActionPerformed

    private void SecondaryPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SecondaryPhoneActionPerformed
        // TODO add your handling code here:
        localSecondaryPhone = SecondaryPhone.getText();
    }//GEN-LAST:event_SecondaryPhoneActionPerformed

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
        localEmail = Email.getText();
    }//GEN-LAST:event_EmailActionPerformed

    private void StreetNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StreetNameActionPerformed
        // TODO add your handling code here:
        localStreetName = StreetName.getText();
    }//GEN-LAST:event_StreetNameActionPerformed

    private void AptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AptActionPerformed
        // TODO add your handling code here:
        localApt = Apt.getText();
    }//GEN-LAST:event_AptActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
        localCity = City.getText();
    }//GEN-LAST:event_CityActionPerformed

    private void StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateActionPerformed
        // TODO add your handling code here:
        localState = State.getText();
    }//GEN-LAST:event_StateActionPerformed

    private void ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipActionPerformed
        // TODO add your handling code here:
        localZip = Zip.getText();
    }//GEN-LAST:event_ZipActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here: health insurance
        localHealthInsurance = (String) jComboBox1.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here: primary physician
        localPrimaryPhysician = jTextField4.getText();
        
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here: covid vaccine
        localCovidVaccine = jTextField3.getText();
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here: allergies
        localAllergies = jTextField2.getText();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here: medical condition
        localMedicalCondition = jTextField1.getText();
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void BloodTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BloodTypeActionPerformed
        // TODO add your handling code here:
        localBloodType = (String) BloodType.getSelectedItem();
    }//GEN-LAST:event_BloodTypeActionPerformed

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
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apt;
    private javax.swing.JLabel AptLabel;
    private javax.swing.JComboBox<String> BloodType;
    private javax.swing.JLabel BloodTypeLabel;
    private javax.swing.JTextField City;
    private javax.swing.JLabel CityLabel;
    private javax.swing.JTextField DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JTextField Email;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel EthinicityLabel;
    private javax.swing.JComboBox<String> Ethnicity;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JLabel HealthInsuranceLabel;
    private javax.swing.JTextField Height;
    private javax.swing.JLabel HeightLabel;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JTextField PrimaryPhone;
    private javax.swing.JLabel PrimaryPhoneLabel;
    private javax.swing.JComboBox<String> Religion;
    private javax.swing.JLabel ReligionLabel;
    private javax.swing.JTextField SSN;
    private javax.swing.JLabel SSNLabel;
    private javax.swing.JTextField SecondaryPhone;
    private javax.swing.JLabel SecondaryPhoneLabel;
    private javax.swing.JComboBox<String> SexuallyActive;
    private javax.swing.JLabel SexuallyActiveLabel;
    private javax.swing.JTextField State;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JTextField StreetName;
    private javax.swing.JLabel StreetNameLabel;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JLabel Wallpaper2;
    private javax.swing.JLabel Wallpaper3;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JTextField Zip;
    private javax.swing.JLabel ZipLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

    //adding variables for things because i dont understand what I'm doing
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
    private String localPrimaryPhone;
    private String localSecondaryPhone;
    private String localEmail;
    private String localStreetName;
    private String localApt;
    private String localCity;
    private String localState; 
    private String localZip;
    private String localHealthInsurance;
    private String localPrimaryPhysician;
    private String localCovidVaccine;
    private String localAllergies;
    private String localMedicalCondition;
    private String localBloodType;
}
