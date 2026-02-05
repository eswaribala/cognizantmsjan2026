package com.cognizant.banking.models;

import java.time.LocalDate;



public class Member {
	private int memberId;
	private String name;
	private LocalDate dateOfBirth;
	public Member(int memberId, String name, LocalDate dateOfBirth) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Member other = (Member) obj;
		return this.memberId == other.memberId &&
			   this.name.equals(other.name) &&
			   this.dateOfBirth.equals(other.dateOfBirth);
	}
	
	
	
	
}
