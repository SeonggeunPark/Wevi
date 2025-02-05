package com.ssafy.wevi.domain.schedule;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "consultations")
@NoArgsConstructor
public class Consultation extends Schedule{
    private String request; // 고객 요청사항
}
