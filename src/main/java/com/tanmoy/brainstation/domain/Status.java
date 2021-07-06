package com.tanmoy.brainstation.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
	@Column(nullable = false)
	private String userId;
	private int locationId;
	@Column(nullable = false)
	private int visibility;
	@Column(nullable = false)
	private String statusBody;
	private Date createdDate;
	
	public Status() {
		super();
	}

	public Status(String userId, int locationId, int visibility, String statusBody) {
		super();
		this.userId = userId;
		this.locationId = locationId;
		this.visibility = visibility;
		this.statusBody = statusBody;
		this.createdDate = Calendar.getInstance().getTime();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public String getStatusBody() {
		return statusBody;
	}

	public void setStatusBody(String statusBody) {
		this.statusBody = statusBody;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", userId=" + userId + ", locationId=" + locationId + ", visibility="
				+ visibility + ", statusBody=" + statusBody + ", createdDate=" + createdDate + "]";
	}

}
