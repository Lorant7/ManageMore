/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cescoandtomas.managemore;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class TransferPanel extends javax.swing.JPanel{

        HashMap<String, String> facilities = new HashMap<>();
        HashMap<String, String> products = new HashMap<>();
        HashMap<String, String> vehicles = new HashMap<>();
        
        public JDialog jd;
        public TableInfo info;
        
    /*
     * Creates new form InsertPanel
     */
        
    public TransferPanel(JDialog jd, TableInfo info) {
        // we store the dialog box that created this panel
        //so we can close it when we are done
        this.jd = jd;
        jd.setModal(false);
        this.info = info;
        initComponents();
        setupComboBox();
        
        //change the label to display the current table name
        
       
    }
    
    private void updateStockCombo(){
        
       //updates the values that are shown under the product combo box.
       //this func is called anytime a user changes the first facility to transfer stock from.
       jComboBox2.removeAllItems();
       products.clear();
       try{
       Connection con = Frame.getCon();
       String stmt = String.format("SELECT DISTINCT * FROM stock, product  WHERE facilityID = %s AND stock.productID = product.productID",facilities.get(jComboBox1.getSelectedItem()));
       System.out.println(stmt);
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(stmt);
       
       //rs holds all stock that a warehouse holds. We populate the product hashmap with every product name mapped to its id.
      
       while(rs.next()){
          
            
        String id = rs.getString("productID");
        String name = rs.getString("name");
        String prodDesc = rs.getString("description");
        String amount = rs.getString("amount");
       
        
        String dispString = name + " - " + prodDesc + " Amount: " + amount;
        System.out.println(dispString);
          
        products.put(dispString,id);
        
        jComboBox2.addItem(dispString);
        }
       
       
       
       
       
       
       
       }catch(Exception e){
           
           e.printStackTrace();
          
       }
       
       
       
        
        
    }
     private void setupComboBox(){
        //initializes the values of the combo boxes to hold the attributes of the table.
        //first remove the sample entries from all
        jComboBox1.removeAllItems(); //facility 1
        jComboBox2.removeAllItems(); //product
        jComboBox3.removeAllItems(); //vehicle
        jComboBox4.removeAllItems(); //facility 2
       
        
        
        //this function takes the name and ID of each object and stores them as a map.
        //the product and facility ID map to its name.
        //so after the user enters all input, a query can be made to perform the result.
        
        try{
        Connection con = Frame.getCon(); // get the connection for the queries we are about to do
       
        //get all facilities
        String stmt = "SELECT DISTINCT * FROM facility";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(stmt);
        
       
        while(rs.next()){
            
        String facilityID = rs.getString("facilityID");
        String facilityName = rs.getString("name");
        
        facilities.put(facilityName, facilityID);
          
        
        
        jComboBox1.addItem(facilityName);
        jComboBox4.addItem(facilityName);
        }
        
        //get all vehicles
        stmt = "SELECT DISTINCT * FROM vehicle";
        st = con.createStatement();
        rs = st.executeQuery(stmt);
        
       
        while(rs.next()){
            
        String vehicleID = rs.getString("vehicleID");
        String type = rs.getString("type");
        String cap = rs.getString("capacity");
        
        String dispString = type + " - Capacity: " + cap;
        vehicles.put(dispString, vehicleID);
          
        
        
        jComboBox3.addItem(dispString);
        
        updateStockCombo();
       
        }
        
        }catch(Exception e){
            e.printStackTrace();
          
        }
        
        
        
    }
    
    
    private boolean transfer(){
     
        //this statement will be a transaction.
        //first, we check if the amount of product to transfer is more than the vehicles limit.
        //then we check if the source facility has enough to fill the transfer.
        // if those pass, transaction starts. amount of product is added to destination facility, and amount of product is removed from source facility, commit transaction.
        Connection con = Frame.getCon();
       
        try{
           con.setAutoCommit(false);  
        
        //get all user input info
        int userAmount = Integer.parseInt(jTextField2.getText());    
        String oldFacilityID = facilities.get(jComboBox1.getSelectedItem());
        String newFacilityID = facilities.get(jComboBox4.getSelectedItem());
        String userVec = vehicles.get(jComboBox3.getSelectedItem());
        String prodID = products.get(jComboBox2.getSelectedItem());
        //check source facility has enough
        
        //check source and dest arent the same
        
        //check amount greater than vehicle capacity
   
        //begin transaction
        
        //make the changes to the two stock tables
        Statement st = con.createStatement();
        
        String subOld = String.format("UPDATE stock SET amount = amount - %d WHERE facilityID = %s and productID = %s;",userAmount, oldFacilityID, prodID);
        String addNew = String.format("UPDATE stock SET amount = amount + %d WHERE facilityID = %s and productID = %s;",userAmount, newFacilityID, prodID);
        
        st.executeUpdate(subOld);
        st.executeUpdate(addNew);
        

        //have to see if destination facility has stock of that product first.
        String stockQuery = String.format("SELECT * FROM stock WHERE facilityID = %s AND productID = %s", newFacilityID, prodID);
        System.out.println(stockQuery);
        ResultSet rs = st.executeQuery(stockQuery);
        //if the query returns 0 rows, insert new stock. IF query returns 1 row, increase the productamount by amount.
        if(rs.next() == false){
            //no stock. Create it
            String addStock = String.format("INSERT INTO stock VALUES (%s,%d,%d,%s)",prodID, userAmount, userAmount+50, newFacilityID);
            st.executeUpdate(addStock);
            
        }else{
            //stock found. the rs holds the stock row
            int amount = rs.getInt("amount") + userAmount;
            String updateStock = String.format("UPDATE stock SET amount = %d WHERE productID = %s AND facilityID = %s",amount, prodID, newFacilityID);
            st.executeUpdate(updateStock);
        }
        
        //make the change to Orders
   
        //the transaction was sucessful
            con.commit();
            con.setAutoCommit(true);
        }catch(Exception e){
            //error has occured.
            //rollback the changes made
            try{
                con.rollback();
                
            }catch(Exception f){
                
                f.printStackTrace();
            }
            
            //the error dialog is handled in the button handling function.
            return false; // statement failed
            
        }
        
        
        Frame.refreshTabs();
        return true; //statements sucessfully executed
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Select Facility to Transfer From");

        jLabel3.setText("Select Product to Transfer");

        jLabel4.setText("Enter Amount to Transfer");

        jLabel5.setText("Select Vehicle");

        jLabel6.setText("Select Facility to Transfer to");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, 0, 200, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //this is the button for applying changes.
        //we call delete, and if it succeeds this dialog box closes.
        //if it fails an error dialog shows and this remains open.
        
        
        boolean success = transfer();
        System.out.println(success);
        if(success){
            //successful delete
            jd.dispose();
            
            
        }else{
            //open error dialog
            //TODO- ONLY GIVE OPTION TO CLOSE THE MENU, NOT BOTH OK AND CANCEL
            JOptionPane.showConfirmDialog(null,"Error: entry does not exist", "Delete Error" ,JOptionPane.CANCEL_OPTION);
           
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //this is the cancel button
        //closes the dialog box
        jd.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        //first facility combo box changed.
        //need to update the stock combobox
        updateStockCombo();
       
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
