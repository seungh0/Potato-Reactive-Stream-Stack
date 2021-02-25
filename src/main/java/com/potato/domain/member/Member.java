package com.potato.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(collection = "members")
public class Member {

	@Id
	private String id;

	private String email;

	private String name;

	private String profileUrl;

	private MemberProvider provider;

	@Builder
	public Member(String email, String name, String profileUrl, MemberProvider provider) {
		this.email = email;
		this.name = name;
		this.profileUrl = profileUrl;
		this.provider = provider;
	}

	public static Member newKaKaoMember(String email, String name, String profileUrl) {
		return Member.builder()
				.email(email)
				.name(name)
				.profileUrl(profileUrl)
				.provider(MemberProvider.KAKAO)
				.build();
	}

}
