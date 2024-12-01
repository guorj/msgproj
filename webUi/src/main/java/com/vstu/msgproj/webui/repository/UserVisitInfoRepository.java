package com.vstu.msgproj.webui.repository;

import com.vstu.msgproj.webui.model.UserVisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserVisitInfoRepository extends JpaRepository<UserVisitInfo, Long> {
    @Query(value = "select count(1) from user_visit_info;", nativeQuery = true)
    List<UserVisitInfo> findAllUser();

    @Query(value = "select count(1),age from user_visit_info group by age;", nativeQuery = true)
    List<UserVisitInfo> groupByAge();

    @Query(value = "select count(1),gender from user_visit_info group by gender;", nativeQuery = true)
    List<UserVisitInfo> groupByGender();

    @Query(value = "select count(1),cityLevel from user_visit_info group by city_level;", nativeQuery = true)
    List<UserVisitInfo> groupByCityLevel();

    @Query(value = "select count(1),car_series from user_visit_info group by car_series;", nativeQuery = true)
    List<UserVisitInfo> groupBySeries();

    @Query(value = "select count(1),car_brand from user_visit_info group by car_brand;", nativeQuery = true)
    List<UserVisitInfo> groupByBrand();

    @Query(value = "select count(1),new_energy from user_visit_info group by new_energy;", nativeQuery = true)
    List<UserVisitInfo> groupByNewEnergy();
}