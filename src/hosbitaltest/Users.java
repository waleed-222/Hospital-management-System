/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hosbitaltest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @ MOAMEN.N
 */
public class Users {
    Connection con=connect.connectdb();
    ResultSet rs=null;
    PreparedStatement pst=null;
    String username;
    String tel;
    String passcode;
   
    
 

    protected void add_user(String name,String tele,String code)
    {
    }
    
   
    protected void login_user(String name,String code)
    {
    }
           
}
