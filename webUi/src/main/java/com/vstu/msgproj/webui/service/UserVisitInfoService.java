package com.vstu.msgproj.webui.service;

import com.vstu.msgproj.webui.model.Result;
import com.vstu.msgproj.webui.model.UserVisitInfo;
import com.vstu.msgproj.webui.repository.UserVisitInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserVisitInfoService {

    @Autowired
    private UserVisitInfoRepository repository;

    public List<UserVisitInfo> getAllVisits() {
        return repository.findAll();
    }

    public Result getGroupByAge() {
        List<Map<String,String>> list = repository.groupByAge();
        return new Result("age",list);
    }

    public Result getGroupByGender() {
        return new Result("gender",repository.groupByGender());
    }

    public Result getGroupByCityLevel() {
        return new Result("city_level",repository.groupByCityLevel());
    }

    public Result getGroupByProvince() {
        return new Result("province",repository.groupByProvince());
    }

    public Result getGroupBySeries() {
        return new Result("car_series",repository.groupBySeries());
    }

    public Result getGroupbyBrand() {
        return new Result("car_brand",repository.groupByBrand());
    }

    public Result getGroupByEnergy() {
        return new Result("new_energy",repository.groupByNewEnergy());
    }
}
