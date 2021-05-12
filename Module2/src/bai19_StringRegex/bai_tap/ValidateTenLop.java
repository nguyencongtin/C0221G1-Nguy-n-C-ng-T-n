package bai19_StringRegex.bai_tap;

public class ValidateTenLop {
    public static void main(String[] args) {
        String string="^[CAP][0-9]{4}[GHIKLM]$";
        String check= "C0221G";
        System.out.println(check.matches(string));
    }
}
