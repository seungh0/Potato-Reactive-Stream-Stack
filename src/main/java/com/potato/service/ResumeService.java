package com.potato.service;

import com.potato.domain.Resume;
import com.potato.domain.ResumeRepository;
import com.potato.service.dto.request.CreateResumeRequest;
import com.potato.service.dto.response.ResumeInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ResumeService {

	private final ResumeRepository resumeRepository;

	@Transactional
	public Mono<ResumeInfoResponse> applyResume(CreateResumeRequest request) {
		return ResumeInfoResponse.of(resumeRepository.save(request.toEntity()));
	}

	@Transactional(readOnly = true)
	public Flux<ResumeInfoResponse> getAll() {
		Flux<Resume> resumeFlux = resumeRepository.findAll();
		return resumeFlux.flatMap(ResumeInfoResponse::of);
	}

}
