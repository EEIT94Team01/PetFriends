package petfriends.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AdoptPhotos")
public class AdoptPhotosBean implements Serializable{
	@Id
	@Column(name = "ApId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ApId;
	private int AId;
	private int PhotoList;
	private byte[] Photo;
	public int getApId() {
		return ApId;
	}
	public void setApId(int apId) {
		ApId = apId;
	}
	public int getAId() {
		return AId;
	}
	public void setAId(int aId) {
		AId = aId;
	}
	public int getPhotoList() {
		return PhotoList;
	}
	public void setPhotoList(int photoList) {
		PhotoList = photoList;
	}
	public byte[] getPhoto() {
		return Photo;
	}
	public void setPhoto(byte[] photo) {
		Photo = photo;
	}
}
