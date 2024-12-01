package com.vstu.msgproj.webui.service;

import com.vstu.msgproj.webui.model.UserVisitInfo;
import com.vstu.msgproj.webui.repository.UserVisitInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVisitInfoService {

    @Autowired
    private UserVisitInfoRepository repository;

    public List<UserVisitInfo> getAllVisits() {
        return repository.findAll();
    }

    public List<UserVisitInfo> getGroupByAge() {
        return repository.findAllUser();
    }

    public List<UserVisitInfo> getGroupByGender() {
        return repository.findAllUser();
    }

    public List<UserVisitInfo> getGroupByCityLevel() {
        return repository.findAllUser();
    }

    public List<UserVisitInfo> getGroupBySeries() {
        return repository.findAllUser();
    }

    public List<UserVisitInfo> getGroupbyBrand() {
        return repository.findAllUser();
    }

    public List<UserVisitInfo> getGroupByEnergy() {
        return repository.findAllUser();
    }
}
