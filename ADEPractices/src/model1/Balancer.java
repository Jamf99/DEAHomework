package model1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.NoSuchElementException;

import estructures.Stack;

public class Balancer {
	
	private static Stack<String> stack;

	private static boolean verifyOpuest(String c, String b) {
		if(c.equals("(") && b.equals(")")){
			return true;
		}
		if(c.equals("{") && b.equals("}")){
			return true;
		}
		if(c.equals("[") && b.equals("]")){
			return true;
		}
		return false;
	}
	
	public static boolean isBalanced(String string) throws NoSuchElementException {
		boolean balanced = false;
		stack = new Stack<String>();
		if(string == null) {
			return false;
		}else if(string == "") {
			return true;
		}
		String[] aux = string.split("");
		for(int i = 0; i<aux.length; i++) {
			if(aux[i].equals("(") || aux[i].equals("{") || aux[i].equals("[")) {
				stack.push(aux[i]);
			}else if(aux[i].equals(")") || aux[i].equals("}") || aux[i].equals("]")) {
				try {
					if(verifyOpuest(stack.getTop(), aux[i])) {
						stack.pop();
					}else {
						return false;
					}
				}catch(NoSuchElementException e) {
					return false;
				}
			}
		}
		if(stack.isEmpty()) {
			balanced = true;
		}
		return balanced;		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		File file = new File("docs/testCases.txt");
//		FileReader fr = new FileReader(file);
//		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long cases = Long.parseLong(in.readLine());
		for(int i = 0; i<cases; ++i) {
			String line = in.readLine();
			if(isBalanced(line)) {
				out.write("T\n");
			}else {
				out.write("F\n");
			}
		}
		
		in.close();
		out.close();
	}

}
