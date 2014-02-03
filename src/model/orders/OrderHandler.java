/*
 * Classname: OrderHandler
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import model.data.DataHandler;

/**
 * This class provides the construction of order and publisher objects as well
 * as access to the data structures holding the data
 *
 * @author Shadow
 */
@XmlRootElement
//@XmlSeeAlso(Order.class)
public class OrderHandler {

    /**
     * Map variable to hold order data
     */
    public static Map<String, Order> orders = new HashMap();
    /**
     * Map variable to hold stock data
     */
    public static Map<String, Publisher> publishers = new HashMap();

    //<editor-fold defaultstate="collapsed" desc="Methods for getting and setting Maps">
    /**
     * This method returns a Map<String, Order> of the current orders variable
     *
     * @return
     */
    @XmlElement(name = "orders")
    public Map<String, Order> getOrders() {
        return orders;
    }

    /**
     * This method will set the orders variable to the Map<String, Order>
     * passed when the method is called
     *
     * @param map
     */
    public void setOrders(Map<String, Order> map) {
        orders = map;
    }

    /**
     * This method returns a Map<String, Publisher> of the current publishers
     * variable
     *
     * @return
     */
    @XmlElement(name = "publishers")
    public Map<String, Publisher> getPublishers() {
        return publishers;
    }

    /**
     * This method will set the publishers variable to the Map<String,
     * Publisher>
     * passed when the method is called
     *
     * @param map
     */
    public void setPaperBooks(Map<String, Publisher> map) {
        publishers = map;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Methods for creating new objects">
    /**
     * This method provides construction for Order objects and will add the new
     * object to the orders variable
     *
     * @param items
     * @param orderID
     * @param orderDate
     * @param deliveryDate
     * @param cost
     * @param publisher
     */
    public static void createOrder(String[][] items, int orderID, String orderDate,
            String deliveryDate, double cost, String publisher) {
        Order order = new Order();
        order.setItems(items);
        order.setOrderID(orderID);
        order.setOrderDate(orderDate);
        order.setDeliveryDate(deliveryDate);
        order.setCost(cost);
        order.setPublisher(publisher);
        order.setStatus("Active");

        DataHandler.addItem(String.valueOf(orderID), order, orders);
    }

    /**
     * This method provides construction for Publisher objects and will add the
     * new object to the publishers variable
     *
     * @param name
     * @param email
     * @param phoneNo
     * @param address
     */
    public static void createPublisher(String name, String email,
            String phoneNo, List address) {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisher.setEmail(email);
        publisher.setPhoneNo(phoneNo);
        publisher.setAddress(address);

        DataHandler.addItem(name, publisher, publishers);
    }
//</editor-fold>
}
