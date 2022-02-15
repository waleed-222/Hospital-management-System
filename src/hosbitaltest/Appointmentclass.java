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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Moamen 
 */
public class Appointmentclass  {
    Connection con=connect.connectdb();
    ResultSet rs=null;
    PreparedStatement pst=null;
    String[] tbdata = new String[4];
    Appointment app=new Appointment();
    
    protected void make_app(String pid,String did,String date,String time)
    {
       try{
          
       Statement stmt;
       stmt= con.createStatement();
       
       String sql1="Select ID from APP.PATIENT where ID ='"+pid+"'";
      rs=stmt.executeQuery(sql1);
      if(!rs.next()){
        JOptionPane.showMessageDialog( app, "PATIENT ID DOESN'T exists","Error", JOptionPane.ERROR_MESSAGE);
      // P_id.setText("");
       //P_id.requestDefaultFocus();
       return;
      }
            String sql= "insert into APP.APPOINTMENTS(ID_DOCTOR,ID_PATIENT,DATE,TIME)values('"+pid+"','"+ did+"','"+ date+"','" + time + "')";
 
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(app,"Successfully Registered","DOCTOR",JOptionPane.INFORMATION_MESSAGE);
            
 
        }catch(HeadlessException | SQLException ex){
            JOptionPane.showMessageDialog(app,ex);
        }
    }
    
    protected String[] searchid_doctor(String id)
    {
      try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.APPOINTMENTS where ID_DOCTOR ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                String DoctorID=String.valueOf(rs.getString("ID_DOCTOR"));
                String PatientID=String.valueOf(rs.getString("ID_PATIENT"));
                String DATE=String.valueOf(rs.getDate("DATE"));
                String TIME=String.valueOf(rs.getString("TIME"));
                tbdata[0]=DoctorID;
                tbdata[1]=PatientID;
                tbdata[2]=DATE;
                tbdata[3]=TIME;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   
                JOptionPane.showMessageDialog(app,"Appointment doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
    }
    
    protected String[] searchid_Patient(String id)
    {
      try {
            Statement stmt;
            stmt= con.createStatement();
            String sql1="Select * from APP.APPOINTMENTS where ID_PATIENT ='"+id+"'";
            rs=stmt.executeQuery(sql1);
            if(rs.next()){
            
                String DoctorID=String.valueOf(rs.getString("ID_DOCTOR"));
                String PatientID=String.valueOf(rs.getString("ID_PATIENT"));
                String DATE=String.valueOf(rs.getDate("DATE"));
                String TIME=String.valueOf(rs.getString("TIME"));
                tbdata[0]=DoctorID;
                tbdata[1]=PatientID;
                tbdata[2]=DATE;
                tbdata[3]=TIME;
                //String tbdata[]={PatientID,PatientName,Patientage,PatientTel};  
            } 
              else
            {   
                JOptionPane.showMessageDialog(app,"Appointment doesn't exists","Error", JOptionPane.ERROR_MESSAGE);
            }
        } 
        catch (SQLException ex) {
           Logger.getLogger(PATINT.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tbdata;
    }
    
     

    
}
