class Twitter {
    private Map<Integer, Set<Integer>> follower_followees ;
    private List<UserTweet> user_feeds;

    public Twitter() {
        follower_followees = new HashMap<>();
        user_feeds = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        user_feeds.add(new UserTweet(userId, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i = user_feeds.size() -1; i >=0 && ans.size() < 10; --i){
            UserTweet feed = user_feeds.get(i);
            Set<Integer> followees = follower_followees.get(userId);
            
            if(feed.userId == userId || followees != null && followees.contains(feed.userId))
                ans.add(feed.tweetId);            
        }
        
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = follower_followees.get(followerId);
        
        if(followees == null)
            followees = new HashSet<>();
        
        follower_followees.put(followerId, followees);
        
        followees.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = follower_followees.get(followerId);
        
        if(followees != null)
            followees.remove(followeeId);
    }
    
    class UserTweet{
        public int userId;
        public int tweetId;
        
        UserTweet(int u, int t){
            userId = u;
            tweetId = t;
        }
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