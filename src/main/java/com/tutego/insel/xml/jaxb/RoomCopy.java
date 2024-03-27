package com.tutego.insel.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import java.util.Arrays;

public class RoomCopy {
  public static void main( String[] args ) throws JAXBException {
    Player john = new Player();
    john.setName( "John Peel" );
    Player tweet = new Player();
    tweet.setName( "Zwitscher Zoe" );
    Room room = new Room();
    room.setPlayers( Arrays.asList( john, tweet ) );

    JAXBContext context = JAXBContext.newInstance( Room.class );
    Unmarshaller unmarshaller = context.createUnmarshaller();
    JAXBSource source = new JAXBSource( context, room );
    Room copiedRoom = Room.class.cast( unmarshaller.unmarshal( source ) );
    System.out.println( copiedRoom.getPlayers() );
  }
}