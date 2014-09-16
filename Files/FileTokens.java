import java.io.*;
import java.util.Scanner;

class FileTokens{
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
	    line = in.next() + " ";  // add space so split works on blank lines
	    token = line.split("\\s+");  // split line around white space
	    n = token.length;
	    out.println("Line " + lineNumber + " contains " + n + " tokens:");
	    for(i=0; i<n; i++){
		out.println(token[i]);
	    }
	    out.println();
	}

	in.close();
	out.close();
    }
}