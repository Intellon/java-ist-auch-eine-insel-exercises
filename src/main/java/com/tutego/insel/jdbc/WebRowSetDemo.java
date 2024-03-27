package com.tutego.insel.jdbc;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetDemo {
  public static void main( String[] args ) throws Exception {
    try ( WebRowSet rowSet = RowSetProvider.newFactory().createWebRowSet() ) {
      rowSet.setDataSourceName( "TutegoDS" );
      rowSet.setCommand( "SELECT * FROM Customer" );
      rowSet.setMaxRows( 2 );
      rowSet.execute();
    
      rowSet.writeXml( System.out );
    }
  }
}