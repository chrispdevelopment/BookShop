/*
 * Classname: PaperBook.java
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
 * This class provides the sub structure for paper books and is an extension of
 * Books
 *
 * @author Shadow
 */
public class PaperBook extends Book {

    private double postageCost;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a double of the current books Postage Cost value
     *
     * @return
     */
    public double getPostageCost() {
        return postageCost;
    }

    /**
     * This method sets the current books Postage Cost value to the double
     * passed when the method is called
     *
     * @param postageCost
     */
    public void setPostageCost(double postageCost) {
        this.postageCost = postageCost;
    }
//</editor-fold>
}
