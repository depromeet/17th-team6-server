package com.sixpack.dorundorun.global.response;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaginationResponse<T> {

	private List<T> contents;
	private PaginationInfo meta;

	public static <T> PaginationResponse<T> of(Page<T> page) {
		PaginationInfo paginationInfo = PaginationInfo.builder()
			.page(page.getNumber())
			.size(page.getSize())
			.totalElements(page.getTotalElements())
			.totalPages(page.getTotalPages())
			.first(page.isFirst())
			.last(page.isLast())
			.hasNext(page.hasNext())
			.hasPrevious(page.hasPrevious())
			.build();

		return PaginationResponse.<T>builder()
			.contents(page.getContent())
			.meta(paginationInfo)
			.build();
	}
}

