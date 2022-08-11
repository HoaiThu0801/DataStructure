package Utils;

import Linkedlist.SingleLinkedList;

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
}
