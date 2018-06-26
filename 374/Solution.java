/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        int medium = (low + high) / 2;
        if(medium < 0)
            medium = low / 2 + high / 2;
        int g = guess(medium);
        while(g != 0){
            // System.out.println(medium);
            if(g == 1){
                low = medium + 1;
            } else {
                high = medium - 1;
            }
            if(low == high)
                return low;
            medium = (low + high) / 2;
            if(medium < 0)
                medium = low / 2 + high / 2;
            g = guess(medium);
        }
        return medium;
    }
}