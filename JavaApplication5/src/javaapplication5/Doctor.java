/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication5;

/**
 *
 * @author alana
 */
public class Doctor extends javax.swing.JFrame {

    /**
     * Creates new form Doctor
     */
    public Doctor() {
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

        Logout = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        BloodPressure = new javax.swing.JTextField();
        BloodPressureLabel = new javax.swing.JLabel();
        HeartRateLabel = new javax.swing.JLabel();
        HeartRate = new javax.swing.JTextField();
        HeightLabel = new javax.swing.JLabel();
        WeightLabel = new javax.swing.JLabel();
        Height = new javax.swing.JTextField();
        Weight = new javax.swing.JTextField();
        SexuallyActive = new javax.swing.JComboBox<>();
        BloodTypeLabel = new javax.swing.JLabel();
        SexuallyActiveLabel = new javax.swing.JLabel();
        AllergiesLabel = new javax.swing.JLabel();
        Allergies = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        BloodType = new javax.swing.JComboBox<>();
        Wallpaper1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Medication = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        TestLabel = new javax.swing.JLabel();
        MedicationLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        Wallpaper2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        SSNLabel = new javax.swing.JLabel();
        DOBLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        ReligionLabel = new javax.swing.JLabel();
        EthnicityLabel = new javax.swing.JLabel();
        Ethnicity = new javax.swing.JComboBox<>();
        GenderLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        SSN = new javax.swing.JTextField();
        FirstName = new javax.swing.JTextField();
        LastName = new javax.swing.JTextField();
        DOB = new javax.swing.JTextField();
        Gender = new javax.swing.JComboBox<>();
        Religion = new javax.swing.JComboBox<>();
        Wallpaper3 = new javax.swing.JLabel();
        DiagnosisLabel = new javax.swing.JLabel();
        Notes = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        NotesLabel = new javax.swing.JLabel();
        Diagnosis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMaximumSize(new java.awt.Dimension(670, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        jTabbedPane1.setMaximumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(503, 300));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(503, 300));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(BloodPressure, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 90, -1));

        BloodPressureLabel.setText("Blood Pressure");
        jPanel2.add(BloodPressureLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        HeartRateLabel.setText("Heart rate");
        jPanel2.add(HeartRateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));
        jPanel2.add(HeartRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 90, -1));

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

        SexuallyActive.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        jPanel2.add(SexuallyActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 90, -1));

        BloodTypeLabel.setText("Blood Type");
        jPanel2.add(BloodTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        SexuallyActiveLabel.setText("Sexually Active?");
        jPanel2.add(SexuallyActiveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, 20));

        AllergiesLabel.setText("Allergies");
        jPanel2.add(AllergiesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jList3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Penicillin", "Aspirin" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList3.setToolTipText("");
        Allergies.setViewportView(jList3);

        jPanel2.add(Allergies, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 270, 90));

        BloodType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-" }));
        jPanel2.add(BloodType, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 90, -1));

        Wallpaper1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 6.jpg"))); // NOI18N
        Wallpaper1.setText("jLabel17");
        jPanel2.add(Wallpaper1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 300));

        jTabbedPane1.addTab("Vitals", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Lantus", "Humalog", "Thiazide", "Lisinopril", "Alosetron", "Linaclotide", "Paxlovid", "Amoxicillin", "Montelukast", "Albuterol", "Atenolol" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        Medication.setViewportView(jList1);

        jPanel3.add(Medication, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 270, 80));

        TestLabel.setText("Select tests");
        jPanel3.add(TestLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        MedicationLabel.setText("Prescribe medication");
        jPanel3.add(MedicationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Xray", "CT scan", "MRI", "CAT scan", "PET scan", "Blood test", "Urine test", "Stool test" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 270, 80));

        Wallpaper2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 4.jpg"))); // NOI18N
        Wallpaper2.setText("jLabel18");
        jPanel3.add(Wallpaper2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 300));

        jTabbedPane1.addTab("Tests/Medication", jPanel3);

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

        Ethnicity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "White", "Hispanic", "Latino", "African American", "Asian", "European", "Native American" }));
        Ethnicity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EthnicityActionPerformed(evt);
            }
        });
        jPanel1.add(Ethnicity, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 100, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 40, -1));

        FirstNameLabel.setText("First Name");
        jPanel1.add(FirstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));
        jPanel1.add(SSN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 90, -1));
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 90, -1));
        jPanel1.add(LastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 90, -1));
        jPanel1.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, -1));

        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Nonbinary", "Other" }));
        Gender.setToolTipText("");
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, -1));

        Religion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Christianity", "Atheism", "Judaism", "Islam", "Buddhism", "Hinduism" }));
        Religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReligionActionPerformed(evt);
            }
        });
        jPanel1.add(Religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 100, -1));

        Wallpaper3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background 5.png"))); // NOI18N
        Wallpaper3.setText("jLabel19");
        jPanel1.add(Wallpaper3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 300));

        jTabbedPane1.addTab("Personal Information", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 320));

        DiagnosisLabel.setText("Diagnosis");
        getContentPane().add(DiagnosisLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        Notes.setViewportView(jTextArea1);

        getContentPane().add(Notes, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 290, 100));

        NotesLabel.setText("Notes");
        getContentPane().add(NotesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));
        getContentPane().add(Diagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void EthnicityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EthnicityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EthnicityActionPerformed

    private void ReligionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReligionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReligionActionPerformed

    private void HeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HeightActionPerformed

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
                new Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Allergies;
    private javax.swing.JLabel AllergiesLabel;
    private javax.swing.JTextField BloodPressure;
    private javax.swing.JLabel BloodPressureLabel;
    private javax.swing.JComboBox<String> BloodType;
    private javax.swing.JLabel BloodTypeLabel;
    private javax.swing.JTextField DOB;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JTextField Diagnosis;
    private javax.swing.JLabel DiagnosisLabel;
    private javax.swing.JComboBox<String> Ethnicity;
    private javax.swing.JLabel EthnicityLabel;
    private javax.swing.JTextField FirstName;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel GenderLabel;
    private javax.swing.JTextField HeartRate;
    private javax.swing.JLabel HeartRateLabel;
    private javax.swing.JTextField Height;
    private javax.swing.JLabel HeightLabel;
    private javax.swing.JTextField LastName;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JScrollPane Medication;
    private javax.swing.JLabel MedicationLabel;
    private javax.swing.JScrollPane Notes;
    private javax.swing.JLabel NotesLabel;
    private javax.swing.JComboBox<String> Religion;
    private javax.swing.JLabel ReligionLabel;
    private javax.swing.JTextField SSN;
    private javax.swing.JLabel SSNLabel;
    private javax.swing.JComboBox<String> SexuallyActive;
    private javax.swing.JLabel SexuallyActiveLabel;
    private javax.swing.JLabel TestLabel;
    private javax.swing.JLabel Wallpaper1;
    private javax.swing.JLabel Wallpaper2;
    private javax.swing.JLabel Wallpaper3;
    private javax.swing.JTextField Weight;
    private javax.swing.JLabel WeightLabel;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
