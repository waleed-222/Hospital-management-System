/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hosbitaltest;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class Maindoctor {
    Connection con=connect.connectdb();
    ResultSet rs=null;
    PreparedStatement pst=null;
    
    String DoctorID;
    String DoctorName;
    String Doctorspec;
    String DoctorTel;
    String[] tbdata = new String[4];
    
    protected String[] Search_id(String id)
    { 
        try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.DOCTOR where ID ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                DoctorID=String.valueOf(rs.getString("ID"));
                DoctorName=String.valueOf(rs.getString("NAME"));
                Doctorspec=String.valueOf(rs.getString("SPECIALIZATION"));
                DoctorTel=String.valueOf(rs.getInt("TEL"));
                tbdata[0]=DoctorID;
                tbdata[1]=DoctorName;
                tbdata[2]=Doctorspec;
                tbdata[3]=DoctorTel;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   Reception rec=new Reception() ;
                JOptionPane.showMessageDialog(rec,"Doctor doesn't exist","Error", JOptionPane.ERROR_MESSAGE);
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
            String sql1="Select * from APP.DOCTOR where NAME ='"+name+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                DoctorID=String.valueOf(rs.getString("ID"));
                DoctorName=String.valueOf(rs.getString("NAME"));
                Doctorspec=String.valueOf(rs.getString("SPECIALIZATION"));
                DoctorTel=String.valueOf(rs.getInt("TEL"));
                tbdata[0]=DoctorID;
                tbdata[1]=DoctorName;
                tbdata[2]=Doctorspec;
                tbdata[3]=DoctorTel;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   Reception rec=new Reception() ;
                JOptionPane.showMessageDialog(rec,"Doctor doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(Maindoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
   }
protected void add(String id,String name,String spec,String email,String tel)
    { Doctoradd rec=new Doctoradd() ;
         try{
          
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select ID from APP.DOCTOR where ID ='"+id+"'";
             rs=stmt.executeQuery(sql1);
             if(rs.next())
             {
             JOptionPane.showMessageDialog( rec, "DOCTOR ID already exists","Error", JOptionPane.ERROR_MESSAGE);
            //txtID.setText("");
           // txtID.requestDefaultFocus();
             return;
            }
       
            String sql= "insert into APP.DOCTOR(ID,NAME,SPECIALIZATION,EMAIl,TEL)values('"+id+"','"+name+"','"+ spec+"','" + email + "',"+ tel+")";
 
 
            pst=con.prepareStatement(sql);
            pst.execute();
           
            JOptionPane.showMessageDialog(rec,"Successfully Registered ","Doctor",JOptionPane.INFORMATION_MESSAGE);
            
            
 
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }
         
                                
    }
    protected void delete(String id)
    { Doctoradd rec=new Doctoradd();
        try{
            int P = JOptionPane.showConfirmDialog(null," Are you sure want to delete ?","Confirmation",JOptionPane.YES_NO_OPTION);
            if (P==0)
            {
                
                String sql= "delete from DOCTOR where ID = '" + id + "'";
                pst=con.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rec,"Successfully deleted","Record",JOptionPane.INFORMATION_MESSAGE);

                
            }
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }        // TODO add your handling code here:
    }
    
    protected void update(String id,String name,String spec,String email,String tel)
    {Doctoradd rec=new Doctoradd();
         try{
            
            String sql= "update DOCTOR set NAME='"+ name+ "',EMAIL='"+ email+ "',SPECIALIZATION=" + spec + "',TEL='" + tel+ "' where ID='" + id + "'";
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(rec,"Successfully updated","Record",JOptionPane.INFORMATION_MESSAGE);
            

        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(rec,ex);
        }          // TODO add your handling code here:
    }
    
    protected void login_doctor(String username,String passcode)
    {   Doctor dr=new Doctor();
        try {
        Statement stmt;
        stmt= con.createStatement();
        String sql1="Select ID,NAME from APP.DOCTOR where ID ='"+passcode+"'"+" AND NAME='"+username+"'";
        rs=stmt.executeQuery(sql1);
        if(rs.next())
        {
           
            new Doctor().setVisible(true);
            
        }
        else
        {
            JOptionPane.showMessageDialog( dr, "DOCTOR's username or passcode is wrong","Error", JOptionPane.ERROR_MESSAGE);
          
        }
        } catch (SQLException ex) {
            Logger.getLogger(Maindoctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
