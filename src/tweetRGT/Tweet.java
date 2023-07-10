package tweetRGT;

import java.time.LocalDateTime;

public class Tweet {
	
	private Integer id;
	private String content;
	private String author;
	private LocalDateTime timestamp;
	
	public Tweet(int id, String content, String author, LocalDateTime timestamp) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

}
