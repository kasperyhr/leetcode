class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        LinkedList<Integer> l = new LinkedList<Integer>();
        for(int i = deck.length - 1; i >= 0; i--){
            if(!l.isEmpty()){
                int j = l.removeLast();
                l.addFirst(j);
            }
            l.addFirst(deck[i]);
        }
        int[] ret = l.stream().parallel().mapToInt(Integer::intValue).toArray();
        return ret;
    }
}