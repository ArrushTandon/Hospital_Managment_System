//Appointment.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
public class Appointment extends javax.swing.JFrame {
  
    public Appointment() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
                            
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        dname = new javax.swing.JTextField();
        page = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("appointment");
        jLabel2.setText("patient's name");
        jLabel3.setText("doctor's name");
        jLabel4.setText("patient's age");
        jLabel6.setText(" will text you the timings of appointment as soon as possible ");
        jButton1.setText("submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }
                              
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into appointment(name,dname,page,date) values(?,?,?,?)");
            ps.setString(1, name.getText());
            ps.setString(2, dname.getText());
            ps.setString(3, page.getText());
            
            Date d = new Date();
              SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
              String dd = sd.format(d);
              ps.setString(4, dd);
               int x = ps.executeUpdate();
              if(x>0)    
              {
                  JOptionPane.showMessageDialog(null, "APPOINTMENT PROCESSED");
                  Appointment ad = new Appointment();
                  ad.setVisible(true);
                  this.dispose();
              }
        }
        catch(Exception e){
            System.out.println(e);
        }
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
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Appointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointment().setVisible(true);
            }
        });
    }
                       
    private javax.swing.JTextField dname;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField name;
    private javax.swing.JTextField page;
                      
}