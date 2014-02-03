
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import model.books.BookHandler;
import model.books.ElectronicBook;
import model.data.DataHandler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shadow
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] licences = {"sdsdsd", "fddfsdfs"};
        
        BookHandler.createUpdateBook("1", "twe", "twt", "fs", 1.25, 2.56);
        BookHandler.createUpdateBook("2", "twe", "twt", "fs", 1.25, "Ebook", licences);
        BookHandler.createUpdateBook("3", "twe", "twt", "fs", 1.25, "Ebook", licences);
        BookHandler.createUpdateStock("2", 12);
        
 
        
        try {
            DataHandler.writeObjects(BookHandler.class, new BookHandler());
        } catch (IOException | JAXBException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }   
}
