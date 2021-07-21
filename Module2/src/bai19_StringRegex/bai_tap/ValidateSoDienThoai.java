package bai19_StringRegex.bai_tap;

public class ValidateSoDienThoai {
    public static void main(String[] args) {
      String regexNumber = "^[\\(][0-9]{2}[\\)][\\-][\\(][0][0-9]{9}[\\)]$";
      String check= "(84)-(0978489648)";
        System.out.println(check.matches(regexNumber));
    }
}
