// File:    Status.java
// Author:  Ayodeji Babaniyi
// Date:    03/05/2011
// Purpose: Utility class used for storing exceptions and displaying them to the users.
package net.mscchoir.donante.util;
import java.util.ArrayList;
import java.util.Iterator;
public class Status {
   //The list of Exception objects
   private ArrayList exceptions;
   public Status() {exceptions=new ArrayList();}
   public boolean isSuccessful() {return (exceptions.isEmpty());}
   public void addException(Exception ex) {exceptions.add(ex);}
   public Iterator getExceptions() {return exceptions.iterator();}
}
