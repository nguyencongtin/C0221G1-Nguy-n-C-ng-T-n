package bai11_StackQueue.bai_tap.kiemTraDauNgoacTrongBieuThucSuDungStack;

import java.util.Scanner;
import java.util.Stack;

public class isParenthesisMatch {
//    public static boolean isParenthesisMatch(String str) {
//        if (str.charAt(0) == '{')
//            return false;
//
//        Stack<Character> stack = new Stack<Character>();
//
//        char c;
//        for(int i=0; i < str.length(); i++) {
//            c = str.charAt(i);
//
//            if(c == '(')
//                stack.push(c);
//            else if(c == '{')
//                stack.push(c);
//            else if(c == ')')
//                if(stack.empty())
//                    return false;
//                else if(stack.peek() == '(')
//                    stack.pop();
//                else
//                    return false;
//            else if(c == '}')
//                if(stack.empty())
//                    return false;
//                else if(stack.peek() == '{')
//                    stack.pop();
//                else
//                    return false;
//        }
//        return stack.empty();
//    }
    public static boolean isParenthesisMatch(String str) {
        if (str.charAt(0) == '{' || str.charAt(0) == '['|| str.charAt(0) == '}'||str.charAt(0) ==']') {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char c;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String input;
        Scanner scanner= new Scanner(System.in);
        System.out.println("Nhập biểu thức cần kiểm tra: ");
        input= scanner.nextLine();
        System.out.println("Biểu thức vừa nhập vào là : "+isParenthesisMatch(input));
    }
}
