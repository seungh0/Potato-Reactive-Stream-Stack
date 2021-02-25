package com.potato.domain.resume;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ResumeRepositoryTest {

	@Autowired
	private ResumeRepository resumeRepository;

	@AfterEach
	void cleanUp() {
		resumeRepository.deleteAll();
	}

	@Test
	void ReactiveMongoTemplate_테스트() {
		// given
		String name = "강승호";
		Resume resume = Resume.builder()
				.name(name)
				.build();
		resumeRepository.save(resume).block();

		// when
		Flux<Resume> resumeFlux = resumeRepository.findAllResumes();

		// then
		StepVerifier.create(resumeFlux)
				.assertNext(r -> assertThat(r.getName()).isEqualTo(name))
				.verifyComplete();
	}

}
