/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cescoandtomas.managemore;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author franc
 */
public class TableInfo {
    //this class holds the name of a table, the primary key, and the columns of a table.
    //it access this through the metadata of the connection
    DisplayPanel dp;
    String dbName;
    String displayName;
    HashMap<String,String> attributes = new HashMap<>();
    String pkey;
    String schema;
    
    public TableInfo(DisplayPanel dp, String displayName, String dbName,  Connection con){
        this.dp = dp;
        this.displayName = displayName;
        this.dbName = dbName;
        try{
        DatabaseMetaData dbmd = con.getMetaData();
        ResultSet keys = dbmd.getPrimaryKeys("managemore",null,dbName);
        keys.next();
        this.pkey = keys.getString("COLUMN_NAME"); //this constant returns the PK of the table.
        //now we get all of the columns
       
        String query = "SELECT * FROM " + dbName + " WHERE 1 = 2";//the where clause returns an empty table. If we just need col names, its faster.
        Statement stmt = Frame.getCon().createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        
        int colCount = rsmd.getColumnCount();
        
        for(int i = 1; i <= colCount; i++){
            String name = rsmd.getColumnName(i);
            String type = rsmd.getColumnTypeName(i);
            //type is an integer denoting the type of 
            //System.out.println(name + " : " + type);
            attributes.put(name,type);
            
            
        }
        
        this.schema = getSchema();
        }catch(Exception e){
            //something went very wrong
            e.printStackTrace();
        }
       
        
    }
    
    private String getSchema(){
        //returns a string containing the schema of the db seperated by newlines.
        
        String schema = "";
        
        for(Map.Entry<String, String> entry : this.attributes.entrySet()){
            
            String key = entry.getKey();
            String value = entry.getValue();
            
            schema += key + " : " + value + " \n";
            
        }
        
        return schema;
    }
    
    
}
