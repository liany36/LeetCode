# 2958
from typing import List


class Solution:

    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        ans = left = right = 0
        mydict = {}
        while left < nums.__len__():
            ans = max(ans, left - right)
            freq = mydict.get(nums[left], 0)
            if freq < k:
                mydict.update({nums[left]: freq + 1})
                left += 1
            else:
                right = self.ejectTillK(right, left, nums, mydict)
                mydict.update({nums[left]: freq - 1})
        ans = max(ans, left - right)
        return ans

    def ejectTillK(self, right: int, left: int, nums: List[int], mydict: dict) -> int:
        target = nums[left]
        flag = True
        while flag:
            curr = nums[right]
            currFreq = mydict.get(curr, 0)
            if currFreq == 1:
                mydict.pop(curr)
            else:
                mydict.update({curr: currFreq - 1})
            right += 1
            flag = target != curr
        return right

    print(maxSubarrayLength([1, 2, 3, 4, 5], 1))
