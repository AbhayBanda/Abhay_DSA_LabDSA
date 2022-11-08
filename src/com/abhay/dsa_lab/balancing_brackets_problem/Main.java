package com.abhay.dsa_lab.balancing_brackets_problem;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] bracketArray = scanner.next().trim().strip().toCharArray();
        Stack<Character> bracketStack = new Stack<>();
        boolean isBalanced = true;
        for(char bracket : bracketArray) {
            if(isOpenBracket(bracket)) {
                bracketStack.push(bracket);
            }
            else {
                if(bracketStack.isEmpty() || !isBalancedBracket(bracket, bracketStack.peek())) {
                    isBalanced = false;
                    break;
                }
                bracketStack.pop();
            }
        }

        if(!isBalanced || !bracketStack.isEmpty())
            System.out.println("The entered Strings do not contain Balanced Brackets");
        else
            System.out.println("The entered String has Balanced Brackets");
    }

    public static boolean isOpenBracket(char bracket) {
        switch (bracket) {
            case '{' : case '[' : case '(' :
                return true;
            default:
                return false;
        }
    }

    public static boolean isBalancedBracket(char closedBracket, char openBracked) {
        if(closedBracket == ']' && openBracked == '[')
            return true;
        else if (closedBracket == '}' && openBracked == '{')
            return true;
        else if (closedBracket == ')' && openBracked == '(')
            return true;
        return false;
    }
}
