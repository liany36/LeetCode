import java.util.HashMap;
import java.util.Hashtable;
// 2958

public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public static void main(String[] args) {
        System.out.println(maxSubarrayLength(new int[]{1,4,4,1,2,3}, 1));

    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int left = 0;
        int right = 0;
        int frequency = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right <= left && left < nums.length) {
            frequency = map.getOrDefault(nums[left], 0);
            ans = Math.max(ans, left - right);
            if (frequency < k) {
                map.put(nums[left], frequency + 1);
                left ++;
            } else {
                right = rejectTillK(right, left, nums, map);
                map.put(nums[left], frequency - 1);
            }
        }
        if (frequency < k) {
            ans = Math.max(ans, left - right);
        }
        return ans;
    }

    public static int rejectTillK(int right, int left, int[] nums, HashMap<Integer, Integer> map) {
        int target = nums[left];
        boolean flag = true;
        while (flag) {
            int curr = nums[right];
            int currFrequency = map.get(curr);
            if(currFrequency == 1) {
                map.remove(curr);
            } else {
                map.put(curr, currFrequency - 1);
            }
            right ++;
            flag = target != curr;
        }
        return right;
    }
}
