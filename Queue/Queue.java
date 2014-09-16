// April Dawn Kester
// akester
// CMPS 12B
// July 31, 2013
// Queue ADT
// Queue.java
// No special instructions

public class Queue implements QueueInterface {
  
   // private inner Node class
   private class Node {
      Object anyObject;
      Node next;

      Node(Object anyObject){
         this.anyObject = anyObject;
         next = null;
      }
    }

   // Fields for the Queue class
   private Node head;     // reference to first Node in List
   private int numItems;  // number of items in this Dictionary

   // Queue()
   // constructor for the Queue class
   public Queue(){
      head = null;
      numItems = 0;
   }
  
   // ADT operations ----------------------------------------------------------
    
   // isEmpty()
   // pre: none
   // post: returns true if this Queue is empty, false otherwise
   public boolean isEmpty(){
      return(numItems == 0);
   }

   // length()
   // pre: none
   // post: returns the length of this Queue.
   public int length(){
     return numItems;
   }

   // enqueue()
   // adds newItem to back of this Queue
   // pre: none
   // post: !isEmpty()
   public void enqueue(Object newItem){
     Node N = head;
     if (head==null){
       head = new Node(newItem);
     }else{
       for(int i = 1; i<numItems; i++){
         N = N.next;
       }
       N.next = new Node(newItem);
     }
     
     numItems++;
   }
     
   // dequeue()
   // deletes and returns item from front of this Queue
   // pre: !isEmpty()
   // post: this Queue will have one fewer element
   public Object dequeue() throws QueueEmptyException{
      if( numItems==0 ){
         throw new QueueEmptyException("Queue class, cannot dequeue() empty queue");
      }
      Node N = head;
      head = head.next;
      numItems--;
      return N.anyObject;
   }

   // peek()
   // pre: !isEmpty()
   // post: returns item at front of Queue
   public Object peek() throws QueueEmptyException{
      if( numItems==0 ){
         throw new QueueEmptyException("Queue class, cannot peek() empty queue");
      }
      return head.anyObject;
   }

   // dequeueAll()
   // sets this Queue to the empty state
   // pre: !isEmpty()
   // post: isEmpty()
   public void dequeueAll() throws QueueEmptyException{
      if( numItems==0 ){
         throw new QueueEmptyException("Queue class, cannot dequeueAll() empty queue");
      }
      head = null;
      numItems = 0;

   }

   // toString()
   // overrides Object's toString() method
   public String toString(){
     String s = "";
     //s = head.next.anyObject.toString();
     Node N;
     for(N=head; N != null; N = N.next){
       s += N.anyObject.toString() + " ";
     }
      return s;
   }
  
}