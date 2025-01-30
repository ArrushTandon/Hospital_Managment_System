//Addtest.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Addtest extends javax.swing.JFrame {
    public Addtest() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
                              
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DOOCTOR = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        name1 = new javax.swing.JTextField();
        fees = new javax.swing.JTextField();
        desc1 = new javax.swing.JTextField();
        doct = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("ADD NEW TEST");
        jLabel2.setText("TEST NAME");
        jLabel3.setText("TEST FEES");
        jLabel4.setText("DESCRIPTION");
        DOOCTOR.setText("DOCTOR");
        jButton1.setText("SAVE");
        buttonGroup1.add(jButton1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("CLEAR");
        buttonGroup1.add(jButton2);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desc1ActionPerformed(evt);
            }
        });
    }
                          
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
          try {
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into test(name1,fees,desc1,doct) values(?,?,?,?)");
            ps.setString(1, name1.getText());
            ps.setString(2, fees.getText());
            ps.setString(3, desc1.getText());
            ps.setString(4, doct.getText());
            
            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "TEST Added");
                Adddoctor ad = new Adddoctor();
                ad.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      name1.setText(" ");
      fees.setText(" ");
      desc1.setText(" ");
      doct.setText(" ");
    }                                        
    private void desc1ActionPerformed(java.awt.event.ActionEvent evt) {                                      
        
    }                                     
    
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Addtest().setVisible(true);
            }
        });
    }
                         
    private javax.swing.JLabel DOOCTOR;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField desc1;
    private javax.swing.JTextField doct;
    private javax.swing.JTextField fees;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField name1;
                       
}