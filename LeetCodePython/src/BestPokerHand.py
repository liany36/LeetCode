class Solution:
    def bestHand(self, ranks: List[int], suits: List[str]) -> str:
        suitRecord = {}
        rankRecord = {}
        for rank in ranks:
            count = rankRecord.setdefault(rank, 0)
            rankRecord.update({rank: count + 1})
        for suit in suits:
            count = suitRecord.setdefault(suit, 0)
            suitRecord.update({suit: count + 1})
        if suitRecord.__len__() == 1:
            return "Flush"
        max_count = 0
        for key, val in rankRecord.items():
            max_count = max(max_count, val)
        if max_count >= 3:
            return "Three of a Kind"
        elif max_count == 2:
            return "Pair"
        else:
            return "High Card"

