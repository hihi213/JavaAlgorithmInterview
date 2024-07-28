import java.util.*;

/*
알게된것
1. asList()는 주어진 배열이나 객체들을 리스트로 변환하는 메서드입니다.
2. 배열을 정렬하는법 배열.sort
3.   List<List<Integer>> results = new ArrayList<>();
제네릭 타입을 사용할 때, 내부의 타입을 명시하지 않아도 컴파일러가 이를 추론합니다.
따라서 new ArrayList<>()는 new ArrayList<List<Integer>>()와 동일한 결과를 낳습니다.
*/
//궁금해졌다.
public class _3Sum15 {
    public static void main(String[] args) {
        _3Sum15 t=new _3Sum15();
        t.threeSum(new int[]{3,0,-2,-1,1,2});
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int left = 0, right = 0, zero = 0, minus = 0, nownum = 0,last=0;
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> repeat = new ArrayList<>();
        List<Integer> number = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nownum = nums[i];
            if (nownum < 0) {
                ++minus;
            }
            if (number.contains(nownum)) {
                if (nownum == 0) {
                    ++zero;
                } else {
                    if (!repeat.contains(nownum)) {
                        repeat.add(nownum);
                    }
                }
            }
            else {
                number.add(nownum);
            }
        }
        if (zero > 1) {
            //[0,0,0]추가
            results.add(Arrays.asList(0, 0, 0));
        }
        if (minus == 0) {
            return results;
        }
        if (!repeat.isEmpty()) {
            for (int i = 0; i < repeat.size(); i++) {
                if(number.contains(repeat.get(i)*(-2))){
                    if (repeat.get(i)<0){
                        results.add(Arrays.asList(repeat.get(i),repeat.get(i),(repeat.get(i)*(-2)))
                        );}
                    else{  results.add(Arrays.asList((repeat.get(i)*(-2)),repeat.get(i),repeat.get(i))
                    );}
                }

            }
        }
        Collections.sort(number);
        left=number.get(0);
        number.remove(0);
        right=1;
        while (true) {
            if (number.size()<2) {
                break;
            }
            last=-left-number.get(right);
            if (number.contains(last)&&number.get(right)!=last&&left!=last) {

                //저장
                results.add(Arrays.asList(left, number.get(right), (-left -number.get(right))
                ));
                //System.out.println(number+"[지운후]"+left+" "+ number.get(right)+" "+last);
            }
            right++;

            if (right == number.size()) {
                left=number.get(0);
                number.remove(0);
                right = 1;
            }
            if (1== number.size()) {
                // System.out.println(results);
                break;
            }
        }
        return results;
    }
}