package final_project;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.function.Consumer;
import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Pattern;
import javax.swing.RowFilter;



public class Mini_Library extends javax.swing.JFrame {
  private Connection connection;
 private DefaultTableModel tableModel;
  private Borrower_Form borrowerForm;
  private static final String username ="root";
  private static final String password ="12345";
  private static final String dataconnect = "jdbc:mysql://localhost:3306/connectors";

  
  Connection sqlConn = null;
  PreparedStatement pst = null;
  ResultSet rs = null;
  int q,i,id,deleteItem;
 
    /**
     * Creates new form Mini_Library
     * @param borrowerData
     * @param 
     */
 public void setBorrowerData(String borrowerData, String connectorsData) {
   
    }
    public Mini_Library(Borrower_Form borrowerForm) {
   this.borrowerForm = borrowerForm;
   initComponents();  
     updateDB();//fetches data from the database and updates the table (tblmain) with the fetched data.
}

private Date calculateReturnDate(Date borrowDate) { //takes a Date object borrowDate and calculates the return date by adding 7 days to the borrowDate
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_MONTH, 7); // Add 7 days to borrow date
        return new Date(calendar.getTimeInMillis());
    }

    //====================================================== Function ========================================================
    
    public void updateDB(){ //responsible for updating the tblmain table with data fetched from the "connectors" table
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataconnect,username,password);
            pst =sqlConn.prepareStatement("select * from connectors");
            rs = pst.executeQuery();
            ResultSetMetaData stData = rs.getMetaData();
            q = stData.getColumnCount();
            DefaultTableModel recordTable = (DefaultTableModel)tblmain.getModel();
            //manage the data in the tblmain table, and it is updated by adding rows of data fetched from the database.
            recordTable.setRowCount(0);
            while(rs.next()){ //iterates over the rows of the result set, and for each row, a new Vector named ColumnData is created to hold the data for that row.
                Vector ColumnData = new Vector();
                for (i=1;i<= q ; i++){
                 ColumnData.add(rs.getString("borrowerID"));  
                  ColumnData.add(rs.getString("ISBN"));  
                   ColumnData.add(rs.getString("Title"));  
                    ColumnData.add(rs.getString("Author")); 
                    ColumnData.add(rs.getString("DateBorrow")); // Add the "Date" column
                    ColumnData.add(rs.getString("DateReturn"));
                }
                recordTable.addRow(ColumnData);
            }
        }catch(Exception ex ){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    

    //====================================================== End Function =====================================================

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblISBN = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        lblauthor = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        txttitle = new javax.swing.JTextField();
        txtauthor = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnsearch = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnborrower = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmain = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtborrowerID = new javax.swing.JTextField();
        txtsearchbook = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        btnreset = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Mreport = new javax.swing.JMenuItem();
        menuexit = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel1.setText("MINI LIBRARY ");

        lblISBN.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblISBN.setText("ISBN: ");

        lbltitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbltitle.setText("Title: ");

        lblauthor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblauthor.setText("Author Name: ");

        txtISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtISBNActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsearch.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/final_project/Google Web Search.png"))); // NOI18N
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnborrower.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        btnborrower.setText("BORROWER");
        btnborrower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrowerActionPerformed(evt);
            }
        });

        tblmain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Borrower's ID", "ISBN", "Title", "Author", "Date Borrow", "Date Return"
            }
        ));
        tblmain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmainMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmain);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Borrower's ID:");

        txtsearchbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchbookActionPerformed(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Arial Black", 1, 15)); // NOI18N
        btnreset.setText("RESET");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(194, 194, 194))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblISBN)
                                    .addComponent(lbltitle)
                                    .addComponent(lblauthor)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtauthor, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                                    .addComponent(txtISBN)
                                    .addComponent(txttitle)
                                    .addComponent(txtborrowerID, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(75, 75, 75)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnadd, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtsearchbook, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(btnreset)
                        .addGap(18, 18, 18)
                        .addComponent(btnborrower)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblISBN)
                        .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltitle)
                    .addComponent(txttitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndelete)
                        .addGap(9, 9, 9)
                        .addComponent(btnupdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblauthor)
                            .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtborrowerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtsearchbook, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnborrower)
                            .addComponent(btnreset)))
                    .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu1.setText("File");

        Mreport.setText("Report");
        Mreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MreportActionPerformed(evt);
            }
        });
        jMenu1.add(Mreport);

        menuexit.setText("Exit");
        menuexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuexitActionPerformed(evt);
            }
        });
        jMenu1.add(menuexit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
////This line retrieves the model of the "tblmain" table and stores it in a DefaultTableModel 
//DefaultTableModel recordTable = (DefaultTableModel) tblmain.getModel();
//int selectedRow = tblmain.getSelectedRow();
//
///*index of the selected row in the "tblmain" table and stores it in the selectedRow variable. 
//The getSelectedRow() method returns -1 if no row is selected. */
//if (selectedRow != -1) { // Check if a row is selected
//    try {
//        int id = Integer.parseInt(recordTable.getValueAt(selectedRow, 0).toString());
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        sqlConn = DriverManager.getConnection(dataconnect, username, password);
//        pst = sqlConn.prepareStatement("UPDATE connectors SET borrowerID = ?, ISBN = ?, Title = ?, Author = ?, DateBorrow = ?, DateReturn = ? WHERE borrowerID = ?");
///*block fetches the primary key (id) of the selected row, converts the text and date picker components' values to strings, 
//  and constructs an SQL UPDATE*/
//
//        pst.setString(1, txtborrowerID.getText());
//        pst.setString(2, txtISBN.getText());
//        pst.setString(3, txttitle.getText());
//        pst.setString(4, txtauthor.getText());
//        pst.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(date.getDate())); // Get the selected date and format it
//        
//        // Calculate the return date (7 days after the borrow date)
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date.getDate());
//        calendar.add(Calendar.DAY_OF_MONTH, 7);
//        String returnDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
//        pst.setString(6, returnDate);
//
//        pst.setInt(7, id);
//
//        int rowsAffected = pst.executeUpdate();//executes the prepared statement and updates the row in the database.
////After executing the update, the number of rows affected is stored in the rowsAffected variable.
//
//        if (rowsAffected > 0) { //checks if any rows were affected by the update if the update was successful
//            JOptionPane.showMessageDialog(this, "Book successfully updated");
//            updateDB(); //efresh the table's data with the updated records from the database.
//        }
//
//    } catch (ClassNotFoundException ex) {
//        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    } catch (SQLException ex) {
//        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//    }
//} else {
//    JOptionPane.showMessageDialog(this, "Please select a row to update.");
//} //If no row is selected (selectedRow == -1)
//

DefaultTableModel recordTable = (DefaultTableModel) tblmain.getModel();
int selectedRow = tblmain.getSelectedRow();

if (selectedRow != -1) { // Check if a row is selected
    try {
        int id = Integer.parseInt(recordTable.getValueAt(selectedRow, 0).toString());

        Class.forName("com.mysql.cj.jdbc.Driver");
        sqlConn = DriverManager.getConnection(dataconnect, username, password);
        pst = sqlConn.prepareStatement("UPDATE connectors SET borrowerID = ?, ISBN = ?, Title = ?, Author = ?, DateBorrow = ?, DateReturn = ? WHERE borrowerID = ?");
        /* Modify the SQL query to update the row based on the 'borrowerID' column. Adjust this based on your actual table schema. */

        pst.setString(1, txtborrowerID.getText());
        pst.setString(2, txtISBN.getText());
        pst.setString(3, txttitle.getText());
        pst.setString(4, txtauthor.getText());
        pst.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(date.getDate()));

        // Calculate the return date (7 days after the borrow date)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date.getDate());
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        String returnDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        pst.setString(6, returnDate);

        pst.setInt(7, id);

        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Book successfully updated");

            // Refresh the JTable with the updated data from the database
            updateDB();
        }

    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
} else {
    JOptionPane.showMessageDialog(this, "Please select a row to update.");
}
 
 // Clear the input fields
    txtborrowerID.setText("");
    txtISBN.setText("");
    txttitle.setText("");
    txtauthor.setText("");
    date.setDate(null);

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        //retrieves the model of the "tblmain" table and stores it in a DefaultTableModel 
//    DefaultTableModel model = (DefaultTableModel)tblmain.getModel();
//    //responsible for sorting and filtering rows in the table.
//      TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
//      tblmain.setRowSorter(tr);
//     tr.setRowFilter(RowFilter.regexFilter(txtsearchbook.getText().trim()));
     //creates a filter that matches the rows containing the specified regular expression pattern
      
DefaultTableModel model = (DefaultTableModel) tblmain.getModel();
TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(model);
tblmain.setRowSorter(tr);

// Assuming the "Name" column is the first column (index 0) in the table
int nameColumnIndex = 2;

tr.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
    @Override
    public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
        String filterText = txtsearchbook.getText().trim().toLowerCase();
        int modelRow = entry.getIdentifier();
        String nameValue = model.getValueAt(modelRow, nameColumnIndex).toString().toLowerCase();

        return nameValue.contains(filterText);
    }
});
    
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnborrowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrowerActionPerformed

    
  Borrower_Form borrowerForm = new Borrower_Form();
  

            // Set location of Borrower_Form to center
            borrowerForm.pack();
            borrowerForm.setLocationRelativeTo(null);
            borrowerForm.setVisible(true);
        



    }//GEN-LAST:event_btnborrowerActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
 

    try {
        // This line loads the MySQL JDBC driver class, which allows the Java application to connect to the MySQL database.
        Class.forName("com.mysql.cj.jdbc.Driver");
        // establishes a connection to the MySQL database
        sqlConn = DriverManager.getConnection(dataconnect, username, password);

        // Input validation: Check whether any of the input fields are empty
        if (txtborrowerID.getText().isEmpty() || txtISBN.getText().isEmpty() || txttitle.getText().isEmpty() || txtauthor.getText().isEmpty()) {
            throw new IllegalArgumentException("Please fill in all the fields.");
        }

        // It takes values from the input fields (borrowerID, ISBN, Title, Author)
        pst = sqlConn.prepareStatement("insert into connectors(borrowerID, ISBN, Title, Author, DateBorrow, DateReturn) values (?, ?, ?, ?, ?, ?)");

        pst.setString(1, txtborrowerID.getText());
        pst.setString(2, txtISBN.getText());
        pst.setString(3, txttitle.getText());
        pst.setString(4, txtauthor.getText());
        pst.setString(5, new SimpleDateFormat("yyyy-MM-dd").format(date.getDate())); // Get the selected date and format it
        

        // Calculate and set the return date
        Date borrowDate = new Date(date.getDate().getTime());
        Date returnDate = calculateReturnDate(borrowDate);
        pst.setDate(6, returnDate); //alculates the return date by adding 7 days to the borrow date (date.getDate()) using the calculateReturnDate function. 

        // Executes the INSERT operation and returns the number of rows affected by the operation.
        int rowsAffected = pst.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Book successfully Added");
            updateDB();
        /*If the INSERT operation affected one or more rows (i.e., successful), a message dialog is displayed, 
        informing the user that the book was successfully added, and the `updateDB()` method is called.*/
        }

    } catch (ClassNotFoundException ex) { // If the MySQL JDBC driver class is not found
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (SQLIntegrityConstraintViolationException ex) {
        JOptionPane.showMessageDialog(this, "ISBN already exists. Please re-enter the ISBN.");
    } catch (SQLException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (NullPointerException ex) {
        JOptionPane.showMessageDialog(this, "Please select a date.");
    } catch (IllegalArgumentException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
    }

    // Clear the input fields
    txtborrowerID.setText("");
    txtISBN.setText("");
    txttitle.setText("");
    txtauthor.setText("");
    date.setDate(null);
    /*clear the input fields (`txtborrowerID`, `txtISBN`, `txttitle`, `txtauthor`) 
    and sets the date to null, effectively clearing the form after a successful book addition 
    or after an exception has been handled.*/

    // Update the tblmain to show the return date for the newly added book
    updateDB();




    }//GEN-LAST:event_btnaddActionPerformed
private JFrame frame;
    private void menuexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuexitActionPerformed
        // TODO add your handling code here:
        frame = new JFrame ("Exit");
        if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","MYSQL Connector",
                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION ){
            }
        System.exit(0);
        
        //The message to be displayed in the dialog.
        //The dialog will have "Yes" and "No" buttons.
    }//GEN-LAST:event_menuexitActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed


DefaultTableModel recordTable = (DefaultTableModel) tblmain.getModel();
int selectedRow = tblmain.getSelectedRow();

try {
// This condition checks if a row is selected in the JTable. If selectedRow is not -1, it means that a row is selected.
        if (selectedRow != -1) { 
    String borrowerID = recordTable.getValueAt(selectedRow, 0).toString();
    int deleteItem = JOptionPane.showConfirmDialog(null, "Confirm if you want to delete the book?", "Warning", JOptionPane.YES_NO_OPTION);
    if (deleteItem == JOptionPane.YES_OPTION) {
        Class.forName("com.mysql.cj.jdbc.Driver");
        sqlConn = DriverManager.getConnection(dataconnect, username, password);

        // Delete the book record from the connectors table based on borrowerid
        pst = sqlConn.prepareStatement("DELETE FROM connectors WHERE borrowerID = ?");
        pst.setString(1, borrowerID);
        int rowsDeleted = pst.executeUpdate();
        if (rowsDeleted > 0) {
            JOptionPane.showMessageDialog(null, "Book Record Deleted"); // notify the user that the book record has been deleted.

            // Delete the corresponding row in the Borrower_Form table
            pst = sqlConn.prepareStatement("DELETE FROM borrowerinfo WHERE ID = ?");
            pst.setString(1, borrowerID);
            pst.executeUpdate();

            recordTable.removeRow(selectedRow); // Remove the row from the JTable
        } else {
            JOptionPane.showMessageDialog(null, "No book record found with the selected ID.", "Error", JOptionPane.ERROR_MESSAGE);
        } //no row selected in the JTable,

        txtborrowerID.setText("");
        txtborrowerID.requestFocus();
        txtISBN.setText("");
        txtISBN.requestFocus();
        txttitle.setText("");
        txtauthor.setText("");
    }
} else {
    JOptionPane.showMessageDialog(null, "Please select a row to delete.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}catch(Exception ex){
        
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tblmainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmainMouseClicked
                              
DefaultTableModel recordTable = (DefaultTableModel) tblmain.getModel();
int selectedRow = tblmain.getSelectedRow(); //gets the index of the selected row in the tblmain JTable.
// not selected = -1

try { 
    /*parse the data from the first column of the selected row as an integer and stores
    it in a variable named id. If the conversion is successful, the id will hold the 
    integer value of the first column in the selected row.*/
    id = Integer.parseInt(recordTable.getValueAt(selectedRow, 0).toString());
} catch (NumberFormatException e) {
    e.printStackTrace();
}

txtborrowerID.setText(recordTable.getValueAt(selectedRow, 0).toString());
txtISBN.setText(recordTable.getValueAt(selectedRow, 1).toString());
txttitle.setText(recordTable.getValueAt(selectedRow, 2).toString());
txtauthor.setText(recordTable.getValueAt(selectedRow, 3).toString());

// Set the date in JDateChooser
//retrieves the date data from the selected row, parses it into a java.util.Date
String dateStr = recordTable.getValueAt(selectedRow, 4).toString();
try {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date utilDate = dateFormat.parse(dateStr);
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
    date.setDate(sqlDate);
} catch (ParseException ex) {
    ex.printStackTrace();
}


        
    }//GEN-LAST:event_tblmainMouseClicked

    private void txtsearchbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchbookActionPerformed

    }//GEN-LAST:event_txtsearchbookActionPerformed

    private void MreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MreportActionPerformed

StringBuilder connectorsData = new StringBuilder();
StringBuilder borrowerData = new StringBuilder();
//store the retrieved data for further processing and display.


try {
    // Register the MySQL JDBC driver and establish a connection using DriverManager.getConnection()
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(dataconnect, username, password);

    // Fetch data from connectors table and store in resultSet
    String connectorsQuery = "SELECT * FROM connectors";
    PreparedStatement connectorsStmt = connection.prepareStatement(connectorsQuery);
    ResultSet connectorsResult = connectorsStmt.executeQuery();

    connectorsData.append("====== Connectors Table ======\n\n");
    while (connectorsResult.next()) {
        String connectorISBN = connectorsResult.getString("ISBN");
        String connectorTitle = connectorsResult.getString("Title");
        String connectorAuthor = connectorsResult.getString("Author");
        connectorsData.append("ISBN: ").append(connectorISBN).append("\n");
        connectorsData.append("Title: ").append(connectorTitle).append("\n");
        connectorsData.append("Author: ").append(connectorAuthor).append("\n------------\n");
    }

    // Fetch data from borrowerinfo table
    String borrowerInfoQuery = "SELECT * FROM borrowerinfo";
    PreparedStatement borrowerInfoStmt = connection.prepareStatement(borrowerInfoQuery);
    ResultSet borrowerInfoResult = borrowerInfoStmt.executeQuery();

    borrowerData.append("====== Borrower Info Table ======\n\n");
    while (borrowerInfoResult.next()) {
        String borrowerName = borrowerInfoResult.getString("Name");
        String borrowerId = borrowerInfoResult.getString("ID");
        String borrowerContact = borrowerInfoResult.getString("Contact");
        String borrowerAddress = borrowerInfoResult.getString("Address");

        // Fetch quantity of books borrowed by the borrower based on borrowerID
        String borrowerBookQuery = "SELECT COUNT(*) AS Quantity FROM connectors WHERE BorrowerID = ?";
        PreparedStatement borrowerBookStmt = connection.prepareStatement(borrowerBookQuery);
        borrowerBookStmt.setString(1, borrowerId);
        ResultSet borrowerBookResult = borrowerBookStmt.executeQuery();
        int quantity = 0;
        if (borrowerBookResult.next()) {
            quantity = borrowerBookResult.getInt("Quantity");
        }

        // Fetch return date of the latest book borrowed by the borrower
        String latestReturnDateQuery = "SELECT MAX(DateReturn) AS LatestReturnDate FROM connectors WHERE BorrowerID = ?";
        PreparedStatement latestReturnDateStmt = connection.prepareStatement(latestReturnDateQuery);
        latestReturnDateStmt.setString(1, borrowerId);
        ResultSet latestReturnDateResult = latestReturnDateStmt.executeQuery();
        Date latestReturnDate = null;
        if (latestReturnDateResult.next()) {
            latestReturnDate = latestReturnDateResult.getDate("LatestReturnDate");
        }

        // Calculate the status (overdue or not) based on the return date
        String status;
        if (latestReturnDate != null) {
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTime(latestReturnDate);
            returnCalendar.add(Calendar.DAY_OF_MONTH, 7);
            Calendar currentCalendar = Calendar.getInstance();
            if (currentCalendar.after(returnCalendar)) {
                status = "Overdue";
            } else {
                status = "Not Overdue";
            }
        } else {
            status = "No Books Borrowed";
        }

        // Append borrower data to the StringBuilder
        borrowerData.append("Borrower Name: ").append(borrowerName).append("\n");
        borrowerData.append("Borrower ID: ").append(borrowerId).append("\n");
        borrowerData.append("Contact: ").append(borrowerContact).append("\n");
        borrowerData.append("Address: ").append(borrowerAddress).append("\n");
        borrowerData.append("Quantity Borrowed: ").append(quantity).append("\n");
        borrowerData.append("Status: ").append(status).append("\n-------------\n");
   

// Fetch and append titles of books borrowed by the borrower
String borrowerBookTitleQuery = "SELECT Title FROM connectors WHERE BorrowerID = ?";
PreparedStatement borrowerBookTitleStmt = connection.prepareStatement(borrowerBookTitleQuery);
borrowerBookTitleStmt.setString(1, borrowerId);
ResultSet borrowerBookTitleResult = borrowerBookTitleStmt.executeQuery();

StringBuilder borrowedBooks = new StringBuilder();
borrowedBooks.append("Books Borrowed:\n");
while (borrowerBookTitleResult.next()) {
    String bookTitle = borrowerBookTitleResult.getString("Title");
    borrowedBooks.append("- ").append(bookTitle).append("\n");
}

borrowerData.append(borrowedBooks);

borrowerData.append("-------------\n");
    
    }

    connection.close(); // Release any associated resources.
} catch (ClassNotFoundException | SQLException ex) {
    ex.printStackTrace();
}

      //Create JTextArea for Connectors information
        JTextArea connectorsTextArea = new JTextArea(40, 35);
        connectorsTextArea.setEditable(false);
        connectorsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        connectorsTextArea.setText(connectorsData.toString());

        // Create JTextArea for Borrower information
        JTextArea borrowerTextArea = new JTextArea(40, 35);
        borrowerTextArea.setEditable(false);
        borrowerTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        borrowerTextArea.setText(borrowerData.toString());

        // Create JScrollPane for Connectors information
        JScrollPane connectorsScrollPane = new JScrollPane(connectorsTextArea);

        // Create JScrollPane for Borrower information
        JScrollPane borrowerScrollPane = new JScrollPane(borrowerTextArea);

        // Create JPanel to hold both JTextAreas side by side
        // Ensure that the JTextAreas are displayed in two columns
        JPanel reportPanel = new JPanel(new GridLayout(1, 2));
        reportPanel.add(connectorsScrollPane);
        reportPanel.add(borrowerScrollPane);

        // Display the report in a JOptionPane
        JOptionPane.showMessageDialog(null, reportPanel, "Database Report", JOptionPane.INFORMATION_MESSAGE);
    

    }//GEN-LAST:event_MreportActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        
        try {
               Class.forName("com.mysql.cj.jdbc.Driver");
            sqlConn = DriverManager.getConnection(dataconnect, username, password);

           String deleteMiniLibraryQuery = "DELETE FROM connectors";
            PreparedStatement deleteMiniLibraryStmt = sqlConn.prepareStatement(deleteMiniLibraryQuery);
            deleteMiniLibraryStmt.executeUpdate();
            // used for DELETE queries and returns the number of affected rows.
            // Delete all data from borrowerinfo table
            String deleteBorrowerInfoQuery = "DELETE FROM borrowerinfo";
            PreparedStatement deleteBorrowerInfoStmt = sqlConn.prepareStatement(deleteBorrowerInfoQuery);
            deleteBorrowerInfoStmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "All data deleted from both tables.");

            // Close the connections
            deleteMiniLibraryStmt.close();
            deleteBorrowerInfoStmt.close();
            sqlConn.close();

            // Refresh the table after deleting data
            updateDB();

        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to delete data from the tables.");
        }
    
 // Clear the input fields
    txtborrowerID.setText("");
    txtISBN.setText("");
    txttitle.setText("");
    txtauthor.setText("");
    date.setDate(null);
        
    }//GEN-LAST:event_btnresetActionPerformed

    private void txtISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtISBNActionPerformed
 

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//     
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//       
//            public void run() {
//                 Borrower_Form borrowerForm = new Borrower_Form();
//               
//                new Mini_Library(borrowerForm).setVisible(true);
//            
//  
//            }
//        });
//    }
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
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(Mini_Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Borrower_Form borrowerForm = new Borrower_Form();
            Mini_Library miniLibrary = new Mini_Library(borrowerForm);

            // Set location of Mini_Library to center
            miniLibrary.pack();
            miniLibrary.setLocationRelativeTo(null);
            miniLibrary.setVisible(true);
            
            

        }
    });
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Mreport;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnborrower;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsearch;
    private javax.swing.JButton btnupdate;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblISBN;
    private javax.swing.JLabel lblauthor;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JMenuItem menuexit;
    private javax.swing.JTable tblmain;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtauthor;
    private javax.swing.JTextField txtborrowerID;
    private javax.swing.JTextField txtsearchbook;
    private javax.swing.JTextField txttitle;
    // End of variables declaration//GEN-END:variables
}
