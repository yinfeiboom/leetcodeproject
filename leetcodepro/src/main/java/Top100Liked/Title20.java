package Top100Liked;

import java.util.Stack;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:
Input: "()"
Output: true
Example 2:
Input: "()[]{}"
Output: true
Example 3:
Input: "(]"
Output: false
Example 4:
Input: "([)]"
Output: false
Example 5:
Input: "{[]}"
Output: true
 */
public class Title20 {

    public static void main(String[] args){
        Title20 t20=new Title20();
      boolean f=  t20.isValid("{[}");
      System.out.print(f);
    }
    public boolean isequal(char a,char b){
        if(a=='('&& b==')') return true;
        else if(a=='{'&& b=='}') return true;
        else if(a=='['&& b==']') return true;
        else return false;
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[]temp=s.toCharArray();
        for (int i = 0; i <temp.length ; i++) {
            if (stack.isEmpty()) stack.push(temp[i]);
            else {
                if (isequal(stack.peek(),temp[i])) stack.pop();
                else stack.push(temp[i]);

            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }
}
