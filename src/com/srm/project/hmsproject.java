//hmsproject.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
class hmsproject extends javax.swing.JFrame {
    
    public hmsproject() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
                          
    private void initComponents() {
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        staffr = new javax.swing.JRadioButton();
        doctorr = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        namer = new javax.swing.JTextField();
        pwd = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("LOGIN FORM");
        jLabel2.setText("NAME ");
        jLabel3.setText("PASSWORD");
        buttonGroup1.add(staffr);
        staffr.setText("STAFF");
        buttonGroup1.add(doctorr);
        doctorr.setText("DOCTOR");
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("CLEAR");
        jLabel4.setText("LOGIN AS");
    }
                           
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
         
        try{
            Connection con=Connectiondb.getConnection();
            PreparedStatement ps=null;
            if(staffr.isSelected()){
                ps=con.prepareStatement("select * from staff where uname=? and pwd=?");
                ps.setString(1,namer.getText());
                ps.setString(2,pwd.getText());
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                      JOptionPane.showMessageDialog(null, "Welcome STAFF");
                    Staffdashboard sd = new Staffdashboard();
                    sd.setVisible(true);        //to open new frame ad
                    this.dispose();
                }
                else
                {
                    //invalid admin
                    JOptionPane.showMessageDialog(null, "Invalid Uname or Password");
                    hmsproject hms = new hmsproject();
                    hms.setVisible(true);        //to open new frame ad
                    this.dispose();             //to close current frame
                }
                    
                
            }
              else if(doctorr.isSelected())      //radio button selection
            {
                //teacher login
                ps = con.prepareStatement
                    ("select * from doctor where uname=? and pwd=?");
                ps.setString(1, namer.getText());
                ps.setString(2, pwd.getText());
                ResultSet rs=ps.executeQuery();
                if(rs.next())
                {   // valid teacher
                    JOptionPane.showMessageDialog(null,"welocome DOCTOR");
                    Doctordashboard td =new Doctordashboard();
                    td.setVisible(true);
                    this.dispose();
                    
                }
                else
                {  // Invalid teacher
                    JOptionPane.showMessageDialog(null,"Invalid username and password");
                    hmsproject hms = new hmsproject();
                    hms.setVisible(true);
                    this.dispose();
                    
                }
                
                
            }
   
        }  catch(Exception e)
        {
            System.out.println(e);
        }
        
 
    }                                        
  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hmsproject().setVisible(true);
            }
        });
    }
                       
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton doctorr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField namer;
    private javax.swing.JPasswordField pwd;
    private javax.swing.JRadioButton staffr;
                  
}