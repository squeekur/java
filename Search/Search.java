// April Dawn Kester
// akester
// CMPS 12B
// July 9, 2013
// Implement MergeSort and BinarySearch to operate on Strings
// Search.java
// No special instructions

import java.io.*;
import java.util.Scanner;

class Search{
  public static void mergeSort(String[] word, int[] lineNumber, int p, int r){
    int q;
    if(p < r) {
      q = (p+r)/2;
      mergeSort(word, lineNumber, p, q);
      mergeSort(word, lineNumber, q+1, r);
      merge(word, lineNumber, p, q, r);  
    }
  }
  
  public static void merge(String[] word, int[] lineNumber, int p, int q, int r){
    int n1 = q-p+1;
    int n2 = r-q;
    String[] L = new String[n1];
    String[] R = new String[n2];
    int[] Left = new int[n1];
    int[] Right = new int[n2];
    int i, j, k;

    for(i=0; i<n1; i++){
      L[i] = word[p+i];
      Left[i] = lineNumber[p+i];
      for(j=0; j<n2; j++){ 
        R[j] = word[q+j+1];
        Right[j] = lineNumber[q+j+1];
      }
    }
    i = 0; j = 0;
    for(k=p; k<=r; k++){
      if( i<n1 && j<n2 ){
        if( L[i].compareTo(R[j]) < 0){ //comparison made here
          word[k] = L[i];
          lineNumber[k] = Left[i];
          i++;
        }else{
          word[k] = R[j];
          lineNumber[k] = Right[j];
          j++;
        }
      }else if( i<n1 ){
        word[k] = L[i];
        lineNumber[k] = Left[i];
        i++;
      }else{ // j<n2
        word[k] = R[j];
        lineNumber[k] = Right[j];
        j++;
      }
    }
  }
  
  public static int binarySearch(String[] word, int[] lineNumber, int p, int r,  String target){
    int q;
    if(p > r) {
      return -1;
    }else {
      q = (p+r)/2;
      if(target.compareTo(word[q])==0){ //comparison made here
        return q;
      }else if(target.compareTo(word[q])<0){//comparison made here
        return binarySearch(word, lineNumber, p, q-1, target);
      }else{ // target.compareTo(word[q])>0
        return binarySearch(word, lineNumber, q+1, r, target);
      }
    }
  }
  
  public static void main(String[] args) throws IOException{
      Scanner in = null;
      String [] word = null;
      String line = null;
      int[] lineNumber = null;
      int i = 0;
      int lineNumberCount = 0;
      int target = 0;

      if(args.length < 2){
         System.out.println("Usage: Search file target1 [target2 ..]");
         System.exit(1);
      }

      in = new Scanner(new File(args[0]));
      while(in.hasNext()){
         lineNumberCount++;
         line = in.next(); 
      }
      
      word = new String[lineNumberCount];
      lineNumber = new int[lineNumberCount];
      for(i=0; i<lineNumber.length; i++){
        lineNumber[i] = i+1; 
      }
      
      in = new Scanner(new File(args[0]));
      i = 0;
         
      while(in.hasNext()){
        i++;
        line = in.next(); 
        word[i-1] = line;  
      }
      
      in.close();
      
      mergeSort(word, lineNumber, 0, lineNumberCount-1);
      for(i=1; i<args.length; i++){
        line = args[i];
        target = binarySearch(word, lineNumber, 0, word.length, line);
        if(target == -1){
          System.out.println(line + " not found");
        }else{
        System.out.println(line + " found on line " + lineNumber[target]);
        }
      }
  }
}
