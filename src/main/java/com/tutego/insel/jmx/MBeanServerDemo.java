package com.tutego.insel.jmx;

import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class MBeanServerDemo {

  public static void main( String[] args ) throws MalformedObjectNameException {
    MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    System.out.println( server.getMBeanCount() );

    for ( ObjectInstance object : server.queryMBeans( new ObjectName( "*:*" ), null ) )
      System.out.println( object.getObjectName() );
  }
}
