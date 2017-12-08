package com.mk.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comments")
public class Comment implements java.io.Serializable{

	private long commentId;
	private User user;
	@JsonIgnore
	private Course weibo;
	private String commentText;
	private Date commentDate;
	
	
	public Comment() {
	}

	public Comment(User user, Course weibo, String commentText, Date commentDate) {
		this.user = user;
		this.weibo = weibo;
		this.commentText = commentText;
		this.commentDate = commentDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "weibo_id")
	public Course getWeibo() {
		return weibo;
	}

	public void setWeibo(Course weibo) {
		this.weibo = weibo;
	}

	@Column(name = "comment_text")
	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Column(name = "comment_date")
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	@Override
	public String toString() {
		return "Comment{" + "commentId=" + commentId + ", user=" + user + ", weibo=" + weibo + ", commentText='"
				+ commentText + '\'' + ", commentDate=" + commentDate + '}';
	}
}