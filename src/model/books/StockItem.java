/*
 * Classname: StockItem.java
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
 * This class provides the structure for stock item data
 *
 * @author Shadow
 */
public class StockItem {

    private String isbn;
    private int amount;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a string of the current stocks Isbn value
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method sets the current stocks Isbn value to the string passed when
     * the method is called
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * This method returns an integer of the current stocks Amount value
     *
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     * This method sets the current stocks Amount value to the integer passed
     * when the method is called
     *
     * @param amount
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
//</editor-fold>
}
