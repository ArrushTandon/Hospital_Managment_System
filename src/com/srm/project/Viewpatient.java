//Viewpatient.java
package com.srm.project;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
public class Viewpatient extends javax.swing.JFrame {
    
    public Viewpatient() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
                "name", "age", "disease", "phone_number", "guardian", "uname", "pwd"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
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
            PreparedStatement ps = con.prepareStatement("select * from patient");
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                String name1 = rs.getString(1);
                String  age1 = rs.getString(2);
                String disease = rs.getString(3);
                String phone_number = rs.getString(4);
                String guardian = rs.getString(5);
                String uname = rs.getString(6);
                String pwd = rs.getString(7);
                Object ob[] = {name1, age1, disease, phone_number, guardian,uname,pwd};
                model.addRow(ob);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }                                    
   
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viewpatient().setVisible(true);
            }
        });
    }
                        
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
                      
}