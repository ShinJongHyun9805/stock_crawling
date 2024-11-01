package com.crawling.stock.stock.service;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private EntityManager em;

    @Test
    void 등록_테스트() {

//        MemberEntity member = MemberEntity.builder()
//                .memberId("qwer")
//                .name("신종현")
//                .role(null)
//                .build();
//
//        em.persist(member);

    }


}