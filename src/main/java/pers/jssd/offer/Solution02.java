package pers.jssd.offer;

/**
 * 计算两个二进制的加法
 */
public class Solution02 {

    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        String addition = addition(a, b);
        System.out.println("addition = " + addition);
    }

    /**
     * 计算两个二进制字符串的加法, 并且返回二进制和
     * @param a 加数
     * @param b 被加数
     * @return 返回的二进制和
     */
    private static String addition(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;
        int carry = 0;
        while (aLength >= 0 || bLength >= 0) {
            int aNumber = aLength >= 0 ? a.charAt(aLength --) - '0' : 0;
            int bNumber = bLength >= 0 ? b.charAt(bLength --) - '0' : 0;
            int sum = aNumber + bNumber + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >=2 ? sum - 2 : sum;
            sb.append(sum);
        }
        if(carry == 1){
            sb.append(1);
        }

        return  sb.reverse().toString();
    }

}
