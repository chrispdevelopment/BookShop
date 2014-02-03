/*
 * Classname: DataHandler.java
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
package model.data;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This class provides functionality for manipulating the data model, reading
 * data from the XML files and writing data to the XML files
 *
 * @author Shadow
 */
public class DataHandler {

    /**
     * File variable to hold location of books.xml file
     */
    public static final File BOOKS_FILE = new File("books.xml");
    /**
     * File variable to hold location of orders.xml file
     */
    public static final File ORDERS_FILE = new File("orders.xml");

    //<editor-fold defaultstate="collapsed" desc="Methods for manipulating the data model">
    /**
     * This method allows for items to be added to the data model depending on
     * what item is passed and which Map is passed
     *
     * @param key
     * @param item
     * @param data
     */
    public static void addItem(String key, Object item, Map data) {
        data.put(key, item);
    }

    /**
     * This method allows for items to be deleted from the data model depending
     * on what item is passed and which Map is passed
     *
     * @param key
     * @param data
     */
    public static void deleteItem(String key, Map data) {
        data.remove(key);
    }

    /**
     * This method allows for items to be retrieved from the data model
     * depending on what item is passed and which Map is passed
     *
     * @param key
     * @param data
     * @return
     */
    public static Object retreiveItem(String key, Map data) {
        return data.get(key);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Method for reading and writing to XML files">
    /**
     * This method allows for data to be wrote to an XML file depending on the
     * class template, the Map object and the file specified
     *
     * @param template
     * @param item
     * @param file
     * @throws JAXBException
     * @throws IOException
     */
    public static void writeObjects(Class template, Object item, File file)
            throws JAXBException, IOException {
        JAXBContext ctx = JAXBContext.newInstance(template);

        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        m.marshal(item, file);
    }

    /**
     * This method allows for data to read from the XML files depending on what
     * class template and file is specified
     *
     * @param template
     * @param file
     * @throws JAXBException
     */
    public static void readObjects(Class template, File file) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(template);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.unmarshal(file);
    }
//</editor-fold>
}
