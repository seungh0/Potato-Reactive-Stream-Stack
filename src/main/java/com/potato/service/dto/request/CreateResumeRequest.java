package com.potato.service.dto.request;

import com.potato.domain.Resume;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateResumeRequest {

	private String name;

	private String contacts;

	private int studentId;

	private String major;

	private String introduction;

	public Resume toEntity() {
		return Resume.newInstance(name, contacts, studentId, major, introduction);
	}

}
