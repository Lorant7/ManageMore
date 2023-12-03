/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.cescoandtomas.managemore;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author franc
 */
public class PurchasePanel extends javax.swing.JPanel{
    
        
        HashMap<String,String> products = new HashMap<>();
        HashMap<String,String> facilities = new HashMap<>();
        String price;

        public JDialog jd;
        public TableInfo info;
        
    /*
     * Creates new form InsertPanel
     */
        
    public PurchasePanel(JDialog jd, TableInfo info) {
        // we store the dialog box that created this panel
        //so we can close it when we are done
        this.jd = jd;
        jd.setModal(false);
        this.info = info;
        initComponents();
        redrawText(info);
        setupComboBox();
        
        //change the label to display the current table name
        
       
    }
    private void redrawText(TableInfo info){
        //retraws the jlabel to display what table is selected
       
        //jLabel1.setText("Enter Primary Key " + info.pkey + " to Delete from "+ info.displayName);
        
    }
    
     private void setupComboBox(){
        //initializes the values of the combo boxes to hold the attributes of the table.
        //first remove the sample entries from all
        jComboBox2.removeAllItems(); //product
        jComboBox3.removeAllItems(); //facility
       
        
        
        //this function takes the name and ID of each object and stores them as a map.
        //the product and facility ID map to its name.
        //so after the user enters all input, a query can be made to perform the result.
        
        try{
        Connection con = Frame.getCon(); // get the connection for the queries we are about to do
        //get all unique products
        String stmt = "SELECT * FROM product";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(stmt);
        
        
        
        while(rs.next()){
            
        String id = rs.getString("productID");
        String name = rs.getString("name");
        String prodDesc = rs.getString("description");
        price = rs.getString("price");
        
        String dispString = name + " - " + prodDesc + " Price: " + price + "$";
          
        products.put(dispString, id);
        
        jComboBox2.addItem(dispString);
        }
        
      
      
        //get all facilities
        stmt = "SELECT DISTINCT * FROM facility";
        st = con.createStatement();
        rs = st.executeQuery(stmt);
        
       
        while(rs.next()){
            
        String facilityID = rs.getString("facilityID");
        String facilityName = rs.getString("name");
        
        facilities.put(facilityName, facilityID);
          
        
        
        jComboBox3.addItem(facilityName);
        }
        
        
        
        
        
        
        
        
        }catch(Exception e){
            e.printStackTrace();
          
        }
        
        
        
    }
    
    private boolean purchase(){
       //this is a transaction and will rollback on failure
       Connection con = Frame.getCon();
        try{
        
        con.setAutoCommit(false);
        Statement st = con.createStatement();
        //create a TRANSACTION QUERY that joins 5 tables: Vendor, sells, product, purchases, stock
        
        //the query will check if that warehouse has a stock obj for that product. If it doesnt, it makes one
        //for example, if facility 1 buys 20 pencils but never bought pencils, a stock for pencils is created and will have amount 20.
        // if facility 1 buys 20 pencils and currently has 200 pencils, a new stock will not be created and instead amount will = 220.
        
        
        //check to see if fac has a stock
        int userAmount = Integer.parseInt(jTextField2.getText());
        
        String userFacName = (String)jComboBox3.getSelectedItem();
        String userProdName = (String)jComboBox2.getSelectedItem();
        System.out.println(userProdName);
        
       //we have the names, now we retrieve the IDs 
        String facilityID = facilities.get(userFacName);
        String prodID = products.get(userProdName);
        
        String stockQuery = String.format("SELECT * FROM stock WHERE facilityID = %s AND productID = %s", facilityID, prodID);
        System.out.println(stockQuery);
        ResultSet rs = st.executeQuery(stockQuery);
        //if the query returns 0 rows, insert new stock. IF query returns 1 row, increase the productamount by amount.
        if(rs.next() == false){
            //no stock. Create it
            String addStock = String.format("INSERT INTO stock VALUES (%s,%d,%d,%s)",prodID, userAmount, userAmount+50, facilityID);
            st.executeUpdate(addStock);
            
        }else{
            //stock found. the rs holds the stock row
            int amount = rs.getInt("amount") + userAmount;
            String updateStock = String.format("UPDATE stock SET amount = %d WHERE productID = %s AND facilityID = %s",amount, prodID, facilityID);
            st.executeUpdate(updateStock);
        }
        //now we update the purchase
        
        //purchase
        Date sqlDate = new Date(System.currentTimeMillis());
        System.out.println(sqlDate);
        String purchaseUpdate = String.format("INSERT INTO purchases VALUES(%s,%s,%d, %f, '",facilityID,prodID, userAmount, Double.parseDouble(price)) + sqlDate + "')";
            st.executeUpdate(purchaseUpdate);
            

        con.commit();
        con.setAutoCommit(true);
        }catch(Exception e){
            //query failed, we must rollback
            try{
                con.rollback();
            }catch(Exception f){
                f.printStackTrace();
                return false;
            }
            e.printStackTrace();
            //the error dialog is handled in the button handling function.
            //the transaction will rollback here
            return false; // statement failed
            
        }
        
        
        //update the stock tab.
        Frame.refreshTabs();
       
        return true; //statement sucessfully executed
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
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

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

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Select Product to Purchase");

        jLabel3.setText("Select Facility to Ship To");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Enter Amount");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jComboBox2, 0, 224, Short.MAX_VALUE)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //this is the button for applying changes.
        //we call delete, and if it succeeds this dialog box closes.
        //if it fails an error dialog shows and this remains open.
        boolean success = purchase();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
