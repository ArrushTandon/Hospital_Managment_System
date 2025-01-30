//Updatepatient.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Updatepatient extends javax.swing.JFrame {
   
    public Updatepatient() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
                         
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        adm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        disease = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        guardian = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        pwd = new javax.swing.JPasswordField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("UPDATE PATIENT");
        jLabel2.setText("USER NAME");
        jLabel3.setText("NAME1");
        adm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admActionPerformed(evt);
            }
        });
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel4.setText("AGE1");
        jLabel6.setText("DISEASE");
        jLabel7.setText("PHONE_NUMBER");
        jLabel8.setText("GUARDOAN");
        jLabel9.setText("UNAME");
        jLabel10.setText("PWD");
        name.setText("\\\\");
            jButton2.setText("UPDATE");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });
            pwd.setText("jPasswordField1");
    }
                                 
    private void admActionPerformed(java.awt.event.ActionEvent evt) {                                    
        
    }                                   
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
String userName = adm.getText();
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement
                ("select * from patient where uname=?");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                
                adm.setEditable(false);
               
                name.setText(rs.getString(1));
                age.setText(rs.getString(2));
                disease.setText(rs.getString(3));
                guardian.setText(rs.getString(4));
                phone_number.setText(rs.getString(5));
                uname.setText(rs.getString(6));
                  pwd.setText(rs.getString(7));
             
            }
            else
            {
                //not exists
                JOptionPane.showMessageDialog(null, "Invalid User Name !!");
            }
        }catch(Exception e){
            System.out.println(e);
        }        // TODO add your handling code here:
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
 try
             {
               Connection con = Connectiondb.getConnection();
                PreparedStatement ps = con.prepareStatement
                ("update patient set name1 = ?, age1 = ?,disease = ?,phone_number = ?,guardian = ?,pwd = ? where uname=?");
               ps.setString(1, name.getText());
              ps.setString(2, age.getText());
              ps.setString(3, disease.getText());
                ps.setString(4, phone_number.getText());
               ps.setString(5,guardian.getText());
             
            ps.setString(6, uname.getText());
            
            ps.setString(7,pwd.getText());
            int x = ps.executeUpdate();
            if(x>0)
            {
                JOptionPane.showMessageDialog(null, "patient Details updated");
                Updatestaff as = new Updatestaff();
                as.setVisible(true);
                this.dispose();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }        
    }                                        
   
    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Updatepatient().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JTextField adm;
    private javax.swing.JTextField age;
    private javax.swing.JTextField disease;
    private javax.swing.JTextField guardian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone_number;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField uname;
                     
}