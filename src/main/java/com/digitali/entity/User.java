package com.digitali.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "USER")
public class User implements Serializable {

	private static final long serialVersionUID = 6371626273760590554L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private long userId;
	private String fullName;
	@Column(unique = true, nullable = false)
	private String username;
	private String password;
	@Transient
	private String rePassword;
	private long age;
	@Column(unique = true, nullable = false)
	private String email;
	private String phoneNo;
	private String gender;
	private String[] newsletterFrequency;
	private String profession;
	private Date createdDate;
	@Version
	private long version;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "createdUser", fetch = FetchType.EAGER)
	private Set<Photo> photoes = new HashSet<Photo>();

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String[] getNewsletterFrequency() {
		return newsletterFrequency;
	}

	public void setNewsletterFrequency(String[] newsletterFrequency) {
		this.newsletterFrequency = newsletterFrequency;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	protected long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Set<Photo> getPhotoes() {
		return photoes;
	}

	public void setPhotoes(Set<Photo> photoes) {
		this.photoes = photoes;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		if (this != null) {
			sb.append("user Name : " + this.getUsername());
			sb.append("\tpassword : " + this.getPassword());
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
