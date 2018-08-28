package model1;

import estructures.Stack;

public class Balancer {
	
	private static Stack<String> string;

	public Stack<String> getString() {
		return string;
	}
	
	public static String isBalanced(String string) {
		String balanced = "";
		boolean flag = false;
		if(string == null) {
			return "F";
		}else if(string == "") {
			return "T";
		}
		String[] aux = string.split("");
		for(int i = 0; i<aux.length; i++) {
			if(aux[i] == "(" || aux[i] == ")" || aux[i] == "{" || aux[i] == "}" || aux[i] == "[" || aux[i] == "]") {
				flag = true;
			}
		}
		return balanced;
				
	}
	
	public static void main(String[] args) {
		System.out.println(isBalanced("{[asasa]}"));
	}

}
