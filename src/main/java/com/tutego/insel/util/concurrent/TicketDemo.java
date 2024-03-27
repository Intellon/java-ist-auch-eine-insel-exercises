package com.tutego.insel.util.concurrent;

import com.tutego.insel.util.concurrent.Ticket.Priority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketDemo {
  public static void main( String[] args ) {
    List<Ticket> tickets = Arrays.asList(
      new Ticket( Priority.NORMAL, "Kein Senf" ),
      new Ticket( Priority.SEVERE, "Feuer" ),
      new Ticket( Priority.NORMAL, "Bier warm" ),
      new Ticket( Priority.SEVERE, "Erdbeben" ) );
    Collections.sort( tickets );
    for ( Ticket ticket : tickets )
      System.out.println( ticket );
  }
}