package petfriends.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Adopt")
public class AdoptBean {
	@Id
	@Column(name = "AId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AId;
	
	private int PetForm;
	
	@NotEmpty
	@Pattern(regexp="^[\u4e00-\u9fa5a-zA-Z]+$")
	private String UserName;
	
	@NotEmpty
	@Pattern(regexp="^09\\d{2}-?\\d{3}-?\\d{3}$")
	private String UserPhone;
	
	@Email
	private String UserEmail;
	
	private String PetName;
	
	@NotEmpty
	private String PetType;
	
	private String PetBreeds;
	
	@NotEmpty
	private String PetFeature;
	
	@NotNull
	private String FindCity;
	
	private String FindDistrict;
	
	private String FindRoad;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@Past
	private java.util.Date FindDate;
	
	private String ICNumber;
	
	@NotNull
	private int PetGender;
	
	private int PetPhotos;
	
	private String PetNotes;
	
	@Override
	public String toString() {
		return "AdoptBean [AId=" + AId + ", PetForm=" + PetForm + ", UserName=" + UserName + ", UserPhone=" + UserPhone
				+ ", UserEmail=" + UserEmail + ", PetName=" + PetName + ", PetType=" + PetType + ", PetBreeds="
				+ PetBreeds + ", PetFeature=" + PetFeature + ", FindCity=" + FindCity + ", FindDistrict=" + FindDistrict
				+ ", FindRoad=" + FindRoad + ", FindDate=" + FindDate + ", ICNumber=" + ICNumber + ", PetGender="
				+ PetGender + ", PetPhotos=" + PetPhotos + ", PetNotes=" + PetNotes + "]";
	}

	public int getAId() {
		return AId;
	}

	public void setAID(int aId) {
		AId = aId;
	}

	public int getPetForm() {
		return PetForm;
	}

	public void setPetForm(int petForm) {
		PetForm = petForm;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getUserPhone() {
		return UserPhone;
	}

	public void setUserPhone(String userPhone) {
		UserPhone = userPhone;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getPetName() {
		return PetName;
	}

	public void setPetName(String petName) {
		PetName = petName;
	}

	public String getPetType() {
		return PetType;
	}

	public void setPetType(String petType) {
		PetType = petType;
	}

	public String getPetBreeds() {
		return PetBreeds;
	}

	public void setPetBreeds(String petBreeds) {
		PetBreeds = petBreeds;
	}

	public String getPetFeature() {
		return PetFeature;
	}

	public void setPetFeature(String petFeature) {
		PetFeature = petFeature;
	}

	public String getFindCity() {
		return FindCity;
	}

	public void setFindCity(String findCity) {
		FindCity = findCity;
	}

	public String getFindDistrict() {
		return FindDistrict;
	}

	public void setFindDistrict(String findDistrict) {
		FindDistrict = findDistrict;
	}

	public String getFindRoad() {
		return FindRoad;
	}

	public void setFindRoad(String findRoad) {
		FindRoad = findRoad;
	}

	public java.util.Date getFindDate() {
		return FindDate;
	}

	public void setFindDate(java.util.Date findDate) {
		FindDate = findDate;
	}

	public String getICNumber() {
		return ICNumber;
	}

	public void setICNumber(String iCNumber) {
		ICNumber = iCNumber;
	}

	public int getPetGender() {
		return PetGender;
	}

	public void setPetGender(int petGender) {
		PetGender = petGender;
	}

	public int getPetPhotos() {
		return PetPhotos;
	}

	public void setPetPhotos(int petPhotos) {
		PetPhotos = petPhotos;
	}

	public String getPetNotes() {
		return PetNotes;
	}

	public void setPetNotes(String petNotes) {
		PetNotes = petNotes;
	}

}
