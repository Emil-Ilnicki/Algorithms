import java.io.*;
import java.util.*;

public class Plagiarism {
	
	FileInfo oriFile, cmpFile;
	String[] oriLines, cmpLines;
	char[] oriLineChar, cmpLineChar;
	int[] indexSim;
	String oriSen, cmpSen;
	int oriSenLen, cmpSenLen; 
	
	public Plagiarism(FileInfo cmpFile, FileInfo oriFile) {
		this.cmpFile = cmpFile;
		this.oriFile = oriFile;
	}
	
	public float similarity(){
		oriLines = oriFile.getFileSentences(oriFile);
		cmpLines = cmpFile.getFileSentences(cmpFile);
	
//		System.out.println(oriFile.fileName);
//		for (int i = 0; i < oriLines.length; i++) { 
//			System.out.println("Sentence " + (i+1) + ":" + oriLines[i]); 
//		}
//		
//		System.out.println(cmpFile.fileName);
//		for (int i = 0; i < cmpLines.length; i++) { 
//			System.out.println("Sentence " + (i+1) + ":" + cmpLines[i]); 
//		}
		
		int strSim, maxSim;
		int index = 0;
		float totalSim = 0;
		float charCount = 0;
		indexSim = new int[oriLines.length];
		
		for (int i = 0; i < cmpLines.length; i++) {
			maxSim = 0;
			cmpSen = cmpLines[i];
			cmpLineChar = cmpSen.toCharArray();
			charCount = charCount + cmpLineChar.length;
			for (int j = 0; j < oriLines.length; j++) {
				oriSen = oriLines[j];
				oriLineChar = oriSen.toCharArray();
				strSim = cmpFile.maxStringLen(cmpLineChar, oriLineChar, cmpLineChar.length, oriLineChar.length);
				if (strSim > maxSim) {
					index = j;
					maxSim = strSim;
				}
	//			System.out.println("i: " + i + ", j: " + j + ", strSim: " + strSim + ", maxSim: " + maxSim);
			}
	//		System.out.println("Max Similarity for sentence " + i + " is: " + maxSim + " and it occured on index: " + index);
			if (indexSim[index] < maxSim) {
				indexSim[index] = maxSim;
			}
		}
		
		for (int i = 0; i < indexSim.length; i++) {
			//System.out.println("Value at index " + i + " is: " + indexSim[i]);
			totalSim = totalSim + indexSim[i];
		}
		//System.out.println(totalSim);
		//System.out.println(charCount);
		float result = totalSim/charCount;
		if(result > 0.998) {
			result = (float) 1.0;
		}
		
		
		return result;
		
	}
	
	
}
