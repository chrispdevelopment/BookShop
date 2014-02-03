/*
 * Classname: CatalogForm.java
 * 
 * Version 1.0
 *
 * Copyright (C) 2014 Chris
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package view;

import controller.BookShopController;
import controller.SortingTableModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * This class contains controls and methods that effect the CatalogForm UI
 *
 * @author Shadow
 */
public class CatalogForm extends javax.swing.JFrame {

    public DefaultTableModel bookModel;
    public DefaultTableModel orderModel;
    public DefaultTableModel pubModel;

    /**
     * Creates new form Main
     */
    public CatalogForm() {
        initComponents();
        bookModel = (DefaultTableModel) this.tblBooks.getModel();
        orderModel = (DefaultTableModel) this.tblOrders.getModel();
        pubModel = (DefaultTableModel) this.tblPubs.getModel();
    }

    //<editor-fold defaultstate="collapsed" desc="Form Generation and events">
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooks = new javax.swing.JTable();
        btnNewBook = new javax.swing.JButton();
        btnEditBook = new javax.swing.JButton();
        btnDeleteBook = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnNewOrder = new javax.swing.JButton();
        btnEditOrder = new javax.swing.JButton();
        btnCompleteOrder = new javax.swing.JButton();
        btnWithdrawOrder = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPubs = new javax.swing.JTable();
        btnNewPub = new javax.swing.JButton();
        btnEditPub = new javax.swing.JButton();
        btnDeletePub = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Shop");

        tblBooks.setAutoCreateRowSorter(true);
        tblBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Price", "Stock", "Date Published", "Type", "Publisher"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBooks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblBooks);

        btnNewBook.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNewBook.setText("New Book");
        btnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBookActionPerformed(evt);
            }
        });

        btnEditBook.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditBook.setText("Edit Book");
        btnEditBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditBookActionPerformed(evt);
            }
        });

        btnDeleteBook.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeleteBook.setText("Delete Book");
        btnDeleteBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 792, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNewBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditBook)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteBook)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewBook)
                    .addComponent(btnEditBook)
                    .addComponent(btnDeleteBook))
                .addContainerGap())
        );

        tabPane.addTab("Books", jPanel1);

        tblOrders.setAutoCreateRowSorter(true);
        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order No", "Publisher", "Order Date", "Delivery Date", "Total Cost", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOrders.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblOrders);

        btnNewOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNewOrder.setText("New Order");
        btnNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewOrderActionPerformed(evt);
            }
        });

        btnEditOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditOrder.setText("Edit Order");
        btnEditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditOrderActionPerformed(evt);
            }
        });

        btnCompleteOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCompleteOrder.setText("Complete Order");
        btnCompleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompleteOrderActionPerformed(evt);
            }
        });

        btnWithdrawOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnWithdrawOrder.setText("Withdraw Order");
        btnWithdrawOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWithdrawOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNewOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCompleteOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnWithdrawOrder)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewOrder)
                    .addComponent(btnEditOrder)
                    .addComponent(btnCompleteOrder)
                    .addComponent(btnWithdrawOrder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPane.addTab("Orders", jPanel2);

        tblPubs.setAutoCreateRowSorter(true);
        tblPubs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Email", "Phone No", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPubs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(tblPubs);

        btnNewPub.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnNewPub.setText("New Publisher");
        btnNewPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPubActionPerformed(evt);
            }
        });

        btnEditPub.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnEditPub.setText("Edit Publisher");
        btnEditPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPubActionPerformed(evt);
            }
        });

        btnDeletePub.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnDeletePub.setText("Delete Publisher");
        btnDeletePub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePubActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnNewPub)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditPub)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeletePub)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewPub)
                    .addComponent(btnEditPub)
                    .addComponent(btnDeletePub))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPane.addTab("Publishers", jPanel3);

        jMenu1.setText("File");

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuExit);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void btnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBookActionPerformed
        BookShopController.showNewForm("book");
    }//GEN-LAST:event_btnNewBookActionPerformed

    private void btnEditBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditBookActionPerformed
        if (this.tblBooks.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select a book from the list");
        } else {
            String isbn = this.tblBooks.getValueAt(this.tblBooks.getSelectedRow(),
                    0).toString();
            String type = this.tblBooks.getValueAt(this.tblBooks.getSelectedRow(),
                    6).toString();

            BookShopController.showEditBookForm(isbn, type);
        }
    }//GEN-LAST:event_btnEditBookActionPerformed

    private void btnDeleteBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookActionPerformed
        if (this.tblBooks.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select a book from the list");
        } else {
            int s = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you wish to delete this book",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (s == 0) {
                String isbn = this.tblBooks.getValueAt(this.tblBooks.getSelectedRow(),
                        0).toString();
                String type = this.tblBooks.getValueAt(this.tblBooks.getSelectedRow(),
                        6).toString();

                BookShopController.deleteBook(isbn, type);
            }
        }
    }//GEN-LAST:event_btnDeleteBookActionPerformed

    private void btnNewPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPubActionPerformed
        BookShopController.showNewForm("publisher");
    }//GEN-LAST:event_btnNewPubActionPerformed

    private void btnEditPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPubActionPerformed
        if (this.tblPubs.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select a publisher from the list");
        } else {
            String name = this.tblPubs.getValueAt(this.tblPubs.getSelectedRow(),
                    0).toString();

            BookShopController.showEditPubForm(name);
        }
    }//GEN-LAST:event_btnEditPubActionPerformed

    private void btnDeletePubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePubActionPerformed
        if (this.tblPubs.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select a publisher from the list");
        } else {
            int s = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you wish to delete this publisher",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (s == 0) {
                String name = this.tblPubs.getValueAt(this.tblPubs.getSelectedRow(),
                        0).toString();

                BookShopController.deletePublisher(name);
            }
        }
    }//GEN-LAST:event_btnDeletePubActionPerformed

    private void btnNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewOrderActionPerformed
        BookShopController.showNewForm("order");
    }//GEN-LAST:event_btnNewOrderActionPerformed

    private void btnEditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditOrderActionPerformed
        if (this.tblOrders.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select an order from the list");
        } else {
            String orderID = this.tblOrders.getValueAt(this.tblOrders.getSelectedRow(),
                    0).toString();
            String status = this.tblOrders.getValueAt(this.tblOrders.getSelectedRow(),
                    5).toString();

            if (status.matches("Active")) {
                BookShopController.showEditOrderForm(orderID);
            } else {
                showMessageDialog(null, "You can only edit active orders");
            }
        }
    }//GEN-LAST:event_btnEditOrderActionPerformed

    private void btnCompleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompleteOrderActionPerformed
        if (this.tblOrders.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select an order from the list");
        } else {
            int s = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you wish to complete this order",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (s == 0) {
                String r = (String) JOptionPane.showInputDialog(
                        null,
                        "Please input the delivery date",
                        "Delivery Date",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        "ham");

                if ((r != null) && (r.length() > 0)) {
                    String orderID = this.tblOrders.getValueAt(this.tblOrders.getSelectedRow(),
                            0).toString();
                    String[][] items = BookShopController.listOrderItems(orderID);
                    BookShopController.completeOrder(orderID, items, r);
                } else {
                    showMessageDialog(null, "Please enter a delivery date");
                }
            }
        }
    }//GEN-LAST:event_btnCompleteOrderActionPerformed

    private void btnWithdrawOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWithdrawOrderActionPerformed
        if (this.tblOrders.getSelectedRow() == -1) {
            showMessageDialog(null, "Please select an order from the list");
        } else {
            int s = JOptionPane.showConfirmDialog(
                    null,
                    "Are you sure you wish to complete this order",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION);
            if (s == 0) {
                String orderID = this.tblOrders.getValueAt(this.tblOrders.getSelectedRow(),
                        0).toString();

                BookShopController.withdrawOrder(orderID);
            }
        }
    }//GEN-LAST:event_btnWithdrawOrderActionPerformed
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for altering table">
    /**
     * Takes the default table model and sorts the data within it and then adds
     * the resultant model to the specified table
     *
     * @param defaultModel
     * @param table
     */
    public void sortTable(DefaultTableModel defaultModel, String table) {
        if (table.matches("books")) {
            TableModel model = new SortingTableModel(defaultModel, 1);
            this.tblBooks.setModel(model);
        } else if (table.matches("orders")) {
            TableModel model = new SortingTableModel(defaultModel, 0);
            this.tblOrders.setModel(model);
        } else {
            TableModel model = new SortingTableModel(defaultModel, 0);
            this.tblPubs.setModel(model);
        }
    }
//</editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompleteOrder;
    private javax.swing.JButton btnDeleteBook;
    private javax.swing.JButton btnDeletePub;
    private javax.swing.JButton btnEditBook;
    private javax.swing.JButton btnEditOrder;
    private javax.swing.JButton btnEditPub;
    private javax.swing.JButton btnNewBook;
    private javax.swing.JButton btnNewOrder;
    private javax.swing.JButton btnNewPub;
    private javax.swing.JButton btnWithdrawOrder;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JTabbedPane tabPane;
    private javax.swing.JTable tblBooks;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTable tblPubs;
    // End of variables declaration//GEN-END:variables
}
