package com.tutego.insel.xml.jdom;

import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.util.List;

class AlbertsWater {
  public static void main( String[] args ) throws Exception {
    Document doc = new SAXBuilder().build( "party.xml" );
    Element party = doc.getRootElement();
    Element albert = party.getChild( "gast" );

    List<Content> albertInfo = albert.getContent();
    Element wasser = new Element( "getraenk" );
    wasser.addContent( "Wasser" );

    albertInfo.add( wasser );

    XMLOutputter fmt = new XMLOutputter();
    fmt.output( doc, System.out );
  }
}