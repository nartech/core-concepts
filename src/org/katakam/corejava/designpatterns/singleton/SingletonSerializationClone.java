package org.katakam.corejava.designpatterns.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class  SingletonSerializationClone implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//eager initialization
	//not preferred if it involves cost eg like loading big images
    private static final SingletonSerializationClone instance = new SingletonSerializationClone();
 
    private SingletonSerializationClone() {}
 
    public static SingletonSerializationClone getInstance() {
        return instance;
    }

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return new CloneNotSupportedException();
	}
    
	public Object readResolve(){
		return instance;
	}
    
	 public static void writeSingleton() {
	      try {
	         FileOutputStream fos = new FileOutputStream("serializedSingleton");
	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         SingletonSerializationClone s = SingletonSerializationClone.getInstance();
	         oos.writeObject(SingletonSerializationClone.getInstance());
	         oos.flush();
	      }
	      catch(NotSerializableException se) {
	         System.out.println("Not Serializable Exception: " + se.getMessage());
	      }
	      catch(IOException iox) {
	         System.out.println("IO Exception: " + iox.getMessage());
	      }
	   }
	 
	   public static SingletonSerializationClone readSingleton() {
	      SingletonSerializationClone s = null;
	      try {
	         FileInputStream fis = new FileInputStream("serializedSingleton");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         s = (SingletonSerializationClone)ois.readObject();
	      }
	      catch(ClassNotFoundException cnf) {
	         System.out.println("Class Not Found Exception: " + cnf.getMessage());
	      }
	      catch(NotSerializableException se) {
	         System.out.println("Not Serializable Exception: " + se.getMessage());
	      }
	      catch(IOException iox) {
	         System.out.println("IO Exception: " + iox.getMessage());
	      }
	      return s;
	   }
	
	
	   public static void main(String[] args){
		   SingletonSerializationClone ssc1 = SingletonSerializationClone.getInstance();
		   
		   writeSingleton();
		   
		   SingletonSerializationClone ssc2 = readSingleton();
		   
		   //Run this program commenting readResolve()
		   System.out.println("HashCode before Serialization : " + ssc1.hashCode());
		   
		   System.out.println("HashCode after Serialization : " + ssc2.hashCode());
		   
	   }
}