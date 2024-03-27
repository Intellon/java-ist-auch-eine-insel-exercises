package com.tutego.insel.ui.table;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class SimpleTableCellEditor extends AbstractCellEditor implements TableCellEditor {
  
  private JTextField component = new JTextField();

  @Override
  public Component getTableCellEditorComponent( JTable table, Object value, boolean isSelected,
                                                int rowIndex, int colIndex ) {
    component.setText( value.toString() );

    return component;
  }

  @Override
  public Object getCellEditorValue() {
    return component.getText();
  }
}
