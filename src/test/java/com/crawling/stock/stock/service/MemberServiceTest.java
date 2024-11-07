package com.crawling.stock.stock.service;

import com.crawling.stock.stock.controller.member.repository.MemberRepository;
import com.crawling.stock.stock.domain.entity.MemberEntity;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private EntityManager em;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    void 등록_테스트() {

        // entity mapping
        MemberEntity member = MemberEntity.builder()
                .memberId("jhshin")
                .name("name")
                .role("")
                .build();

        // 등록
        MemberEntity savedMember = memberRepository.save(member);

        em.flush();

        Assertions.assertTrue(!ObjectUtils.isEmpty(savedMember));
    }
}