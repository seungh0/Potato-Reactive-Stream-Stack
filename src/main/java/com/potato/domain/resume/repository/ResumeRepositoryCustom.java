package com.potato.domain.resume.repository;

import com.potato.domain.resume.Resume;
import reactor.core.publisher.Flux;

public interface ResumeRepositoryCustom {

	Flux<Resume> findAllResumes();

}
