//April Dawn Kester
//akester
//CMPS 12M
//July 7, 2013
//Takes 2 command line args, input/output files
//Reads each line, parse tokens, prints out to file each token backwards
//FileReverse
//No special instructions


import java.io.*;
import java.util.Scanner;
  
  public class FileReverse{
    
    public static String stringReverse(String s, int n){
      StringBuffer reversedString = new StringBuffer();
      if (n > 0) {
        reversedString = reversedString.append(s.substring(n-1, n)); 
        return reversedString + stringReverse(s, n-1);
      }
      return reversedString.toString();  
    }
    
    public static void main(String[] args) throws IOException{
      Scanner in = null;
      PrintWriter out = null;
      String line = null;
      String[] token = null;
      int i, n, lineNumber = 0;

      if(args.length < 2){
         System.out.println("Usage: FileTokens infile outfile");
         System.exit(1);
      }

      in = new Scanner(new File(args[0]));
      out = new PrintWriter(new FileWriter(args[1]));

      in.useDelimiter("\n");
      while( in.hasNext() ){
         lineNumber++;
         line = in.next() + " ";  
         token = line.split("\\s+");  
         n = token.length;
         for(i=0; i<n; i++){
           String s = token[i];
           int j = s.length();
           out.println(stringReverse(s, j));
           
          
         }
      }

      in.close();
      out.close();
   }
  }