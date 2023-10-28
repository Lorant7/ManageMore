/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cescoandtomas.managemore;
import javax.swing.*;


/**
 *
 * @author franc
 */
public class DisplayPanel {
    //This component holds all the rows of a specific table. When the user clicks a tab, the database retrieves the table specified by the name of the tab.
    //All of the objects will be in a row of 5, with automatically expanding vertical rows and a scrollbar
    
    JPanel p = new JPanel();
    
    //first, we retrieve the database data.
    Table t = getTable();
    //need to find how many items are in the table
    int items = t.getAmountItems();
    //need to find how many rows we need, we allready know 5 from column
    int rows = (items / 5) +1; //if there are 4 items, rows will be 0 due to integer division, so we add an extra row.
    //lastly, we find the vertical and horiz gap that looks the best
    //TODO: find the vertical and horiz gap that looks the best
    int verticalGap = 0;
    int horizontalGap = 0;
    //we now make the layout manager to display all of the objects
    
    LayoutManager lm = new GridLayout(rows,5,horizontalGap,verticalGap);
    p.changeLayoutManager();
    
    
}
