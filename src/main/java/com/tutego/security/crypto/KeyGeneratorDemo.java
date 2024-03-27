package com.tutego.security.crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyGeneratorDemo {

  public static void main( String[] args ) throws NoSuchAlgorithmException {
    KeyGenerator kg = KeyGenerator.getInstance( "DES" );
    KeyPairGenerator kpg = KeyPairGenerator.getInstance( "RSA" );

    kg.init( 56 );
    kpg.initialize( 1024 );

    SecretKey secKey = kg.generateKey();
    KeyPair keyPair = kpg.genKeyPair();

    System.out.println( secKey ); // com.sun.crypto.provider.DESKey@18784
    System.out.println( keyPair.getPublic() );
    System.out.println( "----" );
    System.out.println( keyPair.getPrivate() );
  }
}
