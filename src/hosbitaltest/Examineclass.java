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
public class Examineclass {
    
    Connection con=connect.connectdb();
    ResultSet rs=null;
    PreparedStatement pst=null;
    String[] tbdata = new String[4];
    Examine exm=new Examine(); 
    
    protected void Save_examine(String idp,String idD,String medc,String state)
    {
      try{
          
       Statement stmt;
       stmt= con.createStatement();
       
      String sql1="Select ID_PATIENT from APP.APPOINTMENTS where ID ='"+idp+"'";
      rs=stmt.executeQuery(sql1);
      if(!rs.next()){
        JOptionPane.showMessageDialog( exm, "PATIENT DOESN'T exists in Appointments","Error", JOptionPane.ERROR_MESSAGE);
      // P_id.setText("");
       //P_id.requestDefaultFocus();
       return;
      }
            String sql= "insert into APP.EXAMINE(DOCTOR_ID,PATIENT_ID,DRUGS,STATE)values('"+idp+"','"+ idD+"','"+ medc+"','" + state + "')";
 
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(exm,"Successfully Saved","DOCTOR",JOptionPane.INFORMATION_MESSAGE);
            
 
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(exm,ex);
        }
    }
    
    protected String[] searchid_Patient(String id)
    {
      try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.EXAMINE where PATIENT_ID ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                String DoctorID=String.valueOf(rs.getString("DOCTOR_ID"));
                String PatientID=String.valueOf(rs.getString("PATIENT_ID"));
                String DATE=String.valueOf(rs.getDate("DRUGS"));
                String TIME=String.valueOf(rs.getString("STATE"));
                tbdata[0]=DoctorID;
                tbdata[1]=PatientID;
                tbdata[2]=DATE;
                tbdata[3]=TIME;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   
                JOptionPane.showMessageDialog(exm,"Examination doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
    }
     protected String[] searchid_doctor(String id)
    {
      try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.EXAMINE where DOCTOR_ID ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                String DoctorID=String.valueOf(rs.getString("DOCTOR_ID"));
                String PatientID=String.valueOf(rs.getString("PATIENT_ID"));
                String DRUGS=String.valueOf(rs.getDate("DRUGS"));
                String STATE=String.valueOf(rs.getString("STATE"));
                tbdata[0]=DoctorID;
                tbdata[1]=PatientID;
                tbdata[2]=DRUGS;
                tbdata[3]=STATE;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   
                JOptionPane.showMessageDialog(exm,"Appointment doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
    }
    
    protected String show_state(String idstate)
    {
        String state = null;
         try {
            
            Statement stmt;
            stmt= con.createStatement();
           
            String sql1="Select * from APP.EXAMINE where PATIENT_ID ='"+idstate+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
               state=String.valueOf(rs.getString("STATE"));
                
                                
            }
            else
            {JOptionPane.showMessageDialog( exm, "Doctor doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
            
                                         
            }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(exm,ex);
        }
         return state;
    }
}
