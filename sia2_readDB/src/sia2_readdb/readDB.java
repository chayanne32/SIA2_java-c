/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sia2_readdb;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author wabzs
 */
public class readDB {
    
    static{
       System.loadLibrary("sia2_native");
    }
    
    public ResultSet rs;
    //public [] array;
    private native void cgetData(int depth);
    //private native void stringarray(String[] y);
    
    public static void main(String args[]) {
        readDB rdb = new readDB();
        //rdb.getData();
        //rdb.displayData();
        rdb.cgetData(0);
        //rdb.getData();
        //String [] s = rdb.arrangeData();
        //rdb.cgetData(rdb.arrangeData(rdb.getRs()));
    }   
    public ResultSet getRs(){
        return this.rs;
    }
    public readDB(){
    }
    
    public void getData(){
        try{
            System.out.println("Sup");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");  
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sia2","root","");                      
            System.out.println("DB connected");       
            Statement st = conn.createStatement();
            String sql = ("SELECT * FROM students");
            ResultSet rst = st.executeQuery(sql);
            ResultSetMetaData rsmd = rst.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rst.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rst.getString(i);
                    System.out.print(columnValue);
                }
                System.out.println("");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());  
            e.printStackTrace();
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
    
    public String[] arrangeData(ResultSet rs){
        ArrayList<String> arraylist= new ArrayList<>();
        String str ="";
        String[] s = new String[0];
        try{
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    //arraylist.add(rs.getString(i));
                    str += rs.getString(i);
                    if (i > 1) str+= " ";
                    //String columnValue = rs.getString(i);
                    //System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                arraylist.add(str);
                str = "";
            }
            s = new String[arraylist.size()];
            for(int x=0; x < arraylist.size(); x++){
                s[x] = arraylist.get(x);
                System.out.println(s[x]);
            }
            //this.array = arraylist.toArray();
            //return arraylist.toArray();
            /*
            for(String s:arraylist){
                System.out.println(s);
            }*/
        }catch(Exception e){       
            System.out.println(e.getMessage());       
        } 
        return s;
    }
}


