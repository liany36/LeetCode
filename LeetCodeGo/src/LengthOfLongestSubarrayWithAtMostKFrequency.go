package src

func maxSubarrayLength(nums []int, k int) int {
	left, right := 0, 0
	ans := 0
	myMap := make(map[int]int)
	for right < len(nums) {
		curr := nums[right]
		freq := myMap[curr]
		if freq < k {
			ans = max(ans, right-left)
			myMap[curr] = freq + 1
			right++
		} else {
			left = ejectTillK(left, right, nums, myMap)
		}
	}
	ans = max(ans, right-left)
	return ans
}

func ejectTillK(left int, right int, nums []int, myMap map[int]int) int {
	target := nums[right]
	flag := true
	for flag {
		curr := nums[left]
		currFreq := myMap[curr]
		if currFreq > 1 {
			myMap[curr] = currFreq - 1
		} else {
			delete(myMap, curr)
		}
		flag = curr != target
		left++
	}
	return left
}

func main() {
	input := []int{1, 2, 3, 4, 5}
	ans := maxSubarrayLength(input, 1)
	print(ans)
}
