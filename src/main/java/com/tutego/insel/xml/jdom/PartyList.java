package com.tutego.insel.xml.jdom;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

import java.util.List;

class PartyList {
  public static void main( String[] args ) throws Exception {
    Document doc = new SAXBuilder().build( "party.xml" );
    List<Content> partyInfo = doc.getRootElement().getContent();
    for ( Content content : partyInfo )
      System.out.println( content );
  }
}
