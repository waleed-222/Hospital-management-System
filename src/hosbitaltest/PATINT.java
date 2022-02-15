/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hosbitaltest;
import java.awt.HeadlessException;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LENOVO
 */
public class PATINT{

    Connection con=connect.connectdb();
    ResultSet rs=null;
    PreparedStatement pst=null;
    int id;
    String PatientID;
    String PatientName;
    String Patientage;
    String PatientTel;
    String[] tbdata = new String[4];
    
    
    protected String[] Search_id(String id)
    { 
        try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.PATIENT where ID ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                PatientID=String.valueOf(rs.getString("ID"));
                PatientName=String.valueOf(rs.getString("NAME"));
                Patientage=String.valueOf(rs.getInt("AGE"));
                PatientTel=String.valueOf(rs.getInt("TEL"));
                tbdata[0]=PatientID;
                tbdata[1]=PatientName;
                tbdata[2]=Patientage;
                tbdata[3]=PatientTel;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   Reception rec=new Reception() ;
                JOptionPane.showMessageDialog(rec,"Patient doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
   }
    protected String[] Search_name(String name)
    { 
        try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.PATIENT where NAME ='"+name+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                PatientID=String.valueOf(rs.getString("ID"));
                PatientName=String.valueOf(rs.getString("NAME"));
                Patientage=String.valueOf(rs.getInt("AGE"));
                PatientTel=String.valueOf(rs.getInt("TEL"));
                tbdata[0]=PatientID;
                tbdata[1]=PatientName;
                tbdata[2]=Patientage;
                tbdata[3]=PatientTel;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   Reception rec=new Reception() ;
                JOptionPane.showMessageDialog(rec,"Patient doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
   }
    
    protected void add(String name,String age,String email,String tel)
    { Patientedit rec=new Patientedit() ;
      
         try{
             
            Statement stmt;
            stmt= con.createStatement();
       
       
            String sql= "insert into APP.PATIENT1(NAME,AGE,EMAIl,TEL)values('"+name+"',"+ age+",'" + email+ "',"+tel+")";
 
            pst=con.prepareStatement(sql);
           pst.execute();
            
               JOptionPane.showMessageDialog(rec,"Patient added Successfully","Patient",JOptionPane.INFORMATION_MESSAGE);  
             
           
            
            
 
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }
         
                                
    }
    protected void delete(int id)
    { Patientedit rec=new Patientedit() ;
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)
            {
                
                String sql= "delete from PATIENT1 where ID = " +id + "";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rec,"Successfully deleted","Record",JOptionPane.INFORMATION_MESSAGE);

                
            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }        // TODO add your handling code here:
    }
    
    protected void update(int id,String name,String age,String email,int tel)
    {Patientedit rec=new Patientedit() ;
         try{
  
            String sql= "update PATIENT1 set NAME='"+name+ "',EMAIL='"+ email+ "',AGE=" + age + ",TEL="+tel+ " where ID=" + id + "";
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rec,"Successfully updated","Record",JOptionPane.INFORMATION_MESSAGE);
            

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }          // TODO add your handling code here:
    }
    
}
