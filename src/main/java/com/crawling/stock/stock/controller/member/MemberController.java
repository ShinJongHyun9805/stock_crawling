package com.crawling.stock.stock.controller.member;

import com.crawling.stock.stock.controller.member.dto.MemberRequestDto;
import com.crawling.stock.stock.controller.member.dto.MemberResponseDto;
import com.crawling.stock.stock.controller.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입")
    @PostMapping("/register")
    public ResponseEntity<MemberResponseDto> registerMember(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.registerMember(requestDto));
    }
}
