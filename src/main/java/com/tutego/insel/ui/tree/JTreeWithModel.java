package com.tutego.insel.ui.tree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTreeWithModel {
  public static void main( String[] args ) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    List<Point> points = new ArrayList<>();
    points.add( new Point(12,13) );
    points.add( new Point(2,123) );
    points.add( new Point(23,13) );

    JTree tree = new JTree( new PointModel(points) );
    frame.add( new JScrollPane( tree ) );
    frame.pack();
    frame.setVisible( true );

    tree.getSelectionModel().addTreeSelectionListener(
      new TreeSelectionListener() {
        @Override public void valueChanged( TreeSelectionEvent e ) {
          TreePath path = e.getNewLeadSelectionPath();
          System.out.println( path );
        }
      }
    );
  }
}