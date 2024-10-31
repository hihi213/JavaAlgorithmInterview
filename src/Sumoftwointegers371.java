import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sumoftwointegers371 {
    public static void main(String[] args) {
    Solution a= new Solution();
        System.out.println(a.getSum(3,5));
    }
}

class Solution {
    int getSum(int a, int b) {
        //1. 정수의 입력을 받아 이진수 문자열로 변환해 저장한다
        String x = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        String y = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
        int carry = 0;
        int sum;
        List<Character> result = new ArrayList<>();
        //2. 2~4번을 32번 반복한다
        for (int i = 0; i < 32; i++) {
            //3. 1차 sum과 캐리를 구한다
            int X = Character.getNumericValue(x.charAt(31 - i));
            int Y = Character.getNumericValue(y.charAt(31 - i));
            int c1 = X & Y;
            int s1 = X ^ Y;
            //4. 2차 sum과 캐리를 구한다

            sum = carry ^ s1;
            carry = (s1 & carry) | c1;

            //5. 2차 sum를 list에 add한다
            result.add(0, Character.forDigit(sum, 2));
        }
            //6. Character list를 문자열으로 변환하여 리턴한다
            //이거는 교재를 참고했다..
            return Integer.parseUnsignedInt(
                    result.stream().
                            map(String::valueOf)
                            .collect(Collectors.joining(""))
                    ,2);

    }

};