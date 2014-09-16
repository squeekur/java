// April Dawn Kester
// akester
// CMPS 12B
// July 31, 2013
// Test Object for the QueueTest class for Queue ADT testing
// Pair.java
// No special instructions

public class Pair{
  String key;
  String value;
      
  Pair(String x, String y){
    key = x;
    value = y;
  }
      
  public String toString(){
    String s = "key = " + key + "," + " value = " + value;
    return s;
  }
}