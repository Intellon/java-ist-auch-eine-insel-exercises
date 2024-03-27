package com.tutego.insel.jdbc;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

public class DBMetaData {
  public static void main( String[] args ) throws Exception {
    try ( Connection con = ((DataSource) new InitialContext().lookup( "TutegoDS" )).getConnection() ) {
      DatabaseMetaData meta = con.getMetaData();
      System.out.println( "Product name " + meta.getDatabaseProductName() );
      System.out.println( "Version: " + meta.getDatabaseProductVersion()  );
      System.out.println( "Maximum number of connections: " + meta.getMaxConnections() );
      System.out.println( "JDBC driver version: " + meta.getDriverVersion() );
      System.out.println( "Supports update in batch: " + meta.supportsBatchUpdates() );
      System.out.println( "Supports stored procedures: " + meta.supportsStoredProcedures() );
    }
  }
}