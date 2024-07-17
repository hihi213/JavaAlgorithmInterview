package string_processing;

import java.util.Arrays;

public class ReverseString344 {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;

        // 배열의 끝과 끝이 서로 중앙을 향해 이동해 가면서 값을 바꿈
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }

        System.out.println(Arrays.toString(s));
    }
}
