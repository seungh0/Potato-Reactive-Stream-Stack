package com.potato.controller;

import com.potato.service.ResumeService;
import com.potato.service.dto.request.CreateResumeRequest;
import com.potato.service.dto.response.ResumeInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class ResumeController {

	private final ResumeService resumeService;

	@PostMapping("/api/v1/resume")
	public Mono<ResumeInfoResponse> applyResume(@RequestBody CreateResumeRequest request) {
		return resumeService.applyResume(request);
	}

	@GetMapping("/api/v1/resumes")
	public Flux<ResumeInfoResponse> getResumes() {
		return resumeService.retrieveAllResumes();
	}

}
