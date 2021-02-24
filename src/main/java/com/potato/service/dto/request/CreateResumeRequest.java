package com.potato.service.dto.request;

import com.potato.domain.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateResumeRequest {

	private String name;

	private String contact;

	private int studentId;

	private String major;

	private String introduction;

	@Builder(builderMethodName = "testBuilder")
	public CreateResumeRequest(String name, String contact, int studentId, String major, String introduction) {
		this.name = name;
		this.contact = contact;
		this.studentId = studentId;
		this.major = major;
		this.introduction = introduction;
	}

	public Resume toEntity() {
		return Resume.newInstance(name, contact, studentId, major, introduction);
	}

}
