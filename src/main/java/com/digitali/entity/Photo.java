package com.digitali.entity;

import java.awt.image.BufferedImage;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "PHOTO")
public class Photo {
	@Id
	@GeneratedValue
	@Column(name = "PHOTO_ID")
	private long photoId;
	private String name;
	private String caption;
	private String description;
	private String category;
	private String imgLocation;	// Server location
	private String imgName;
	@Transient
	private BufferedImage bufferedFile;
	private byte[] imgThumbInByte;
	@Version
	private long version;
	private Date createdDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private User createdUser;

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public BufferedImage getBufferedFile() {
		return bufferedFile;
	}

	public void setBufferedFile(BufferedImage bufferedFile) {
		this.bufferedFile = bufferedFile;
	}

	public byte[] getImgThumbInByte() {
		return imgThumbInByte;
	}

	public void setImgThumbInByte(byte[] imgThumbInByte) {
		this.imgThumbInByte = imgThumbInByte;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

}
