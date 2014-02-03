/*
 * Classname: SortingTableModel.java
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
package controller;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * This class provides extensions to the abstractTableModel class that will
 * allow table models to be sorted before they are entered into their designated
 * table.
 *
 * @author Chris
 */
public class SortingTableModel extends AbstractTableModel implements TableModelListener {

    protected TableModel base;
    protected int sortColumn;
    protected int[] row;

    /**
     * Constructor for this class that takes the current table model and the int
     * of the column to be sorted and runs methods to achieve this
     *
     * @param tm
     * @param sortColumn
     */
    public SortingTableModel(TableModel tm, int sortColumn) {
        this.base = tm;
        this.sortColumn = sortColumn;
        tm.addTableModelListener(this);
        rebuild();
    }

    //<editor-fold defaultstate="collapsed" desc="Overrides">
    @Override
    public Class getColumnClass(int c) {
        return base.getColumnClass(c);
    }
    
    @Override
    public int getColumnCount() {
        return base.getColumnCount();
    }
    
    @Override
    public String getColumnName(int c) {
        return base.getColumnName(c);
    }
    
    @Override
    public int getRowCount() {
        return base.getRowCount();
    }
    
    @Override
    public Object getValueAt(int r, int c) {
        return base.getValueAt(row[r], c);
    }
    
    @Override
    public boolean isCellEditable(int r, int c) {
        return base.isCellEditable(row[r], c);
    }
    
    @Override
    public void setValueAt(Object value, int r, int c) {
        base.setValueAt(value, row[r], c); // Notification will cause re-sort
    }
    
    @Override
    public void tableChanged(TableModelEvent event) {
        rebuild();
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Sorting Methods">
    /**
     * Creates row array depending on row count and starts sorting method
     */
    protected void rebuild() {
        int size = base.getRowCount();
        row = new int[size];
        for (int i = 0; i < size; i++) {
            row[i] = i;
        }
        sort();
    }
    
    /**
     * Sort and notify listeners
     */
    protected void sort() {
        for (int i = 1; i < row.length; i++) {
            int j = i;
            while (j > 0 && compare(j - 1, j) > 0) {
                int temp = row[j];
                row[j] = row[j - 1];
                row[j - 1] = temp;
                j--;
            }
        }
        fireTableStructureChanged();
    }
    
    /**
     * Compare values in rows
     *
     * @param i
     * @param j
     * @return
     */
    protected int compare(int i, int j) {
        String s1 = base.getValueAt(row[i], sortColumn).toString();
        String s2 = base.getValueAt(row[j], sortColumn).toString();
        return s1.compareTo(s2);
    }
//</editor-fold>
}
