/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author Windows10
 */
public class ConnecDB {
    private String URL = "jdbc:mysql://localhost:3306/rester"
            + "";
    private String Username = "root";
    private String Password = "";
    
    private Connection Cn = null ; // เชื่อม DB
    private Statement Stm = null; // สร้างคำสั่ง sql
    private ResultSet Rs = null; // เก็บข้อมูล
    
    public void ConnectionDB()throws SQLException{
    
        try{ Cn = DriverManager.getConnection(URL,Username,Password);
        System.out.println("Connected");
        
          }
        catch(SQLException e){
            System.out.println("fail");
          }
    
    }
    
    public void DisconnectDB()throws SQLException{
    
        try{ Cn.close();
        
        }//try
        
        catch(SQLException e){
            
        }//catch
    }
    
    public boolean execute(String SQL)throws SQLException{
        
        try{ ConnectionDB(); 
        Stm = Cn.createStatement();
        Stm.execute(SQL);
        DisconnectDB();
        
        return true;
        
        }//try
        catch(SQLException e){
        
            return false;
        }//catch
    }
    
    public ResultSet getResultSet(String SQL)throws SQLException{
        try{ ConnectionDB();
         Stm = Cn.createStatement();
         Rs = Stm.executeQuery(SQL);
                    
        }//try
        catch(SQLException e){
            
            Rs = null ;
        }//catch
        
        return Rs;
    }
}

