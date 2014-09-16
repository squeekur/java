// April Dawn Kester
// akester
// CMPS 12B
// July 18, 2013
// Test file for Dictionary.java
// DictionaryTest.java
// No special instructions

public class DictionaryTest{
  public static void main(String[] args){
    //String k1 = "8";
    //String v1 = "g";
    
    Dictionary bob = new Dictionary();
    //System.out.println(bob.isEmpty());
    //System.out.println(bob.size());
    
    //bob.insert(k1, v1);
    //System.out.println(bob.isEmpty());
    //System.out.println(bob.size());
    
    //System.out.println(bob.toString());
    
    //String k2 = "6";
    //String v2 = "p";
    
    //bob.insert(k2, v2);
    //System.out.println(bob.size());
    //System.out.println(bob.toString());
    
    //String k3 = "6";
    //String v3 = "p";
    //bob.insert(k3, v3);
    
    //String k4 = "10";
    //String v4 = "p";
    //bob.insert(k4, v4);
    //System.out.println(bob.toString());
    
    //bob.delete("10");
    //System.out.println(bob.toString());
    //System.out.println(bob.size());
    
    //bob.delete("8");
    //System.out.println(bob.toString());
    //System.out.println(bob.size());
    
      bob.insert("1","a");
      bob.insert("2","b");
      bob.insert("3","c");
      bob.insert("4","d");
      bob.insert("5","e");
      bob.insert("6","f");
      bob.insert("7","g");
      System.out.println(bob.toString());
      System.out.println(bob.size());
      
      bob.delete("1");
      bob.delete("3");
      bob.delete("7");
      System.out.println(bob.toString());
      System.out.println(bob.size());
      
      //bob.makeEmpty();
      //System.out.println(bob.toString());
      //System.out.println(bob.size());
      
      String v;
      
      v = bob.lookup("1");
      System.out.println("key=1 "+(v==null?"not found":("value="+v)));
      v = bob.lookup("4");
      System.out.println("key=3 "+(v==null?"not found":("value="+v)));
      v = bob.lookup("7");
      System.out.println("key=7 "+(v==null?"not found":("value="+v)));
      v = bob.lookup("8");
      System.out.println("key=8 "+(v==null?"not found":("value="+v)));
      System.out.println();
       
  }

}