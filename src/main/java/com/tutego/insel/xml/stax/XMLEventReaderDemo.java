package com.tutego.insel.xml.stax;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class XMLEventReaderDemo {

  public static void main( String[] args ) {
    try ( Reader in = Files.newBufferedReader( Paths.get( "party.xml" ),
                                               StandardCharsets.UTF_8 ) ) {
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLEventReader parser = factory.createXMLEventReader( in );

      StringBuilder spacer = new StringBuilder();
  
      while ( parser.hasNext() ) {
        XMLEvent event = parser.nextEvent();
  
        switch ( event.getEventType() ) {
          case XMLStreamConstants.START_DOCUMENT:
            System.out.println( "START_DOCUMENT:" );
            break;
            
          case XMLStreamConstants.END_DOCUMENT:
            System.out.println( "END_DOCUMENT:" );
            parser.close();
            break;
            
          case XMLStreamConstants.START_ELEMENT:
            StartElement element = event.asStartElement();
            System.out.println( spacer.append("  ")
                                + "START_ELEMENT: "
                                + element.getName() );
            for ( Iterator<?> attributes = element.getAttributes();
                  attributes.hasNext(); ) {
              Attribute attribute = (Attribute) attributes.next();
              System.out.println( spacer + "  Attribut: "
                                  + attribute.getName() + " Wert: "
                                  + attribute.getValue() );
            }
            break;
            
          case XMLStreamConstants.CHARACTERS:
            Characters characters = event.asCharacters();
            if ( !characters.isWhiteSpace() )
              System.out.println( spacer
                                  + "  CHARACTERS: "
                                  + characters.getData() );
            break;
            
          case XMLStreamConstants.END_ELEMENT:
            System.out.println( spacer
                                + "END_ELEMENT: "
                                + event.asEndElement().getName() );
            spacer.setLength( spacer.length() - 2 );
            break;
        }
      }
      parser.close();
    }
    catch ( IOException | XMLStreamException e ) {
      e.printStackTrace();
    }
  }
}