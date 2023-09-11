package pers.jssd.offer;

/**
 * 不使用除法获取两个int值整除之后最大商   eg:  15  2   得结果7
 */
public class Solution01 {

    private static class Main{

        public int divide(int dividend, int divisor){
            // 当除数是-2^31并且被除数是-1得时候  会溢出   因为int的取值范围是 -2^31~2^31-1
            if (dividend == 0x80000000 && divisor == -1) {
                return Integer.MAX_VALUE;
            }
            // 变更了几次 因为负数得范围比正数大, 所以把他们都转换为负数进行运算, 避免出现正数溢出得问题
            int negative = 2;
            if (dividend > 0) {
                negative -=1;
                dividend = -dividend;
            }

            if (divisor > 0) {
                negative -= 1;
                divisor = -divisor;
            }
            int result = divideCore(dividend, divisor);
            return negative == 1 ? -result : result;
        }

        private int divideCore(int dividend, int divisor) {
            int result = 0;
            while (dividend <= divisor) {
                int value = divisor;
                int quotient = 1;
                while (value >= 0xc0000000 && dividend <= value + value) {
                    quotient += quotient;
                    value += value;
                }
                result += quotient;
                dividend -= value;
            }
            return result;
        }


    }

    private static class test{

        public static void main(String[] args) {
            int [][] data = new int[][]{
                    {15, 2}
            };
            for (int[] datum : data) {
                int d0 = datum[0];
                int d1 = datum[1];
                int res = Math.floorDiv(d0, d1);
                System.out.println("res = " + res);

                int divide = new Main().divide(d0, d1);
                System.out.println("divide = " + divide);
            }
        }
    }

}
