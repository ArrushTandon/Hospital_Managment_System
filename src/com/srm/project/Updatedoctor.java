//Updatedoctor.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class Updatedoctor extends javax.swing.JFrame {
    public Updatedoctor() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        qualification = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        uname = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("UPDATE DOCTOR");
        jLabel2.setText("USER NAME");
        jButton1.setText("search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("clear");
        jLabel3.setText("name");
        jLabel4.setText("age");
        jLabel5.setText("qualification");
        jLabel6.setText("address");
        jLabel7.setText("phone");
        jLabel8.setText("uname");
        jLabel9.setText("pwd");
        jButton3.setText("submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
    }
                         
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
String userName = adm.getText();
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement
                ("select * from doctor where uname=?");
            ps.setString(1,userName);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
              
                adm.setEditable(false);
               
                name.setText(rs.getString(1));
                age.setText(rs.getString(2));
                qualification.setText(rs.getString(3));
                address.setText(rs.getString(4));
                phone.setText(rs.getString(5));
                adm.setText(rs.getString(6));
                  pwd.setText(rs.getString(7));
             
            }
            else
            {
             
                JOptionPane.showMessageDialog(null, "Invalid User Name !!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
              
        
                              
    }                                        
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
     uname.setText(" ") ;       
    }                                        
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       try
             {
               Connection con = Connectiondb.getConnection();
                PreparedStatement ps = con.prepareStatement
                ("update doctor set name = ?, age = ?,qualification = ?,address = ?,phone = ?,pwd = ? where uname=?");
               ps.setString(1, name.getText());
              ps.setString(2, age.getText());
              ps.setString(3, qualification.getText());
                ps.setString(4, address.getText());
               ps.setString(5,phone.getText());
             
            ps.setString(6, uname.getText());
            
            ps.setString(7,pwd.getText());
            int x = ps.executeUpdate();
            if(x>0)
            {
                JOptionPane.showMessageDialog(null, "DOCTOR Details updated");
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
                new Updatedoctor().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JTextField address;
    private javax.swing.JTextField adm;
    private javax.swing.JTextField age;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField pwd;
    private javax.swing.JTextField qualification;
    private javax.swing.JTextField uname;
                    
}