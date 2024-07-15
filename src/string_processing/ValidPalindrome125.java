package string_processing;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        // 문자열 s는 대소문자를 구분하지 않음 -> 소문자 또는 대문자로 변경
        // 문자열 s는 영어 및 숫자로 이루어져 있음 -> 이를 제외한 나머지 제거
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // StringBuilder를 사용하여 문자열 s 뒤집기
        String reverseS = new StringBuilder(s).reverse().toString();

        return s.equals(reverseS);
    }
}
