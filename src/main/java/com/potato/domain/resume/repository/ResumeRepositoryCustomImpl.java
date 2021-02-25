package com.potato.domain.resume.repository;

import com.potato.domain.resume.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ResumeRepositoryCustomImpl implements ResumeRepositoryCustom {

	private final ReactiveMongoTemplate mongoTemplate;

	@Override
	public Flux<Resume> findAllResumes() {
		return mongoTemplate.findAll(Resume.class, "resumes");
	}

}
