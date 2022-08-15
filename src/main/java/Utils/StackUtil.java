package Utils;

import Linkedlist.SingleLinkedList;

import java.util.Arrays;
import java.util.Stack;

public class StackUtil {
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
    public static SingleLinkedList reverse(SingleLinkedList list){
        Stack stack = new Stack<SingleLinkedList.Node>();
        SingleLinkedList.Node currNode = list.getHead();
        while (currNode != null){
            stack.push(currNode);
            currNode = currNode.getNext();
        }
        currNode = (SingleLinkedList.Node) stack.pop();
        list.setHead(currNode);
        while(!stack.empty()){
            currNode.setNext((SingleLinkedList.Node) stack.pop());
            currNode = currNode.getNext();
        }
        currNode.setNext(null);
        return list;
    }
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
    public static Boolean isOperator(Character c){
        Character[] arrOperator = {'+', '-', '*', '/'};
        for (Character i : arrOperator){
            if (i == c){
                return true;
            }
        }
        return false;
    }
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
