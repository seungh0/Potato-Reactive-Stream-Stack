package com.potato.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "resume")
public class Resume {

	@Id
	private String id;

	private String name;

	private int studentId;

	private String contact;

	private String major;

	private String introduction;

	@Builder
	public Resume(String name, int studentId, String contact, String major, String introduction) {
		this.name = name;
		this.studentId = studentId;
		this.contact = contact;
		this.major = major;
		this.introduction = introduction;
	}

	public static Resume newInstance(String name, String contacts, int studentId, String major, String introduction) {
		return Resume.builder()
				.name(name)
				.contact(contacts)
				.studentId(studentId)
				.major(major)
				.introduction(introduction)
				.build();
	}

}
