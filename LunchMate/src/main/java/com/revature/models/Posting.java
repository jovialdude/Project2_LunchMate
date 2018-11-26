package com.revature.models;

import java.sql.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Future;





@Component
public class Posting	{


@Id
private int postingId;

private String postingName;

@Future
private Date dateTimeForMeal;

//	doesn't Google have something for this?
//	Like $$$ vs $
private String priceRange;

private String description;

//	foreign keys
//	@ForeignKey
private String posterAccountId;

private String responseAccountId;
private String foodType;
public Posting() {
	super();
	// TODO Auto-generated constructor stub
}
public Posting(int postingId, String postingName, Date dateTimeForMeal, String priceRange, String description,
		String posterAccountId, String responseAccountId, String foodType) {
	super();
	this.postingId = postingId;
	this.postingName = postingName;
	this.dateTimeForMeal = dateTimeForMeal;
	this.priceRange = priceRange;
	this.description = description;
	this.posterAccountId = posterAccountId;
	this.responseAccountId = responseAccountId;
	this.foodType = foodType;
}
public int getPostingId() {
	return postingId;
}
public void setPostingId(int postingId) {
	this.postingId = postingId;
}
public String getPostingName() {
	return postingName;
}
public void setPostingName(String postingName) {
	this.postingName = postingName;
}
public Date getDateTimeForMeal() {
	return dateTimeForMeal;
}
public void setDateTimeForMeal(Date dateTimeForMeal) {
	this.dateTimeForMeal = dateTimeForMeal;
}
public String getPriceRange() {
	return priceRange;
}
public void setPriceRange(String priceRange) {
	this.priceRange = priceRange;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getPosterAccountId() {
	return posterAccountId;
}
public void setPosterAccountId(String posterAccountId) {
	this.posterAccountId = posterAccountId;
}
public String getResponseAccountId() {
	return responseAccountId;
}
public void setResponseAccountId(String responseAccountId) {
	this.responseAccountId = responseAccountId;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
@Override
public String toString() {
	return "Posting [postingId=" + postingId + ", postingName=" + postingName + ", dateTimeForMeal=" + dateTimeForMeal
			+ ", priceRange=" + priceRange + ", description=" + description + ", posterAccountId=" + posterAccountId
			+ ", responseAccountId=" + responseAccountId + ", foodType=" + foodType + "]";
}





}
