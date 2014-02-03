/*
 * Copyright (C) 2014 Chris
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Helper class that contains methods for operations on forms
 *
 * @author Chris
 */
public class FormHelper {

    /**
     * Clears all text fields in a given container
     *
     * @param container
     */
    public static void clearTextFields(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                JTextField f = (JTextField) c;
                f.setText("");
            } else if (c instanceof JTextArea) {
                JTextArea f = (JTextArea) c;
                f.setText("");
            } else if (c instanceof Container) {
                clearTextFields((Container) c);
            }
        }
    }

    /**
     * Checks that container text fields are not null
     *
     * @param container
     * @return
     */
    public static boolean validateTextFields(Container container) {
        for (Component c : container.getComponents()) {
            if (c instanceof JTextField) {
                JTextField f = (JTextField) c;
                if (f.getText().matches("")) {
                    showMessageDialog(null, "Please complete all text fields");
                    return false;
                }  
            } else if (c instanceof JTextArea) {
                JTextArea f = (JTextArea) c;
                if (f.getText().matches("")) {
                    showMessageDialog(null, "Please complete all text fields");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks that characters being entered into text fields are numbers
     *
     * @param evt
     */
    public static void checkForNumber(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE
                || c == KeyEvent.VK_DELETE || c == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Methods for altering table">
    /**
     * Adds data to table model for given data array
     *
     * @param data
     * @param model
     */
    public static void setTableModel(Object[] data, DefaultTableModel model) {
        model.addRow(data);
    }

    /**
     * Removes all rows from a table
     *
     * @param model
     */
    public static void clearTableModel(DefaultTableModel model) {
        model.setRowCount(0);
    }
}
