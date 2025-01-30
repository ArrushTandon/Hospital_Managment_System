//Bill.java
package com.srm.project;
public class Bill extends javax.swing.JFrame {
 
    public Bill() {
        initComponents();
    }
  
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        a = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b = new javax.swing.JTextField();
        c = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        g = new javax.swing.JTextField();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Bill of patient");
        jLabel2.setText("ENTER NUMBER OF DAYS PATIENT WAS ADMITTED");
        jLabel3.setText("ENTER  TOTAL COST OF TESTS");
        jLabel4.setText("ENTER TOTAL FEES OF DOCTOR");
        b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActionPerformed(evt);
            }
        });
        jButton1.setText("GENERATE BILL");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
    }
     
                        
    private void bActionPerformed(java.awt.event.ActionEvent evt) {                                  
       
    }                                 
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
int d=Integer.parseInt(a.getText());  
int e=Integer.parseInt(b.getText()); 
int f=Integer.parseInt(c.getText());
int m=d*5000+e+f;
g.setText(m+" ");
// TODO add your handling code here:
    }                                        
    public static void main(String args[]) {
      
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bill().setVisible(true);
            }
        });
    }
                      
    private javax.swing.JTextField a;
    private javax.swing.JTextField b;
    private javax.swing.JTextField c;
    private javax.swing.JTextField g;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
                    
}