package com.ssafy.wevi.domain.schedule;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@Table(name = "contracts")
@NoArgsConstructor
public class Contract extends Schedule{
    private int price;  // 계약금액
    @Column(nullable = false)
    private LocalDateTime contractDate; // 계약일
    private String detail;  // 계약 세부사항
}
