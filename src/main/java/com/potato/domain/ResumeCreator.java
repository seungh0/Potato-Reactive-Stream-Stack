package com.potato.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResumeCreator {

	public static Resume create(String name, String contact, int studentId, String major, String introduction) {
		return Resume.builder()
				.name(name)
				.contact(contact)
				.studentId(studentId)
				.major(major)
				.introduction(introduction)
				.build();
	}

}
