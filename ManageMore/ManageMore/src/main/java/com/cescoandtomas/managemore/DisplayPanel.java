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
    public DefaultTableModel model; // we store this so it is easy to 
    public JTable table;
    public TableInfo info;
    
    public DisplayPanel(JTable table, String dbName, String displayName){
    //the panel is initialized with a string of a DB table.
    //we store the table and name to make it easy to update 
    super(table);
    this.table = table;
    this.model = (DefaultTableModel)table.getModel();
    this.info = new TableInfo(this, displayName, dbName, Frame.con);
    setVisible(true);
    
    }
    
    //we make this function static, because to initialize the panel, we cant make the table in the constructor.
    //we have to make the table before the displayPanel is created.
    public static JTable getTable(String reqTable){
        //creates a jTable with the data from the sql table reqTable.
        //first, we retrieve the database data.
    //we are going to execute a query based on the parameter, get the resultset and put it into a JTable
    
    try{
        
        Statement st = Frame.getCon().createStatement(); 
        String query = "SELECT * FROM " + reqTable; 
        ResultSet rs = st.executeQuery(query); //the resultset holds the results of the query 
        ResultSetMetaData rsmd = rs.getMetaData(); // the metadata has info like how many columns and their names
        
        //we will gather the information we need to make a DefaultTableModel
        int cols = rsmd.getColumnCount();
        String[] names = new String[cols];
        for(int i = 1; i <= cols; i++){
            names[i-1] = rsmd.getColumnName(i);
            //System.out.println(names[i-1]);
        }
        
        //all of the column names are stored in names
        
        //each entry in resultset is a tuple from the table.
        //we have to fill the row with the tuple information
        ArrayList<Object[]> allRows = new ArrayList<>();
        while(rs.next()){
       
        Object[] row = new Object[cols];
        //have to start the index at 1, as 1 corresponds to column 1
            for(int i = 1; i <= cols; i++){
            //TODO: handling for BLOBS goes here
            row[i-1] = rs.getObject(i);
            //System.out.println(rs.getString(i));
            }
            
            allRows.add(row);
            
        }   
        //we have the column names and data, we have to transform the arrayList into a 2d array
        Object[][] rows = new Object[allRows.size()][];
        
        allRows.toArray(rows);// turns the arrayList of object[] into a 2d array for the table model
        
        DefaultTableModel model = new DefaultTableModel(rows,names);
        //System.out.println(model.getDataVector().toString());
        JTable table = new JTable(model){
            //prevents the table from being editied.
            //we do this by overriding the function that checks for editableness
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false); // prevent columns from being reordered.
        table.setAutoCreateRowSorter(true);// allows sorting of columns by clicking them
        
        
        return table;
       
        
    } catch(Exception e){
        e.printStackTrace();
        return null;
    }
   
 }
    
    public void updateTable(){
        //this func is a wrapper for updating the table.
        //we dont change the JTables directly but we manipulate the model.
        //so we create a new JTable, which executes the SELECt query,
        //and replace our old data with new.
        this.model = (DefaultTableModel) getTable(this.info.dbName).getModel();
        this.table.setModel(model);
        table.repaint();
        
        
    }
    
   
    
   
}
