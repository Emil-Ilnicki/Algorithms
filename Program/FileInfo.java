import java.io.*;
import java.util.*;

public class FileInfo {
	
	File object;
	String fileName;
	String absPath;
	int wc;
	
	public FileInfo(String fileName) {
		File myObj = new File(fileName);
		this.object = myObj;
		if (myObj.exists()) {
			this.absPath = myObj.getAbsolutePath();
			this.fileName = fileName;
		}	
	}
	
	public String getPath() {
		return this.absPath;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String[] getFileSentences(FileInfo inputFile) {
		String lines = "";
		try {
			Scanner s = new Scanner(new File(inputFile.getFileName()));
			while(s.hasNextLine()) {
				lines = lines + s.nextLine().replaceAll("[\\s]", "").toLowerCase();
			}
		} catch (FileNotFoundException e ) {
			System.err.println("FILE NOT FOUND");
			e.printStackTrace();
			System.exit(1);
		}
		
		//System.out.println(lines);
		String[] sentences = lines.split("\\.");
		return sentences;
		
	}
	
	public int maxStringLen(char []cmp , char[]ori, int cmpLen, int oriLen) { // m, n
		int matrix[][] = new int[cmpLen+1][oriLen+1]; 
		  
	    /* Following steps build L[m+1][n+1] in bottom up fashion. Note 
	         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
	    for (int i=0; i<=cmpLen; i++) 
	    { 
	      for (int j=0; j<=oriLen; j++) 
	      { 
	        if (i == 0 || j == 0) 
	            matrix[i][j] = 0; 
	        else if (cmp[i-1] == ori[j-1]) 
	            matrix[i][j] = matrix[i-1][j-1] + 1; 
	        else
	            matrix[i][j] = max(matrix[i-1][j], matrix[i][j-1]); 
	      } 
	    } 
	  return matrix[cmpLen][oriLen]; 
	}
	
	
	public int max(int a, int b) {
		return (a > b)? a : b;
	}
	
	
}

