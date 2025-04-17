class Tweet implements Comparable<Tweet> {
    int time;
    int tweetId;

    Tweet(int t, int id) {
        time = t;
        tweetId = id;
    }

    public int compareTo(Tweet that) {
        return that.time - this.time;
    }
}

class User {
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId) {
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t) {
        tweets.add(0, t); //insertion at the head
    }

    public void addFollower(int followeeId) {
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId) {
        followers.remove(followeeId);
    }
}

class Twitter {
    HashMap<Integer, User> userMap;
    int timeCounter;

    public Twitter() {
        userMap = new HashMap<>(); // Corrected to HashMap
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId) {
        timeCounter++;
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> lst = new ArrayList<>();
        if (!userMap.containsKey(userId)) {
            return lst; 
        }

        PriorityQueue<Tweet> pq = new PriorityQueue<>(); // Corrected to PriorityQueue<Tweet>
        User user = userMap.get(userId);

        for (int followId : user.followers) {
            int count = 0;
            for (Tweet tweet : userMap.get(followId).tweets) {
                pq.offer(tweet);
                count++;
                if (count >= 10) break; // Limit to 10 tweets per follower
            }
        }

        // Add tweets from the user's own feed
        int count = 0;
        for (Tweet tweet : user.tweets) {
            pq.offer(tweet);
            count++;
            if (count >= 10) break; // Limit to 10 tweets
        }

        // Collect the top 10 tweets from the priority queue
        int i = 0;
        while (!pq.isEmpty() && i < 10) {
            Tweet tweet = pq.poll();
            lst.add(tweet.tweetId);
            i++;
        }
        return lst;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId)); 
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId)); 
        }
        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)) {
            return; 
        }
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}
