package com.vstu.msgproj.webui.controller;

import com.vstu.msgproj.webui.model.Result;
import com.vstu.msgproj.webui.model.UserVisitInfo;
import com.vstu.msgproj.webui.service.UserVisitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uvi")
public class UserVisitInfoController {
    @Autowired
    private UserVisitInfoService service;
    @GetMapping("/visits")
    public List<UserVisitInfo> getVisits() {
        List<UserVisitInfo> list= service.getAllVisits();
        return list;
    }

//    @GetMapping("/age")
//    public Result getGroupByAge() {
//        return service.getGroupByAge();
//    }

    @GetMapping("/age")
    public Result getGroupByAge() {
        return service.getGroupByAge();
    }
    @GetMapping("/cityLevel")
    public Result getGroupByCityLevel() {
        return service.getGroupByCityLevel();
    }

    @GetMapping("/province")
    public Result getGroupByProvince() {
        return service.getGroupByProvince();
    }

    @GetMapping("/series")
    public Result getGroupBySeries() {
        return service.getGroupBySeries();
    }

    @GetMapping("/brand")
    public Result getGroupByBrand() {
        return service.getGroupbyBrand();
    }

    @GetMapping("/newEnergy")
    public Result getGroupByEnergy() {
        return service.getGroupByEnergy();
    }
}
