package com.potato.service.member;

import com.potato.domain.member.Member;
import com.potato.domain.member.MemberRepository;
import com.potato.service.member.dto.request.SignUpMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Transactional
	public Mono<String> sigUpMember(SignUpMemberRequest request) {
		Mono<Member> memberMono = memberRepository.save(request.toEntity());
		return memberMono.flatMap(member -> Mono.just(member.getId()));
	}

}
