package tweetRGT;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String userName;
	private String password;
	private String name;
	private String bio;
	private Set<String> followings;
	private Set<String> followers;
	private Set<String> tweets;

	Tweet tweet;

	public User(String userName, String password, String name, String bio) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.bio = bio;
		this.followings = new HashSet<String>();
		this.followers = new HashSet<String>();
		this.tweets = new HashSet<String>();
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Set<String> getFollowings() {
		return followings;
	}

	public void setFollowings(Set<String> followings) {
		this.followings = followings;
	}

	public Set<String> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}

	public Set<String> getTweets() {
		return tweets;
	}

	public void setTweets(Set<String> tweets) {
		this.tweets = tweets;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public void follow(User user) {
		followers.add(user.getUserName());
		user.followers.add(userName);
		System.out.println("Followed successfully..!");
	}
	
	public void unfollow(User user) {
		followers.remove(user.getUserName());
		user.followers.remove(userName);
		System.out.println("Unfollowed successfully ...... !");
	}
	

}
