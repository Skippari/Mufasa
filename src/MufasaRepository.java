
import java.util.*;
import java.io.*;
import java.util.Vector;
import java.util.Iterator;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

class MufasaRepository {
    
    private Vector <Mufasa> accounts;
    private static MufasaRepository instance = null;
   
    private MufasaRepository(){
        accounts = new Vector<>(3,1);
    }
    
    public void addMufasa( Mufasa account ){
        accounts.addElement( account );
    }
    
    public Mufasa removeLast(){
        
        if(!accounts.isEmpty()){
            Mufasa dMufasa;
            dMufasa = accounts.lastElement();
            int indeksi= accounts.lastIndexOf( dMufasa );
            accounts.removeElementAt( indeksi );
            return dMufasa;
        }
        return null;
        
    }
    
    public boolean tallennaTiedostoon( String tiedostonNimi ) {
    	try (ObjectOutputStream oOut = new ObjectOutputStream(new FileOutputStream(tiedostonNimi))){
    	
    	Iterator<Mufasa> iter = accounts.iterator();
    			
    	while(iter.hasNext()) {
    		oOut.writeObject(iter.next());
    	}
    	oOut.writeObject(null);
    	return true;
    
    }catch (IOException ioe) {
    	return false;
    }
    }//tallenna
    
    public boolean lueTiedostosta( String tiedostonNimi ) {
    	try (ObjectInputStream oIn = new ObjectInputStream(new FileInputStream(tiedostonNimi))){
        	
        	Mufasa p = (Mufasa)oIn.readObject();
        	
        	while( p != null) {
        		accounts.addElement(p);
        		p = (Mufasa)oIn.readObject();
        	}
        	tulosta();
        	return true;
        
        }catch (IOException | ClassNotFoundException e) {
        	System.out.println(e.getMessage());
        	return false;
        }
    }
        
    public void tulosta(){
        
        Iterator<Mufasa> iter = accounts.iterator();
        
        while( iter.hasNext()){
            System.out.println(iter.next());
        }
        
    }
   
   public static MufasaRepository getInstance(){
      if( instance == null ){
         instance = new MufasaRepository();
      }
      return instance;
   }
}
