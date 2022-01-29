package com.st;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Student {

	@Id
	@GeneratedValue
	private long id;
	
	private String ssId;
	private String name;
	private String city;
	private String country;
	private String pin;
	
}
