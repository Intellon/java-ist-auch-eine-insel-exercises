public class FinalLocal {
  @SuppressWarnings( "unused" )
  static void foo( final int a ) {
    int i = 2;
    final int j = i + 1;  // j = 3
    i = 3;
//    j = 4;       //  Compilerfehler
//    a = 2;       //  Compilerfehler
  }

}
