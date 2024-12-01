package com.vstu.msgproj.webui.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user_visit_info")
@Data
public class UserVisitInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id// 使用IDENTITY策略
    private Long id;
    private String userName;
    private int age;
    private String gender;
    private String province;
    private String city;
    private String cityLevel;
    private String carSeries;
    private String carBrand;
    private int newEnergy;
}
