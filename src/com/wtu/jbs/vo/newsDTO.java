package com.wtu.jbs.vo;

import java.sql.Date;

public class newsDTO {
 private int newsId;
 private String newsTitle;
 private String newsContent;
 private java.sql.Date newsTime;
public int getNewsId() {
	return newsId;
}
public void setNewsId(int newsId) {
	this.newsId = newsId;
}
public String getNewsTitle() {
	return newsTitle;
}
public void setNewsTitle(String newsTitle) {
	this.newsTitle = newsTitle;
}
public String getNewsContent() {
	return newsContent;
}
public void setNewsContent(String newsContent) {
	this.newsContent = newsContent;
}
public Date getNewsTime() {
	return newsTime;
}
public void setNewsTime(Date newsTime) {
	this.newsTime = newsTime;
}
 
}
