package com.crawling.stock.stock.controller.member.repository;

import com.crawling.stock.stock.domain.entity.MemberEntity;

public interface MemberRepositoryCustom {

    MemberEntity findByMemberId(String memberId);
}
