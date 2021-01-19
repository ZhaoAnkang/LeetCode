package question.easy;

import java.util.HashMap;
import java.util.Map;


/**
 * 两数之和，哈希表经典应用
 * @author ZhaoAnkang
 */
public class TwoSum {
    public int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
