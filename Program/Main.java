import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println(args[0]);
		System.out.println(args[1]);
		
		FileInfo cmpFile = new FileInfo(args[0]);
		FileInfo oriFile = new FileInfo(args[1]);
		
		Plagiarism check = new Plagiarism(cmpFile, oriFile);
		float similarity = check.similarity();
		System.out.println(similarity);

	}
}
