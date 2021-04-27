package bai11.bai_tap.kiemTraChuoiPalindromeSuDungQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindromes {
//    public static void main(String[] args) {
////        String word = "12321";
////        char[] warray = word.toCharArray();
////        System.out.println(isPalindrome(new String(warray)));
////    }
////
////    private static boolean isPalindrome(String s) {
////        int length = s.length();
////        if (length < 2) return true;
////        else return s.charAt(0) != s.charAt(length - 1) ? false :
////                isPalindrome(s.substring(1, length - 1));
////    }
public static void main(String[] args) {
    Stack<Character>stack=new Stack<>();
    Queue<Character>queue=new LinkedList<>();
    String string= "123321";
    for(int i=0;i<string.length();i++){
        stack.push(string.charAt(i));
        queue.add(string.charAt(i));
    }for(int i=0;i<string.length();i++){
        if(stack.pop()!=queue.remove()){
            System.out.println("Chuỗi không đối xứng");
            return;
        }
    }
    System.out.println("Chuỗi đối xứng");

}
}
