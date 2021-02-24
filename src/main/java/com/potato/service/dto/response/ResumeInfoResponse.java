package com.potato.service.dto.response;

import com.potato.common.BaseTimeResponse;
import com.potato.domain.Position;
import com.potato.domain.Resume;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class ResumeInfoResponse extends BaseTimeResponse {

	private final String id;

	private final String name;

	private final Integer studentId;

	private final String contact;

	private final String major;

	private final String introduction;

	private final Position position;

	public static ResumeInfoResponse of(Resume resume) {
		ResumeInfoResponse response = new ResumeInfoResponse(resume.getId(), resume.getName(), resume.getStudentId(),
				resume.getContact(), resume.getMajor(), resume.getIntroduction(), resume.getPosition());
		response.setBaseTimeResponse(resume);
		return response;
	}

}

