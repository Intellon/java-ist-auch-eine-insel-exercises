package com.tutego.insel.xml.xslt;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.transform.JDOMResult;
import org.jdom2.transform.JDOMSource;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;

class XslTransformer {
  public static void main( String[] args ) throws Exception {
    Document doc = new SAXBuilder().build( "party.xml" );

    Source xmlFile = new JDOMSource( doc );
    JDOMResult htmlResult = new JDOMResult();

    Transformer transformer = TransformerFactory.newInstance()
        .newTransformer( new StreamSource( "party.xsl" ) );

    transformer.transform( xmlFile, htmlResult );

    XMLOutputter xmlOutputter = new XMLOutputter();
    xmlOutputter.output( doc, System.out );
    xmlOutputter.output( htmlResult.getDocument(), System.out );
  }
}
