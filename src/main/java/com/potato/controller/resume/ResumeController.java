package com.potato.controller.resume;

import com.potato.service.resume.ResumeService;
import com.potato.service.resume.dto.request.CreateResumeRequest;
import com.potato.service.resume.dto.response.ResumeInfoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ResumeController {

	private final ResumeService resumeService;

	@PostMapping("/api/v1/resume")
	public Mono<ResumeInfoResponse> applyResume(@Valid @RequestBody CreateResumeRequest request) {
		return resumeService.applyResume(request);
	}

	@GetMapping("/api/v1/resumes")
	public Flux<ResumeInfoResponse> getResumes() {
		return resumeService.retrieveAllResumes();
	}

	@GetMapping("/api/v1/resume/{id}")
	public Mono<ResumeInfoResponse> getResume(@PathVariable String id) {
		return resumeService.retrieveResume(id);
	}

}
