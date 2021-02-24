package com.potato.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class ResumeRepositoryTest {

	@Autowired
	private ResumeRepository resumeRepository;

	@AfterEach
	void cleanUp() {
		resumeRepository.deleteAll();
	}

	@Test
	void insert_테스트() {
		// given
		String name = "강승호";
		String contacts = "010-1234-1234";
		int studentId = 201610302;
		String major = "컴퓨터공학과";
		String introduction = "Let me introduce myself";

		Resume resume = Resume.builder()
				.name(name)
				.contact(contacts)
				.studentId(studentId)
				.major(major)
				.introduction(introduction)
				.build();

		// when
		resumeRepository.save(resume).subscribe();

		// then
		Flux<Resume> resumeFlux = resumeRepository.findAll();
		StepVerifier.create(resumeFlux)
				.expectNextCount(1L)
				.verifyComplete();
	}

}
