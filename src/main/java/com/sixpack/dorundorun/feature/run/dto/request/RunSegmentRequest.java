package com.sixpack.dorundorun.feature.run.dto.request;

import java.time.Instant;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(description = "러닝 세그먼트 단건 요청 DTO")
public record RunSegmentRequest(
	@Schema(description = "위도", example = "37.5293", requiredMode = Schema.RequiredMode.REQUIRED)
	@NotNull @DecimalMin(value = "-90") @DecimalMax(value = "90")
	Double latitude,

	@Schema(description = "경도", example = "126.9335", requiredMode = Schema.RequiredMode.REQUIRED)
	@NotNull @DecimalMin(value = "-180") @DecimalMax(value = "180")
	Double longitude,

	@Schema(description = "고도 (m)", example = "15.2")
	Double altitude,

	@Schema(description = "속도 (km/h)", example = "8.5")
	@PositiveOrZero
	Double speed,

	@Schema(description = "페이스 (초/km)", example = "360")
	@Positive
	Integer pace,

	@Schema(description = "케이던스 (걸음/분)", example = "170")
	@PositiveOrZero
	Integer cadence,

	@Schema(description = "누적 거리 (m)", example = "1000")
	@PositiveOrZero
	Integer distance,

	@Schema(description = "측정 시각 (ISO 8601)", example = "2024-01-15T09:00:00Z", requiredMode = Schema.RequiredMode.REQUIRED)
	@NotNull
	Instant time
) {
}
