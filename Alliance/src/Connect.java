/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author jaric
 */
public class Connect {

    /**
     * @param args the command line arguments
     */
    Connection conn=null;
    public static Connection dbConnector(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\jaric\\OneDrive\\Documents\\NetBeansProjects\\Alliance\\Database\\Alliance.sqlite");
            
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
        
        
        
    }
}
