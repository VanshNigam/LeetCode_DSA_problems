import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Sort the hand to process the smallest card first
        Arrays.sort(hand);
        
        // Use a map to store the frequency of each card
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int card : hand) {
            freqMap.put(card, freqMap.getOrDefault(card, 0) + 1);
        }

        // Try to form straight hands
        for (int card : hand) {
            if (freqMap.get(card) == 0) { // Skip if this card has already been used
                continue;
            }

            // Try to form a sequence starting with `card`
            for (int i = 0; i < groupSize; i++) {
                int currentCard = card + i;
                if (freqMap.getOrDefault(currentCard, 0) == 0) {
                    return false; // Not enough cards to form a straight
                }
                freqMap.put(currentCard, freqMap.get(currentCard) - 1);
            }
        }

        return true;
    }
}
