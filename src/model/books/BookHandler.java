/*
 * Classname: BookHandler.java
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
package model.books;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import model.data.DataHandler;
import model.data.MapAdapter;

/**
 * This class provides the construction of book and stock objects as well as
 * access to the data structures holding the data
 *
 * @author Shadow
 */
@XmlRootElement
@XmlJavaTypeAdapter(MapAdapter.class)
public class BookHandler {

    /**
     * Map variable to hold paper books data
     */
    public static Map<String, PaperBook> paperBooks = new HashMap();
    /**
     * Map variable to hold electronic books data
     */
    public static Map<String, ElectronicBook> electronicBooks = new HashMap();
    /**
     * Map variable to hold stock data
     */
    public static Map<String, StockItem> stock = new HashMap();

    //<editor-fold defaultstate="collapsed" desc="Methods for getting and setting Maps">
    /**
     * This method returns a Map<String, PaperBook> of the current paperBooks
     * variable
     *
     * @return
     */
    @XmlElement(name = "paperbooks")
    public Map<String, PaperBook> getPaperBooks() {
        return paperBooks;
    }

    /**
     * This method will set the paperBooks variable to the Map<String,
     * PaperBook>
     * passed when the method is called
     *
     * @param map
     */
    public void setPaperBooks(Map<String, PaperBook> map) {
        paperBooks = map;
    }

    /**
     * This method returns a Map<String, ElectronicBook> of the current
     * electronicBooks variable
     *
     * @return
     */
    @XmlElement(name = "electronicbooks")
    public Map<String, ElectronicBook> getElectronicBooks() {
        return electronicBooks;
    }

    /**
     * This method will set the electronicBooks variable to the Map<String,
     * ElectronicBook> passed when the method is called
     *
     * @param map
     */
    public void setElectronicBooks(Map<String, ElectronicBook> map) {
        electronicBooks = map;
    }

    /**
     * This method returns a Map<String, StockItem> of the current stock
     * variable
     *
     * @return
     */
    @XmlElement(name = "stock")
    public Map<String, StockItem> getStock() {
        return stock;
    }

    /**
     * This method will set the stock variable to the Map<String, StockItem>
     * passed when the method is called
     *
     * @param map
     */
    public void setStock(Map<String, StockItem> map) {
        stock = map;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for creating new objects">
    /**
     * This method provides construction for PaperBook objects and will add the
     * new object to the paperBooks variable
     *
     * @param isbn
     * @param title
     * @param authors
     * @param pubDate
     * @param price
     * @param postageCost
     * @param type
     * @param publisher
     */
    public static void createBook(String isbn, String title, String authors,
            String pubDate, double price, double postageCost, String type,
            String publisher) {

        PaperBook book = new PaperBook();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthors(authors);
        book.setPubDate(pubDate);
        book.setPrice(price);
        book.setPostageCost(postageCost);
        book.setType(type);
        book.setPublisher(publisher);

        DataHandler.addItem(isbn, book, paperBooks);
    }

    /**
     * This method provides construction for ElectronicBook objects and will add
     * the new object to the electronicBooks variable
     *
     * @param isbn
     * @param title
     * @param authors
     * @param pubDate
     * @param price
     * @param format
     * @param licences
     * @param type
     * @param publisher
     */
    public static void createBook(String isbn, String title, String authors,
            String pubDate, double price, String format, List licences,
            String type, String publisher) {

        ElectronicBook book = new ElectronicBook();
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthors(authors);
        book.setPubDate(pubDate);
        book.setPrice(price);
        book.setFormat(format);
        book.setLicences(licences);
        book.setType(type);
        book.setPublisher(publisher);

        DataHandler.addItem(isbn, book, electronicBooks);
    }

    /**
     * This method provides construction for StockItem objects and will add the
     * new object to the stock variable
     *
     * @param isbn
     * @param amount
     */
    public static void createStock(String isbn, int amount) {
        StockItem stockItem = new StockItem();
        stockItem.setIsbn(isbn);
        stockItem.setAmount(amount);

        DataHandler.addItem(isbn, stockItem, stock);
    }
//</editor-fold>
}
