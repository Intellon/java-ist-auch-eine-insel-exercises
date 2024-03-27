package com.tutego.insel.net;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;

public class MacAddress {
  public static void main( String[] args ) throws SocketException {
    for ( NetworkInterface ni : Collections.list( NetworkInterface.getNetworkInterfaces() ) ) {
      byte[] adr = ni.getHardwareAddress();
      if ( adr != null && adr.length == 6 )
        System.out.printf( "%02X:%02X:%02X:%02X:%02X:%02X",
                           adr[0], adr[1], adr[2], adr[3], adr[4], adr[5] );
    }
  }
}
