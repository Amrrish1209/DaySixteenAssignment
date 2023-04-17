package com.bridgelabz.datastructure;

import java.util.Stack;

public class BalancedParantheses {
	public static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.isEmpty()) {
					return false;
				} else {
					stack.pop();
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String expression = "(5+6)*(7+8)/(4+3)(5+6)*(7+8)/(4+3)";
		if (isBalanced(expression)) {
			System.out.println("The arithmetic expression is balanced.");
		} else {
			System.out.println("The arithmetic expression is not balanced.");
		}
	}
}
