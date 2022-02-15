package hosbitaltest;

//package hosbitaltest;
//import .*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class connect {
    public static Connection connectdb(){
        Connection con=null;
        try {
            con=DriverManager.getConnection("jdbc:derby://localhost:1527/hos","APP","APP");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(connect.class.getName()).log(Level.SEVERE, "ttttttttttttttttttt", ex);
        }
        return con;
    }
}
