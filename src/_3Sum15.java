import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int left, right, sum;
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
// 합이 0보다 작다면 왼쪽 포인터 이동
                if (sum < 0)
                    left += 1;

                else if (sum > 0)
                    right -= 1;
                else {
// 합이 0인 경우이므로 정답 처리
                    results.add(Arrays.asList(nums[i], nums[left], nums[right]));
// 중복된 값 건너뛰기
                    while (left < right && nums[left] == nums[left + 1])
                        left += 1;
                    while (left < right && nums[right] == nums[right - 1])
                        right -= 1;
// 정답이 나왔으므로 투 포인터 모두 한 칸씩 이동
                    left += 1;
                    right -= 1;
                }
            }}return results;}}