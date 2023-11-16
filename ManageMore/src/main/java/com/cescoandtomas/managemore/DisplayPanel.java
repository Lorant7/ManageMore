/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cescoandtomas.managemore;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.*;


/**
 *
 * @author franc
 */
public class DisplayPanel extends JScrollPane{
    //This component holds all the rows of a specific table. When the user clicks a tab, the database retrieves the table specified by the name of the tab.
    //All of the objects will be in a row of 5, with automatically expandingvb nm rows and a scrollbar
    
    public DisplayPanel(){
    setup();
    }
    
    private void setup(){
        //first, we retrieve the database data.
    //we are going to execute a query based on the name of this displayPanel, get the resultset and put it into a JTable
    
    //TODO: code for query
    JTable jt = new JTable();
    //TODO: code for adding query results to JTable
    
    //TODO: sort the table if requested
    
    //need to find how many items are in the table
    //int items = jt.getAmountItems();
    //need to find how many rows we need, we allready know 5 from column
    int rows = 1;//(items / 5) +1; //if there are 4 items, rows will be 0 due to integer division, so we add an extra row.
    //lastly, we find the vertical and horiz gap that looks the best
    //TODO: find the vertical and horiz gap that looks the best
    int verticalGap = 0;
    int horizontalGap = 0;
    //we now make the layout manager to display all of the objects
    LayoutManager lm = new GridLayout(rows,5,horizontalGap,verticalGap);
    //and add it to the panel
    this.setLayout(lm);
   
    //TODO: any processing steps to make the table get on the jScrollPane
    
    this.add(jt);
    //the table is added, and you can scroll through entries.
    //There will be a displayPanel created for each tab in the main Frame
    //TODO: check if tables update when information is changed
        
    }
}
