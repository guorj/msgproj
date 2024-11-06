package com.vstu.msgproj.process.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="user_visit_info")
@Data
public class UserVisitInfo {
    private String username;
    private int age;
    private String gender;
    private String province;
    private String city;
    private String carSeries;
    private String carBrand;
    private int newEnergy;
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
