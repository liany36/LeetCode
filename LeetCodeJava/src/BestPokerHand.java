import java.util.HashMap;



class BestPokerHand {
    public static void main(String[] args) {
        int[] ranks = new int[5];
        ranks[0] = 4;
        ranks[1] = 4;
        ranks[2] = 2;
        ranks[3] = 4;
        ranks[4] = 4;
        char[] suits = new char[5];
        suits[0] = 'd';
        suits[1] = 'a';
        suits[2] = 'a';
        suits[3] = 'b';
        suits[4] = 'c';
        bestHand(ranks, suits);
        System.out.println( bestHand(ranks, suits));
    }

    public static String bestHand(int[] ranks, char[] suits) {
        HashMap<Integer, Integer> rankRecord = new HashMap<>();
        HashMap<Character, Integer> suitRecord = new HashMap<>();
        for (int rank : ranks) {
            rankRecord.put(rank, rankRecord.getOrDefault(rank, 1) + 1);
        }
        for (char suit : suits) {
            suitRecord.put(suit, suitRecord.getOrDefault(suit, 1) + 1);
        }
        if (suitRecord.size() == 5) {
            return "Flush";
        }
        int maxSameRank = 0;
        for (int rank : rankRecord.keySet()) {
            maxSameRank = Math.max(rankRecord.get(rank), maxSameRank);
        }
        if (maxSameRank >= 3) {
            return "Three of a Kind";
        } else if (maxSameRank == 2) {
            return "Pair";
        } else {
            return "High Card";
        }
    }
}