// April Dawn Kester
// akester
// CMPS 12B
// July 18, 2013
// Client module for testing Queue and Job ADT's
// Simulation.java
// No special instructions

import java.io.*;
import java.util.Scanner;

public class Simulation{

// Function to assemble storage queues
   public static Job getJob(Scanner in) {
      String[] s = in.nextLine().split(" ");
      int a = Integer.parseInt(s[0]);
      int d = Integer.parseInt(s[1]);
      return new Job(a, d);
   }

// Function main 
   public static void main(String[] args) throws IOException{
     // Function main variables
     Scanner in = null; 
     PrintWriter rptOut = null; 
     PrintWriter trcOut = null;  
     String line = null;
     String numJobs = null;
     int finalNumJobs; //Probably an extra variable, need to convert String to int (this is m)
     Queue storageCopy = new Queue();
     Queue storage = new Queue();
     Queue finished = new Queue();  
     Job j = null;
     Queue[] processorQueues = null;
     int time = 0;
 
     if(args.length < 1){
      System.out.println("Usage: Simulation infile");
       System.exit(1);
     }
     
     in = new Scanner(new File(args[0]));
     rptOut = new PrintWriter(new FileWriter(args[0] + ".rpt"));
     trcOut = new PrintWriter(new FileWriter(args[0] + ".trc"));    

     numJobs = in.nextLine();
     finalNumJobs = Integer.parseInt(numJobs);
     
     while (in.hasNext()){
       j = getJob(in);
       storageCopy.enqueue(j); 
     }
     
     trcOut.println("Trace file: " + (args[0] + ".trc"));//print once per program run
     trcOut.println(finalNumJobs + " Jobs:");
     trcOut.println(storageCopy.toString());
     trcOut.println();
     
     rptOut.println("Report file: " + (args[0] + ".rpt"));//print once per program run
     rptOut.println(finalNumJobs + " Jobs:");
     rptOut.println(storageCopy.toString());
     rptOut.println();
     rptOut.println("*****************************************************************************");
     
     // Main program loop for running simulations n=1 to n=(m-1)
     for(int n = 1; n < finalNumJobs; n++){ // one less processor than jobs
       int totalWait = 0;//Main loop calculation variables
       int maxWait = 0;
       double averageWait = 0.00;
       for(int i = 1; i<storageCopy.length()+1; i++){
         j = (Job)storageCopy.dequeue();
         j.resetFinishTime();
         storage.enqueue(j);
         storageCopy.enqueue(j);  
       }
       
       int processors = n; 
       processorQueues = new Queue[n+2];
       processorQueues[0] = storage;//place storage in first array index
       processorQueues[n+1] = finished;//place finished in last array index
       for (int i = 1; i < n+1; i++){//filling array with empty queues
         processorQueues[i] = new Queue();
       }
       
       trcOut.println("*****************************");//Print for each run of the main loop
       if(processors==1){
         trcOut.println(processors + " processor:");
       }else{
         trcOut.println(processors + " processors:"); 
       }
       trcOut.println("*****************************");
       
       trcOut.println("time=" + time);
       trcOut.println("0: " + storage.toString());
       for(int i = 1; i < processors+1; i++){
         trcOut.println(i + ": " + processorQueues[i]);
       }
       trcOut.println("finished: " + finished.toString());
       
       while(finished.length()!=finalNumJobs){ // Run as long as there are still jobs pending
         // While loop variables  
         int compFinal = Integer.MAX_VALUE; //-1 THESE ARE MESSING ME UP <---------------------------------------------------------
         int finalIndex = 1; //-1 THESE ARE MESSING ME UP <---------------------------------------------------------
         int comp = -1;
         int length = -1;
         int finalLength = -1;
         Job compare = null;
         
         if(!storage.isEmpty()){ // Check storage arrival time, if empty ignore
           compare = (Job)storage.peek(); 
           compFinal = compare.getArrival(); // -1 if don't go into loop <------------------------------------------
           finalIndex = 0; // -1 if don't go into loop <------------------------------------------------------------
         }//end of if statement
         
         for(int i = 1; i < processors+1; i++){ // Check processor indicies   
           if(processorQueues[i].length() != 0){ // Check processor finish time, if empty ignore
             compare = (Job)processorQueues[i].peek();
             comp = compare.getFinish();
           } 
           if(comp == -1){ // Never went into if loop above because que was empty
           }else if(comp<compFinal){ // Compare ints in for loop to find smallest, track index
             compFinal = comp; // if (comp < -1) CAN'T HAPPEN <------------------------------------------------------
             finalIndex = i;
           }   
           time = compFinal;
         }//end of comparison for loop
         
         if(finalIndex == 0){ // Move from storage to processor with shortest length(index), compute finish time if first in line
           int tempIndex = 1;
           finalLength = processorQueues[tempIndex].length(); //Always at least 1 processor!!!! RIGHT?!
           for(int i = 1; i < processors+1; i++){
             length = processorQueues[i].length();
             if(length<finalLength){
               finalLength = length;
               tempIndex = i;
             }
           }//end of comparison for loop
           
           compare = (Job)storage.dequeue();
           processorQueues[tempIndex].enqueue(compare);
           if(processorQueues[tempIndex].length()==1){
             compare = (Job)processorQueues[tempIndex].peek();
             compare.computeFinishTime(time); 
           }
         }//end of if statement
         
         else{ // Move from processor to finish 
           compare = (Job)processorQueues[finalIndex].dequeue();
           finished.enqueue(compare);
           int tempWait = compare.getWaitTime();
           if(tempWait > maxWait){
             maxWait = tempWait; 
           }
           totalWait += tempWait;
           
           if(processorQueues[finalIndex].length() >= 1){
             compare = (Job)processorQueues[finalIndex].peek();
             compare.computeFinishTime(time); 
           }
          
         }//end else
         
         trcOut.println();
         trcOut.println("time=" + time);
         trcOut.println("0: " + storage.toString());
         for(int i = 1; i < processors+1; i++){
           trcOut.println(i + ": " + processorQueues[i]);
         }
         trcOut.println("finished: " + finished.toString());
        
       } // end of processing while loop
      
     //compute the total wait, maximum wait, and average wait for all Jobs, then reset finish times
       averageWait = ((double)totalWait/finalNumJobs);
       averageWait = (double)Math.round(averageWait*100)/100;
       trcOut.println();
       rptOut.println();
       if(processors==1){
         rptOut.print(processors + " processor: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait);         
       }else{
         rptOut.print(processors + " processors: totalWait=" + totalWait + ", maxWait=" + maxWait + ", averageWait=" + averageWait); 
       }
       
       time = 0;
       finished.dequeueAll();
       }//end main body loop
     
       in.close();
       rptOut.close();
       trcOut.close();

   }//end main
}//end Simulation

