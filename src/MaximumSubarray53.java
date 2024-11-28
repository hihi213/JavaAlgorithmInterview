import java.util.*;

public class MaximumSubarray53 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        //첫번째값을 초기값으로
        List<Integer> sums= new ArrayList<>(List.of(nums[0]));
        int max= sums.get(0);
        for (int i=1; i<nums.length; i++) {
            //이떄 num은 인덱스값이 아닌 요소값
                sums.add(i,sums.get(i-1)+nums[i]);
                if (max<sums.get(i)){
                    max=sums.get(i);
                }
        }
            return max;
    }
}