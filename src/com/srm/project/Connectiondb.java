//Connection.java
package com.srm.project;
import java.sql.DriverManager;
import java.sql.Connection;
public class Connectiondb {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hms","root","98188");
        }
        catch(Exception e){
            System.out.println(e);
        }
        return con;
    }
    
}