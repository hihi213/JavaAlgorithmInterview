import java.util.HashMap;
import java.util.Map;

public class TwoSome1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map= new HashMap<>();
        if(nums.length==2){
            return new int[]{0,1};
        }

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])&& map.get(target-nums[i])!=i){
                return new int []{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
return null;
    }
}

