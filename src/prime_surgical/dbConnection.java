/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prime_surgical;
import java.awt.Component;
import javax.swing.*;

import java.sql.*;
import java.util.logging.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahmudul Hasan(UTC)
 */

 public class dbConnection  {
     /**
      * these variables are custom variables and defined by the author.
      */
    String id,name,mobile,address,shop;
   Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/primesurgical";
    String un = "root";
    String pw = "";
    /**
     * This method is for connection mysql to java class
     */
    void dbconnect(){
        try {
            con = DriverManager.getConnection(url, un, pw);
            st = con.createStatement();
            
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * this method is for adding data into database
     * @param q is String and you have to add query here.
     * @param frame is a component and you have to enter frame name here.
     */
    void addData(String q, Component frame){
        try {
            dbconnect();
            int a=st.executeUpdate(q);
            if(a>0){
                JOptionPane.showMessageDialog(frame, "Data Added!");
            }
            else{
                JOptionPane.showMessageDialog(frame, "failed!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, "ERROR:"+ex);
        }
    }
    /**
     * this method is for showing data from Sales officer table defined in database.
     * @param query is string 
     * @param table is jTable
     */
     void showDataForSalesOfficerTable(String query,JTable table){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            rs=st.executeQuery(query);
            while (rs.next() ) {
            dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
            rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sales_Officers.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
     /**
      * this method is for updating data 
      * @param query is string
      * @param frame is JFrame
      */
     void updateData(String query,JFrame frame){
        try {
            dbconnect();
            int a =st.executeUpdate(query);
            if(a>0){
                JOptionPane.showMessageDialog(frame, "Updated!");
            }
            else{
                 JOptionPane.showMessageDialog(frame, "Failed!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     String singledata(String query){
         String data="";
        try {
            dbconnect();
            rs=st.executeQuery(query);
            if(rs.next()){
              data=rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
     }
     /**
      * this method is for getting Real-time data from database; 
      * @param query is string
      * @param table is jTable
      */
     void searchData(String query, JTable table){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            rs=st.executeQuery(query);
            dtm.setRowCount(0);
            while(rs.next()){
                dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
     /**
      * this method is for getting data from suppliers table defined in database
      * @param query is string
      * @param table is jTable
      */
     void showDataForSuppliersTable(String query,JTable table){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            rs=st.executeQuery(query);
            while (rs.next()) {
            dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sales_Officers.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
     /**
      * this method is for getting single value from database and set it to combo box
      * @param j is a jCombobox.
      */
     void  getDataFromCombo(JComboBox j,String query){
       try { 
        dbconnect();
        j.removeAllItems();
         j.addItem("Select");
             rs=st.executeQuery(query);
             while(rs.next()){
                 j.addItem(rs.getString(1));
             }
         } catch (SQLException e) {
         }
        }
     /**
      * this method is for auto increment 
      * @param query is String
      * @return int value 
      */
     int autoIdorBillorGR(String query){
         int a=0;
        try {
            dbconnect();
            rs=st.executeQuery(query);
            while(rs.next()){
                a=Integer.parseInt(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a; 
     }
     void showPurchaseEntry(String query, JTable table){
         try {
             dbconnect();
             DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            rs=st.executeQuery(query);
            int i=0;
            while (rs.next()){i++;
                dtm.addRow(new Object[]{i,rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)});
            }
             
         } catch (Exception e) {
         }
     }
     void addBankOrCash(String q){
        try {
            dbconnect();
            int a=st.executeUpdate(q);
            if(a>0){
                
            }
            else{
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     void showBankData(JTable table,JFrame frame,String query){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            rs=st.executeQuery(query);
            dtm.setRowCount(0);
            for(int i=0;rs.next();){i++;
                dtm.addRow(new Object[]{i,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(frame, ex);
        }
     }
     void showCashData(String query,JTable table){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            rs=st.executeQuery(query);
            dtm.setRowCount(0);
            for(int i=0;rs.next();){i++;
            dtm.addRow(new Object[]{i,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            } 
        } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     void showCostData(String query, JTable table){
        try {
            dbconnect();
            DefaultTableModel dtm=(DefaultTableModel)table.getModel();
            rs=st.executeQuery(query);
            dtm.setRowCount(0);
            for(int i=0;rs.next();){i++;
            dtm.addRow(new Object[]{i,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)});
            }  } catch (SQLException ex) {
            Logger.getLogger(dbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 }
