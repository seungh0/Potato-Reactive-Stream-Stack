package com.potato.service.dto.request;

import com.potato.domain.Position;
import com.potato.domain.Resume;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateResumeRequest {

	@NotBlank
	private String name;

	@NotBlank
	private String contact;

	@NotNull
	private int studentId;

	@NotBlank
	private String major;

	@NotBlank
	private String introduction;

	@NotNull
	private Position position;

	@Builder(builderMethodName = "testBuilder")
	public CreateResumeRequest(String name, String contact, int studentId, String major, String introduction, Position position) {
		this.name = name;
		this.contact = contact;
		this.studentId = studentId;
		this.major = major;
		this.introduction = introduction;
		this.position = position;
	}

	public Resume toEntity() {
		return Resume.newInstance(name, contact, studentId, major, introduction, position);
	}

}
