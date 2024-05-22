package src

import (
	"strconv"
	"strings"
)

func compareVersion(version1 string, version2 string) int {
	revisions1 := strings.Split(version1, ".")
	revisions2 := strings.Split(version2, ".")
	ptr1, ptr2 := 0, 0
	for ptr1 < len(revisions1) || ptr2 < len(revisions2) {
		num1, num2 := 0, 0
		if ptr1 < len(revisions1) {
			num1, _ = strconv.Atoi(revisions1[ptr1])
		}
		if ptr2 < len(revisions2) {
			num2, _ = strconv.Atoi(revisions2[ptr2])
		}
		if num1 < num2 {
			return -1
		} else if num1 > num2 {
			return 1
		} else {
			ptr1++
			ptr2++
		}
	}
	return 0
}
