class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> s = new HashSet<Integer>();
        for(int c: candies)
            s.add(c);
        return Math.min(s.size(), candies.length / 2);
    }
}