package org.jobs.mtt.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String description;

	private Date date;
	
	private Boolean isDone;
	
	@ManyToOne
	private User user;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Boolean getIsDone() {
		return isDone;
	}
	
	public void setIsDone(Boolean isDone) {
		this.isDone = isDone;
	}

	public Task() {
	}
	

	public Task(String name, String description, Date date, Boolean isDone, User user) {
		super();
		this.name = name;
		this.description = description;
		this.date = date;
		this.isDone = isDone;
		this.user = user;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date=");
		builder.append(date);
		builder.append(", isDone=");
		builder.append(isDone);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}



}
