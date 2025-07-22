/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



/**
 *
 * @author mypc
 */
public class Borrower_Form extends javax.swing.JFrame{

 private Connection connection;
private boolean ascendingOrder = true;   
private List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 private static final String username ="root";
  private static final String password ="12345";
  private static final String dataconnect = "jdbc:mysql://localhost:3306/connectors";
  private SortOrder sortOrder = SortOrder.ASCENDING;

  
  Connection sqlConn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  int q,i,id,deleteItem;
    
    public Borrower_Form() {
     initComponents(); 
  
     updateDB();

    }


    //====================================================== Function ========================================================
    
    public void updateDB(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataconnect,username,password);
            pst =sqlConn.prepareStatement("select * from borrowerinfo");
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblborrower.getModel();
            recordTable.setRowCount(0);
            while(rs.next()){
                Vector ColumnData = new Vector();
                for (i=1;i<= q ; i++){
                  ColumnData.add(rs.getString("Name"));  
                  ColumnData.add(rs.getString("ID"));  
                  ColumnData.add(rs.getString("Contact")); 
                  ColumnData.add(rs.getString("Address"));
                }
                recordTable.addRow(ColumnData);
            }
        }catch(Exception ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    
    //====================================================== End Function =====================================================
 public void setBorrowerData(String borrowerData, String connectorsData) {
    // Process the borrowerData and connectorsData as needed
    // For example, you can display them in separate JTextAreas or perform other operations
    if (borrowerData != null && connectorsData != null) {
        JOptionPane.showMessageDialog(this, borrowerData, "Borrowing History", JOptionPane.INFORMATION_MESSAGE);
    }
}

   
 
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnback = new javax.swing.JButton();
        lblborrower = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtcontact = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaddress = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnaddborrower = new javax.swing.JButton();
        btnhistory = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblborrower = new javax.swing.JTable();
        btnsort = new javax.swing.JButton();
        txtfilter = new javax.swing.JTextField();
        btnfilter = new javax.swing.JButton();
        btninfo = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setForeground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        btnback.setText("<");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        lblborrower.setFont(new java.awt.Font("Century Schoolbook", 1, 30)); // NOI18N
        lblborrower.setText("BORROWER MANAGEMENT");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Name: ");

        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setText("ID:");

        txtcontact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontactActionPerformed(evt);
            }
        });

        txtaddress.setColumns(20);
        txtaddress.setRows(5);
        jScrollPane1.setViewportView(txtaddress);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setText("Contact Number: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setText("Address: ");

        btnaddborrower.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnaddborrower.setText("ADD");
        btnaddborrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddborrowerActionPerformed(evt);
            }
        });

        btnhistory.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnhistory.setText("HISTORY");
        btnhistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhistoryActionPerformed(evt);
            }
        });

        tblborrower.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Contact Number", "Address"
            }
        ));
        jScrollPane2.setViewportView(tblborrower);

        btnsort.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnsort.setText("SORT");
        btnsort.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnsort.setBorderPainted(false);
        btnsort.setPreferredSize(new java.awt.Dimension(40, 40));
        btnsort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsortActionPerformed(evt);
            }
        });

        btnfilter.setBackground(new java.awt.Color(204, 204, 255));
        btnfilter.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnfilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Filter.png"))); // NOI18N
        btnfilter.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnfilter.setBorderPainted(false);
        btnfilter.setMinimumSize(new java.awt.Dimension(40, 40));
        btnfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfilterActionPerformed(evt);
            }
        });

        btninfo.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btninfo.setText("BORROWER INFO");
        btninfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnback)
                        .addGap(118, 118, 118)
                        .addComponent(lblborrower))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnhistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnaddborrower, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btninfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnsort, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfilter, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblborrower))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnback)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btninfo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcontact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnaddborrower)
                        .addGap(18, 18, 18)
                        .addComponent(btnhistory)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnfilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfilter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsort, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        btnfilter.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void btnaddborrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddborrowerActionPerformed

                                                 
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataconnect, username, password);

            // Check if borrower ID already exists
            String checkQuery = "SELECT COUNT(*) FROM borrowerinfo WHERE ID = ?";
            pst = sqlConn.prepareStatement(checkQuery);
            pst.setString(1, txtID.getText());
            ResultSet resultSet = pst.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);

            if (count > 0) {
                // Borrower ID already exists
                JOptionPane.showMessageDialog(this, "Borrower ID already exists. The borrower information will not be added again.");
            } else {
                // Borrower ID does not exist, insert the borrower information
                pst = sqlConn.prepareStatement("INSERT INTO borrowerinfo (Name, ID, Contact, Address) VALUES (?, ?, ?, ?)");

                if (txtname.getText().isEmpty() || txtID.getText().isEmpty() || txtcontact.getText().isEmpty() || txtaddress.getText().isEmpty()) {
                    throw new IllegalArgumentException("Please fill in all the fields.");
                }

                pst.setString(1, txtname.getText());
                pst.setString(2, txtID.getText());
                pst.setString(3, txtcontact.getText());
                pst.setString(4, txtaddress.getText());

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) { //check if any rows were affected 
                    //If rowsAffected is greater than 0, it means that the insertion was successful
                    JOptionPane.showMessageDialog(this, "Borrower's Information successfully added!");
                    updateDB();
                } else { //If rowsAffected is 0, it means that the insertion failed
                    JOptionPane.showMessageDialog(this, "Failed to add borrower's information.");
                }
            }

        } catch (ClassNotFoundException ex) {// incorrect classpath or missing driver JAR file
            java.util.logging.Logger.getLogger(Borrower_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        // Clear the input fields
        txtname.setText("");
        txtID.setText("");
        txtcontact.setText("");
        txtaddress.setText("");
    
    }//GEN-LAST:event_btnaddborrowerActionPerformed

    private void txtcontactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontactActionPerformed

    private void btnhistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhistoryActionPerformed
 
try {//establishes a connection to the MySQL database 
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection sqlConn = DriverManager.getConnection(dataconnect, username, password);

    // Query to fetch all data from connectors and borrowerinfo tables in descending order of date
    String query = "SELECT c.DateBorrow, c.Title, b.Name, b.ID " +
                   "FROM connectors c " +
                   "JOIN borrowerinfo b ON c.borrowerID = b.ID " +
                   "ORDER BY c.DateBorrow DESC";
    PreparedStatement pst = sqlConn.prepareStatement(query);
    ResultSet rs = pst.executeQuery();

    StringBuilder history = new StringBuilder();
    history.append("=== Book Borrowing History ===\n\n");
    while (rs.next()) {
        /*Data from each row of the ResultSet is extracted, and the history string is 
        appended with the relevant information, */
        String date = rs.getString("DateBorrow");
        String title = rs.getString("Title");
        String name = rs.getString("Name");
        String borrowerId = rs.getString("ID");

        history.append("DateBorrow: ").append(date).append("\n");
        history.append("Title: ").append(title).append("\n");
        history.append("Name: ").append(name).append("\n");
        history.append("Borrower ID: ").append(borrowerId).append("\n");
        history.append("--------------------\n");
    }
//check is performed to determine if any data was retrieved.
    if (history.length() == 0) {
        JOptionPane.showMessageDialog(null, "No Borrowing History Found", "Borrowing History", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, history.toString(), "Borrowing History", JOptionPane.INFORMATION_MESSAGE);
    }

    sqlConn.close();
} catch (ClassNotFoundException | SQLException ex) {
    ex.printStackTrace();
}

    }//GEN-LAST:event_btnhistoryActionPerformed

    private void btnfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfilterActionPerformed
//        // TODO add your handling code here:
//      DefaultTableModel model = (DefaultTableModel)tblborrower.getModel();
//      TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
//      tblborrower.setRowSorter(tr);
//      tr.setRowFilter(RowFilter.regexFilter(txtfilter.getText().trim()));
      
  /* 1. method filters the rows of the tblborrower JTable based on the text entered in the txtfilter JTextField.
     2.  uses a TableRowSorter to achieve the filtering.
      */    
// TODO add your handling code here:
DefaultTableModel model = (DefaultTableModel) tblborrower.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
tblborrower.setRowSorter(tr);

// Assuming the "Name" column is the first column (index 0) in the table
int nameColumnIndex = 0;

tr.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
    @Override
    public boolean include(Entry<? extends DefaultTableModel, ? extends Integer> entry) {
        String filterText = txtfilter.getText().trim().toLowerCase();
        int modelRow = entry.getIdentifier();
        String nameValue = model.getValueAt(modelRow, nameColumnIndex).toString().toLowerCase();

        return nameValue.contains(filterText);
    }
});

        
    }//GEN-LAST:event_btnfilterActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
Mini_Library miniLibrary = new Mini_Library(this);
   
    // Make the Mini_Library JFrame visible
    miniLibrary.setVisible(true);
    
    // Close the current Borrower_Form JFrame
    this.dispose();
        
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnsortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsortActionPerformed
        // TODO add your handling code here:

// It retrieves the DefaultTableModel from the tblborrower JTable. 
try {
    DefaultTableModel model = (DefaultTableModel) tblborrower.getModel();
    model.setRowCount(0); //clears the existing rows in the table to avoid duplication when updating the data.

    // Execute a SELECT statement to fetch data from the borrowerinfo table
    pst = sqlConn.prepareStatement("SELECT * FROM borrowerinfo");
    ResultSet rs = pst.executeQuery();

    while (rs.next()) {
        String date = rs.getString("Name");
        String title = rs.getString("ID");
        String name = rs.getString("Contact");
        String borrowerId = rs.getString("Address");

        Object[] row = { date, title, name, borrowerId };
        model.addRow(row);
    }

    rs.close();
    pst.close();

    // Create a TableRowSorter if it doesn't exist or update the existing one
    if (tblborrower.getRowSorter() == null) {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        sorter.setComparator(0, (name1, name2) -> name1.toString().compareTo(name2.toString()));
        tblborrower.setRowSorter(sorter);
    } else {
        // Toggle between ascending and descending order
        sortOrder = (sortOrder == SortOrder.ASCENDING) ? SortOrder.DESCENDING : SortOrder.ASCENDING;
        tblborrower.getRowSorter().setSortKeys(Collections.singletonList(new RowSorter.SortKey(0, sortOrder)));
    }

} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}

    
    }//GEN-LAST:event_btnsortActionPerformed

    private void btninfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninfoActionPerformed
        // TODO add your handling code here:
        
        // Get the borrower's name from the user using JOptionPane
        String borrowerName = JOptionPane.showInputDialog(this, "Enter Borrower Name:", "Borrower Info", JOptionPane.PLAIN_MESSAGE);

        // If the user clicked "Cancel" or entered an empty name, do nothing
        if (borrowerName == null || borrowerName.trim().isEmpty()) {
            return;
        }

        // Retrieve the information about the borrower with the entered name
        String borrowerInfo = getBorrowerInfoFromDatabase(borrowerName);

        // Display the borrower's information in a JOptionPane
        JOptionPane.showMessageDialog(this, borrowerInfo, "Borrower Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btninfoActionPerformed


    /**
     * @param args the command line arguments
//     */
    
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
        java.util.logging.Logger.getLogger(Borrower_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Borrower_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Borrower_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Borrower_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            Borrower_Form borrowerForm = new Borrower_Form();

            // Set location of Borrower_Form to center
            borrowerForm.pack();
            borrowerForm.setLocationRelativeTo(null);
            borrowerForm.setVisible(true);
        }
    });
}


   
  private String getBorrowerInfoFromDatabase(String borrowerName) {
        String borrowerInfo = "";

        try {
            // Establish a connection to the MySQL database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection sqlConn = DriverManager.getConnection(dataconnect, username, password);

            // Query to fetch borrower information based on the name entered by the user
            String query = "SELECT b.Name, b.ID, b.Contact, b.Address " +
                           "FROM borrowerinfo b " +
                           "WHERE b.Name = ?";
            PreparedStatement pst = sqlConn.prepareStatement(query);
            pst.setString(1, borrowerName);
            ResultSet rs = pst.executeQuery();

            // Check if any data was retrieved
            if (rs.next()) {
                String borrowerID = rs.getString("ID");

                // Query to fetch borrowing history based on the borrower ID
                String historyQuery = "SELECT c.DateBorrow, c.Title " +
                                      "FROM connectors c " +
                                      "WHERE c.borrowerID = ?";
                PreparedStatement historyPst = sqlConn.prepareStatement(historyQuery);
                historyPst.setString(1, borrowerID);
                ResultSet historyRs = historyPst.executeQuery();

                StringBuilder history = new StringBuilder();
                history.append("Borrower ID: ").append(borrowerID).append("\n");
                history.append("Name: ").append(borrowerName).append("\n");
                history.append("Contact: ").append(rs.getString("Contact")).append("\n");
                history.append("Address: ").append(rs.getString("Address")).append("\n");
                history.append("\n=== Book Borrowing History ===\n");
                while (historyRs.next()) {
                    String date = historyRs.getString("DateBorrow");
                    String title = historyRs.getString("Title");
                    history.append("DateBorrow: ").append(date).append("\n");
                    history.append("Title: ").append(title).append("\n");
                    history.append("--------------------\n");
                }

                borrowerInfo = history.toString();
                historyRs.close();
                historyPst.close();
            } else {
                borrowerInfo = "Borrower not found!";
            }

            rs.close();
            pst.close();
            sqlConn.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            borrowerInfo = "Error occurred while fetching borrower information.";
        }

        return borrowerInfo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddborrower;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btnfilter;
    private javax.swing.JButton btnhistory;
    private javax.swing.JButton btninfo;
    private javax.swing.JButton btnsort;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblborrower;
    private javax.swing.JTable tblborrower;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtaddress;
    private javax.swing.JTextField txtcontact;
    private javax.swing.JTextField txtfilter;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
