package com.ssafy.wevi.repository;

import com.ssafy.wevi.domain.Customer;
import com.ssafy.wevi.domain.SigunguId;
import com.ssafy.wevi.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {
    Optional<Vendor> findByEmail(String email);

    // 기본 CRUD 메서드 제공

    @Query(value =
            "SELECT v.user_id, v.name, v.category, v.address, " +
                    "v.do_id, v.sigungu_code "+
                    "FROM vendors v " +
                    "WHERE v.do_id = :doId " +
                    "AND v.sigungu_code = :sigunguCode " +
                    "AND v.category_id = :category",
            nativeQuery = true)
    List<Vendor> findByLocationAndCategory(
            @Param("doId") Integer doId,
            @Param("sigunguCode") Integer sigunguCode,
            @Param("category") Integer category);
}
