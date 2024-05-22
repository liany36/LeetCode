from typing import List


def countSubarrays(nums: List[int], k: int) -> int:
    myMax = 0
    ans = 0
    for num in nums:
        myMax = max(num, myMax)
    left_ptr = 0
    while nums[left_ptr] != myMax:
        left_ptr += 1
    right_ptr = left_ptr
    temp = 1
    limit = nums.__len__()
    while temp < k and right_ptr < limit:
        right_ptr += 1
        if right_ptr < limit and nums[right_ptr] == myMax:
            temp += 1
    temp = -1
    while right_ptr < limit:
        left_offset = left_ptr - temp
        right_offset = limit - right_ptr
        ans += left_offset * right_offset
        temp = left_ptr
        left_ptr = find_next_ptr(myMax, left_ptr, nums, limit)
        right_ptr = find_next_ptr(myMax, right_ptr, nums, limit)
    return ans


def find_next_ptr(my_max, ptr, nums, limit):
    ptr += 1
    while ptr < limit and nums[ptr] != my_max:
        ptr += 1
    return ptr


if __name__ == '__main__':
    print(countSubarrays([1,3,2,3,3], 2))
