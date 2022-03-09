package com.koreait.cgvproject.repository;

import com.koreait.cgvproject.entity.GiftPayment;
import com.koreait.cgvproject.entity.Member;
import com.koreait.cgvproject.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface GiftPaymentRepository extends JpaRepository<GiftPayment, Long> {
    // 특정 멤버아이디값의 모든 상품결제내역 조회
    @Query(value = "SELECT * FROM gift_payment where mem_idx = :memberIdx", nativeQuery = true)
    List<GiftPayment> findByMemberIdx(Long memberIdx);

}