# Number 165
class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        revisions1 = version1.split('.')
        revisions2 = version2.split('.')
        ptr1, ptr2 = 0, 0
        while ptr1 < revisions1.__len__() or ptr2 < revisions2.__len__():
            num1, num2 = 0, 0
            if ptr1 < revisions1.__len__():
                num1 = int(revisions1[ptr1])
            if ptr2 < revisions2.__len__():
                num2 = int(revisions2[ptr2])
            if num1 < num2:
                return -1
            elif num1 > num2:
                return 1
            else:
                ptr1 += 1
                ptr2 += 1
        return 0
