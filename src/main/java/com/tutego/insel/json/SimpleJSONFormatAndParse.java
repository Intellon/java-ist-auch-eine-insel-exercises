package com.tutego.insel.json;

import javax.json.*;
import javax.json.stream.JsonGenerator;
import java.awt.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class SimpleJSONFormatAndParse {

  public static void main( String[] args ) {

    Point p = new Point( 10, 20 );
    
    JsonObjectBuilder objBuilder = Json.createObjectBuilder()
                                       .add( "x", p.x )
                                       .add( "y", p.y );
    JsonObject jsonObj = objBuilder.build();
    
    System.out.println( jsonObj );  // {"x":10,"y":20}
    
    Json.createWriter( System.out ).write( jsonObj ); // {"x":10,"y":20}
    
    Map<String, Boolean> config = new HashMap<>();
    config.put( JsonGenerator.PRETTY_PRINTING, true );
    JsonWriterFactory writerFactory = Json.createWriterFactory( config );
    
    StringWriter out = new StringWriter();
    writerFactory.createWriter( out ).write( jsonObj );
    System.out.println( out );  // {\n    "x": 10, ...
    
    JsonReader reader = Json.createReader( new StringReader( out.toString() ) );
    System.out.println( reader.readObject().getInt( "x" ) ); // 10
  }
}
 