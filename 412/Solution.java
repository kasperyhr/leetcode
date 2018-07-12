class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new LinkedList();
        for(int i = 1; i <= n; i++){
            if(i % 15 == 0)
                ret.add("FizzBuzz");
            else if(i % 3 == 0)
                ret.add("Fizz");
            else if(i % 5 == 0)
                ret.add("Buzz");
            else
                ret.add("" + i);
        }
        return ret;
    }
}