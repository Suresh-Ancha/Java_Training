package tweetRGT;

import java.util.Scanner;

public class MainTweet {
	
	public static void main(String[] args) {
		
		Scanner scanner= new Scanner(System.in);
		
		RGTMessaging rgtMessage = new RGTMessaging();
		boolean logout = false;
		
		while(!logout) {
			System.out.println("Welcome to RGT messaging");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			System.out.print("Enter your choice : ");
			int choice=scanner.nextInt();
			
			switch (choice) {
			
			case 1: {
				rgtMessage.registerUser();
				break;
			}
			
			case 2:{
				rgtMessage.login();
				break;
			}
			default:
				System.out.println("Please enter valid details");
			}
			
			
		}
		
	}

}
