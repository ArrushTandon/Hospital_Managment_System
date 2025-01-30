//Viewtest.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
public class Viewtest extends javax.swing.JFrame {
   
    public Viewtest() {
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "NAME", "FEES", "DESC", "DOCT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
    }
       
    private void formWindowActivated(java.awt.event.WindowEvent evt) {                                     
          DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        try{
            Connection con = Connectiondb.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from teacher");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String name = rs.getString(1);
                String fees = rs.getString(2);
                String desc= rs.getString(3);
                String doct = rs.getString(4);
            
                
                Object ob[] = {name, fees, desc,doct };
                model.addRow(ob);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }                                    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewtest().setVisible(true);
            }
        });
    }
                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
                      
}