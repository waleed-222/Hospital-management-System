/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hosbitaltest;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Managerclass extends Users {
    
     @Override
     protected void add_user(String name,String code,String tele)
    { Manager mg=new Manager();
         try{
          
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select NAME from APP.MANAGER where NAME ='"+name+"'";
             rs=stmt.executeQuery(sql1);
             if(rs.next())
             {
             JOptionPane.showMessageDialog( mg, "username already exists","Error", JOptionPane.ERROR_MESSAGE);
            //txtID.setText("");
           // txtID.requestDefaultFocus();
             return;
            }
       
            String sql= "insert into APP.MANAGER(NAME,PASSCODE,TEL)values('"+name+"','"+code+"',"+ tele+")";
 
 
            pst=con.prepareStatement(sql);
            pst.execute();
           
            JOptionPane.showMessageDialog(mg,"Successfully Registered ","Manager",JOptionPane.INFORMATION_MESSAGE);
            
            
 
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(mg,ex);
        }
         
    }
     
     @Override
    protected void login_user(String name,String code){
     Manager mgr=new Manager();
        try {
        Statement stmt;
        stmt= con.createStatement();
        String sql1="Select PASSCODE,NAME from APP.MANAGER where PASSCODE ='"+code+"'"+" AND NAME='"+name+"'";
        rs=stmt.executeQuery(sql1);
        if(rs.next())
        {
           
            new Manager().setVisible(true);
            
        }
        else
        {
            JOptionPane.showMessageDialog( mgr, "Manager's username or passcode is wrong","Error", JOptionPane.ERROR_MESSAGE);
          
        }
        } catch (SQLException ex) {
            Logger.getLogger(Maindoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
