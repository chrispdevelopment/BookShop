/*
 * Classname: ElectronicBook.java
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

import java.util.List;

/**
 * This class provides the sub structure for electronic books and is an
 * extension of Books
 *
 * @author Shadow
 */
public class ElectronicBook extends Book {

    private String format;
    private List licences;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a string of the current books Format value
     *
     * @return
     */
    public String getFormat() {
        return format;
    }

    /**
     * This method sets the current books Format value to the string passed when
     * the method is called
     *
     * @param format
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * This method returns a list of the current books Licences values
     *
     * @return
     */
    public List getLicences() {
        return licences;
    }

    /**
     * This method sets the current books Licences values to the list passed
     * when the method is called
     *
     * @param licences
     */
    public void setLicences(List licences) {
        this.licences = licences;
    }
//</editor-fold>
}
