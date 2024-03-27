package com.tutego.insel.xml.jdom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;

class RootElement {
  public static void main( String[] args ) throws JDOMException, IOException {
    SAXBuilder builder = new SAXBuilder();
    Document doc = builder.build( "party.xml" );

    Element party = doc.getRootElement();

    System.out.println( "Wurzelelement: " + party.toString() );

    XMLOutputter fmt = new XMLOutputter();
    fmt.output( doc, System.out );
  }
}