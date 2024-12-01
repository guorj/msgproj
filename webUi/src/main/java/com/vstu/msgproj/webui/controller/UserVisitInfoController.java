package com.vstu.msgproj.webui.controller;

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
        return service.getAllVisits();
    }

    @GetMapping("/age")
    public List<UserVisitInfo> getGroupByAge() {
        return service.getGroupByAge();
    }

    @GetMapping("/age")
    public List<UserVisitInfo> getGroupByCityLevel() {
        return service.getGroupByAge();
    }

    @GetMapping("/age")
    public List<UserVisitInfo> getGroupBySeries() {
        return service.getGroupByAge();
    }

    @GetMapping("/age")
    public List<UserVisitInfo> getGroupByBrand() {
        return service.getGroupByAge();
    }

    @GetMapping("/age")
    public List<UserVisitInfo> getGroupByEnergy() {
        return service.getGroupByAge();
    }
}
