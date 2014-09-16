//-----------------------------------------------------------------------------
// DictionaryInterface.java
// interface for the Dictionary ADT
//-----------------------------------------------------------------------------

public interface DictionaryInterface{

   // isEmpty()
   // returns true if this Dictionary is empty, false otherwise
   // pre: none
   public boolean isEmpty();

   // size()
   // returns the number of entries in this Dictionary
   // pre: none
   public int size();

   // lookup()
   // returns value associated key, or null reference if no such key exists
   // pre: none
   public String lookup(String key);

   // insert()
   // inserts new (key,value) pair into this Dictionary
   // pre: lookup(key)==null
   public void insert(String key, String value) throws KeyCollisionException;

   // delete()
   // deletes pair with the given key
   // pre: lookup(key)!=null
   public void delete(String key) throws KeyNotFoundException;

   // makeEmpty()
   // pre: none
   public void makeEmpty();

   // toString()
   // returns a String representation of this Dictionary
   // overrides Object's toString() method
   // pre: none
   public String toString();
}