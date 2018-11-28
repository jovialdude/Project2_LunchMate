package com.revature.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@NamedQueries({
	@NamedQuery(name="Posting.getByIdQuery", query="from Posting where id=:idVar")
})


@Component
@Entity
@Table(name = "POSTING_INFO")
public class Posting {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postingSequence")
	@SequenceGenerator(name = "postingSequence", allocationSize = 1, sequenceName = "SQ_POSTING_PK")
	@Column(name = "POSTING_ID")
	private int id;

	@Column(name = "POSTING_NAME")
	private String name;

	@Column(name = "POSTING_MEET_UP_TIME")
	private Date meetUpTime;

	@Column(name = "POSTING_DESCRIPTION")
	private String description;

	@Column(name = "POSTING_LIMIT")
	private Integer priceLimit;

	private String pref;
	
	//We need a column with an ID for the user who origionally posted this.

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "POSTING_USERS", joinColumns = { @JoinColumn(name = "POSTING_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "U_ID") })
	private List<User> users = new ArrayList<>();

	
	public Posting() {
		super();
	}

	public Posting(int id, String name, Date meetUpTime, String description, Integer priceLimit) {
		super();
		this.id = id;
		this.name = name;
		this.meetUpTime = meetUpTime;
		this.description = description;
		this.priceLimit = priceLimit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getMeetUpTime() {
		return meetUpTime;
	}

	public void setMeetUpTime(Date meetUpTime) {
		this.meetUpTime = meetUpTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriceLimit() {
		return priceLimit;
	}

	public void setPriceLimit(Integer priceLimit) {
		this.priceLimit = priceLimit;
	}

//	public List<Preference> getPref() {
//		return pref;
//	}
//
//	public void setPref(List<Preference> pref) {
//		this.pref = pref;
//	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((meetUpTime == null) ? 0 : meetUpTime.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pref == null) ? 0 : pref.hashCode());
		result = prime * result + ((priceLimit == null) ? 0 : priceLimit.hashCode());
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posting other = (Posting) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (meetUpTime == null) {
			if (other.meetUpTime != null)
				return false;
		} else if (!meetUpTime.equals(other.meetUpTime))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pref == null) {
			if (other.pref != null)
				return false;
		} else if (!pref.equals(other.pref))
			return false;
		if (priceLimit == null) {
			if (other.priceLimit != null)
				return false;
		} else if (!priceLimit.equals(other.priceLimit))
			return false;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Posting [id=" + id + ", name=" + name + ", meetUpTime=" + meetUpTime + ", description=" + description
				+ ", priceLimit=" + priceLimit + ", pref=" + pref + ", users=" + users + "]";
	}
	
}
