//April Dawn Kester
//akester
//CMPS 12B
//July 1, 2013
//Returns max and min elements in an array
//Extrema.java
//No special instructions

class Extrema {
   
   // maxArray()
   // returns the largest value in int array A
   static int maxArray(int[] A, int p, int r){
     int q;
     int maxLeft;
     int maxRight;
     if (p == r) return A[p];
     else if (p < r) {
       q = (p+r)/2;
       maxLeft = maxArray(A, p, q);
       maxRight = maxArray(A, q+1, r);
       return max(maxLeft, maxRight);
   }
     return 0;
   }
   
   // minArray()
   // returns the smallest value in int array A
   static int minArray(int[] A, int p, int r){
     int q;
     int minLeft;
     int minRight;
     if (p == r) return A[p];
     else if (p < r) {
       q = (p+r)/2;
       minLeft = minArray(A, p, q);
       minRight = minArray(A, q+1, r);
       return min(minLeft, minRight);
   }
     return 0;
   }
   
   //max()
   //compares two ints and retuns the largest
   static int max(int first, int second){
     if (first >= second) return first;
     else return second;
   }
   
   //min()
   //compares two ints and returns the smallest
   static int min(int first, int second){
     if (second >= first) return first;
     else return second;
     
   }

   // main()
   public static void main(String[] args){
      int[] B = {-1, 2, 6, 3, 9, 2, -3, -2, 11, 5, 7};
      System.out.println( "max = " + maxArray(B, 0, B.length-1) );  // output: max = 11
      System.out.println( "min = " + minArray(B, 0, B.length-1) );  // output: min = -3
   }
   
}