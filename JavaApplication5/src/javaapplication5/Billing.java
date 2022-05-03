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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author alana
 */
public class Billing extends javax.swing.JFrame {

    /**
     * Creates new form Billing
     */
    public Billing() throws SQLException {
        initComponents();

        
        setList();
        //calculateTotal();
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
                        localVisitID = visitInfo.getInt("Visit_ID");
                        if(db.getBill(localVisitID) != null)
                        {
                            
                        }
                        else
                        {
                            temp.addElement(firstName + " " + lastName);
                        }
                    }
                    else
                    {
                        System.out.println("Patient has not been discharged yet!");
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

        ResultSet visitInfo = db.getVisit(localPatientID);
        localVisitID = visitInfo.getInt(2);
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
            populateFields(patientInfo, visitInfo);

        }
        catch (Exception e)
        {
        }
        db.close();
    }

    public void populateFields(ResultSet patientInfo, ResultSet visitInfo) throws SQLException, ParseException
    {
        FirstName.setText(patientInfo.getString(2).replaceAll("\\s", ""));
        FirstNameBill.setText(patientInfo.getString(2).replaceAll("\\s", ""));
        LastName.setText(patientInfo.getString(3).replaceAll("\\s", ""));
        LastNameBill.setText(patientInfo.getString(3).replaceAll("\\s", ""));
        DOB.setText(patientInfo.getString(4));
        Gender.setText(patientInfo.getString(5).replaceAll("\\s", ""));

        int billID = (int)(Math.random()*(100000 - 1 + 1) + 1);
        BillNum.setText(billID + "");
        Insurance.setText(patientInfo.getString(7).replaceAll("\\s", ""));
        DefaultListModel list = new DefaultListModel();
            list.addElement(visitInfo.getString(11).replaceAll("\\s", ""));
            list.addElement(visitInfo.getString(12).replaceAll("\\s", ""));
        DateAdmitted.setText(visitInfo.getString("Admittance_Date").replaceAll("\\s", ""));
        DateReleased.setText(visitInfo.getString("Discharge_Date").replaceAll("\\s", ""));
        jList5.setModel(list);
        SecondaryPhone.setText(patientInfo.getString(9).replaceAll("\\s", ""));
        City.setText(patientInfo.getString(17).replaceAll("\\s", ""));
        Address.setText(patientInfo.getString(18).replaceAll("\\s", ""));
        State.setText(patientInfo.getString(19).replaceAll("\\s", ""));
        Zip.setText(patientInfo.getString(20).replaceAll("\\s", ""));
        PrimaryPhone.setText(patientInfo.getString(21).replaceAll("\\s", ""));
        Email.setText(patientInfo.getString(22).replaceAll("\\s", ""));

        Total.setText("$" + calculateTotal());
        


        
    }

    public void emptyFields()
    {
        jList6.removeAll();
        FirstName.setText("");
        LastName.setText("");
        DOB.setText("");
        Gender.setText("");
        //Admit.setSelectedItem("Yes");
    }

    public int getVisitDays() throws ParseException, SQLException
    {
        azure db = new azure();
        db.connect();
        ResultSet visitInfo = db.getVisit(localPatientID);

        String admittanceDate = visitInfo.getString("Admittance_Date").replaceAll("\\s", "");
        String dischargeDate = visitInfo.getString("Discharge_Date").replaceAll("\\s", "");

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date firstDate = sdf.parse(admittanceDate);
        Date secondDate = sdf.parse(dischargeDate);

        long diff = secondDate.getTime() - firstDate.getTime();

        TimeUnit time = TimeUnit.DAYS; 
        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
        int days = (int) diffrence;

        db.close();
        return days;
    }

    public int calculateTotal() throws SQLException, ParseException
    {
        localTotal = 0;
        azure db = new azure();
        db.connect();

        ResultSet visitInfo = db.getVisit(localPatientID);
        ResultSet medicineInfo = db.getTreatmentList();
        ResultSet testInfo = db.getTestList();

        String[] medicine = visitInfo.getString("Prescriptions").replaceAll("\\s", "").split("[^A-Za-z]+");
        for(int i = 0; i < medicine.length; i++)
        {
            do
            {
                String tempMed = medicineInfo.getString(1).replaceAll("\\s", "");
                if(medicine[i].contains(tempMed))
                {
                    localTotal += medicineInfo.getInt(2);
                }
            } while(medicineInfo.next());
        }

        String[] tests = visitInfo.getString("Tests_Administered").replaceAll("\\s", "").split("[^A-Za-z]+");
        for(int i = 0; i < tests.length; i++)
        {
            do
            {
                String tempTest = testInfo.getString(1).replaceAll("\\s", "");
                if(tests[i].contains(tempTest))
                {
                    localTotal += testInfo.getInt(2);
                }
            } while(testInfo.next());
        }

        System.out.println("visit days: " + getVisitDays());
        System.out.println(visitCharge);
        localTotal += ((getVisitDays() + 1) * visitCharge);
        
        
        //System.out.println("calculated total = " + localTotal);
        db.close();
        return localTotal;
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
        Wallpaper = new javax.swing.JLabel();
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
        ItemsLabel = new javax.swing.JLabel();
        DueDateLabel = new javax.swing.JLabel();
        Items = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        DateAdmitted = new javax.swing.JTextField();
        DateAdmittedLabel = new javax.swing.JLabel();
        TaxLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        GenerateBill = new javax.swing.JButton();
        BillNum = new javax.swing.JTextField();
        DueDate = new javax.swing.JTextField();
        Tax = new javax.swing.JTextField();
        Insurance = new javax.swing.JTextField();
        Wallpaper3 = new javax.swing.JLabel();
        Logout = new javax.swing.JButton();
        PatientSelect = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setMinimumSize(new java.awt.Dimension(580, 466));
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
        jPanel1.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 90, -1));

        Zip.setEditable(false);
        Zip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZipActionPerformed(evt);
            }
        });
        jPanel1.add(Zip, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 110, -1));

        GenderLabel.setText("Gender");
        jPanel1.add(GenderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        FirstName.setEditable(false);
        FirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FirstNameActionPerformed(evt);
            }
        });
        jPanel1.add(FirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 90, -1));

        DOBLabel.setText("D.O.B");
        jPanel1.add(DOBLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

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
        Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressActionPerformed(evt);
            }
        });
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

        Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray.png"))); // NOI18N
        Wallpaper.setText("jLabel2");
        jPanel1.add(Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 430, 420));

        jTabbedPane1.addTab("Patient Information", jPanel1);

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

        GenerateBill.setText("Generate Bill");
        GenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerateBillActionPerformed(evt);
            }
        });
        jPanel3.add(GenerateBill, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, -1, -1));

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

        Insurance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsuranceActionPerformed(evt);
            }
        });
        jPanel3.add(Insurance, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 90, -1));

        Wallpaper3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background gray.png"))); // NOI18N
        Wallpaper3.setText("jLabel24");
        jPanel3.add(Wallpaper3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 430, 420));

        jTabbedPane1.addTab("View Bill", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 450));

        Logout.setBackground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        getContentPane().add(Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        jList6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "John Doe", "Jane Doe" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList6.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PatientSelect.setViewportView(jList6);

        getContentPane().add(PatientSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 120, 90));

        OK.setBackground(new java.awt.Color(255, 255, 255));
        OK.setText("Ok");
        OK.setMaximumSize(new java.awt.Dimension(63, 21));
        OK.setMinimumSize(new java.awt.Dimension(63, 21));
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
        getContentPane().add(OK, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 60, 20));

        jLabel1.setText("Select Patient");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-7, -40, 560, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 150, 300));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication5/images/background blue 2.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 150, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        this.dispose();
        Login login = new Login();
        login.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMouseClicked

    }//GEN-LAST:event_OKMouseClicked

    private void OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKActionPerformed
        this.dispose();
        try
        {
            Billing billing = new Billing();
            billing.setVisible(true);
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_OKActionPerformed

    private void TaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TaxActionPerformed

    private void DueDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DueDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DueDateActionPerformed

    private void BillNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BillNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BillNumActionPerformed

    private void GenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerateBillActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        //wasnt able to figure out which button this is maybe submit button?
        System.out.println("submit button pushed");
        azure db = new azure();
        db.connect();
        // getting all fields
        localBillNum = Integer.parseInt(BillNum.getText());
        //localTotal = Integer.parseInt(Total.getText());

         

         
       ArrayList billInformation = new ArrayList();
        
        billInformation.add(localVisitID);
        billInformation.add(localBillNum);
        billInformation.add(localTotal);


        db.setBill(localVisitID, localBillNum, localTotal);
        db.close();
    }//GEN-LAST:event_GenerateBillActionPerformed

    private void DateAdmittedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateAdmittedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateAdmittedActionPerformed

    private void FirstNameBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameBillActionPerformed

    private void DateReleasedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateReleasedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateReleasedActionPerformed

    private void TotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TotalActionPerformed

    private void LastNameBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameBillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameBillActionPerformed

    private void LastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameActionPerformed

    private void StateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StateActionPerformed

    private void CityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CityActionPerformed

    private void PrimaryPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimaryPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrimaryPhoneActionPerformed

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBActionPerformed

    private void FirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FirstNameActionPerformed

    private void ZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ZipActionPerformed

    private void GenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenderActionPerformed
        Gender.setEditable(false);
    }//GEN-LAST:event_GenderActionPerformed

    private void InsuranceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsuranceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InsuranceActionPerformed

    private void AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressActionPerformed
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
                try
                {
                    new Billing().setVisible(true);
                }
                catch(Exception e)
                {
                }
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Address;
    private javax.swing.JLabel AddressLabel;
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
    private javax.swing.JTextField Insurance;
    private javax.swing.JLabel InsuranceLabel;
    private javax.swing.JScrollPane Items;
    private javax.swing.JLabel ItemsLabel;
    private javax.swing.JTextField LastName;
    private javax.swing.JTextField LastNameBill;
    private javax.swing.JLabel LastNameBillLabel;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JButton Logout;
    private javax.swing.JButton OK;
    private javax.swing.JScrollPane PatientSelect;
    private javax.swing.JTextField PrimaryPhone;
    private javax.swing.JLabel PrimaryPhoneLabel;
    private javax.swing.JTextField SecondaryPhone;
    private javax.swing.JLabel SecondaryPhoneLabel;
    private javax.swing.JTextField State;
    private javax.swing.JLabel StateLabel;
    private javax.swing.JTextField Tax;
    private javax.swing.JLabel TaxLabel;
    private javax.swing.JTextField Total;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel Wallpaper;
    private javax.swing.JLabel Wallpaper3;
    private javax.swing.JTextField Zip;
    private javax.swing.JLabel ZipLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JPanel jPanel1;
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
private int localBillNum;
private String localFirstNameBill;
private String localLastNameBill;
private Date localDateAdmitted;
private Date localDateReleased;
private String localBillable; //jList5
private String localTax;
private String localDueDate;
private int localTotal = 0;
private int localPatientID = -1;
private int localVisitID = -1;
private final int visitCharge = 700;

}
