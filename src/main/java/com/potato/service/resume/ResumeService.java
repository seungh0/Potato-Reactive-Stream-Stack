package com.potato.service.resume;

import com.potato.domain.resume.Resume;
import com.potato.domain.resume.ResumeRepository;
import com.potato.service.resume.dto.request.CreateResumeRequest;
import com.potato.service.resume.dto.response.ResumeInfoResponse;
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
		Mono<Resume> resumeMono = resumeRepository.save(request.toEntity());
		return resumeMono.flatMap(resume -> Mono.just(ResumeInfoResponse.of(resume)));
	}

	@Transactional(readOnly = true)
	public Flux<ResumeInfoResponse> retrieveAllResumes() {
		Flux<Resume> resumeFlux = resumeRepository.findAllResumes();
		return resumeFlux.flatMap(resume -> Flux.just(ResumeInfoResponse.of(resume)));
	}

	@Transactional(readOnly = true)
	public Mono<ResumeInfoResponse> retrieveResume(String id) {
		Mono<Resume> resumeMono = resumeRepository.findById(id);
		return resumeMono.flatMap(resume -> Mono.just(ResumeInfoResponse.of(resume)))
				.switchIfEmpty(Mono.error(new IllegalArgumentException(String.format("해당하는 (%s) 지원서는 존재하지 않습니다", id))));
	}

}
