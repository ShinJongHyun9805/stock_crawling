package com.crawling.stock.stock.controller.member.repository;

import com.crawling.stock.stock.domain.entity.MemberEntity;
import com.crawling.stock.stock.domain.entity.QMemberEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.crawling.stock.stock.domain.entity.QMemberEntity.memberEntity;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public MemberEntity findByMemberId(String memberId) {

        QMemberEntity member = memberEntity;

        return jpaQueryFactory
                .selectFrom(member)
                .where(member.memberId.eq(memberId))
                .fetchOne();
    }
}
