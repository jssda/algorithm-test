package pers.jssd.offer;

public class Solution1_1 {

    public static void main(String[] args) {
        int divide = divide(15, 2);
        System.out.println("divide = " + divide);
    }

    private static  int divide(int dividend, int divisor) {
        int res = 0;
        int count = 2;
        if (dividend > 0) {
            count -=1;
            dividend = -dividend;
        }

        if (divisor > 0) {
            count -=1;
            divisor = -divisor;
        }

        while (dividend <= divisor) {
           int value = divisor;
            int a = 1;
            // value 必须大于 int 的最小值的一半, 否则value+value就会溢出 0xc0000000就是int最小值的一半
            while (value >= 0xc0000000 && dividend <= (value + value)) {
                value = value + value;
                a = a+a;
            }
            dividend = dividend - value;
            res += a;
        }



        if (count == 1) {
            res = -res;
        }

        return res;
    }

}
