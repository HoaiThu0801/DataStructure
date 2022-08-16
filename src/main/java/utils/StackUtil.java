package utils;

import linkedlist.Node;
import linkedlist.SingleLinkedList;

import java.util.Stack;

public class StackUtil {
    /**
     * This method is used to reverse the string.
     * @param s This is the input string parameter
     * @return String This returns the reversed string.
     */
    public static String reverse(String s){
        Stack stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i ++){
            stack.push(chars[i]);
        }
        for (int i = 0; !stack.empty(); i ++){
            chars[i] = (char) stack.pop();
        }
        return String.valueOf(chars);
    }
    /**
     * This method is used to reverse the single linked list.
     * @param list This is the input string parameter
     * @return SingleLinkedList This returns the reversed single linked list.
     */
    public static SingleLinkedList reverse(SingleLinkedList list){
        Stack stack = new Stack<Node>();
        Node currNode = list.getHead();
        while (currNode != null){
            stack.push(currNode);
            currNode = currNode.getNext();
        }
        currNode = (Node) stack.pop();
        list.setHead(currNode);
        while(!stack.empty()){
            currNode.setNext((Node) stack.pop());
            currNode = currNode.getNext();
        }
        currNode.setNext(null);
        return list;
    }
    /**
     * This method is used to check whether balanced parentheses.
     * @param s This is the input string parameter
     * @return boolean This returns true/false if balanced parentheses or not.
     */
    public static boolean checkBalancedParentheses(String s){
        Stack stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i ++){
            if (s.isEmpty()){
                return false;
            }
            if (chars[i] == '{' || chars[i] == '(' || chars[i] == '[' ){
                stack.push(chars[i]);
            }
            else {
                if (chars[i] == ']' || chars[i] == ')' || chars[i] == '}'){
                    char temp = (char)stack.pop();
                    if (temp == '(' && chars[i] != ')'){
                        return false;
                    }
                    if (temp == '{' && chars[i] != '}'){
                        return false;
                    }
                    if (temp == '[' && chars[i] != ']'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    /**
     * This method is used to convert infix to postfix expression.
     * @param s This is infix expression parameter
     * @return String This returns the postfix expression.
     */
    public static String infixToPostfix(String s){
        Stack stack = new Stack<Character>();
        String res = "";
        Character temp = null;
        for (int i = 0; i < s.length(); i ++){
            temp = s.charAt(i);
            if (temp == '('){
                stack.push(temp);
            } else if (temp == ')') {
                while(!stack.empty() && (Character)stack.peek() != '(' ){
                    res += stack.pop();
                }
                stack.pop();
            }else if (isOperator(s.charAt(i))) {
                while(!stack.empty() && hasHigherPrec((Character) stack.peek(), temp)){
                    res += stack.pop();
                }
                stack.push(temp);
            }
            else {
                res += temp;
            }
        }
        while(!stack.empty()){
            res += stack.pop();
        }
        return res;
    }
    /**
     * This method is used to check whether character is operator.
     * @param c This is character input parameter
     * @return Boolean This returns true/false if character is operator or not.
     */
    public static Boolean isOperator(Character c){
        Character[] arrOperator = {'+', '-', '*', '/'};
        for (Character i : arrOperator){
            if (i == c){
                return true;
            }
        }
        return false;
    }
    /**
     * This method is used to compare operator 1 to operator 2.
     * @param operatorStack This is 1st operator parameter
     * @param operatorStr This is 2nd operator parameter
     * @return Boolean This returns true/false if operator 1 is greater than operator 2 or not.
     */
    public static Boolean hasHigherPrec(Character operatorStack, Character operatorStr){
        Character[] arrOperator = {'+', '-', '*', '/'};
        int indexOfOSt = -1;
        int indexOfOStr = -1;
        for (int i = 0; i < arrOperator.length; i++){
            if (arrOperator[i] == operatorStack){
                indexOfOSt = i;
            }
            if (arrOperator[i] == operatorStr){
                indexOfOStr = i;
            }
        }
        if (indexOfOStr == -1 || indexOfOSt == -1){
            return false;
        }
        if (indexOfOSt > indexOfOStr){
            return true;
        }else {
            return false;
        }
    }
}
