/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.cescoandtomas.managemore;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class Frame extends javax.swing.JFrame implements WindowListener {
    public static Connection con = null;
    public static ArrayList<DisplayPanel> panels = new ArrayList<>();
    public static JFrame f;
    
   
    
   //This is the main panel of the applcation.
   //there is a JPanel on the left side that holds all the buttons that modify the DB, as well as the analytic options.
   //On the right side if a JTabbedPane. It holds all of the DisplayPanels that display the tables from the DB.
    
    public Frame() {
        initDataBase();
        initComponents();
        initTabs();
    }
  
    public static Connection getCon(){
        return con;
    }
    
        @Override 
    public void windowClosing(WindowEvent e){
        //this method closes the connection when the x is pressed.
        try{
        con.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    //we dont need these, but to use the windowListener interface to close the JDBC connection, we need to implement them all.
     @Override 
    public void windowDeactivated(WindowEvent e){};
     @Override 
    public void windowActivated(WindowEvent e){};
     @Override 
    public void windowDeiconified(WindowEvent e){};
     @Override 
    public void windowIconified(WindowEvent e){};
     @Override 
    public void windowClosed(WindowEvent e){};
     @Override 
    public void windowOpened(WindowEvent e){};
    
    public void initDataBase(){
        //this function establishes the database connection, and assigns it to a static variable
            try{
              Class.forName("com.mysql.cj.jdbc.Driver");
                //MAY HAVE TO CHANGE WHEN PROJECT IS MOVED TO LAPTOP
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/managemore","root","password");
                //now the infopanels can use the connection to execute sql statements. Must close the connection when the application closes to prevent memory leaks
                
            }catch(Exception e){
                e.printStackTrace();
                
            }
        
        
    }
    
    

   
    public void initTabs(){
        //this function does alot.
        //First, we make all of the displayPanels. Then we read its corresponding table from the DB
        //then we add the panel to the tabbed pane.
        JTabbedPane pane = jTabbedPane2;
        DisplayPanel employee, facility, product,stock,vehicle,vendor, purchases, sells, facilityEmployee, driver, orders;
        employee = new DisplayPanel(DisplayPanel.getTable("employee"),"employee","Employees");
        pane.addTab("Employees", employee);
        facility = new DisplayPanel(DisplayPanel.getTable("facility"),"facility" ,"Facilities");
        pane.addTab("Facilities", facility);
        product = new DisplayPanel(DisplayPanel.getTable("product"),"product","Products");
        pane.addTab("Products", product);
        stock = new DisplayPanel(DisplayPanel.getTable("stock"),"stock","Stock");
        pane.addTab("Stock", stock);
        vehicle = new DisplayPanel(DisplayPanel.getTable("vehicle"),"vehicle","Vehicles");
        pane.addTab("Vehicles", vehicle );
        vendor = new DisplayPanel(DisplayPanel.getTable("vendor"),"vendor", "Vendors");
        pane.addTab("Vendors", vendor );
        purchases = new DisplayPanel(DisplayPanel.getTable("purchases"),"purchases", "Purchases");
        pane.addTab("Purchases", purchases);
        sells = new DisplayPanel(DisplayPanel.getTable("sells"), "sells", "Sells");
        pane.addTab("Sells", sells);
        
        facilityEmployee = new DisplayPanel(DisplayPanel.getTable("facilityEmployee"),"facilityEmployee", "Facility Employees");
        pane.addTab("Facility Employees", facilityEmployee );
        driver = new DisplayPanel(DisplayPanel.getTable("driver"),"driver", "Drivers");
        pane.addTab("Drivers", driver);
        orders = new DisplayPanel(DisplayPanel.getTable("orders"), "orders", "Orders");
        pane.addTab("Orders", orders);
        
        
        //now we add all tabs to an array.
        //we need access to these panels so we can update the jTable when data changes.
       panels.add(employee);
       panels.add(facility);
       panels.add(product);
       panels.add(stock);
       panels.add(vehicle);
       panels.add(vendor);
       panels.add(sells);
       panels.add(purchases);
        
    }
    
    public static void refreshTabs(){
        //Updates all tabs if the database is modified.
        //THIS METHOD MUST EB CALLED AFTER ANY MODIFICATION TO ANY TABLE IN THE DB
        for(DisplayPanel dp : panels){
            dp.updateTable();
           
        }
        
    }
   
 
    public DisplayPanel getCurrentPanel(){
        //reutrns the current panel displayed in the jTabbedPane
        int index = jTabbedPane2.getSelectedIndex();
        return (DisplayPanel) jTabbedPane2.getComponent(index);
       
    }
    public TableInfo getInfo(DisplayPanel p){
        //returns the info for the displaypanels table
        return p.info;
        
    }
    
       /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        jButton4.setText("Vendors");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Insert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Transfer");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Purchase");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Analyitcs");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel1.setText("    DB Actions");

        jLabel2.setText("Product Actions");

        jLabel3.setText("Facility Info");

        jButton8.setText("Refresh");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 905, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    
    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //delete button
        //creates a JDialog and adds a DeletePanel to it.
        JDialog jd = new JDialog(this,"Delete Entry");
        jd.setModal(true);
        jd.add(new DeletePanel(jd,getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //update button
         JDialog jd = new JDialog(this,"Update Entry");
        jd.setModal(true);
        jd.add(new UpdatePanel(jd, getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //insert button
         JDialog jd = new JDialog(this,"Insert Entry");
        jd.setModal(true);
        jd.add(new InsertPanel(jd, getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //purchase button
         JDialog jd = new JDialog(this,"Purchase Products");
        jd.setModal(true);
        jd.add(new PurchasePanel(jd, getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Transfer button
        JDialog jd = new JDialog(this,"Transfer Products");
        jd.setModal(true);
        jd.add(new TransferPanel(jd, getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // analytics
        JDialog jd = new JDialog(this,"Facility Analytics");
        jd.setModal(true);
        jd.add(new AnalyticsPanel(jd, getInfo(getCurrentPanel())));
        jd.pack();
        jd.setLocationRelativeTo(null);
        jd.setResizable(false);
        jd.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // refresh the tables
        refreshTabs();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //set up initial frame
            f = new Frame();
            //the constructor initializes all of the side components attached to this JFrame.
              
            //all of these changes should be in the Frame constructor, however it displays incorrectly if these execute there
            f.setVisible(true); // makes it visible obvously
            f.setState(JFrame.MAXIMIZED_BOTH);
           // f.setResizable(false); // we dont want the window to resize because it will break the view of the tables
            f.setTitle("ManageMore");
            f.setLocationRelativeTo(null);//makes the window in the center of the screen
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
              
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    // End of variables declaration//GEN-END:variables
}
