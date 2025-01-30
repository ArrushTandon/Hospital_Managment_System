//Adddoctor.java

package com.srm.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Adddoctor extends javax.swing.JFrame {
	public Adddoctor() {
		initComponents();
	}
	@SuppressWarnings("unchecked")
	
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        qualification = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pwd = new javax.swing.JPasswordField();
        uname = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("ADD NEW Doctor");
        jLabel2.setText("NAME");
        jLabel3.setText("AGE");
        jLabel4.setText("QUALIFICATION");
        jLabel5.setText("ADDRESS");
        jLabel6.setText("PHONE");
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
        jLabel7.setText("uname ");
        jLabel8.setText("password");
        pwd.setText("jPasswordField1");
	}
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into doctor(name,age,qualification,address,phone,uname,pwd) values(?,?,?,?,?,?,?)");
            ps.setString(1, name.getText());
            ps.setString(2, age.getText());
            ps.setString(3, qualification.getText());
            ps.setString(4, address.getText());
            ps.setString(5, phone.getText());
            ps.setString(6, uname.getText());
            ps.setString(7, pwd.getText());
            int x = ps.executeUpdate();
            if (x > 0) {
                JOptionPane.showMessageDialog(null, "Doctor Added");
                Adddoctor ad = new Adddoctor();
                ad.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
name.setText(" ");
age.setText(" ");
qualification.setText(" ");
address.setText(" ");
phone.setText(" ");
uname.setText(" ");
pwd.setText(" ");
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
            java.util.logging.Logger.getLogger(Adddoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Adddoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Adddoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Adddoctor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Adddoctor().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
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
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JTextField qualification;
    private javax.swing.JTextField uname;
                      
}

