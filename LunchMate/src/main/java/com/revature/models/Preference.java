package com.revature.models;

import java.sql.Date;

import javax.persistence.Id;

import org.springframework.stereotype.Component;



//	are we having a table for each preference???

@Component
public class Preference	{

@Id
private int preferenceID;

private String preferenceName;

//foreign key
//	@JoinColumn("Posting_ID")
//	@ForeignKey
private String postingID;




/*
private boolean gluten;
private boolean peanut;
private boolean vegetarian;
*/


//constructors
//getters, setters
//toString

}
