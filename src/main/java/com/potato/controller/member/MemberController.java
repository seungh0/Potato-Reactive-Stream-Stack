package com.potato.controller.member;

import com.potato.service.member.MemberService;
import com.potato.service.member.dto.request.SignUpMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/api/v1/member")
	public Mono<String> signUpMember(@Valid @RequestBody SignUpMemberRequest request) {
		memberService.sigUpMember(request);
		return Mono.just("OK");
	}

}
