package com.cognizant.banking.utils;

import java.time.LocalDate;

import com.cognizant.banking.models.Member;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Member member1 = new Member(1, "Alice", LocalDate.of(1990, 5, 15));
		Member member2 =  new Member(2, "Alice", LocalDate.of(1990, 5, 15));
		if(member1.equals(member2)) {
			System.out.println("member1 is equal to member2");
			} else {
				System.out.println("member1 is not equal to member2");
			}
	}

}
