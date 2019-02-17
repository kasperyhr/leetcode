class Twitter {
    public static int timeStamp;
    Map<Integer, User> users;
    class Tweet implements Comparable<Tweet>{
        int t_id;
        int u_id;
        int time;
        public Tweet(int userId, int tweetId){
            t_id = tweetId;
            u_id = userId;
            time = timeStamp++;
        }
        
        public int compareTo(Tweet t){
            return t.time - time;
        }
    }
    
    class User{
        int u_id;
        Set<User> f_ids;
        Set<Tweet> ts;
        public User(int userId){
            u_id = userId;
            f_ids = new HashSet<User>();
            ts = new  HashSet<Tweet>();
        }
        
        public void follow(User u){
            f_ids.add(u);
        }
        
        public void unfollow(User u){
            f_ids.remove(u);
        }
        
        public void post(int t_id){
            Tweet t = new Tweet(u_id, t_id);
            ts.add(t);
        }
    }
    
    /** Initialize your data structure here. */
    public Twitter() {
        timeStamp = 0;
        users = new HashMap<Integer, User>();
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User u = getUser(userId);
        u.post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>();
        User u = getUser(userId);
        q.addAll(u.ts);
        for(User uu: u.f_ids) if(uu != u) q.addAll(uu.ts);
        List<Integer> ret = new ArrayList<Integer>();
        while(ret.size() < 10 && !q.isEmpty()){
            ret.add(q.poll().t_id);
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        getUser(followerId).follow(getUser(followeeId));
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        getUser(followerId).unfollow(getUser(followeeId));
    }
    
    public User getUser(int userId){
        if(!users.containsKey(userId)) users.put(userId, new User(userId));
        return users.get(userId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
