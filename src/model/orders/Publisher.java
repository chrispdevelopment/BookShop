/*
 * Classname: Publisher
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
package model.orders;

import java.util.List;

/**
 * This class provides the structure for publisher data
 *
 * @author Shadow
 */
public class Publisher {

    private String name;
    private String email;
    private String phoneNo;
    private List address;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a string of the current publishers name value
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the current publishers name value to the string passed
     * when the method is called
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method returns a string of the current publishers email value
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the current publishers email value to the string passed
     * when the method is called
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns a string of the current publishers phoneNo value
     *
     * @return
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * This method sets the current publishers phoneNo value to the string
     * passed when the method is called
     *
     * @param phoneNo
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * This method returns a list of the current publishers address values
     *
     * @return
     */
    public List getAddress() {
        return address;
    }

    /**
     * This method sets the current publishers address values to the list passed
     * when the method is called
     *
     * @param address
     */
    public void setAddress(List address) {
        this.address = address;
    }
//</editor-fold>
}
