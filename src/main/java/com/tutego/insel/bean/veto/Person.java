package com.tutego.insel.bean.veto;

import java.beans.*;

public class Person {
  
  private boolean isBigamist;

  private PropertyChangeSupport changes = new PropertyChangeSupport( this );
  private VetoableChangeSupport vetos = new VetoableChangeSupport( this );

  public void setBigamist( boolean bigamist ) throws PropertyVetoException {
    boolean oldValue = this.isBigamist;
    vetos.fireVetoableChange( "bigamist", oldValue, bigamist );
    this.isBigamist = bigamist;
    changes.firePropertyChange( "bigamist", oldValue, bigamist );
  }

  public boolean isBigamist() {
    return isBigamist;
  }

  public void addPropertyChangeListener( PropertyChangeListener l ) {
    changes.addPropertyChangeListener( l );
  }

  public void removePropertyChangeListener( PropertyChangeListener l ) {
    changes.removePropertyChangeListener( l );
  }

  public void addVetoableChangeListener( VetoableChangeListener l ) {
    vetos.addVetoableChangeListener( l );
  }

  public void removeVetoableChangeListener( VetoableChangeListener l ) {
    vetos.removeVetoableChangeListener( l );
  }
}