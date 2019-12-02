package question.no20;

import java.util.Stack;

/**
 * 用栈即可
 * @author 赵安康
 *
 */
public class Solution {
	public static boolean isValid(String s) {
		if(s.equals("")) {
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		char[] ch = s.toCharArray();
		for(int i = 0;i<ch.length;i++) {
			if(ch[i] == '(' || ch[i] == '[' || ch[i] == '{') {
				stack.add(ch[i]);
				continue;
			}
			char temp;
			switch(ch[i]) {
			case ')':if(stack.empty()) return false;temp = stack.pop();if(temp != '(') return false;break;
			case ']':if(stack.empty()) return false;temp = stack.pop();if(temp != '[') return false;break;
			case '}':if(stack.empty()) return false;temp = stack.pop();if(temp != '{') return false;break;
			}
		}
		if(!stack.empty()) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String test = "()";
		System.out.println(isValid(test));
	}
}
