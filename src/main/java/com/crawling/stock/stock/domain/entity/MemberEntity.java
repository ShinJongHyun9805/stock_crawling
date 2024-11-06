package com.crawling.stock.stock.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Member")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberEntity extends BaseEntity {

    @Id @GeneratedValue
    Long memberSeq;             // 회원 일련 번호

    String memberId;            // 회원 ID

    String name;                // 회원 명

    String role;                // 권한


}
