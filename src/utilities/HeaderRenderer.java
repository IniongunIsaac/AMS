/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.plaf.UIResource;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author INIONGUN ISAAC I
 */
public class HeaderRenderer implements UIResource, TableCellRenderer {

    private TableCellRenderer original;

    public HeaderRenderer(TableCellRenderer original) {
        this.original = original;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = original.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        //comp.setFont(comp.getFont().deriveFont(Font.BOLD));
        comp.setFont(comp.getFont().deriveFont(12f));
        return comp;
    }

}