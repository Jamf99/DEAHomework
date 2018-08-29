package model1;

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
	
	public static String isBalanced(String string) throws NoSuchElementException {
		stack = new Stack<String>();
		String balanced = "F";
		if(string == null) {
			return "F";
		}else if(string == "") {
			return "T";
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
						return "F";
					}
				}catch(NoSuchElementException e) {
					return "F";
				}
			}
		}
		if(stack.isEmpty()) {
			balanced = "T";
		}
		return balanced;		
	}
	
	public static void main(String[] args) {
		System.out.println(isBalanced("hola]}"));
	}

}
