package src

import "math"

func bestHand(ranks []int, suits []byte) string {
	rankCount := make(map[int]int)
	suitCount := make(map[byte]int)
	for i := 0; i < len(ranks); i++ {
		rankCount[ranks[i]]++
	}
	for i := 0; i < len(suits); i++ {
		suitCount[suits[i]]++
	}
	if len(suitCount) == 1 {
		return "Flush"
	}
	maxRanks := 0
	for _, value := range rankCount {
		maxRanks = int(math.Max(float64(maxRanks), float64(value)))
	}
	if maxRanks >= 3 {
		return "Three of a Kind"
	} else if maxRanks == 2 {
		return "Pair"
	} else {
		return "High Card"
	}
}
