package com.tanmoy.brainstation.domain;

import java.util.Calendar;
import java.util.Date;

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
	private int userId;
	private int locationId;
	private boolean isPublic;
	private String statusBody;
	private Date createdDate;
	
	public Status() {
		super();
	}

	public Status(int userId, int locationId, boolean isPublic, String statusBody) {
		super();
		this.userId = userId;
		this.locationId = locationId;
		this.isPublic = isPublic;
		this.statusBody = statusBody;
		this.createdDate = Calendar.getInstance().getTime();
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public boolean isPublic() {
		return isPublic;
	}

	public void setPublic(boolean isPublic) {
		this.isPublic = isPublic;
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
		return "Status [statusId=" + statusId + ", userId=" + userId + ", locationId=" + locationId + ", isPublic="
				+ isPublic + ", statusBody=" + statusBody + ", createdDate=" + createdDate + "]";
	}

}
