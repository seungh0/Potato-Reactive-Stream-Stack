package com.potato.service.member.dto.response;

import com.potato.domain.member.Member;
import com.potato.domain.member.MemberProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemberInfoResponse {

	private final String id;

	private final String email;

	private final String name;

	private final String profileUrl;

	private final MemberProvider provider;

	public static MemberInfoResponse of(Member member) {
		return new MemberInfoResponse(member.getId(), member.getEmail(), member.getName(), member.getProfileUrl(), member.getProvider());
	}

}
