/*
 * Classname: Order
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

/**
 * This class provides the structure for order data
 *
 * @author Shadow
 */
public class Order {

    private String[][] items;
    private int orderID;
    private String orderDate;
    private String deliveryDate;
    private double cost;
    private String publisher;
    private String status;

    //<editor-fold defaultstate="collapsed" desc="Class getters and setters">
    /**
     * This method returns a 2 dimensional string array of the current orders
     * items
     *
     * @return
     */
    public String[][] getItems() {
        return items;
    }

    /**
     * This method sets the current orders items to the 2 dimensional string
     * array passed when the method is called
     *
     * @param items
     */
    public void setItems(String[][] items) {
        this.items = items;
    }

    /**
     * This method returns a integer of the current orders orderID value
     *
     * @return
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * This method sets the current orders orderID value to the integer passed
     * when the method is called
     *
     * @param orderID
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * This method returns a string of the current orders orderDate value
     *
     * @return
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * This method sets the current orders orderDate value to the string passed
     * when the method is called
     *
     * @param orderDate
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * This method returns a string of the current orders deliveryDate value
     *
     * @return
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * This method sets the current orders deliveryDate value to the string
     * passed when the method is called
     *
     * @param deliveryDate
     */
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * This method returns a double of the current orders cost value
     *
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     * This method sets the current orders cost value to the double passed when
     * the method is called
     *
     * @param cost
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * This method returns a string of the current orders publisher value
     *
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * This method sets the current orders publisher value to the string passed
     * when the method is called
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * This method returns a string of the current orders status value
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method sets the current orders status value to the string passed
     * when the method is called
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
//</editor-fold>
}
