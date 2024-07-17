package string_processing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderDataInLogFiles937 {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"};

        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }

    public static String[] reorderLogFiles(String[] logs) {
        // 문자 로그를 저장할 문자 리스트
        List<String> wordsList = new ArrayList<>();
        // 숫자 로그를 저장할 숫자 리스트
        List<String> numbersList = new ArrayList<>();

        // 배열(logs) 안의 문자열(log)이 문자 로그인지 숫자 로그인지 확인
        for (String log : logs) {
            // 문자열(log)을 공백을 기준으로 쪼개고
            // 그 중 1번 인덱스에 위치한 값이 문자이면 문자 리스트
            if (log.split(" ")[1].matches("[a-zA-Z]+")) {
                wordsList.add(log);
            } else {    // 숫자이면 숫자 리스트에 할당
                numbersList.add(log);
            }
        }

        // 문자 리스트 정렬
        wordsList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 문자 로그에서 식별자를 제외한 문자열 값
                String o1Words = o1.substring(o1.indexOf(" ")+1);
                String o2Words = o2.substring(o2.indexOf(" ")+1);

                // 비교하는 문자열 값이 같은 경우
                if (o1Words.equals(o2Words)) {
                    // 식별자를 기준으로 정렬 -> 문자 로그 자체를 비교
                    return o1.compareTo(o2);
                } else {    // 다른 경우
                    // 문자열 값을 기준으로 정렬
                    return o1Words.compareTo(o2Words);
                }
            }
        });

        // 문자 리스트 뒤에 숫자 리스트를 추가하여 하나로 합치기
        wordsList.addAll(numbersList);

        return wordsList.toArray(new String[0]);
    }
}
