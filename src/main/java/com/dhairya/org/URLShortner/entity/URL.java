package com.dhairya.org.URLShortner.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class URL {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid")
	@Column(name="ID",unique = true,nullable = false)
	private String ID;
	
	@Column(name="Original_Url", unique = true,nullable = false)
	private String str;
	
	@Column(name="Shortened_Url",unique = true,nullable = false)
	private String small;
	
	@Column(name="Date_Generated")
	@CreationTimestamp
	private Date urlDate;
	
	@Column(name="Count")
	private long count;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Date getUrlDate() {
		return urlDate;
	}

	public void setUrlDate(Date urlDate) {
		this.urlDate = urlDate;
	}

	public String getSmall() {
		return small;
	}

	public void setSmall(String small) {
		this.small = small;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return "URL [ID=" + ID + ", str=" + str + ", small=" + small + ", urlDate=" + urlDate + ", count=" + count
				+ "]";
	}


	public URL(String iD, String str, String small, Date urlDate, long count) {
		super();
		ID = iD;
		this.str = str;
		this.small = small;
		this.urlDate = urlDate;
		this.count = count;
	}

	public URL() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
