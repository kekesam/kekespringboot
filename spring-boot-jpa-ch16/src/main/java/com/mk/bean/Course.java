package com.mk.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "weibo")
public class Course implements java.io.Serializable{

	private long weiboId;
	private User user;
	private String weiboText;
	private Date createDate;
	private Set<Comment> comments;
	
	
	public Course() {
	}

	public Course(User user, String weiboText, Date createDate) {
		this.user = user;
		this.weiboText = weiboText;
		this.createDate = createDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getWeiboId() {
		return weiboId;
	}

	public void setWeiboId(long weiboId) {
		this.weiboId = weiboId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "weibo_text")
	public String getWeiboText() {
		return weiboText;
	}

	public void setWeiboText(String weiboText) {
		this.weiboText = weiboText;
	}

	@Column(name = "create_date")
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE }, mappedBy = "weibo")
	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Weibo{" + "weiboId=" + weiboId + ", user=" + user + ", weiboText='" + weiboText + '\'' + ", createDate="
				+ createDate + '}';
	}
}