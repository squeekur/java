// April Dawn Kester
// akester
// CMPS 12B
// July 31, 2013
// Test Client for the Queue class prior to Simulation
// QueueTest.java
// No special instructions

public class QueueTest {
    public static void main(String[] args){
    Pair testObject = new Pair("test", "one");
    Pair testObject2 = new Pair("test", "two");
    Pair testObject3 = new Pair("test", "three");
    Pair testObject4 = new Pair("test", "four");    
    Pair testObject5 = new Pair("test", "five");    
    Pair testObject6 = new Pair("test", "six");    
    
    Queue sam = new Queue(); 
    
    System.out.println(sam.isEmpty());
    
    sam.enqueue(testObject);
    sam.enqueue(testObject2);
    sam.enqueue(testObject3);
    sam.enqueue(testObject4);
    sam.enqueue(testObject5);    
    
    System.out.println(sam.toString());
    System.out.println(sam.isEmpty());
    
    sam.dequeue();
    System.out.println(sam.toString());
    
    sam.dequeue();
    System.out.println(sam.toString());
    
    System.out.println(sam.peek());
    System.out.println(sam.length());
    
    sam.enqueue(testObject6);  
    System.out.println(sam.peek());
    System.out.println(sam.length());
    
    System.out.println(sam.isEmpty());
    sam.dequeue();
    sam.dequeue();
    sam.dequeue();
    sam.dequeue();
    //sam.dequeue();
    System.out.println(sam.isEmpty());
    System.out.println(sam.toString());
    

    sam.enqueue(testObject3);
    sam.enqueue(testObject2);
    sam.enqueue(testObject);
    System.out.println(sam.length());
    System.out.println(sam.isEmpty());
    System.out.println(sam.peek());
    
    sam.dequeueAll();
    System.out.println(sam.length());
    System.out.println(sam.isEmpty());
    //System.out.println(sam.peek());
    //sam.dequeueAll();
    
    
  }

}