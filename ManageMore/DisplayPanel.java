/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cescoandtomas.managemore;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 *
 * @author franc
 */
public class DisplayPanel extends JScrollPane{
    //this component holds the JTable that is populated from the DB.
    //It has a scrollbar
    DefaultTableModel model; // we store this so it is easy to 
    public DisplayPanel(JTable table){

    super(table);
    this.model = (DefaultTableModel)table.getModel();
    setVisible(true);
    
    }
    
   
    
   
}
