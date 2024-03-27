package com.tutego.insel.xml.jdom;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

class ReadXmlFile {
  public static void main( String[] args ) throws IOException, JDOMException {

    try ( Reader in = Files.newBufferedReader( Paths.get( "party.xml" ), StandardCharsets.UTF_8 ) ) {
      Document doc = new SAXBuilder().build( in );
      XMLOutputter fmt = new XMLOutputter();
      fmt.output( doc, System.out );
    }
  }
}
