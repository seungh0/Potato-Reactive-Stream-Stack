package com.potato.service.dto.response;

import com.potato.domain.Resume;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Getter
@RequiredArgsConstructor
public class ResumeInfoResponse {

	private final String id;

	private final String name;

	private final Integer studentId;

	private final String contact;

	private final String major;

	private final String introduction;

	public static Mono<ResumeInfoResponse> of(Mono<Resume> resumeMono) {
		return resumeMono.map(resume -> new ResumeInfoResponse(resume.getId(), resume.getName(), resume.getStudentId(),
				resume.getContact(), resume.getMajor(), resume.getIntroduction()));
	}

	public static Flux<ResumeInfoResponse> of(Resume resume) {
		return Flux.just(new ResumeInfoResponse(resume.getId(), resume.getName(), resume.getStudentId(), resume.getContact(), resume.getMajor(), resume.getIntroduction()));
	}
}
