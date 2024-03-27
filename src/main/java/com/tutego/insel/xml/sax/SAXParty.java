package com.tutego.insel.xml.sax;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SAXParty {
  public static void main( String[] args ) throws Exception {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();
    DefaultHandler handler = new PartyHandler();
    try ( InputStream in = Files.newInputStream( Paths.get( "party.xml" ) ) ) {
      saxParser.parse( in, handler );
    }
  }
}
