package com.potato.service.member;

import com.potato.domain.member.Member;
import com.potato.domain.member.MemberRepository;
import com.potato.service.member.dto.request.SignUpMemberRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Autowired
	private MemberRepository memberRepository;

	@AfterEach
	void cleanUp() {
		memberRepository.deleteAll();
	}

	@Test
	void 새로운_유저가_회원가입한다() {
		// given
		String email = "will.seungho@gmail.com";
		String name = "강승호";
		String profileUrl = "http://profile.com";

		SignUpMemberRequest request = SignUpMemberRequest.testBuilder()
				.email(email)
				.name(name)
				.profileUrl(profileUrl)
				.build();

		// when
		memberService.sigUpMember(request).subscribe();

		// then
		Flux<Member> memberFlux = memberRepository.findAll();
		StepVerifier.create(memberFlux)
				.assertNext(member -> assertMember(member, email, name, profileUrl))
				.verifyComplete();
	}

	private void assertMember(Member member, String email, String name, String profileUrl) {
		assertThat(member.getEmail()).isEqualTo(email);
		assertThat(member.getName()).isEqualTo(name);
		assertThat(member.getProfileUrl()).isEqualTo(profileUrl);
	}

}