package com.tutego.insel.array;

class PascalsTriangle {

  public static void main( String[] args ) {
    int[][] triangle = new int[7][];

    for ( int row = 0; row < triangle.length; row++ ) {
      String spc = new String( new char[(14 - 2*row)] ).replace('\0', ' ');
      System.out.print( spc );

      triangle[row] = new int[row + 1];

      for ( int col = 0; col <= row; col++ ) {
        if ( (col == 0) || (col == row) )
           triangle[row][col] = 1;
        else
           triangle[row][col] =   triangle[row - 1][col - 1]
                                + triangle[row - 1][col];

        System.out.printf( "%3d ", triangle[row][col] );
      }

      System.out.println();
    }
  }
}
