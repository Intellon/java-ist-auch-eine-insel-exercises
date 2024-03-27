package com.tutego.insel.ui.table;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableWithRowSorter {
  public static void main( String[] args ) {
    TableModel model = new DefaultTableModel( 100, 3 ) {
      @Override public Integer getValueAt( int row, int column ) {
        return (int) Math.pow( row, column + 1 );
      }
    };
    final JTable table = new JTable( model );
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.add( new JScrollPane(table) );
    frame.pack();
    frame.setVisible( true );

    final TableRowSorter<TableModel> rowSorter = new TableRowSorter<>( model );
    table.setRowSorter( rowSorter );

    rowSorter.setComparator( 0,
      (Integer i1, Integer i2) -> Integer.bitCount( i1 ) - Integer.bitCount( i2 ) );
    rowSorter.setSortable( 1, false );
//    rowSorter.sort();

    rowSorter.setRowFilter( RowFilter.regexFilter("(0|2|4|6|8)$", 2) );

    table.addMouseListener( new MouseAdapter() {
      @Override public void mouseClicked( MouseEvent e ) {
        int rowAtPoint = table.rowAtPoint( e.getPoint() );
        int columnAtPoint = table.columnAtPoint( e.getPoint() );    
        System.out.printf( "%d/%d%n", rowAtPoint, columnAtPoint );

        int convertedRowAtPoint = rowSorter.convertRowIndexToModel( rowAtPoint );        
        int convertedColumAtPoint = table.convertColumnIndexToModel( columnAtPoint );        
        System.out.println( rowSorter.getModel().getValueAt( convertedRowAtPoint, convertedColumAtPoint) );
      }
    } );
  }
}