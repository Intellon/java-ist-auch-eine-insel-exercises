package com.tutego.insel.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

public class CachedRowSetDemo {
  public static void main( String[] args ) throws SQLException {
    try ( CachedRowSet crset = RowSetProvider.newFactory().createCachedRowSet() ) {
      crset.setDataSourceName( "TutegoDS" );
      crset.setCommand( "SELECT * FROM Customer" );
      crset.execute();
    
      while ( crset.next() )
        System.out.println( crset.getString( 1 ) );
    }
  }
}