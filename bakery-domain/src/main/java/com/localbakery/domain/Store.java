package com.localbakery.domain;

import lombok.*;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "stores")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "storeId")
    private Long storeId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "storeId")
    private List<Menu> menus;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private storeType type;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "startTime")
    private Long startTime;

    @Column(name = "endTime")
    private Long endTime;

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdAt", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "location")
    private Point location;

    enum storeType {
        BAKERY
    }
}
