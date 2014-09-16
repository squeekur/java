// April Dawn Kester
// akester
// CMPS 12B
// July 18, 2013
// Creates Dictionary using LinkedList operations
// Dictionary.java
// No special instructions

public class Dictionary implements DictionaryInterface {

   // private inner Node class
   private class Node {
      Pair item;
      Node next;

      Node(Pair x){
         item = x;
         next = null;
      }
   }

    // private inner Pair class
    private class Pair{
      String key;
      String value;
      
      Pair(String x, String y){
        key = x;
        value = y;
      }
    }

   // Fields for the Dictionary class
   private Node head;     // reference to first Node in List
   private int numItems;  // number of items in this Dictionary

   // Dictionary()
   // constructor for the Dictionary class
   public Dictionary(){
      head = null;
      numItems = 0;
   }


   // private helper function -------------------------------------------------

   // find()
   // returns a reference to the Node at position index in this Dictionary
   private Node find(int index){
      Node N = head;
      for(int i=1; i<index; i++) N = N.next;
      return N;
   }

    //findKey()
    //returns a reference to the Node containing its argument key, or return null if no such Node exists
    private Node findKey(String targetKey){
      Node N = head;
      while (N != null){
        if(N.item.key.equals(targetKey)){
          break;
        }
        N = N.next;
      }
      return N;
    }
    
    //myString()
    //returns string of current state using recursion, called by toString()
    private String myString(Node H){
      if( H==null ){
        return "";
      }else{
	  return (myString(H.next) + H.item.key + " " + H.item.value + "\n");
      }
    }
    
    
   // ADT operations ----------------------------------------------------------

   // isEmpty()
   // pre: none
   // post: returns true if this Dictionary is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // size()
   // pre: none
   // post: returns the number of elements in this Dictionary
   public int size() {
      return numItems;
   }

   // lookup (similar to GET())
   // pre: none
   // post: returns value associated key, or null reference if no such key exists
    public String lookup(String key){
      Node N = findKey(key);
      if(N==null){
        return null;
      }
      else{
      return N.item.value;
      }
    }
   // get()
   // pre: 1 <= index <= size()
   // post: returns item at position index in this Dictionary
    /* public int get(int index) throws ListIndexOutOfBoundsException {
      
      if( index<1 || index>numItems ){
         throw new ListIndexOutOfBoundsException(
            "IntegerList Error: get() called on invalid index: " + index);
      }
      Node N = find(index);
      return N.item;
      }*/

   // insert() (similar to ADD())
   // inserts new (key,value) pair into this Dictionary
   // pre: key currently does not exist in this Dictionary, i.e. lookup(key)==null
   // post: !isEmpty(), size() is increased by one
    public void insert(String key, String value) throws KeyCollisionException{
      if(findKey(key)!=null){
        throw new KeyCollisionException("Dictionary Error: insert() cannot insert duplicate keys");
      }
      Node N = new Node(new Pair(key, value));
      N.next = head;
      head = N;
      numItems++;  
    }

   // delete() (similar to REMOVE())
   // deletes pair with the given key
   // pre: key currently exists in this Dictionary, i.e. lookup(key)!=null
   // post: size() is decreased by one
    public void delete(String key) throws KeyNotFoundException{
      if(findKey(key)==null){
        throw new KeyNotFoundException("Dictionary Error: delete() cannot delete non-existent key");
      }
      if(findKey(key)==head){
         Node N = head;
         head = head.next;
         N.next = null;
      }else{
        Node N = findKey(key);

        Node prev = head;
        Node temp = head.next;
        while(temp != N){//stop one earlier
          temp = temp.next;
          prev = prev.next;
        }
        prev.next = N.next;
        N.next = null;
      }
      numItems--; 
    }
     
   // makeEmpty (similar to REMOVEALL())
   // pre: none
   // post: isEmpty()
    public void makeEmpty(){
      head = null;
      numItems = 0;
    }

   // toString()
   // pre: none
   // post:  prints current state to stdout
   // Overrides Object's toString() method
    public String toString(){
      return myString(head);
    }
}
