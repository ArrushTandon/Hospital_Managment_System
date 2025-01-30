//Addpatient.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Addpatient extends javax.swing.JFrame {
public Addpatient() {
        initComponents();
    }
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name1 = new javax.swing.JTextField();
        age1 = new javax.swing.JTextField();
        disease = new javax.swing.JTextField();
        phone_number = new javax.swing.JTextField();
        guardian = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("ADD NEW PATIENT");
        jLabel2.setText("NAME ");
        jLabel3.setText("AGE");
        jLabel4.setText("DISEASE");
        jLabel5.setText("PHONE NUMBER");
        jLabel6.setText("GUARDIAN");
        age1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                age1ActionPerformed(evt);
            }
        });
        disease.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diseaseActionPerformed(evt);
            }
        });
        guardian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardianActionPerformed(evt);
            }
        });
        jButton1.setText("SUBMIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLabel7.setText("uname");
        jLabel8.setText("password");
    }   
    private void age1ActionPerformed(java.awt.event.ActionEvent evt) {                                     
        
    }                                    
    private void guardianActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
    }                                        
    private void diseaseActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
    }                                       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into patient(name1,age1,disease,phone_number,guardian,uname,pwd) values(?,?,?,?,?,?,?)");
            ps.setString(1, name1.getText());
            ps.setString(2, age1.getText());
            ps.setString(3, disease.getText());
            ps.setString(4, phone_number.getText());
            ps.setString(5, guardian.getText());
            ps.setString(6, uname.getText());
            ps.setString(7, pwd.getText());
            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Patient Added");
                Addpatient ap = new Addpatient();
                ap.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
name1.setText(" ");
age1.setText(" ");
disease.setText(" ");
phone_number.setText(" ");
guardian.setText(" ");
    }                                        
  
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Addpatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Addpatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Addpatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Addpatient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addpatient().setVisible(true);
            }
        });
    }
                       
    private javax.swing.JTextField age1;
    private javax.swing.JTextField disease;
    private javax.swing.JTextField guardian;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField name1;
    private javax.swing.JTextField phone_number;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField uname;
                       
}