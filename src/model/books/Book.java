/*
 * Classname: Book.java
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

/**
 * This class provides the super structure for book data
 *
 * @author Chris
 */
public class Book {

    private String isbn;
    private String title;
    private String authors;
    private String pubDate;
    private double price;
    private String type;
    private String publisher;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a string of the current books Isbn value
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method sets the current books Isbn value to the string passed when
     * the method is called
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * This method returns a string of the current books Title value
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method sets the current books Title value to the string passed when
     * the method is called
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns a string of the current books Authors value
     *
     * @return
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * This method sets the current books Authors value to the string passed
     * when the method is called
     *
     * @param authors
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }

    /**
     * This method returns a string of the current books Publication Date value
     *
     * @return
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * This method sets the current books Publication Date value to the string
     * passed when the method is called
     *
     * @param pubDate
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * This method returns a double of the current books Price value
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     * This method sets the current books Price value to the double passed when
     * the method is called
     *
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * This method returns a string of the current books Type value
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * This method sets the current books Type value to the string passed when
     * the method is called
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * This method returns a string of the current books Publisher value
     *
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method sets the current books Publisher value to the string passed
     * when the method is called
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
//</editor-fold>
}
