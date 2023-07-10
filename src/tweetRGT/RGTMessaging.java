package tweetRGT;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RGTMessaging {

	private Map<String, User> users;
	private List<Tweet> tweets;
	private User currentUser;

	public RGTMessaging() {
		super();
		this.users = new HashMap<String, User>();
		this.tweets = new ArrayList<Tweet>();
		this.currentUser = null;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	Scanner scanner = new Scanner(System.in);

	public void registerUser() {
		System.out.println("Enter user name");
		String userName = scanner.nextLine();
		if (users.containsKey(userName)) {
			System.out.println("User already existed");
			return;
		}
		System.out.println("Enter password");
		String password = scanner.nextLine();

		System.out.println("Enter name");
		String name = scanner.nextLine();

		System.out.println("Enter bio");
		String bio = scanner.nextLine();

		User user = new User(userName, password, name, bio);
		users.put(userName, user);

		System.out.println("User registered successfully!!!!");
	}

	public void login() {
		System.out.println("Please enter user name");
		String userName = scanner.nextLine();

		System.out.println("Please enter password");
		String password = scanner.nextLine();

		User user = users.get(userName);
		if (user != null && user.getPassword().equals(password)) {
			currentUser = user;
			System.out.println("Welcome RGT Tweet app " + user.getUserName());
			boolean logout = false;
			while (!logout) {
				System.out.println("1. Post a Tweet");
				System.out.println("2. Enter your timeline");
				System.out.println("3. Search for a user");
				System.out.println("4. Search for Tweets");
				System.out.println("5. View your profile");
				System.out.println("6. Logout");
				System.out.print("Enter your choice : ");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1: {
					postTweet();
					break;
				}

				case 2: {
					viewProfile(scanner);
				}

				case 3: {
					searchUser(scanner);
				}
				case 4: {
					searchTweet(scanner);
				}
				default:

				}
			}
		}
	}

	public void postTweet() {
		System.out.println("Enter tweet id : ");
		Integer id = scanner.nextInt();

		try {
		System.out.println("Enter tweet : ");
		String tweetContent = scanner.next();

		Tweet tweet = new Tweet(id, tweetContent, currentUser.getUserName(), LocalDateTime.now());
		tweets.add(tweet);
		System.out.println("Tweet added successfully........!");
		}
		  catch (InputMismatchException e) {
			  scanner.nextLine();
	         }
	}

	public void searchUser(Scanner scanner) {
		System.out.println("Enter user name to search :");
		String userName = scanner.next();
		if (users.containsKey(userName)) {
			User user = users.get(userName);
			System.out.println("User found");
			System.out.println("User name : " + user.getUserName());
			System.out.println("Name : " + user.getName());
			System.out.println("User bio : " + user.getBio());
		} else {
			System.out.println("User not found");
		}
	}

	public void searchTweet(Scanner scanner) {
		System.out.println("Enter tweetId : ");
		Integer tweetId = scanner.nextInt();
		for (Tweet tweet : tweets) {
			if (tweet.getId()==(tweetId)) {
				System.out.println("Tweet found");
				System.out.println("Tweet id : " + tweet.getId());
				System.out.println("Tweet content : " + tweet.getContent());
				System.out.println("Tweet author : " + tweet.getAuthor());
				System.out.println("Timestamp : " + tweet.getTimestamp());
			} else {
				System.out.println("Tweet not found");
			}

		}
	}

	public void viewProfile(Scanner scanner) {
		System.out.println("User profile");
		System.out.println("User name : " + currentUser.getUserName());
		System.out.println("User bio : " + currentUser.getBio());
		System.out.println("User following : " + currentUser.getFollowings().size());
		System.out.println("User followers : " + currentUser.getFollowers().size());
		System.out.println("User Tweets : " + currentUser.getTweets().size());

		boolean exit = false;
		while (!exit) {
			System.out.println("1. Follow user");
			System.out.println("2. Unfollow user");
			System.out.println("3. Exit");

			int choice = scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Enter the user name");
				String userName = scanner.next();
				User user = users.get(userName);
				if (user != null) {
					currentUser.follow(user);
				}
				break;
			}
			case 2: {
				System.out.println("Enter the user name");
				String userName = scanner.next();
				User user = users.get(userName);
				if (user != null) {
					currentUser.unfollow(user);
				}
				break;

			}
			case 3: {
				exit = true;
				System.out.println("Exit successfully");
			}
			default:
				System.out.println("Please provide valid details");
			}
		}

	}

}
