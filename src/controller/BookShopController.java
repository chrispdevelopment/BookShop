/*
 * Classname: BookShopController.java
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
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.xml.bind.JAXBException;

import model.books.Book;
import model.books.BookHandler;
import model.books.ElectronicBook;
import model.books.PaperBook;
import model.books.StockItem;
import model.data.DataHandler;
import model.orders.Order;
import model.orders.OrderHandler;
import model.orders.Publisher;

import view.BookForm;
import view.CatalogForm;
import view.FormHelper;
import view.OrderForm;
import view.PublisherForm;
import view.SelectItemsForm;

/**
 * This class is the main controller for the program and has methods that allow
 * the view and the model to interact
 *
 * @author Shadow
 */
public class BookShopController {

    public static CatalogForm catalog;
    public static BookForm bookForm;
    public static OrderForm orderForm;
    public static PublisherForm pubForm;
    public static SelectItemsForm selectForm;

    /**
     * Method is run when the program is first started. Creates and shows
     * catalog form, sets the data model and puts data into tables.
     *
     * @param args
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CatalogForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                catalog = new CatalogForm();
                catalog.setVisible(true);
                initShop();
                createTableData("books", null);
                createTableData("orders", null);
                createTableData("publishers", null);
            }
        });
    }

    /**
     * Read objects from XML files and pass into data model
     */
    private static void initShop() {
        try {
            DataHandler.readObjects(BookHandler.class, DataHandler.BOOKS_FILE);
            DataHandler.readObjects(OrderHandler.class, DataHandler.ORDERS_FILE);
        } catch (JAXBException ex) {
            Logger.getLogger(BookShopController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Table data creation">
    /**
     * Creates table data for the passed table orderID value only needed for
     * setting the orderItems table
     *
     * @param table
     * @param orderID can be null
     */
    private static void createTableData(String table, String orderID) {
        switch (table) {
            case "books":
                FormHelper.clearTableModel(catalog.bookModel);

                for (ElectronicBook book : BookHandler.electronicBooks.values()) {
                    Object[] data = new Object[]{
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthors(),
                        "£" + book.getPrice(),
                        BookHandler.stock.get(book.getIsbn()).getAmount(),
                        book.getPubDate(),
                        book.getType(),
                        book.getPublisher()
                    };
                    FormHelper.setTableModel(data, catalog.bookModel);
                }

                for (PaperBook book : BookHandler.paperBooks.values()) {
                    Object[] data = new Object[]{
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthors(),
                        "£" + book.getPrice(),
                        BookHandler.stock.get(book.getIsbn()).getAmount(),
                        book.getPubDate(),
                        book.getType(),
                        book.getPublisher()
                    };
                    FormHelper.setTableModel(data, catalog.bookModel);
                }
                catalog.sortTable(catalog.bookModel, table);
                break;
            case "orders":
                FormHelper.clearTableModel(catalog.orderModel);

                for (Order order : OrderHandler.orders.values()) {
                    Object[] data = new Object[]{
                        order.getOrderID(),
                        order.getPublisher(),
                        order.getOrderDate(),
                        order.getDeliveryDate(),
                        "£" + order.getCost(),
                        order.getStatus()
                    };
                    FormHelper.setTableModel(data, catalog.orderModel);
                }

                catalog.sortTable(catalog.orderModel, table);
                break;
            case "publishers":
                FormHelper.clearTableModel(catalog.pubModel);

                for (Publisher publisher : OrderHandler.publishers.values()) {
                    Object[] data = new Object[]{
                        publisher.getName(),
                        publisher.getEmail(),
                        publisher.getPhoneNo(),
                        publisher.getAddress()
                    };
                    FormHelper.setTableModel(data, catalog.pubModel);
                }

                catalog.sortTable(catalog.pubModel, table);
                break;
            case "orderItems":
                FormHelper.clearTableModel(orderForm.itemModel);

                String[][] items = listOrderItems(orderID);

                for (String[] item : items) {
                    Object[] data = new Object[]{
                        retreiveBookTitle(item[0]),
                        item[1]
                    };
                    FormHelper.setTableModel(data, orderForm.itemModel);
                }

                orderForm.sortTable(orderForm.itemModel);
                break;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for showing and hidding forms">
    /**
     * Shows a new form depending on what string is passed to the method and
     * disables parent form
     *
     * @param form current cases book, order, publisher and selectItem
     */
    public static void showNewForm(String form) {
        switch (form) {
            case "book":
                bookForm = new BookForm();
                bookForm.setVisible(true);
                bookForm.setPudCombo();
                break;
            case "order":
                orderForm = new OrderForm();
                orderForm.setVisible(true);
                orderForm.setPudCombo();
                break;
            case "publisher":
                pubForm = new PublisherForm();
                pubForm.setVisible(true);
                break;
            case "selectItem":
                selectForm = new SelectItemsForm();
                selectForm.setVisible(true);
                orderForm.setEnabled(false);
                break;
        }

        catalog.setEnabled(false);
    }

    /**
     * Closes a form depending on what string is passed to the method and
     * re-enables parent form
     *
     * @param form current cases book, order, publisher and selectItem
     */
    public static void closeForm(String form) {
        catalog.setEnabled(true);
        switch (form) {
            case "book":
                bookForm.setVisible(false);
                bookForm.dispose();
                break;
            case "order":
                orderForm.setVisible(false);
                orderForm.dispose();
                break;
            case "publisher":
                pubForm.setVisible(false);
                pubForm.dispose();
                break;
            case "selectItem":
                orderForm.setEnabled(true);
                selectForm.setVisible(false);
                selectForm.dispose();
                break;
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Methods for showing forms with editable data">
    /**
     * Shows the book form, sets the data into the editData variable for the
     * currently selected row in its parent table and runs setDataFields method
     * to set the editData into the required fields
     *
     * @param isbn
     * @param type choices paper or electronic
     */
    public static void showEditBookForm(String isbn, String type) {
        showNewForm("book");
        if (type.matches("Paper")) {
            PaperBook book = (PaperBook) DataHandler.retreiveItem(isbn, BookHandler.paperBooks);

            bookForm.editData.add(book.getIsbn());
            bookForm.editData.add(book.getTitle());
            bookForm.editData.add(book.getAuthors());
            bookForm.editData.add(book.getPubDate());
            bookForm.editData.add(book.getPrice());
            bookForm.editData.add(BookHandler.stock.get(book.getIsbn()).getAmount());
            bookForm.editData.add(book.getPublisher());
            bookForm.editData.add(book.getPostageCost());
        } else {
            ElectronicBook book = (ElectronicBook) DataHandler.retreiveItem(isbn, BookHandler.electronicBooks);

            bookForm.editData.add(book.getIsbn());
            bookForm.editData.add(book.getTitle());
            bookForm.editData.add(book.getAuthors());
            bookForm.editData.add(book.getPubDate());
            bookForm.editData.add(book.getPrice());
            bookForm.editData.add(BookHandler.stock.get(book.getIsbn()).getAmount());
            bookForm.editData.add(book.getPublisher());
            bookForm.editData.add(book.getFormat());
            bookForm.editData.add(book.getLicences());
        }

        bookForm.setDataFields(type);
    }

    /**
     * Shows the order form, sets the data into the editData variable for the
     * currently selected row in its parent table and runs setDataFields method
     * to set the editData into the required fields
     *
     * @param orderID
     */
    public static void showEditOrderForm(String orderID) {
        showNewForm("order");

        Order order = (Order) DataHandler.retreiveItem(orderID, OrderHandler.orders);
        orderForm.editData.add(order.getOrderID());
        orderForm.editData.add(order.getOrderDate());
        orderForm.editData.add(order.getDeliveryDate());
        orderForm.editData.add(order.getCost());
        orderForm.editData.add(order.getStatus());
        orderForm.editData.add(order.getPublisher());
        createTableData("orderItems", orderID);

        orderForm.setDataFields();
    }

    /**
     * Shows the publisher form, sets the data into the editData variable for
     * the currently selected row in its parent table and runs setDataFields
     * method to set the editData into the required fields
     *
     * @param name
     */
    public static void showEditPubForm(String name) {
        showNewForm("publisher");

        Publisher pub = (Publisher) DataHandler.retreiveItem(name, OrderHandler.publishers);
        pubForm.editData.add(pub.getName());
        pubForm.editData.add(pub.getEmail());
        pubForm.editData.add(pub.getPhoneNo());
        pubForm.editData.add(pub.getAddress());

        pubForm.setDataFields();
    }
//</editor-fold>
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for manipulating the books data">
    /**
     * Creates new ElectronicBook, adds a new stock item for this book, updates
     * the books table, writes new data to the books XML and then closes the
     * books form
     *
     * @param isbn
     * @param title
     * @param authors
     * @param pubDate
     * @param price
     * @param format
     * @param licences
     * @param type
     * @param stock
     * @param publisher
     */
    public static void newBook(String isbn, String title, String authors,
            String pubDate, double price, String format, List licences,
            String type, int stock, String publisher) {
        BookHandler.createBook(isbn, title, authors, pubDate, price, format,
                licences, type, publisher);

        newStock(isbn, stock);
        createTableData("books", null);
        writeBookData();
        closeForm("book");
    }

    /**
     * Creates new PaperBook, adds a new stock item for this book, updates the
     * books table, writes new data to the books XML and then closes the books
     * form
     *
     * @param isbn
     * @param title
     * @param authors
     * @param pubDate
     * @param price
     * @param postageCost
     * @param type
     * @param stock
     * @param publisher
     */
    public static void newBook(String isbn, String title, String authors,
            String pubDate, double price, double postageCost, String type,
            int stock, String publisher) {
        BookHandler.createBook(isbn, title, authors, pubDate, price, postageCost,
                type, publisher);

        newStock(isbn, stock);
        createTableData("books", null);
        writeBookData();
        closeForm("book");
    }

    /**
     * Deletes book from one of the books maps depending on type, deleted the
     * stock entry for this item, updates books table and writes data change to
     * books XML
     *
     * @param isbn
     * @param type
     */
    public static void deleteBook(String isbn, String type) {
        if (type.matches("Paper")) {
            DataHandler.deleteItem(isbn, BookHandler.paperBooks);
        } else {
            DataHandler.deleteItem(isbn, BookHandler.electronicBooks);
        }

        for (Order o : OrderHandler.orders.values()) {
            String[][] items = o.getItems();
            String[][] updatedItems;
            List keysToKeep = new ArrayList();
            int currentSize = items.length;
            int newSize = 0;

            for (int x = 0; x < currentSize; x++) {
                if (items[x][0].toString().matches(isbn)) {
                    newSize = currentSize - 1;
                } else {
                    keysToKeep.add(x);
                }
            }

            if (newSize > 0) {
                updatedItems = new String[newSize][2];
                int counter = 0;
                for (Object i : keysToKeep) {
                    int key = Integer.valueOf(i.toString());

                    updatedItems[counter][0] = items[key][0];
                    updatedItems[counter][1] = items[key][1];
                    counter++;
                }
                o.setItems(updatedItems);
            } else {
                o.setStatus("Withdrawn");
            }
            DataHandler.addItem(String.valueOf(o.getOrderID()), o, OrderHandler.orders);
        }

        deleteStock(isbn);
        createTableData("books", null);
        writeBookData();
        writeOrderData();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for manipulating the stock data">
    /**
     * Creates new StockItem
     *
     * @param isbn
     * @param amount
     */
    private static void newStock(String isbn, int amount) {
        BookHandler.createStock(isbn, amount);
    }

    /**
     * Deletes a StockItem
     *
     * @param isbn
     */
    private static void deleteStock(String isbn) {
        DataHandler.deleteItem(isbn, BookHandler.stock);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for manipulating the order data">
    /**
     * Creates new Order, updates the orders table, writes new data to the
     * orders XML and then closes the order form
     *
     * @param orderID
     * @param orderDate
     * @param deliveryDate
     * @param cost
     * @param publisher
     * @param items
     */
    public static void newOrder(int orderID, String orderDate,
            String deliveryDate, double cost, String publisher,
            String[][] items) {
        OrderHandler.createOrder(items, orderID, orderDate, deliveryDate, cost, publisher);

        createTableData("orders", null);
        writeOrderData();
        closeForm("order");
    }

    /**
     * Completes an order, sets its status to completed, sets its delivery date,
     * updates the stock for the orders items, updates the table data and writes
     * new data to XML files
     *
     * @param orderID
     * @param items
     * @param orderDate
     */
    public static void completeOrder(String orderID, String[][] items, String orderDate) {
        Order order = (Order) DataHandler.retreiveItem(orderID,
                OrderHandler.orders);

        if (order.getStatus().matches("Active")) {
            order.setStatus("Completed");
            order.setDeliveryDate(orderDate);
            DataHandler.addItem(orderID, order, OrderHandler.orders);

            for (String[] item : items) {
                StockItem stock = (StockItem) DataHandler.retreiveItem(item[0],
                        BookHandler.stock);
                stock.setAmount(stock.getAmount() + Integer.valueOf(item[1]));
                DataHandler.addItem(item[0], stock, BookHandler.stock);
            }

            createTableData("orders", null);
            createTableData("books", null);
            writeBookData();
            writeOrderData();
        } else {
            showMessageDialog(null, "You cannot withdraw an order if it is not active");
        }
    }

    /**
     * Withdraws an order, set order to withdrawn, updates table data and writes
     * new data to XML file
     *
     * @param orderID
     */
    public static void withdrawOrder(String orderID) {
        Order order = (Order) DataHandler.retreiveItem(orderID,
                OrderHandler.orders);
        if (order.getStatus().matches("Active")) {
            order.setStatus("Withdrawn");
            DataHandler.addItem(orderID, order, OrderHandler.orders);

            createTableData("orders", null);
            writeOrderData();
        } else {
            showMessageDialog(null, "You cannot withdraw an order if it is not active");
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for manipulating the publisher data">
    /**
     * Creates a new publisher, updates tables data, writes new data to XML file
     * and then closes the publisher form
     *
     * @param name
     * @param email
     * @param phoneNo
     * @param address
     */
    public static void newPublisher(String name, String email, String phoneNo,
            List address) {
        OrderHandler.createPublisher(name, email, phoneNo, address);

        createTableData("publishers", null);
        writeOrderData();
        closeForm("publisher");
    }

    /**
     * Deletes publisher if the publisher dosn't currently have any active
     * orders, sets related book publisher fields to empty, updates table data
     * and writes new data to XML files
     *
     * @param name
     */
    public static void deletePublisher(String name) {
        if (checkForActiveOrder(name)) {
            showMessageDialog(null, "You cannot delete a publisher that has an active order");
        } else {
            DataHandler.deleteItem(name, OrderHandler.publishers);
            for (PaperBook p : BookHandler.paperBooks.values()) {
                if (p.getPublisher().matches(name)) {
                    p.setPublisher("");
                }
            }
            for (ElectronicBook b : BookHandler.electronicBooks.values()) {
                if (b.getPublisher().matches(name)) {
                    b.setPublisher("");
                }
            }
            createTableData("publishers", null);
            createTableData("books", null);
            writeBookData();
            writeOrderData();
        }
    }

    /**
     * Checks to see if the selected publisher has any active orders
     *
     * @param name
     * @return
     */
    private static boolean checkForActiveOrder(String name) {
        for (Order order : OrderHandler.orders.values()) {
            if (order.getPublisher().matches(name) && order.getStatus().matches("Active")) {
                return true;
            }
        }
        return false;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for reading and writing to the XML files">
    /**
     * Writes current book maps to XML file
     */
    private static void writeBookData() {
        try {
            DataHandler.writeObjects(BookHandler.class, new BookHandler(),
                    DataHandler.BOOKS_FILE);
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(BookShopController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    /**
     * Writes current order maps to XML file
     */
    private static void writeOrderData() {
        try {
            DataHandler.writeObjects(OrderHandler.class, new OrderHandler(),
                    DataHandler.ORDERS_FILE);
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(BookShopController.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for creating lists of data values">
    /**
     * Creates a list of all publisher names
     *
     * @return
     */
    public static List listPublishers() {
        List pubList = new ArrayList();
        for (Publisher publisher : OrderHandler.publishers.values()) {
            pubList.add(publisher.getName());
        }
        return pubList;
    }

    /**
     * Creates a list of all book names for books relating to given publisher
     *
     * @param publisher
     * @return
     */
    public static List listBooksForPub(String publisher) {
        List books = new ArrayList();

        for (Book book : BookHandler.paperBooks.values()) {
            if (book.getPublisher().matches(publisher)) {
                books.add(book.getTitle());
            }
        }

        for (Book book : BookHandler.electronicBooks.values()) {
            if (book.getPublisher().matches(publisher)) {
                books.add(book.getTitle());
            }
        }
        return books;
    }

    /**
     * Creates 2D string array containing a list of all items for a given order
     *
     * @param orderID
     * @return
     */
    public static String[][] listOrderItems(String orderID) {
        return OrderHandler.orders.get(orderID).getItems();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for retreiving book values">
    /**
     * Retrieves string containing book title for specified book
     *
     * @param isbn
     * @return
     */
    public static String retreiveBookTitle(String isbn) {
        for (Book book : BookHandler.paperBooks.values()) {
            if (book.getIsbn().matches(isbn)) {
                return book.getTitle();
            }
        }

        for (Book book : BookHandler.electronicBooks.values()) {
            if (book.getIsbn().matches(isbn)) {
                return book.getTitle();
            }
        }

        return null;
    }

    /**
     * Retrieves string containing book Isbn for specified book
     *
     * @param title
     * @return
     */
    public static String retreiveBookIsbn(String title) {
        for (Book book : BookHandler.paperBooks.values()) {
            if (book.getTitle().matches(title)) {
                return book.getIsbn();
            }
        }

        for (Book book : BookHandler.electronicBooks.values()) {
            if (book.getTitle().matches(title)) {
                return book.getIsbn();
            }
        }

        return null;
    }
//</editor-fold>
}
