package com.potato.service.dto.response;

import com.potato.domain.Resume;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class ResumeInfoResponse {

	private final String id;

	private final String name;

	private final Integer studentId;

	private final String contact;

	private final String major;

	private final String introduction;

	public static ResumeInfoResponse of(Resume resume) {
		return new ResumeInfoResponse(resume.getId(), resume.getName(), resume.getStudentId(), resume.getContact(), resume.getMajor(), resume.getIntroduction());
	}

}

