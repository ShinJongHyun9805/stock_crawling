package com.crawling.stock.stock.controller.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class MemberResponseDto {

    @Schema(description = "회원 일련 번호", example = "1")
    private Long memberSeq;

    @Schema(description = "회원 ID", example = "user123")
    private String memberId;

    @Schema(description = "회원 이름", example = "John Doe")
    private String name;

    @Schema(description = "회원 권한", example = "USER")
    private String role;

    public MemberResponseDto(Long memberSeq, String memberId, String name, String role) {
        this.memberSeq = memberSeq;
        this.memberId = memberId;
        this.name = name;
        this.role = role;
    }
}
