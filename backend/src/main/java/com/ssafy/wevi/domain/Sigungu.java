package com.ssafy.wevi.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sigungu")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@IdClass(SigunguId.class)
public class Sigungu {
    @Id
    private Integer sigunguId;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "do_region_id", nullable = false)
    private Do doRegion;

    @Column(nullable = false)
    private String sigunguName;
}
