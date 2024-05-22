public class CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1,3,2,3,3}, 1));
    }
    public static long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left_ptr = 0;
        long ans = 0;
        int limit = nums.length;
        while (nums[left_ptr] != max) {
            left_ptr ++;
        }
        int temp = 1;
        int right_ptr = left_ptr;
        while(temp < k && right_ptr < limit) {
            right_ptr++;
            if (right_ptr < limit && nums[right_ptr] == max) {
                temp++;
            }
        }
        if (right_ptr >= limit) {
            return 0;
        }
        temp = -1;
        int left_offset, right_offset;
        while (right_ptr < limit) {
            left_offset = left_ptr - temp;
            right_offset = limit - right_ptr;
            ans += (long) left_offset * right_offset;
            temp = left_ptr;
            left_ptr = find_next_index(nums, max, left_ptr, limit);
            right_ptr = find_next_index(nums, max, right_ptr, limit);
        }
        return ans;
    }

    public static int find_next_index(int[] nums, int max, int index, int limit) {
        index++;
        while (index < limit && nums[index] != max) {
            index++;
        }
        return index;
    }
}
