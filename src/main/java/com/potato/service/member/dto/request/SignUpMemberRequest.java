package com.potato.service.member.dto.request;

import com.potato.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignUpMemberRequest {

	private String email;

	private String name;

	private String profileUrl;

	@Builder(builderMethodName = "testBuilder")
	public SignUpMemberRequest(String email, String name, String profileUrl) {
		this.email = email;
		this.name = name;
		this.profileUrl = profileUrl;
	}

	public Member toEntity() {
		return Member.newKaKaoMember(email, name, profileUrl);
	}

}
