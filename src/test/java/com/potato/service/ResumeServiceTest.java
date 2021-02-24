package com.potato.service;

import com.potato.domain.Position;
import com.potato.domain.Resume;
import com.potato.domain.ResumeRepository;
import com.potato.service.dto.request.CreateResumeRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ResumeServiceTest {

	@Autowired
	private ResumeService resumeService;

	@Autowired
	private ResumeRepository resumeRepository;

	@AfterEach
	void cleanUp() {
		resumeRepository.deleteAll();
	}

	@Test
	void 지원서를_등록한다() {
		// given
		String name = "강승호";
		String contact = "010-1234-1234";
		int studentId = 201610302;
		String major = "컴퓨터공학과";
		String introduction = "Will 입니당";
		Position position = Position.BACKEND;

		CreateResumeRequest request = CreateResumeRequest.testBuilder()
				.name(name)
				.contact(contact)
				.studentId(studentId)
				.major(major)
				.introduction(introduction)
				.position(position)
				.build();

		// when
		resumeService.applyResume(request).subscribe();

		// then
		Flux<Resume> resumeFlux = resumeRepository.findAll();
		StepVerifier.create(resumeFlux)
				.assertNext(resume -> assertResume(resume, name, contact, studentId, major, introduction, position))
				.verifyComplete();
	}

	private void assertResume(Resume resume, String name, String contact, int studentId, String major, String introduction, Position position) {
		assertThat(resume.getName()).isEqualTo(name);
		assertThat(resume.getContact()).isEqualTo(contact);
		assertThat(resume.getStudentId()).isEqualTo(studentId);
		assertThat(resume.getMajor()).isEqualTo(major);
		assertThat(resume.getIntroduction()).isEqualTo(introduction);
		assertThat(resume.getPosition()).isEqualTo(position);
	}

}
