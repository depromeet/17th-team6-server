package com.sixpack.dorundorun.feature.run.dto.request;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(description = "러닝 세그먼트 저장 요청 DTO")
public record RunSegmentSaveRequest(
	@Schema(description = "세그먼트 리스트", requiredMode = Schema.RequiredMode.REQUIRED)
	@NotEmpty @Valid
	List<RunSegmentRequest> segments,

	@Schema(description = "러닝 중지 여부", example = "false", requiredMode = Schema.RequiredMode.REQUIRED)
	boolean isStopped
) {
}
