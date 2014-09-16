import java.io.*;
import java.util.Scanner;

public class FileCopy{
    public static void main(String[] args) throws IOException{
	Scanner in = null;
	PrintWriter out = null;
	String line = null;
	int n;

	if(args.length < 2){
	    System.out.println("Usage: FileCopy infile outfile");
	    System.exit(1);
	}

	in = new Scanner(new File(args[0]));
	out = new PrintWriter(new FileWriter(args[1]));

	in.useDelimiter("\n");
	while( in.hasNext() ){
	    line = in.next();
	    out.println( line );
	}

	in.close();
	out.close();
    }
}