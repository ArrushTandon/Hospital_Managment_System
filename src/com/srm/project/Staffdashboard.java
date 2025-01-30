//Staffdashboard.java
package com.srm.project;
public class Staffdashboard extends javax.swing.JFrame {
   
    public Staffdashboard() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("welcome staff");
        jMenu1.setText("File");
        jMenuItem1.setText("Add doctor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem2.setText("Add staff");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenuItem3.setText("Add patient");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenuItem4.setText("Add test");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);
        jMenuItem5.setText("appointmemts");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenuItem6.setText("view doctor");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);
        jMenuItem7.setText("Update doctor");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenuItem8.setText("BILL");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);
        jMenuItem9.setText("VIEW DOCTOR");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);
        jMenuItem10.setText("VIEW PATIENT");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);
        jMenuItem11.setText("VIEW STAFF");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);
        jMenuItem12.setText("UPDATE PATIENT");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);
        setJMenuBar(jMenuBar1);
    }
  
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Adddoctor().setVisible(true);        
    }                                          
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Addstaff().setVisible(true);
    }                                          
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Addpatient().setVisible(true);       
    }                                          
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Addtest().setVisible(true);        
    }                                          
    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Appointment().setVisible(true);       
    }                                          
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Viewdoctor_1().setVisible(true);        
    }                                          
    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Updatedoctor().setVisible(true);
    }                                          
    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Bill().setVisible(true);       
    }                                          
    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	new Viewdoctor_1().setVisible(true);        
    }                                          
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	new Viewpatient().setVisible(true);       
    }                                           
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	new Viewstaff().setVisible(true);
    }                                           
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    	new Updatepatient().setVisible(true);        
    }                                           
   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staffdashboard().setVisible(true);
            }
        });
    }
                    
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
                      
}