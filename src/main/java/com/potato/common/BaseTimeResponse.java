package com.potato.common;

import com.potato.domain.BaseTimeEntity;
import lombok.Getter;

@Getter
public abstract class BaseTimeResponse {

	private String createdDateTime;

	private String updatedDateTime;

	protected void setBaseTimeResponse(BaseTimeEntity entity) {
		this.createdDateTime = entity.getCreatedDateTime().toString();
		this.updatedDateTime = entity.getUpdatedDateTime().toString();
	}

}
