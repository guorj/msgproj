package com.vstu.msgproj.webui.repository;

import com.vstu.msgproj.webui.model.UserVisitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface UserVisitInfoRepository extends JpaRepository<UserVisitInfo, Long> {
    @Query(value = "select count(1) as totalNum from user_visit_info;", nativeQuery = true)
    List<UserVisitInfo> findAllUser();

//    @Query(value = "select count(1),age from user_visit_info group by age;", nativeQuery = true)
//    List<Map<String,String>> groupByAge();

    @Query(value = "select count(1) as totalNum,age from user_visit_info group by age;", nativeQuery = true)
    List<Map<String,String>> groupByAge();

    @Query(value = "select count(1) as totalNum,gender from user_visit_info group by gender;", nativeQuery = true)
    List<Map<String,String>> groupByGender();

    @Query(value = "select count(1) as totalNum,cityLevel from user_visit_info group by city_level;", nativeQuery = true)
    List<Map<String,String>> groupByCityLevel();

    @Query(value = "select count(1) as totalNum,province from user_visit_info group by province;", nativeQuery = true)
    List<Map<String,String>> groupByProvince();

    @Query(value = "select count(1) as totalNum,car_series from user_visit_info group by car_series;", nativeQuery = true)
    List<Map<String,String>> groupBySeries();

    @Query(value = "select count(1) as totalNum,car_brand from user_visit_info group by car_brand;", nativeQuery = true)
    List<Map<String,String>> groupByBrand();

    @Query(value = "select count(1) as totalNum,new_energy from user_visit_info group by new_energy;", nativeQuery = true)
    List<Map<String,String>> groupByNewEnergy();
}