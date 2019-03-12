/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readdb;

import java.sql.*;
/**
 *
 * @author wabzs
 */
public class readDB {
    
    public ResultSet rs;
    
    public readDB(){
    }
    
    public void getData(){
        try{
            Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sia2","root","");                      
            System.out.println("DB connected");       
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM students");
            rs = st.executeQuery(sql);
        }catch(Exception e){       
            System.out.println("Something went wrong !! Please try again");       
        }      
    }
    
    public void displayData(){
        try{
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
        }catch(Exception e){       
            System.out.println("Something went wrong !! Please try again");       
        } 
    }
}
