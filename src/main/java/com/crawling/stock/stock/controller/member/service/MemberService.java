package com.crawling.stock.stock.controller.member.service;

import com.crawling.stock.stock.controller.member.dto.MemberRequestDto;
import com.crawling.stock.stock.controller.member.dto.MemberResponseDto;
import com.crawling.stock.stock.controller.member.repository.MemberRepository;
import com.crawling.stock.stock.domain.entity.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원 등록
    @Transactional
    public MemberResponseDto registerMember(MemberRequestDto requestDto) {

        // entity mapping
        MemberEntity member = MemberEntity.builder()
                .memberId(requestDto.getMemberId())
                .name(requestDto.getName())
                .role(requestDto.getRole())
                .build();

        // 등록
        MemberEntity savedMember = memberRepository.save(member);

        // 응답
        return new MemberResponseDto(savedMember.getMemberSeq(), savedMember.getMemberId(), savedMember.getName(), savedMember.getRole());
    }

}
