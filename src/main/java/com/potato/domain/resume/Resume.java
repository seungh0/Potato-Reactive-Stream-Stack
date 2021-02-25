package com.potato.domain.resume;

import com.potato.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "resumes")
public class Resume extends BaseTimeEntity {

	@Id
	private String id;

	private String name;

	private int studentId;

	private String contact;

	private String major;

	private String introduction;

	private Position position;

	@Builder
	public Resume(String name, int studentId, String contact, String major, String introduction, Position position) {
		this.name = name;
		this.studentId = studentId;
		this.contact = contact;
		this.major = major;
		this.introduction = introduction;
		this.position = position;
	}

	public static Resume newInstance(String name, String contacts, int studentId, String major, String introduction, Position position) {
		return Resume.builder()
				.name(name)
				.contact(contacts)
				.studentId(studentId)
				.major(major)
				.introduction(introduction)
				.position(position)
				.build();
	}

}
