package com.crawling.stock.stock.controller.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class MemberRequestDto {
    
    @Schema(description = "회원 ID")
    private String memberId;

    @Schema(description = "회원 이름")
    private String name;

    @Schema(description = "권한")
    private String role;
}
